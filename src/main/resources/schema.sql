create table if not exists t_user (
  id       serial,
  username    varchar(32),
  password varchar(32),
  passwordConfirm varchar(32)
);

create table if not exists t_role (
  id       serial,
  name    varchar(32)
);