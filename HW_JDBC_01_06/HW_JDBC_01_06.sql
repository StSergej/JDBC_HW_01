Drop database Test;

Create database Test;

use  test;

CREATE TABLE Categories (
        CategoryId  INT auto_increment primary key,  
        CategoryName VARCHAR(50) NOT NULL
   );
   
INSERT INTO Categories(CategoryName)
	VALUES ('Комплектующие ПК'),
			('Мобильные устройства');
      


   CREATE TABLE Goods (
        ProductId INT auto_increment primary key, 
        Category  INT NOT NULL,
        ProductName  VARCHAR(50) NOT NULL,
        Price  INT NULL
	);
   
   INSERT INTO Goods(Category, ProductName, Price)
        VALUES (1, 'Системный блок', 10000),
				(1, 'Монитор', 3500),
				(2, 'Смартфон', 8500);

select * from categories;

select * from goods;

