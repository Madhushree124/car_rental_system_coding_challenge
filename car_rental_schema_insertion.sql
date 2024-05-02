INSERT INTO Vehicle (vehicleID, make, model, year, dailyRate, status, passengerCapacity, engineCapacity)
VALUES
    (1, 'Toyota', 'Camry', 2022, 50.00, 'available', 4, 1450),
    (2, 'Honda', 'Civic', 2023, 45.00, 'available', 7, 1500),
    (3, 'Ford', 'Focus', 2022, 48.00, 'notAvailable', 4, 1400),
    (4, 'Nissan', 'Altima', 2023, 52.00, 'available', 7, 1200),
    (5, 'Chevrolet', 'Malibu', 2022, 47.00, 'available', 4, 1800),
    (6, 'Hyundai', 'Sonata', 2023, 49.00, 'notAvailable', 7, 1400),
    (7, 'BMW', '3 Series', 2023, 60.00, 'available', 7, 2499),
    (8, 'Mercedes', 'C-Class', 2022, 58.00, 'available', 8, 2599),
    (9, 'Audi', 'A4', 2022, 55.00, 'notAvailable', 4, 2500),
    (10, 'Lexus', 'ES', 2023, 54.00, 'available', 4, 2500),
    (11, 'Tesla', 'Model S', 2018, 70.00, 'available', 4, 2000),
    (12, 'Volkswagen', 'Jetta', 2022, 46.00, 'available', 5, 1600),
    (13, 'Kia', 'Optima', 2023, 48.00, 'available', 5, 1500),
    (14, 'Subaru', 'Legacy', 2020, 49.00, 'notAvailable', 5, 1700),
    (15, 'Mazda', 'Mazda6', 2010, 52.00, 'available', 5, 1550);
    
INSERT INTO Customer (customerID, firstName, lastName, email, phoneNumber)
VALUES
    (1, 'John', 'Doe', 'johndoe@example.com', '555-555-5555'),
    (2, 'Jane', 'Smith', 'janesmith@example.com', '555-123-4567'),
    (3, 'Robert', 'Johnson', 'robert@example.com', '555-789-1234'),
    (4, 'Sarah', 'Brown', 'sarah@example.com', '555-456-7890'),
    (5, 'David', 'Lee', 'david@example.com', '555-987-6543'),
    (6, 'Laura', 'Hall', 'laura@example.com', '555-234-5678'),
    (7, 'Michael', 'Davis', 'michael@example.com', '555-876-5432'),
    (8, 'Emma', 'Wilson', 'emma@example.com', '555-432-1098'),
    (9, 'William', 'Taylor', 'william@example.com', '555-321-6547'),
    (10, 'Olivia', 'Adams', 'olivia@example.com', '555-765-4321'),
    (11, 'Madhushree', 'T', 'madhushree@example.com', '555-111-2222'),
    (12, 'Shanthi', 'A', 'Shanthi@example.com', '555-333-4444'),
    (13, 'Ava', 'Lopez', 'ava@example.com', '555-555-6666'),
    (14, 'Daniel', 'Garcia', 'daniel@example.com', '555-777-8888'),
    (15, 'Isabella', 'Perez', 'isabella@example.com', '555-999-0000');

INSERT INTO Lease (leaseID, vehicleID, customerID, startDate, endDate, leaseType)
VALUES
    (1, 1, 1, '2023-01-01', '2023-01-05', 'Daily'),
    (2, 2, 2, '2023-02-15', '2023-02-28', 'Monthly'),
    (3, 3, 3, '2023-03-10', '2023-03-15', 'Daily'),
    (4, 4, 4, '2023-04-20', '2023-04-30', 'Monthly'),
    (5, 5, 5, '2023-05-05', '2023-05-10', 'Daily'),
    (6, 4, 3, '2023-06-15', '2023-06-30', 'Monthly'),
    (7, 7, 7, '2023-07-01', '2023-07-10', 'Daily'),
    (8, 8, 8, '2023-08-12', '2023-08-15', 'Monthly'),
    (9, 3, 3, '2023-09-07', '2023-09-10', 'Daily'),
    (10, 10, 10, '2023-10-10', '2023-10-31', 'Monthly'),
    (11, 6, 6, '2023-11-05', '2023-11-10', 'Daily'),
    (12, 8, 9, '2023-12-15', '2023-12-31', 'Monthly'),
    (13, 9, 10, '2024-01-02', '2024-01-15', 'Daily'),
    (14, 10, 7, '2024-02-10', '2024-02-28', 'Monthly'),
    (15, 12, 11, '2024-03-20', '2024-03-25', 'Daily');

INSERT INTO Payment (paymentID, leaseID, paymentDate, amount)
VALUES
    (1, 1, '2023-01-03', 200.00),
    (2, 2, '2023-02-20', 1000.00),
    (3, 3, '2023-03-12', 75.00),
    (4, 4, '2023-04-25', 900.00),
    (5, 5, '2023-05-07', 60.00),
    (6, 6, '2023-06-18', 1200.00),
    (7, 7, '2023-07-03', 40.00),
    (8, 8, '2023-08-14', 1100.00),
    (9, 9, '2023-09-09', 80.00),
    (10, 10, '2023-10-25', 1500.00),
    (11, 11, '2023-11-08', 70.00),
    (12, 12, '2023-12-20', 1000.00),
    (13, 13, '2024-01-10', 80.00),
    (14, 14, '2024-02-25', 1400.00),
    (15, 15, '2024-03-23', 50.00);