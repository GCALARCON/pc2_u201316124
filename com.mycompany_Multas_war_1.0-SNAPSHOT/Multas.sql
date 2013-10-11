SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

SHOW WARNINGS;
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Contribuyente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Contribuyente` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Contribuyente` (
  `ruc` BIGINT(11) NOT NULL,
  `razon` VARCHAR(60) NULL,
  PRIMARY KEY (`ruc`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `ruc_UNIQUE` ON `Contribuyente` (`ruc` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Tributo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Tributo` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Tributo` (
  `id` BIGINT(4) NOT NULL,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `id_UNIQUE` ON `Tributo` (`id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Multas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Multas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Multas` (
  `id` BIGINT(8) NOT NULL,
  `id_ruc` BIGINT(11) NULL,
  `periodo` DATETIME NULL,
  `id_tributario` BIGINT(4) NULL,
  `importe` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `contribuyente_idx` ON `Multas` (`id_ruc` ASC);

SHOW WARNINGS;
CREATE INDEX `tributo_idx` ON `Multas` (`id_tributario` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
