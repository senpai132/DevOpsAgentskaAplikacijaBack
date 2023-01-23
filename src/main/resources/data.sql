INSERT INTO authority (name) VALUES
    ('ROLE_ADMIN'),
    ('ROLE_CLIENT');

INSERT INTO client (id, username, password) VALUES
    (1201, 'admin', '$2a$10$av7zaFCEOUdda1qqXS1cVuL8V4Fzn7tWTHG47iU7Ah5Het2Nd19Ky'),
    (1202, 'uki', '$2a$10$av7zaFCEOUdda1qqXS1cVuL8V4Fzn7tWTHG47iU7Ah5Het2Nd19Ky'),
    (1203, 'bob', '$2a$10$av7zaFCEOUdda1qqXS1cVuL8V4Fzn7tWTHG47iU7Ah5Het2Nd19Ky'),
    (1204, 'peca', '$2a$10$av7zaFCEOUdda1qqXS1cVuL8V4Fzn7tWTHG47iU7Ah5Het2Nd19Ky'),
    (1205, 'jova', '$2a$10$av7zaFCEOUdda1qqXS1cVuL8V4Fzn7tWTHG47iU7Ah5Het2Nd19Ky'),
    (1206, 'ana', '$2a$10$av7zaFCEOUdda1qqXS1cVuL8V4Fzn7tWTHG47iU7Ah5Het2Nd19Ky');

INSERT INTO client_authority (client_id, authority_id) VALUES
    (1201, 1),
    (1202, 2),
    (1203, 2),
    (1204, 2),
    (1205, 2),
    (1206, 2);

INSERT INTO company (id, name, owner, culture, description, address, status, phone_number, email_address) VALUES
    (1201, 'Levi', 'uki', 'Free', 'Netherland company', 'Newyork 2', 1, '555333', 'levi@gmail.com'),
    (1202, 'Vega', 'bob', 'Closed', 'Home field', 'Bulevar 1', 1, '555333', 'vega@gmail.com'),
    (1203, 'Microsoft', 'uki', 'Test driven', 'Famous', 'Bulevar 2', 0, '555333', 'microsoft@gmail.com'),
    (1204, 'DMS', 'bob', 'Free', 'Large', 'Bulevar 3', 0, '555333', 'dms@gmail.com'),
    (1205, 'Simphony', 'bob', 'Closed', 'Small', 'Bulevar 4', 1, '555333', 'simphony@gmail.com'),
    (1206, 'Electro', 'uki', 'Free', 'Extra', 'Bulevar 5', 1, '555333', 'electro@gmail.com');