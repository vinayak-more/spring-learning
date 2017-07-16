create table product(
	id int(10) auto increment primary key,
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
	id int(10) auto increment primary key,
	seller_id int(10),
	name varchar(1000) not null,
	address varchar(25000),
	contact_number int(13),
);

create table pricing_info(
	id int(10) auto increment primary key,
	product_id int(10),
	purchase_price double(10,2) not null,
	sale_price double(10,2) not null,
	amount_paid double(10,2) not null default 0,
	amount_balance double(10,2) not null default 0,
	discount double(10,2)
);

create table booking(
	id int(10) auto increment primary key,
	booking_id varchar(100) not null,
	seller_id int(10),
	product_id int(10),
	customer_id int(10),
	date timestamp not null default current_date,
	pricing_info_id int(10)
);

create table inventory(
	id int(10) auto increment primary key,
	product_id int(10),
	quantity int(10) not null default 0
);