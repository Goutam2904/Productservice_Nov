CREATE TABLE category
(
    id            BIGINT NOT NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    isdeleted     BIT(1) NULL,
    category_name VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT NOT NULL,
    created_at    datetime NULL,
    updated_at    datetime NULL,
    isdeleted     BIT(1) NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    imageurl      VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);