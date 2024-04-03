CREATE TABLE colors (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE details (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    color_id INT,
    sell_price BOOLEAN NOT NULL,
    count BOOLEAN NOT NULL,
    FOREIGN KEY (color_id) REFERENCES colors(id)
);


INSERT INTO colors (id, name) VALUES
(1, 'Red'),
(2, 'Blue'),
(3, 'Green');

INSERT INTO details (id, name, color_id, sell_price, count) VALUES
(1, 'Detail1', 1, 100, 10),
(2, 'Detail2', 2, 200, 20),
(3, 'Detail3', 1, 150, 15);