create database carrentalsystem;
use carrentalsystem;

create table Vehicle (
    vehicleID int primary key,
    make varchar(50),
    model varchar(50),
    year int,
    dailyRate decimal(8,2),
    status varchar(20),
    passengerCapacity int,
    engineCapacity int
);

desc Vehicle;

create table Customer (
    customerID int primary key,
    firstName varchar(50),
    lastName varchar(50),
    email varchar(50),
    phoneNumber varchar(15)
);

desc Customer;

create table Lease (
    leaseID int primary key,
    vehicleID int,
    customerID int,
    startDate date,
    endDate date,
    leaseType varchar(20),
    foreign key(vehicleID) references Vehicle(vehicleId),
    foreign key(customerID) references Customer(customerID)
);

desc lease;

create table Payment (
    paymentID int primary key,
    leaseID int,
    paymentDate date,
    amount decimal(8,2),
    foreign key(leaseID) references Lease(leaseID)
);

desc payment;

