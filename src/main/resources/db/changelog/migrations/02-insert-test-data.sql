--liquibase formatted sql

--changeset goodwoor:6
--comment Наполнение таблицы пользователей (users)
INSERT INTO users (id, first_name, second_name, status) VALUES
(1, 'Иван', 'Иванов', 'ACTIVE'),
(2, 'Мария', 'Петрова', 'ACTIVE'),
(3, 'Алексей', 'Сидоров', 'BANNED')
ON CONFLICT DO NOTHING;

--changeset goodwoor:7
--comment Наполнение таблицы адресов (addresses)
INSERT INTO addresses (id, user_id, city, street, home_number, apartment) VALUES
(1, 1, 'Москва', 'Ленина', '10', '45'),
(2, 2, 'Санкт-Петербург', 'Невский проспект', '25', '12'),
(3, 1, 'Новосибирск', 'Красный проспект', '5', NULL)
ON CONFLICT DO NOTHING;

--changeset goodwoor:8
--comment Наполнение таблицы продуктов (products)
INSERT INTO products (id, title, price, sku) VALUES
(1, 'Смартфон Новая Модель', 59990.00, 'PHONE-NEW-01'),
(2, 'Беспроводные Наушники', 12490.00, 'EAR-WIRELESS-02'),
(3, 'Чехол для смартфона', 990.00, 'CASE-PHONE-03'),
(4, 'Кабель USB-C', 450.00, 'CABLE-USBC-04')
ON CONFLICT DO NOTHING;

--changeset goodwoor:9
--comment Наполнение таблицы заказов (orders)
INSERT INTO orders (id, user_id, created_at, status) VALUES
(1, 1, '2026-09-01 10:00:00', 'COMPLETED'),
(2, 1, '2026-09-05 14:30:00', 'IN_PROGRESS'),
(3, 2, '2026-09-06 18:15:00', 'CREATED')
ON CONFLICT DO NOTHING;

--changeset goodwoor:10
--comment Связывание заказов с продуктами (order_items)
INSERT INTO order_items (order_id, product_id, quantity) VALUES
(1, 1, 1), -- В заказе №1 лежит 1 смартфон
(1, 3, 2), -- В заказе №1 также лежит 2 чехла
(2, 2, 1), -- В заказе №2 лежат 1 наушники
(3, 1, 1), -- В заказе №3 лежит 1 смартфон
(3, 4, 3)  -- В заказе №3 также лежат 3 кабеля
ON CONFLICT DO NOTHING;

--changeset goodwoor:11
--comment Синхронизация генераторов ID (для PostgreSQL/H2 после ручного указания ID)
ALTER TABLE users ALTER COLUMN id RESTART WITH (SELECT MAX(id) + 1 FROM users);
ALTER TABLE addresses ALTER COLUMN id RESTART WITH (SELECT MAX(id) + 1 FROM addresses);
ALTER TABLE products ALTER COLUMN id RESTART WITH (SELECT MAX(id) + 1 FROM products);
ALTER TABLE orders ALTER COLUMN id RESTART WITH (SELECT MAX(id) + 1 FROM orders);