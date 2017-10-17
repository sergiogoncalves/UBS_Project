/**
 * CREATE Script for init of DB
 */
 
insert into product (id, name, description, price) values (1, 'Iphone 8', 'New Apples mobile', 1500);
 
insert into product (id, name, description, price) values (2, 'MOTO Z', 'New Mobile from Motorola', 750);
 
insert into order_table (id, product_id, quantity, total_Price, promotion_offer) values (1, 1, 2, 3000, false);
 
insert into order_table (id, product_id, quantity, total_Price, promotion_offer) values (2, 2, 2, 3000, false);

insert into special_offer(id, amount, unit, discount, product_id) values(1, 2, 1, 25, 1);

insert into cart(id, currency) values(1, 'EURO');
 