create database bank;
use bank;

drop table customer;
drop table transactions;
drop table transactions_list;

CREATE TABLE transactions (id int(10) NOT NULL AUTO_INCREMENT, 
							date date,
                            amount float,
                            type varchar(10),
                            PRIMARY KEY (id)
                            );
							


create table customer(id int(10) NOT NULL AUTO_INCREMENT, 
					name varchar(50),
                    address varchar(100),
                    phone varchar(15),
                    password varchar(20), 
                    balance float,
                    PRIMARY KEY (id)
                    );
                    
CREATE TABLE transactions_list (id int(10) NOT NULL AUTO_INCREMENT, 
							customerid int not null,
                            transactionid  int not null,
                            PRIMARY KEY (id),
                            FOREIGN KEY (customerid) references customer(id),
                            FOREIGN KEY (transactionid) references transactions(id)
                            );
                            

                    
                    
insert into customer(name, address, phone, password, balance) values("User1", "123 main street", "1234567890", "pw123", 26456.23);
insert into customer(name, address, phone, password, balance) values("User2", "55 main street", "123456", "pw55", 11232.66);
 
insert into transactions(date, amount, type) values("2022-1-1", 234.67, "deposit");
insert into transactions(date, amount, type) values("2022-1-11", -20.22, "withdraw");


INSERT INTO transactions_list(customerid, transactionid) values (1, 1);


DELETE from transactions WHERE id = 2;
 
select * from customer;
select * from transactions;
select * from transactions_list;
                    

                    
                    