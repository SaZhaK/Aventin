create table if not exists t_user
(
  id              serial,
  username        varchar(255),
  password        varchar(255)
);

create table if not exists t_role
(
  id       serial,
  name     varchar(255)
);

create table if not exists t_user_roles
(
  user_id       bigint not null,
  roles_id      bigint not null
);