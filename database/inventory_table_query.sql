CREATE TABLE Inventory109(
   Part_ID  VARCHAR(50) primary key,
   Part_Name VARCHAR(200) not null,
   Price DECIMAL(10,2) not null,
   Quantity INT not null,
   Supplier_ID VARCHAR(50),
   Category VARCHAR(50),
   Location VARCHAR(100),
   Date_Added DATE not null,
   Date_Modified DATE 

);
INSERT INTO Inventory109(Part_ID, Part_Name, Price, Quantity, Supplier_ID, Category, Location, Date_Added, Date_Modified)
VALUES
('P001', 'Brake Pads', 400.00, 100, 'S002', 'Brakes', 'Shelf A1', '2022-02-10', '2023-02-10'),
('P002', 'Engine Oil Filter', 700.00, 50, 'S006', 'Engine', 'Shelf B2', '2023-02-20', '2023-12-20'),
('P003', 'Spark Plugs', 800.00, 70, 'S001', 'Engine', 'Shelf A3', '2022-08-15', '2023-01-15'),
('P004', 'Brake Rotors', 600.00, 40, 'S004', 'Brakes', 'Shelf A1', '2021-04-02', '2023-04-02'),
('P005', 'Air Filter', 900.00, 12, 'S008', 'Engine', 'Shelf B4', '2023-03-10', '2023-03-10'),
('P006', 'Transmission Fluid', 1200.00, 10, 'S009', 'Transmission', 'Shelf C2', '2021-03-10', '2023-03-10'),
('P007', 'Headlights', 500.00, 20, 'S011', 'Lights', 'Shelf D2', '2022-08-20', '2023-02-20');

SELECT * FROM Inventory109
