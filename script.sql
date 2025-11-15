CREATE DATABASE IF NOT EXISTS `inventory-manager`;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;

create table CATEGORY (
	CATEGORY_ID INT,
	CATEGORY_NAME VARCHAR(50),
	PRIMARY KEY (CATEGORY_ID)
);

create table Product (
	product_id INT,
	product_name VARCHAR(50),
	product_category_id INT,
	product_price INT,
	product_stock INT,
	PRIMARY KEY (product_id),
	FOREIGN KEY (product_category_id) REFERENCES CATEGORY(CATEGORY_ID)
);

insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (1, 'Electronics');
insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (2, 'Kitchen');
insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (3, 'Spreads');
insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (4, 'Baking');
insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (5, 'Frozen Foods');
insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (6, 'Condiments');
insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (7, 'Clothing');
insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (8, 'Toys');
insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (9, 'Fitness');
insert into CATEGORY (CATEGORY_ID, CATEGORY_NAME) values (10, 'Outdoor');

insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1001, 'Pumpkin Spice Muffins', 5, 29291, 135);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1002, 'Cheddar & Bacon Potato Skins', 5, 38206, 35);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1003, 'Feta Cheese', 1, 18931, 57);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1004, 'Bird Feeder', 6, 40849, 136);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1005, 'Wireless Earbuds Case', 6, 32837, 109);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1006, 'Eggs', 6, 29433, 125);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1007, 'Hibiscus Herbal Tea', 6, 20565, 15);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1008, 'Fall-Themed Table Runner', 4, 37353, 124);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1009, 'Garlic Breadsticks', 9, 15754, 54);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1010, 'Kids Tablet', 5, 28237, 84);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1011, 'Dark Chocolate Covered Almonds', 8, 5465, 55);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1012, 'Cranberry Orange Juice', 6, 49267, 146);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1013, 'Black Olives', 3, 16426, 136);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1014, 'Lemon Pepper Seasoning', 7, 24341, 64);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1015, 'Smartphone Photography Tripod', 5, 46112, 83);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1016, 'Kale and Quinoa Salad', 3, 3343, 31);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1017, 'Smartphone Projector Kit', 7, 16932, 75);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1018, 'Baby Monitor', 9, 2979, 106);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1019, 'Energy Protein Bars', 1, 6362, 60);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1020, 'Nutritional Yeast', 4, 43395, 113);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1021, 'Pineapple Teriyaki Chicken Mix', 3, 46182, 140);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1022, 'Folding Backpack Chair', 7, 44236, 122);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1023, 'Interchangeable Watch Bands', 2, 19129, 103);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1024, 'Pumpkin Puree', 6, 18055, 54);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1025, 'Fitness Jump Box', 3, 48324, 108);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1026, 'Tea Infuser', 7, 22206, 19);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1027, 'Chicken Fajita Kit', 9, 25531, 127);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1028, 'Magnetic Phone Car Mount', 10, 10890, 91);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1029, 'Vegetarian Chili', 9, 44129, 90);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1030, 'Honey Wheat Pretzels', 1, 38027, 92);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1031, 'Spiced Pumpkin Soup', 8, 23484, 28);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1032, 'Foldable Electric Scooter', 3, 19916, 81);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1033, 'Under Desk Footrest', 5, 25388, 131);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1034, 'Tabletop Fire Pit', 3, 43422, 18);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1035, 'Crispy Onion Rings', 2, 8970, 29);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1036, 'Almond Coconut Granola', 8, 6493, 125);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1037, 'Herbal Tea Infuser', 6, 36611, 82);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1038, 'Body Wash', 4, 12800, 138);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1039, 'Chickpea Flour', 4, 24773, 115);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1040, 'Ripped Boyfriend Jeans', 6, 40665, 98);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1041, 'Craft Beer Mustard', 8, 32510, 25);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1042, 'Almond Butter Cookies', 4, 13068, 65);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1043, 'Non-Slip Yoga Socks', 3, 41422, 134);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1044, 'Foot Spa Bath Massager', 4, 37531, 142);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1045, 'Rechargeable Electric Screwdriver', 3, 9698, 23);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1046, 'Kale Salad Kit', 2, 38434, 40);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1047, 'Brown Sugar', 3, 10529, 24);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1048, 'Noise-Canceling Headphones', 6, 1400, 10);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1049, 'Chocolate Hazelnut Granola', 8, 41851, 39);
insert into Product (product_id, product_name, product_category_id, product_price, product_stock) values (1050, 'Two-Tier Fruit Basket', 9, 29339, 103);