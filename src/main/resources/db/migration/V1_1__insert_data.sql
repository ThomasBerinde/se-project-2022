-- address data
INSERT INTO `se_project_2022`.`address` (`street`, `number`, `city`, `county`, `country`, `post_code`) VALUES ('Viilor ', '11', 'Baia Mare', 'Maramures', 'Romania', '430114');
INSERT INTO `se_project_2022`.`address` (`street`, `number`, `city`, `county`, `country`, `post_code`) VALUES ('Barbu-Stefanescu-Delavrancea', '23', 'Baia Mare', 'Maramures', 'Romania', '430155');
INSERT INTO `se_project_2022`.`address` (`street`, `number`, `city`, `county`, `country`, `post_code`) VALUES ('Observatorului', '32-34', 'Cluj-Napoca', 'Cluj', 'Romania', '400488');
INSERT INTO `se_project_2022`.`address` (`street`, `number`, `city`, `county`, `country`, `post_code`) VALUES ('Fabricii de Zahar', '56', 'Cluj-Napoca', 'Cluj', 'Romania', '400712');

-- account data
INSERT INTO `se_project_2022`.`account` (`email`, `first_name`, `last_name`, `phone_number`, `password`, `address_id`, `role`) VALUES ('thomas.berinde.99@gmail.com', 'Thomas', 'Berinde', '0756294614', '$2a$10$Yby08PHx5ZZqW6wHOcFY9ezq/yEewESEdCrP84.n/CJuBWq2zS2lG', '4', 'ADMIN');
INSERT INTO `se_project_2022`.`account` (`email`, `first_name`, `last_name`, `phone_number`, `password`, `address_id`, `role`) VALUES ('georgiana.bodea@yahoo.com', 'Georgiana', 'Bodea', '0745819223', '$2a$10$5ofD3sPgpwxZ5dsKiYhi3.jsI9oKMaikBMPe4SjI1CQHdpIa9LOkW', '3', 'ADMIN');
INSERT INTO `se_project_2022`.`account` (`email`, `first_name`, `last_name`, `phone_number`, `password`, `address_id`, `role`) VALUES ('maier.catalin@gmail.com', 'Andrei-Catalin', 'Maier', '0756102392', '$2a$10$HNI7bbdTT4uKt7Nj21yvhuytjD6X5WO9yqVJgLBelH6wSxAJBrecu', '3', 'USER');
INSERT INTO `se_project_2022`.`account` (`email`, `first_name`, `last_name`, `phone_number`, `password`, `address_id`, `role`) VALUES ('cristidora@gmail.com', 'Cristian-Adrian', 'Dora', '0734102100', '$2a$10$ka8bhGLZBkIRiHu74ikPOuU5RAejMPSOHo8MBLsPxrWrnsb7neA5C', '3', 'USER');
INSERT INTO `se_project_2022`.`account` (`email`, `first_name`, `last_name`, `phone_number`, `password`, `address_id`, `role`) VALUES ('raul_girbe@hotmail.com', 'Raul-Eugen ', 'Girbe', '+30 89 102 9192', '$2a$10$k3VkJzvpRN8OLmGpHGDMPegnViX.TNsBIBJjegezibJSMpjaBK6si', '2', 'USER');
INSERT INTO `se_project_2022`.`account` (`email`, `first_name`, `last_name`, `phone_number`, `password`, `address_id`, `role`) VALUES ('emmaberinde@gmail.com', 'Emma', 'Berinde', '0789102994', '$2a$10$iDrzR3EAh/vw0vdi0vQNUOOZmikOT/SlZPb5QMC06ETmo8opVAAgm', '1', 'USER');
INSERT INTO `se_project_2022`.`account` (`email`, `first_name`, `last_name`, `phone_number`, `password`, `address_id`, `role`) VALUES ('porumbadi2002@yahoo.ro', 'Adrian-Leonard', 'Porumb', '0756261223', '$2a$10$xa4ZVIVbREFPCH8jMASUB.lu4easrDAaV6U7cK9tPN6PUinHlahPG', '4', 'USER');
INSERT INTO `se_project_2022`.`account` (`email`, `first_name`, `last_name`, `phone_number`, `password`, `address_id`, `role`) VALUES ('luci7288@yahoo.com', 'Lucian', 'Boanches-Netea', '(+40) 789 201 288', '$2a$10$.Z3i8zH5zFz.f091MuBbmuFiRfUESKvIdFxeJCUKfeyidSMyiizZu', '4', 'USER');

-- category data
INSERT INTO `se_project_2022`.`category` (`name`) VALUES ('ELECTRONICS');
INSERT INTO `se_project_2022`.`category` (`name`) VALUES ('FASHION');
INSERT INTO `se_project_2022`.`category` (`name`) VALUES ('FOOD');
INSERT INTO `se_project_2022`.`category` (`name`) VALUES ('HOME_USE');

-- product data
INSERT INTO `se_project_2022`.`product` (`name`, `price`, `description`, `amount`, `img_url`) VALUES ('Phillips Hair Drier', '79.99', 'Phillips hair drier with 3 levels of power and 2 levels of heat', '100', '...');
INSERT INTO `se_project_2022`.`product` (`name`, `price`, `description`, `amount`, `img_url`) VALUES ('Bunica Sunflower Oil', '16.49', 'Cooking sunflower oil from natural sunflower from the south of Romania', '550', '...');
INSERT INTO `se_project_2022`.`product` (`name`, `price`, `description`, `amount`, `img_url`) VALUES ('Lenovo Legion Y530', '3899', 'Intel i5 8th gen, 8GB RAM, 1TB SSD, GeForce GTX 1080, 125GB SSD, Free DOS', '20', '...');
INSERT INTO `se_project_2022`.`product` (`name`, `price`, `description`, `amount`, `img_url`) VALUES ('MacBook Pro', '7999', 'Intel i7 12th gen, 512 SSD, 16GB RAM, Inel Graphics, MacOS Catalina 11.4', '40', '...');
INSERT INTO `se_project_2022`.`product` (`name`, `price`, `description`, `amount`, `img_url`) VALUES ('Calvin Kelin Jeans', '239.99', 'Standar Fit, 32/30, Dark Gray', '60', '...');
INSERT INTO `se_project_2022`.`product` (`name`, `price`, `amount`, `img_url`) VALUES ('Rowenda Robot Vacum Cleaner', '1999.99', '15', '...');
INSERT INTO `se_project_2022`.`product` (`name`, `price`, `amount`, `img_url`) VALUES ('Thermomix', '5590', '7', '...');

-- product_category data
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('1', '1');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('1', '4');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('2', '3');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('3', '1');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('4', '1');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('5', '2');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('6', '1');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('6', '4');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('7', '1');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('7', '3');
INSERT INTO `se_project_2022`.`product_category` (`product_id`, `category_id`) VALUES ('7', '4');