CREATE TABLE purchases (
    id BIGSERIAL PRIMARY KEY,
    detail_id BIGINT NOT NULL,
    count BIGINT NOT NULL,
    total_price INT NOT NULL,
    FOREIGN KEY (detail_id) REFERENCES details(id)
);

INSERT INTO purchases (detail_id, count, total_price) VALUES
(1, 10, 100),
(2, 5, 50),
(3, 3, 30);