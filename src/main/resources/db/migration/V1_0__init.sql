-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema se_project_2022
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `se_project_2022` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `se_project_2022` ;

-- -----------------------------------------------------
-- Table `se_project_2022`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `se_project_2022`.`address` ;

CREATE TABLE IF NOT EXISTS `se_project_2022`.`address` (
                                                           `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                           `street` VARCHAR(45) NOT NULL,
    `number` VARCHAR(45) NOT NULL,
    `city` VARCHAR(45) NOT NULL,
    `county` VARCHAR(45) NOT NULL,
    `country` VARCHAR(45) NOT NULL,
    `post_code` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `se_project_2022`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `se_project_2022`.`account` ;

CREATE TABLE IF NOT EXISTS `se_project_2022`.`account` (
                                                           `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                           `email` VARCHAR(100) NOT NULL,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `phone_number` VARCHAR(20) NOT NULL,
    `password` VARCHAR(1000) NOT NULL,
    `address_id` BIGINT UNSIGNED NOT NULL,
    `role` ENUM('ADMIN', 'USER') NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
    INDEX `fk_account_address_idx` (`address_id` ASC) VISIBLE,
    CONSTRAINT `fk_account_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `se_project_2022`.`address` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `se_project_2022`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `se_project_2022`.`category` ;

CREATE TABLE IF NOT EXISTS `se_project_2022`.`category` (
                                                            `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                            `name` ENUM('ELECTRONICS', 'FASHION', 'FOOD', 'HOME_USE') NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `se_project_2022`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `se_project_2022`.`product` ;

CREATE TABLE IF NOT EXISTS `se_project_2022`.`product` (
                                                           `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                           `name` VARCHAR(100) NOT NULL,
    `price` FLOAT UNSIGNED NOT NULL,
    `description` VARCHAR(1000) NULL DEFAULT NULL,
    `amount` INT UNSIGNED NOT NULL,
    `img_url` VARCHAR(1000) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `se_project_2022`.`product_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `se_project_2022`.`product_category` ;

CREATE TABLE IF NOT EXISTS `se_project_2022`.`product_category` (
                                                                    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                                    `product_id` BIGINT UNSIGNED NOT NULL,
                                                                    `category_id` BIGINT UNSIGNED NOT NULL,
                                                                    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_product_category_category_idx` (`category_id` ASC) VISIBLE,
    INDEX `fk_product_category_product_idx` (`product_id` ASC) VISIBLE,
    CONSTRAINT `fk_product_category_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `se_project_2022`.`category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_product_category_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `se_project_2022`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;