CREATE TABLE telegram_users
(
    id       serial not null primary key,
    nickname text   NOT NULL
);

CREATE SEQUENCE public.hibernate_sequence START 1;