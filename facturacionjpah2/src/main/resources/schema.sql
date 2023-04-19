CREATE TABLE IF NOT EXISTS clients(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(75),
    lastname varchar(75),
    docNumber varchar(11) NOT NULL UNIQUE,
    status bit NOT NULL DEFAULT true,
    PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS invoice(
    id int NOT NULL AUTO_INCREMENT,
    client_id INT NOT NULL,
    created_at DATE,
    total double DEFAULT 0,
    status bit NOT NULL DEFAULT true,
    PRIMARY KEY (id),
    CONSTRAINT fk_id_client_tbl	FOREIGN KEY(client_id) REFERENCES clients(id)
	);



CREATE TABLE IF NOT EXISTS products(
    id int NOT NULL AUTO_INCREMENT,
    description varchar(150),
    code varchar(50),
    stock int,
    price double,
    status bit NOT NULL DEFAULT true,
    PRIMARY KEY (id)
    );



CREATE TABLE IF NOT EXISTS invoice_details(
    invoice_details_id int NOT NULL AUTO_INCREMENT,
    invoice_id int NOT NULL,
    amount int,
    product_id int NOT NULL,
    product_price double NOT NULL,
    price double NOT NULL,
    status bit NOT NULL DEFAULT true,
    PRIMARY KEY (invoice_details_id),
    CONSTRAINT fk_id_product_tbl FOREIGN KEY(product_id) REFERENCES products(id),
    CONSTRAINT fk_id_invoice_tbl FOREIGN KEY(invoice_id) REFERENCES invoice(id)
    );

INSERT INTO CLIENTS (NAME, LASTNAME ,DOCNUMBER)
VALUES ('Tony','Stark','40000000'),('Bruce','Banner','40000001'),('Steve','Rogers','20000000'),('Natasha','Romanoff','50000000'),('Chris','Hemsworrth','30000000'),('Clint','Barton','40000002');


INSERT INTO PRODUCTS (CODE ,DESCRIPTION ,STOCK ,PRICE )
VALUES('NTBK0001','NOTEBOOK ALIENWARE',100,900.000),('LENT0001','LENTES',100,120.00),('ESCD0001','ESCUDO DE VIBRANIUM',100,400.00),('BAST0001','BASTONES',100,250.00),('MART0001','MARTILLO DE METAL URU',100,600.00),('ARCO0001','ARCO DE ACERO',100,300.00);
     
	 
	 
	 
	 







