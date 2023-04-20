CREATE TABLE IF NOT EXISTS _user
(
    id        INT PRIMARY KEY,
    firstname varchar(20),
    lastname  varchar(20),
    email     varchar(20),
    password  varchar(200),
    role      integer
);
INSERT INTO _user (id, firstname, lastname, email, password, role)
VALUES (1, 'John', 'Doe', 'john@doe.com', '$2a$10$ZtKaPqAzB1gvUatukZuExuW3WjPSDu0iaJkyvRPnxdzsFUp4GseY.', 0);

CREATE TABLE IF NOT EXISTS words
(
    id   INT PRIMARY KEY,
    word varchar(14)
);

INSERT INTO words (id, word)
VALUES (1, 'reward'),
       (2, 'shiver'),
       (3, 'regret'),
       (4, 'carbon'),
       (5, 'island'),
       (6, 'impound'),
       (7, 'extreme'),
       (8, 'inspire'),
       (9, 'control'),
       (10, 'collapse'),
       (11, 'medicine'),
       (12, 'frighten'),
       (13, 'observer'),
       (14, 'classify'),
       (15, 'monstrous'),
       (16, 'orchestra'),
       (17, 'executive'),
       (18, 'fireplace'),
       (19, 'essential'),
       (20, 'prevalence'),
       (21, 'background'),
       (22, 'particular'),
       (23, 'attraction'),
       (24, 'pedestrian'),
       (25, 'unfortunate'),
       (26, 'charismatic'),
       (27, 'institution'),
       (28, 'destruction'),
       (29, 'presentation'),
       (30, 'manufacturer'),
       (31, 'interference'),
       (32, 'announcement'),
       (33, 'presidential'),
       (34, 'inappropriate'),
       (35, 'embarrassment'),
       (36, 'consideration'),
       (37, 'comprehensive'),
       (38, 'communication'),
       (39, 'representative'),
       (40, 'responsibility'),
       (41, 'constitutional'),
       (42, 'discrimination'),
       (43, 'recommendation')

