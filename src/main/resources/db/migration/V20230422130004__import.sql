CREATE TABLE _user
(
    "id"        SERIAL PRIMARY KEY,
    "firstname" varchar(20),
    "lastname"  varchar(20),
    "email"     varchar(20),
    "password"  varchar(200),
    "role"      integer
);


INSERT INTO _user (firstname, lastname, email, password, role)
VALUES ('John', 'Doe', 'john@doe.com', '$2a$10$ZtKaPqAzB1gvUatukZuExuW3WjPSDu0iaJkyvRPnxdzsFUp4GseY.', 0),
       ('God', 'Game', 'god@game.com', '$2a$10$ZtKaPqAzB1gvUatukZuExuW3WjPSDu0iaJkyvRPnxdzsFUp4GseY.', 0),
       ('Rich', 'Versus', 'rich@versus.com', '$2a$10$ZtKaPqAzB1gvUatukZuExuW3WjPSDu0iaJkyvRPnxdzsFUp4GseY.', 0);

CREATE TABLE words
(
    "id"   SERIAL PRIMARY KEY,
    "word" varchar(14)
);


INSERT INTO words (word)
VALUES ('reward'),
       ('shiver'),
       ('regret'),
       ('carbon'),
       ('island'),
       ('impound'),
       ('extreme'),
       ('inspire'),
       ('control'),
       ('collapse'),
       ('medicine'),
       ('frighten'),
       ('observer'),
       ('classify'),
       ('monstrous'),
       ('orchestra'),
       ('executive'),
       ('fireplace'),
       ('essential'),
       ('prevalence'),
       ('background'),
       ('particular'),
       ('attraction'),
       ('pedestrian'),
       ('unfortunate'),
       ('charismatic'),
       ('institution'),
       ('destruction'),
       ('presentation'),
       ('manufacturer'),
       ('interference'),
       ('announcement'),
       ('presidential'),
       ('inappropriate'),
       ('embarrassment'),
       ('consideration'),
       ('comprehensive'),
       ('communication'),
       ('representative'),
       ('responsibility'),
       ('constitutional'),
       ('discrimination'),
       ('recommendation');
CREATE TABLE game
(
    "id"              SERIAL PRIMARY KEY,
    "actual_word"     varchar(255) not null,
    "wrong_counter"   integer,
    "tried_character" varchar(20),
    "user_id"         integer      not null references _user ("id"),
    "word_id"         integer      not null references words ("id"),
    "game_state"      varchar(32)  not null
);
INSERT INTO game (actual_word, wrong_counter, tried_character, user_id, word_id, game_state)
VALUES ('control', '0', 'contrl', '1', 9, 'SUCCESS'),
       ('island', '0', 'island', 1, 5, 'SUCCESS'),
       ('s*****', 6, 'softjuwk', 1, 2, 'DONE'),
       ('shiver', 0, 'shiver', 1, 2, 'SUCCESS'),
       ('inspire', 0, 'inspire', 3, 8, 'SUCCESS'),
       ('frighten', 0, 'frighten', 3, 12, 'SUCCESS');


CREATE TABLE game_higscore
(
    "user_id" int PRIMARY KEY references _user ("id"),
    "score"   int not null
);
INSERT INTO game_higscore (user_id, score)
VALUES (1, 4),
       (3, 2);


