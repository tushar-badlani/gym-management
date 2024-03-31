use gym;
CREATE TABLE customer(customer_id int Primary key, customer_name varchar(50), age int, address varchar(50),staff_id int);
CREATE TABLE equipment(equipment_id int Primary key, brand_name varchar(50), weight int, colour varchar(50),price int,mem_type varchar(50),equip_name varchar(50));
CREATE TABLE staff(staff_id int Primary key, staff_name varchar(50), salary int, work_duration int,staff_type varchar(50));
CREATE TABLE brand(brand_name varchar(50) Primary key,total_products int);
CREATE TABLE membershipPlan(mem_type varchar(50),duration_left int,customer_id int);
insert into equipment values(1,'Decathlon',5,'black',450,'Regular','Dumb Bells');
insert into equipment values(2,'Decathlon',30,'black',1200,'Regular','Pull up bar');
insert into equipment values(3,'Precor',10,'red',850,'Regular','Dumb Bells');
insert into equipment values(4,'Precor',150,'red',65000,'VIP','Treadmill');
insert into equipment values(5,'Precor',10,'black',550,'Regular','Dumb Bells');
insert into equipment values(6,'Precor',100,'black',10000,'VIP','Exercise Bench');
insert into equipment values(7,'Precor',50,'red',4000,'Regular','Dip Bar');
insert into equipment values(8,'Paramount',15,'black',1050,'Regular','Kettlebell');
insert into equipment values(9,'Star Trac',85,'red',450,'Regular','Exercise Bench');
insert into equipment values(10,'Star Trac',30,'black',1500,'VIP','Pull up bar');
insert into equipment values(11,'Star Trac',150,'black',45000,'Regular','Treadmill');
insert into brand values('Decathlon',2);
insert into brand values('Precor',5);
insert into brand values('Paramount',1);
insert into brand values('Star Trac',3);
insert into customer values(1,'Modi',67,'Delhi','7');
insert into customer values(2,'Ashwat',19,'Rohini','2');
insert into customer values(3,'Utkarsh',19,'Rohini','7');
insert into customer values(4,'Thanos',10000,'eternal colony','10');
insert into customer values(5,'Tiger',22,'Okhla','3');
insert into customer values(6,'Kohli',26,'Delhi','7');
insert into customer values(7,'Alax',16,'Rohini','2');
insert into customer values(8,'Rohit',32,'Okhla','4');
insert into staff values(7,'Raja',100000,5,'Trainer');
insert into staff values(2,'Alok',40000,6,'Trainer');
insert into staff values(10,'Black Dwarf',1000000,3,'Trainer');
insert into staff values(3,'Nitish',15000,2,'Trainer');
insert into staff values(4,'Kaalia',25000,2,'Trainer');
insert into staff values(1,'Proxima Midnight',50000,4,'Management');
insert into staff values(5,'Lukaku',40000,2,'Management');
insert into staff values(8,'Heisenberg',20000,5,'Management');
insert into membershipplan values('VIP',2,1);
insert into membershipplan values('VIP',3,2);
insert into membershipplan values('VIP',3,3);
insert into membershipplan values('VIP',10000,4);
insert into membershipplan values('Regular',5,5);
insert into membershipplan values('VIP',1,6);
insert into membershipplan values('Regular',5,7);
insert into membershipplan values('Regular',4,8);
insert into staff values(7,'Raja',100000,5,'Trainer');
select distinct customer_name from customer INNER JOIN membershipplan ON customer.customer_id=membershipplan.customer_id where mem_type='VIP';
select distinct customer_id from membershipplan INNER JOIN equipment where price>30000 and membershipplan.mem_type='VIP'; 
select customer_name from customer INNER JOIN staff ON customer.staff_id=staff.staff_id where staff.salary>40000;
select * from customer INNER JOIN membershipplan; 
select staff_name from staff where salary>20000 and work_duration>3;
select customer_id from membershipPLan where mem_type='Regular';
select brand_name from brand where total_products>=3;
select * from customer;
update brand set total_products=2 where brand_name = 'Decathlon';
delete from customer where customer_id=2;
select customer_name from customer where staff_id=7;
select * from customer where address='Rohini';