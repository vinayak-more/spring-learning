create table user(
	id int(10) auto_increment primary key,
	seller_id int(10),
	name varchar(1000) not null,
	address varchar(25000),
	contact_number varchar(13)	
);

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
	CONSTRAINT fk_product_user FOREIGN KEY (seller_id)
  	REFERENCES user(id)
  	ON DELETE CASCADE
);


insert into user (name, address,contact_number)
	value("Vinayak","Mumbai",'7208467350');

insert into product (seller_id, name, height, price, description)
value(1,"Product 1",5.5,1000,"Product 1 description");