DROP TABLE IF EXISTS `subscriptions`;
DROP TABLE IF EXISTS `likes`;
DROP TABLE IF EXISTS `comments`;
DROP TABLE IF EXISTS `posts`;
DROP TABLE IF EXISTS `postImages`;
DROP TABLE IF EXISTS `users`;



CREATE TABLE `users` (
  `id` varchar(45) NOT NULL UNIQUE,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `postsCount` int(11) NOT NULL DEFAULT '0',
  `subscriptionsCount` int(11) NOT NULL DEFAULT '0',
  `subscribersCount` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);


CREATE TABLE `subscriptions` (
  `id` varchar(45) NOT NULL UNIQUE,
  `subscriber` varchar(45) NOT NULL,
  `subscribedTo` varchar(45) NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_subscriptions_1_idx` (`subscriber`),
  KEY `fk_subscriptions_2_idx` (`subscribedTo`),
  CONSTRAINT `fk_subscriptions_1` FOREIGN KEY (`subscriber`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_subscriptions_2` FOREIGN KEY (`subscribedTo`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE `postImages` (
  `id` varchar(45) NOT NULL UNIQUE,
  `imageData` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `posts` (
  `id` varchar(45) NOT NULL UNIQUE,
  `userId` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `image` varchar(45) NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_posts_1_idx` (`userId`),
  CONSTRAINT `fk_posts_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_posts_2` FOREIGN KEY (`image`) REFERENCES `postImages` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE `likes` (
  `id` varchar(45) NOT NULL UNIQUE,
  `userId` varchar(45) NOT NULL,
  `postId` varchar(45) NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_likes_1_idx` (`userId`),
  KEY `fk_likes_2_idx` (`postId`),
  CONSTRAINT `fk_likes_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_likes_2` FOREIGN KEY (`postId`) REFERENCES `posts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE `comments` (
  `id` varchar(45) NOT NULL UNIQUE,
  `userId` varchar(45) NOT NULL,
  `postId` varchar(45) NOT NULL,
  `text` varchar(45) NOT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_comments_1_idx` (`userId`),
  CONSTRAINT `fk_comments_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)  ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comments_2` FOREIGN KEY (`postId`) REFERENCES `posts` (`id`)  ON DELETE CASCADE ON UPDATE CASCADE
);



INSERT INTO `users` (ID, USERNAME, PASSWORD, EMAIL) VALUES ('1', 'user1','pass1','user1@email.com');
INSERT INTO `users` (ID, USERNAME, PASSWORD, EMAIL) VALUES ('2', 'user2','pass2','user2@email.com');
INSERT INTO `users` (ID, USERNAME, PASSWORD, EMAIL) VALUES ('3', 'user3','pass3','user3@email.com');

INSERT INTO `subscriptions` (ID, SUBSCRIBER, SUBSCRIBEDTO) VALUES ('1', '1', '3');
INSERT INTO `subscriptions` (ID, SUBSCRIBER, SUBSCRIBEDTO) VALUES ('2', '2', '3');
INSERT INTO `subscriptions` (ID, SUBSCRIBER, SUBSCRIBEDTO) VALUES ('3', '3', '1');

INSERT INTO `postImages` (ID, imageData) VALUES ('1', '9fad5e9eefdfb449');
INSERT INTO `postImages` (ID, imageData) VALUES ('2', '9fad5e9eefdfb449');
INSERT INTO `postImages` (ID, imageData) VALUES ('3', '9fad5e9eefdfb449');
INSERT INTO `postImages` (ID, imageData) VALUES ('4', '9fad5e9eefdfb449');

INSERT INTO `posts` (ID, USERID, DESCRIPTION, IMAGE) VALUES ('1' ,'2', 'user post 1', '1');
INSERT INTO `posts` (ID, USERID, DESCRIPTION, IMAGE) VALUES ('2' ,'3', 'user post 2', '2');
INSERT INTO `posts` (ID, USERID, DESCRIPTION, IMAGE) VALUES ('3' ,'1', 'user post 3', '3');
INSERT INTO `posts` (ID, USERID, DESCRIPTION, IMAGE) VALUES ('4' ,'1', 'user post 4', '4');

INSERT INTO `likes` (ID, USERID, POSTID) VALUES ('1', '1', '2');
INSERT INTO `likes` (ID, USERID, POSTID) VALUES ('2', '1', '4');
INSERT INTO `likes` (ID, USERID, POSTID) VALUES ('3', '2', '3');
INSERT INTO `likes` (ID, USERID, POSTID) VALUES ('4', '3', '1');

INSERT INTO `comments` (ID, USERID, POSTID, TEXT) VALUES ('1', '1', '2', 'Great job');
INSERT INTO `comments` (ID, USERID, POSTID, TEXT) VALUES ('2', '3', '1', 'Excellent');
INSERT INTO `comments` (ID, USERID, POSTID, TEXT) VALUES ('3', '2', '4', 'Not half bad');
