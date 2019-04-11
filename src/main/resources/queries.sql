/*Roles*/
insert into yoga_poses.role (role_id, role) values (1, 'ADMIN');
insert into yoga_poses.role (role_id, role) values (2, 'USER');

/*users*/
insert into yoga_poses.user (id, active, name, password)
values(1, 1,'ADMIN', '$2a$10$5lg54YksDRGEsZwyQTu6seOcPDPN4cbGNO6smS5LHPnVYvYOzhiau');

insert into yoga_poses.user (id, active, name, password)
values(2, 1, 'USER', '$2a$10$FTXFa36aZ1VXVc8.M8yNuuf0eCq/Q07cmHvktyw/QR/YY3pYxqW9q');

/*Add Role To User*/
insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (1, 2);
insert into user_role (user_id, role_id) values (2, 2);