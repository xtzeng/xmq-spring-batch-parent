DROP TABLE IF EXISTS `registration_confirmation`;
CREATE TABLE `registration_confirmation` (
	`number` VARCHAR(255) NULL,
	`contact_id` INT NULL,
	`accepted` TINYINT NULL
)
COLLATE='utf8_general_ci'
;
