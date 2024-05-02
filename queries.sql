-- 1. Update the daily rate for a Mercedes car to 68.
select * from vehicle;
update vehicle set dailyRate=67 where make="Mercedes";

-- 2. Delete a specific customer and all associated leases and payments.
select * from customer;
delete from customer where customerID=5;
select * from lease;
select * from payment;

-- 3. Rename the "paymentDate" column in the Payment table to "transactionDate".
alter table payment rename column paymentDate to transactionDate;

-- 4. Find a specific customer by email.
select * from customer where email='sarah@example.com';

-- 5. Get active leases for a specific customer.
select * from vehicle;
select * from lease;
select v.make,v.model,v.dailyRate,l.leaseID,l.startDate,l.endDate,l.leaseType
from vehicle v 
join lease l on v.vehicleID=l.vehicleID 
where l.customerID=7 and  l.startDate<=curdate() and l.endDate>=curdate();

-- 6. Find all payments made by a customer with a specific phone number.
select * from customer;
select * from lease;
select c.customerID,c.firstname,c.lastname,c.phoneNumber,p.paymentID,p.leaseID,p.transactionDate,p.amount
from payment p  inner join lease l on p.leaseID=l.leaseID 
inner join customer c on l.customerID=c.customerID 
where c.phoneNumber='555-765-4321';

-- 7. Calculate the average daily rate of all available cars.
select avg(dailyRate) as average_dailyrate from vehicle;

-- 8. Find the car with the highest daily rate.
select vehicleID,make,model,dailyRate 
from vehicle 
where dailyRate=(select max(dailyRate) from vehicle);

-- 9. Retrieve all cars leased by a specific customer.
select * from lease;
select v.* from vehicle v 
inner join lease l on v.vehicleID=l.vehicleID 
where l.customerID=10;

-- 10. Find the details of the most recent lease.
select v.*,l.*,c.firstname,c.lastname 
from lease l 
inner join customer c on l.customerID=c.customerID 
inner join vehicle v on l.vehicleid=v.vehicleID 
where l.startDate=(select max(startDate) from lease);

-- 11. List all payments made in the year 2023.
select * from payment;
select * from payment where transactionDate like '%2023%';

-- 12. Retrieve customers who have not made any payments.
select c.customerId,c.firstname,c.lastname 
from customer c 
left join lease l on c.customerID=l.customerID
left join payment p on l.leaseID=p.leaseID 
where p.paymentID is null;

-- 13. Retrieve Car Details and Their Total Payments.
select v.* ,sum(p.amount) as total_payments 
from vehicle v 
left join lease l on v.vehicleID=l.vehicleID 
left join payment p on l.leaseID=p.leaseID 
group by v.vehicleID;

-- 14. Calculate Total Payments for Each Customer.
select c.customerID,c.firstname,c.lastname,sum(p.amount) as total_payments 
from customer c 
left join lease l on c.customerID=l.customerID
left join payment p on l.leaseID=p.leaseID
group by c.customerID,c.firstName,c.lastName;

-- 15. List Car Details for Each Lease.
select v.*,l.leaseID,l.customerID,l.startDate,l.endDate,l.leaseType 
from lease l 
inner join vehicle v on l.vehicleID=v.vehicleID;

-- 16. Retrieve Details of Active Leases with Customer and Car Information.
select c.*,l.leaseID,v.*
from vehicle v 
join lease l on v.vehicleID=l.vehicleID 
join customer c on l.customerID=c.customerID
where l.startDate<=curdate() and l.endDate>=curdate();

-- 17. Find the Customer Who Has Spent the Most on Leases.
select c.customerID,c.firstName,c.lastName,sum(p.amount) as total_spent from customer c 
inner join lease l on c.customerID=l.customerID
inner join payment p on l.leaseID=p.leaseID
group by c.customerID,c.firstName,c.lastName
order by total_spent desc 
limit 1 ;

-- 18. List All Cars with Their Current Lease Information.
select * from lease;
select v.*,l.leaseID,l.startDate ,l.endDate,l.leaseType from vehicle v 
left join lease l on v.vehicleID=l.vehicleID 
where l.endDate>=curdate() ;