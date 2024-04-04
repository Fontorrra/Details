CREATE TABLE colors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE details (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    color_id INT,
    sell_price INT NOT NULL,
    count INT NOT NULL,
    FOREIGN KEY (color_id) REFERENCES colors(id)
);


INSERT INTO colors (name) VALUES
('Red'),
('Blue'),
('Green');

INSERT INTO details (name, color_id, sell_price, count) VALUES
('Detail1', 1, 100, 10),
('Detail2', 2, 200, 20),
('Detail3', 1, 150, 15);