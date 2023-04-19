CREATE TABLE IF NOT EXISTS _user(
                      id INT  PRIMARY KEY,
                      firstname varchar(20),
                      lastname varchar(20) ,
                      email varchar(20),
                      password varchar(200),
                      role integer);
INSERT INTO _user (id,firstname, lastname, email, password, role) VALUES (1,'John', 'Doe', 'john@doe.com', '$2a$10$ZtKaPqAzB1gvUatukZuExuW3WjPSDu0iaJkyvRPnxdzsFUp4GseY.',0);
