CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  username VARCHAR(30) NOT NULL UNIQUE,
  password VARCHAR(80) NOT NULL,
  email VARCHAR(50) UNIQUE
);


CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE users_roles (
  user_id BIGINT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id)
);


INSERT INTO roles (name)
VALUES
('ROLE_USER'),
('ROLE_ADMIN');

INSERT INTO users (username, password, email)
VALUES
('user', '$2y$10$/HdiQiv9V2WK50InBLCJq.7V5C2K3VMy6gwrlFaRoz81JKfvBFW42', 'user@gmail.com'),
('admin', '$2y$10$2L1hdvSTtxwvI1BYfeH0K.ZRigQhut8NkIx1pq/2BTmdamEzdKaYi', 'admin@gmail.com');

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(2, 2);