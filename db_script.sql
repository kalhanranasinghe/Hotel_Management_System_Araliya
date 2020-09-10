-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hotel_management_system_dinuka
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel_management_system_dinuka
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel_management_system_dinuka` DEFAULT CHARACTER SET utf8 ;
USE `hotel_management_system_dinuka` ;

-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `contact_no` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `loyalty` INT NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`event` (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NULL,
  `date` VARCHAR(45) NULL,
  `time` VARCHAR(45) NULL,
  `no_of_members` INT NULL,
  `price` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`event_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`stock` (
  `stock_id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `qty` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`stock_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`invoice` (
  `invoice_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NULL,
  `bonus` DOUBLE NULL,
  `price` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`invoice_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`invoice_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`invoice_details` (
  `invoice_details_id` INT NOT NULL AUTO_INCREMENT,
  `invoice_id` INT NULL,
  `stock_id` INT NULL,
  `qty` DOUBLE NULL,
  `total` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`invoice_details_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`grn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`grn` (
  `grn_id` INT NOT NULL AUTO_INCREMENT,
  `stock_id` INT NULL,
  `supplier_id` INT NULL,
  `qty` DOUBLE NULL,
  `ststus` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`grn_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`supplier` (
  `supplier_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `contact` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`supplier_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`tours`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`tours` (
  `tours` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `start_location` VARCHAR(45) NULL,
  `end_location` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `special` VARCHAR(45) NULL,
  `description` VARCHAR(455) NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`tours`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`tour_booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`tour_booking` (
  `tour_booking_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NULL,
  `no_of_members` INT NULL,
  `date` VARCHAR(45) NULL,
  `total_price` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`tour_booking_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `nic` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `contact` VARCHAR(45) NULL,
  `basic_salary` DOUBLE NULL,
  `designation` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`employee_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`housekeeping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`housekeeping` (
  `housekeeping_id` INT NOT NULL,
  `employee_id` INT NULL,
  `task` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`housekeeping_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`room` (
  `room_id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `qty` INT NULL,
  `price` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`room_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`reservation` (
  `reservation_id` INT NOT NULL AUTO_INCREMENT,
  `room_id` INT NULL,
  `start_date` VARCHAR(45) NULL,
  `end_date` VARCHAR(45) NULL,
  `no_of_members` INT NULL,
  `total` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`reservation_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_management_system_dinuka`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_management_system_dinuka`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL,
  `user_type` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
