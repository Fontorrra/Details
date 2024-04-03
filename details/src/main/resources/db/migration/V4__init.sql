CREATE TABLE sells(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    detail_id BIGINT NOT NULL,
    count BIGINT NOT NULL,
    total_price BIGINT NOT NULL,
    is_paid BOOLEAN NOT NULL DEFAULT false,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (detail_id) REFERENCES details(id)
);

INSERT INTO sells (user_id, detail_id, count, total_price, is_paid) VALUES
(1, 1, 3, 1500, false),
(2, 2, 5, 2500, true),
(1, 3, 2, 1000, false
);