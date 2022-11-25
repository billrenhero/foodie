DROP TABLE IF EXISTS foodie;
CREATE TABLE `foodie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location_id` varchar(16) NOT NULL,
  `applicant` varchar(128) NOT NULL,
  `facility_type` int NOT NULL COMMENT '0-NULL 1-Truck 2-Push Cart',
  `location_description` varchar(512) NOT NULL,
  `address` varchar(256) NOT NULL,
  `status` int NOT NULL COMMENT '0-NULL 1-APPROVED 2-REQUESTED 3-EXPIRED 4-SUSPEND 5-ISSUED 6-ONLINE',
  `food_items` varchar(1024) NOT NULL,
  `latitude` varchar(64) NOT NULL,
  `longitude` varchar(64) NOT NULL,
  `zip_code` varchar(16) NOT NULL,
  `neighborhoods` int NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY uniq_location_id (location_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin COMMENT = 'foodie data';