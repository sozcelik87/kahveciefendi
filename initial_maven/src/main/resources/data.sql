insert into PRODUCT(ID,NAME,PRICE,PRODUCT_TYPE) values(1,'Filtre Kahve',400,'BEVERAGE');
insert into PRODUCT(ID,NAME,PRICE,PRODUCT_TYPE) values(2,'Latte',500,'BEVERAGE');
insert into PRODUCT(ID,NAME,PRICE,PRODUCT_TYPE) values(3,'Mocha',600,'BEVERAGE');
insert into PRODUCT(ID,NAME,PRICE,PRODUCT_TYPE) values(4,'Çay',300,'BEVERAGE');
insert into PRODUCT(ID,NAME,PRICE,PRODUCT_TYPE) values(5,'Türk Kahvesi',500,'BEVERAGE');

insert into PRODUCT(ID,NAME,PRICE,PRODUCT_TYPE) values(6,'Süt',200,'ADDITION');
insert into PRODUCT(ID,NAME,PRICE,PRODUCT_TYPE) values(7,'Fındık Şurubu',300,'ADDITION');
insert into PRODUCT(ID,NAME,PRICE,PRODUCT_TYPE) values(8,'Çikolata Sosu',500,'ADDITION');
insert into PRODUCT(ID,NAME,PRICE,PRODUCT_TYPE) values(9,'Limon',200,'ADDITION');

insert into BEVERAGE_ADDITION_MAP(BEVERAGE_ID,ADDITION_ID) values (1,6);
insert into BEVERAGE_ADDITION_MAP(BEVERAGE_ID,ADDITION_ID) values (2,7);
insert into BEVERAGE_ADDITION_MAP(BEVERAGE_ID,ADDITION_ID) values (2,8);
insert into BEVERAGE_ADDITION_MAP(BEVERAGE_ID,ADDITION_ID) values (3,7);
insert into BEVERAGE_ADDITION_MAP(BEVERAGE_ID,ADDITION_ID) values (3,8);
insert into BEVERAGE_ADDITION_MAP(BEVERAGE_ID,ADDITION_ID) values (4,9);
insert into BEVERAGE_ADDITION_MAP(BEVERAGE_ID,ADDITION_ID) values (5,6);

insert into PAYMENT_TYPE(ID,NAME) values(1,'Nakit');
insert into PAYMENT_TYPE(ID,NAME) values(2,'Kredi Kartı');
insert into PAYMENT_TYPE(ID,NAME) values(3,'Sodexo');
insert into PAYMENT_TYPE(ID,NAME) values(4,'Multinet');
insert into PAYMENT_TYPE(ID,NAME) values(5,'SetCard');
