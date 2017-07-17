CREATE USER 'productdb'@'localhost' IDENTIFIED BY 'productdb';

GRANT CREATE,DELETE,INSERT,SELECT,UPDATE ON productdb.* TO 'productdb'@'localhost';

CREATE DATABASE  IF NOT EXISTS `productdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `productdb`;

create table product(
	id int(10) auto_increment primary key,
	seller_id int(10),
	name varchar(1000) not null,
	image_path varchar(10000),
	height double(10,2) not null,
	length double(10,2),
	width double(10,2),
	price double(10,2) not null default 0,
	description varchar(20000)
);

create table user(
	id int(10) auto_increment primary key,
	seller_id int(10),
	name varchar(1000) not null,
	address varchar(25000),
	contact_number int(13)
);

create table user_access(
	id int(10) auto_increment primary key,
	user_id int(10),
	username varchar(1000) not null,
	password varchar(1000) not null,
	online int(1) not null DEFAULT 1,
	CONSTRAINT fk_user_user_access FOREIGN KEY (user_id)
  	REFERENCES user(id)
  	ON DELETE CASCADE
);

create table pricing_info(
	id int(10) auto_increment primary key,
	product_id int(10),
	purchase_price double(10,2) not null,
	sale_price double(10,2) not null,
	amount_paid double(10,2) not null default 0,
	amount_balance double(10,2) not null default 0,
	discount double(10,2),
	CONSTRAINT fk_product_pricing_info FOREIGN KEY (product_id)
  	REFERENCES product(id)
  	ON DELETE CASCADE
  	ON UPDATE CASCADE 
);

create table inventory(
	id int(10) auto_increment primary key,
	product_id int(10),
	quantity int(10) not null default 0,
	CONSTRAINT fk_product_inventory FOREIGN KEY (product_id)
  	REFERENCES product(id)
);

create table booking(
	id int(10) auto_increment primary key,
	booking_id varchar(100) not null,
	seller_id int(10),
	product_id int(10),
	customer_id int(10),
	date timestamp not null default current_timestamp,
	pricing_info_id int(10),
	CONSTRAINT fk_booking_customer FOREIGN KEY (customer_id) REFERENCES user(id),
	CONSTRAINT fk_booking_product FOREIGN KEY (product_id) REFERENCES product(id),
	CONSTRAINT fk_booking_pricing_info FOREIGN KEY (pricing_info_id) REFERENCES pricing_info(id)
);

