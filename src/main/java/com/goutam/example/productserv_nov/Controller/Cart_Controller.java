package com.goutam.example.productserv_nov.Controller;

import com.goutam.example.productserv_nov.DTO.CartItemRequest;
import com.goutam.example.productserv_nov.DTO.CheckoutRequest;
import com.goutam.example.productserv_nov.Model.Order;
import com.goutam.example.productserv_nov.Service.Cart_Service;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class Cart_Controller {
    private final Cart_Service cartService;

    public Cart_Controller(Cart_Service cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Map<Long, Integer> getCart(@RequestHeader("X-User-Id") long userId) {
        return cartService.getCart(userId);
    }

    @PostMapping("/items")
    public Map<Long, Integer> addItem(@RequestHeader("X-User-Id") long userId,
                                      @Valid @RequestBody CartItemRequest request) {
        return cartService.addItem(userId, request);
    }

    @DeleteMapping("/items/{productId}")
    public Map<Long, Integer> removeItem(@RequestHeader("X-User-Id") long userId,
                                         @PathVariable long productId) {
        return cartService.removeItem(userId, productId);
    }

    @PostMapping("/checkout")
    public Order checkout(@RequestHeader("X-User-Id") long userId,
                          @Valid @RequestBody CheckoutRequest request) {
        return cartService.checkout(userId, request);
    }

    @GetMapping("/orders")
    public java.util.List<Order> orderHistory(@RequestHeader("X-User-Id") long userId) {
        return cartService.getOrderHistory(userId);
    }
}
