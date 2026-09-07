--liquibase formatted sql

--changeset goodwoor:1 runOnChange:true
CREATE TABLE users (
   id          BIGSERIAL PRIMARY KEY,
   first_name  VARCHAR(50) NOT NULL,
   second_name VARCHAR(50) NOT NULL,
   status      VARCHAR(30) NOT NULL
);

--changeset goodwoor:2
--comment Создание таблицы адресов (связь один-к-одному/один-ко-многим с пользователем)
CREATE TABLE addresses (
   id          BIGSERIAL PRIMARY KEY,
   user_id     BIGINT NOT NULL,
   city        VARCHAR(100) NOT NULL,
   street      VARCHAR(150) NOT NULL,
   home_number VARCHAR(20) NOT NULL,
   apartment   VARCHAR(20),
   CONSTRAINT fk_address_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

--changeset goodwoor:3
--comment Создание таблицы продуктов
CREATE TABLE products (
   id          BIGSERIAL PRIMARY KEY,
   title       VARCHAR(150) NOT NULL,
   price       NUMERIC(10, 2) NOT NULL, -- Точный тип для хранения денег
   sku         VARCHAR(50) UNIQUE NOT NULL
);

--changeset goodwoor:4
--comment Создание таблицы заказов (связь один-ко-многим с пользователем)
CREATE TABLE orders (
   id          BIGSERIAL PRIMARY KEY,
   user_id     BIGINT NOT NULL,
   created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   status      VARCHAR(30) NOT NULL,
   CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

--changeset goodwoor:5
--comment Промежуточная таблица для связи многие-ко-многим (заказы и продукты)
CREATE TABLE order_items (
   order_id   BIGINT NOT NULL,
   product_id BIGINT NOT NULL,
   quantity   INT NOT NULL DEFAULT 1, -- Количество конкретного товара в заказе
   PRIMARY KEY (order_id, product_id), -- Составной первичный ключ
   CONSTRAINT fk_items_order FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
   CONSTRAINT fk_items_product FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE RESTRICT
);