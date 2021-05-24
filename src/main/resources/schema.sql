create table if not exists t_user (
  id       serial,
  username    varchar(256),
  password varchar(256),
  passwordConfirm varchar(256)
);

create table if not exists t_role (
  id       serial,
  name    varchar(256)
);