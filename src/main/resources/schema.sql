create table if not exists user (
  id       serial,
  login    varchar(32),
  password varchar(32),
  passwordConfirm varchar(32)
);

create table if not exists role (
  id       serial,
  name    varchar(32)
);