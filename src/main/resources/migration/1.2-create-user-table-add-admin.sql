CREATE TABLE `users` (
  `id` varchar (255) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_group` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


insert into users values( uuid(), false, 'test@email.com','testAdmin', '12345', 'ADMIN');