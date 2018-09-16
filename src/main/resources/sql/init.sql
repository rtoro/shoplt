INSERT INTO `shoplt`.`authority` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `shoplt`.`authority` (`name`) VALUES ('ROLE_USER');
INSERT INTO `shoplt`.`user_authority` (`user_id`,`authority_name`) VALUES (1,'ROLE_ADMIN');
INSERT INTO `shoplt`.`user_authority` (`user_id`,`authority_name`) VALUES (1,'ROLE_USER');
INSERT INTO `shoplt`.`user` (`created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `activated`, `email`, `first_name`, `lang_key`, `login`, `password_hash`) VALUES ('system', now(), now(), now(), true, 'asdf@asdf.com', 'admin', 'es', 'admin', '$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG');
