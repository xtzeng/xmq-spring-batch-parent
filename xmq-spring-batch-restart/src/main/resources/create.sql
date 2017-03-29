drop table if exists `people`;
CREATE TABLE `people` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(255) NOT NULL,
	`last_name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

INSERT INTO `people` (`id`, `first_name`, `last_name`) VALUES
	(1, 'xiaoti1', 'zeng1'),
	(2, 'xiaoti2', 'zeng2'),
	(3, 'xiaoti3', 'zeng3'),
	(4, 'xiaoti4', 'zeng4');

drop table if exists `people_desc`;
CREATE TABLE `people_desc` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(255) NULL DEFAULT NULL,
	`last_name` VARCHAR(255) NULL DEFAULT NULL,
	`batch_desc` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;