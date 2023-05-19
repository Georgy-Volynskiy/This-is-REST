USE my_db;

INSERT INTO roles (role) values ('ROLE_ADMIN'), ('ROLE_USER');

-- password = rinmin
INSERT INTO users (username, email, pass) values ('user1', 'user1@gmail.com', 'user1');

INSERT INTO user_role (user_id, role_id) values (1, 1);

INSERT INTO users (username, email, pass) values ('user2', 'user2@gmail.com', 'user2');

INSERT INTO user_role (user_id, role_id) values (2, 2);