INSERT INTO USER (id, username, password, role) VALUES
(1, 'admin', '$2a$10$2yQw7K1YwZKnD3OvlJtI5OoykZcW.ycKQu9OQl6pZRt6dd78Wq9ma', 'ROLE_ADMIN'),
(2, 'user', '$2a$10$2yQw7K1YwZKnD3OvlJtI5OoykZcW.ycKQu9OQl6pZRt6dd78Wq9ma', 'ROLE_USER');

-- password: password

INSERT INTO BOOK (id, title, author, isbn, price, stock) VALUES
(1, 'Effective Java', 'Joshua Bloch', '9780134685991', 45.00, 10),
(2, 'Clean Code', 'Robert C. Martin', '9780132350884', 40.00, 15),
(3, 'Spring in Action', 'Craig Walls', '9781617294945', 50.00, 5);
