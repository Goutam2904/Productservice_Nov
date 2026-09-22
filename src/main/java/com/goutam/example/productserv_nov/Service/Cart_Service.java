package com.goutam.example.productserv_nov.Service;

import com.goutam.example.productserv_nov.DTO.CartItemRequest;
import com.goutam.example.productserv_nov.DTO.CheckoutRequest;
import com.goutam.example.productserv_nov.Model.Order;
import com.goutam.example.productserv_nov.Model.OrderItem;
import com.goutam.example.productserv_nov.Model.OrderStatus;
import com.goutam.example.productserv_nov.Model.Product;
import com.goutam.example.productserv_nov.Repository.Order_Repo;
import com.goutam.example.productserv_nov.Repository.Product_Repo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class Cart_Service {
    private static final String CART_KEY_PREFIX = "cart:";

    private final RedisTemplate<String, Object> redisTemplate;
    private final Product_Repo productRepo;
    private final Order_Repo orderRepo;

    public Cart_Service(RedisTemplate<String, Object> redisTemplate, Product_Repo productRepo, Order_Repo orderRepo) {
        this.redisTemplate = redisTemplate;
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    @SuppressWarnings("unchecked")
    public Map<Long, Integer> getCart(long userId) {
        Object value = redisTemplate.opsForValue().get(cartKey(userId));
        if (value instanceof Map<?, ?> storedCart) {
            Map<Long, Integer> cart = new LinkedHashMap<>();
            storedCart.forEach((key, quantity) -> cart.put(Long.valueOf(key.toString()), ((Number) quantity).intValue()));
            return cart;
        }
        return new LinkedHashMap<>();
    }

    public Map<Long, Integer> addItem(long userId, CartItemRequest request) {
        Product product = requireProduct(request.getProductId());
        Map<Long, Integer> cart = getCart(userId);
        cart.merge(product.getId(), request.getQuantity(), Integer::sum);
        saveCart(userId, cart);
        return cart;
    }

    public Map<Long, Integer> removeItem(long userId, long productId) {
        Map<Long, Integer> cart = getCart(userId);
        cart.remove(productId);
        saveCart(userId, cart);
        return cart;
    }

    @Transactional
    public Order checkout(long userId, CheckoutRequest request) {
        Map<Long, Integer> cart = getCart(userId);
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setDeliveryAddress(request.getDeliveryAddress());
        order.setPaymentMethod(request.getPaymentMethod());
        order.setStatus(OrderStatus.PAYMENT_PENDING);

        double total = 0;
        for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
            Product product = requireProduct(entry.getKey());
            OrderItem item = new OrderItem();
            item.setProductId(product.getId());
            item.setProductName(product.getName());
            item.setUnitPrice(product.getPrice());
            item.setQuantity(entry.getValue());
            order.addItem(item);
            total += product.getPrice() * entry.getValue();
        }
        order.setTotalAmount(total);

        Order savedOrder = orderRepo.save(order);
        redisTemplate.delete(cartKey(userId));
        return savedOrder;
    }

    public List<Order> getOrderHistory(long userId) {
        return orderRepo.findByUserIdOrderByCreatedAtDesc(userId);
    }

    private Product requireProduct(long productId) {
        Product product = productRepo.findById(productId);
        if (product == null || Boolean.TRUE.equals(product.getIsdeleted())) {
            throw new IllegalArgumentException("Product not found: " + productId);
        }
        return product;
    }

    private void saveCart(long userId, Map<Long, Integer> cart) {
        redisTemplate.opsForValue().set(cartKey(userId), cart);
    }

    private String cartKey(long userId) {
        return CART_KEY_PREFIX + userId;
    }
}
