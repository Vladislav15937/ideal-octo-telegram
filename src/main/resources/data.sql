insert into users (username, password, email) values ('lera', '$2a$12$u65JeeRAQVrPBhwGcFBQ/uF8HaNOODOG0zVY2Q.DKPnl78BqQIUP.', 'lera@lera.ru');
# пароль lera
insert into roles (id, name) values (1, 'ROLE_ADMIN'),(2, 'ROLE_USER');
insert into users_roles(user_id, role_id) values (1, 1), (1, 2);