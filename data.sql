CREATE TABLE country (
    id bigserial CONSTRAINT pk_id_country PRIMARY KEY,
    name text NOT NULL
);

CREATE TABLE musician_role (
    id bigserial CONSTRAINT pk_id_role PRIMARY KEY,
    name text NOT NULL
);

CREATE TABLE band (
    id bigserial CONSTRAINT pk_id_band PRIMARY KEY,
    name text NOT NULL,
    country_id bigint REFERENCES country (id) 
);

CREATE TABLE artist (
    id bigserial CONSTRAINT pk_id_artist PRIMARY KEY,
    name text NOT NULL,
    age integer,
    place_of_origin_id bigint REFERENCES country (id)
);

CREATE TABLE artist_musician_roles (
    id bigserial CONSTRAINT pk_id_artist_roles PRIMARY KEY,
    artist_id bigint REFERENCES artist (id),
    musician_role_id bigint REFERENCES musician_role (id)
);

CREATE TABLE band_members (
    id bigserial CONSTRAINT pk_id_band_member PRIMARY KEY,
    artist_id bigint REFERENCES artist (id),
    band_id bigint REFERENCES band (id)
);

INSERT INTO country (name) VALUES
    ('EUA'),
    ('Sweden'),
    ('Finland');

INSERT INTO band (name, country_id) VALUES
    ('Avatar', 2),
    ('Type O Negative', 1),
    ('The 69 Eyes', 3),
    ('H.I.M.', 3),
    ('Pantera', 1),
    ('Korn', 1);

INSERT INTO musician_role (name) VALUES
    ('Vocals'),
    ('Guitars'),
    ('Bass'),
    ('Drums'),
    ('Keyboards');

INSERT INTO artist (name, age, place_of_origin_id) VALUES
    ('Johannes Michael Gustaf Eckerström', 32, 2),
    ('John Alfredsson', 32, 2),
    ('Jonas Jarlsby', 31, 2),
    ('Henrik Sandelin', 30, 2),
    ('Tim Öhrström', 28, 2),
    ('Kenny Hickey', 52, 1),
    ('Josh Silver', 55, 1),
    ('Peter Steele', 48, 1),
    ('Johnny Kelly', 50, 1),
    ('Arto Väinö Ensio Ojajärvi', null, 3),
    ('Pasi Moilanen', null, 3),
    ('Jussi Heikki Tapio Vuori', 45, 3),
    ('Jyrki Pekka Emil Linnankivi', 49, 3),
    ('Ville Hermanni Valo', 41, 3),
    ('Mikko Henrik Julius Paananen', 43, 3),
    ('Mikko Viljami Lindström', 41, 3),
    ('Janne Johannes Puurtinen', 43, 3),
    ('Jukka "Kosmo" Kröger', null, 3),
    ('Vinnie Paul', null, 1),
    ('Dimebag Darrell', null, 1),
    ('Rex Brown', 53, 1),
    ('Phil Anselmo', 50, 1),
    ('Jonathan Howsmon Davis', 47, 1),
    ('James Christian Shaffer', 48, 1),
    ('Reginald Quincy "Fieldy" Arvizu', 48, 1),
    ('Brian Philip Welch', 48, 1),
    ('Raymond Lee "Ray" Luzier', 48, 1);

INSERT INTO artist_musician_roles (artist_id, musician_role_id) VALUES
    (1, 1),
    (2, 4),
    (3, 2),
    (3, 1),
    (4, 3),
    (5, 2),
    (6, 2),
    (6, 1),
    (7, 5),
    (7, 1),
    (8, 1),
    (8, 3),
    (8, 2),
    (8, 5),
    (9, 4),
    (9, 1),
    (10, 3),
    (10, 1),
    (11, 2),
    (11, 1),
    (12, 4),
    (13, 1),
    (14, 1),
    (14, 2),
    (15, 3),
    (16, 2),
    (17, 5),
    (18, 4),
    (19, 4),
    (20, 2),
    (21, 3),
    (22, 1),
    (23, 1),
    (24, 2),
    (24, 1),
    (25, 3),
    (26, 2),
    (26, 1),
    (27, 4); 

INSERT INTO band_members (artist_id, band_id) VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1),
    (6, 2),
    (7, 2),
    (8, 2),
    (9, 2),
    (10, 3),
    (11, 3),
    (12, 3),
    (13, 3),
    (14, 4),
    (15, 4),
    (16, 4),
    (17, 4),
    (18, 4),
    (19, 5),
    (20, 5),
    (21, 5),
    (22, 5),
    (23, 6),
    (24, 6),
    (25, 6),
    (26, 6),
    (27, 6);