USE hotel2;

insert into Customer 
(FirstName, LastName, PhoneNumber, Email) 
values ('Blair', 'Wagner', '651-303-3033', 'blairwagner@gmail.com'),
('Shane', 'Wayne', '651-214-3593', 'wayneshagner@gmail.com'),
('Megan', 'Elizabeth', '651-111-1111', 'meganwagner@gmail.com'),
('Billy', 'Wags', '651-491-7608', 'billywagner@gmail.com'),
('Geri', 'Mom', '651-308-3033', 'mom@gmail.com'),
('Lily', 'Doggie', '651-439-3384', 'wuff@gmail.com'),
('Tank', 'Tauro', '952-999-9999', 'minot@tauros.com');


insert into PromotionCode
(CodeName, StartDate, EndDate, PercentOff, DollarsOff)
values 
('Reward Member', '2016-01-31', '2019-01-31', 5, null),
('Tauro Family', '2019-05-08', '2019-12-31', null, 25),
('Freak Fest', '2015-01-31', '2018-01-31', 15, null),
('Wedding Guest', '2010-01-31', '2019-01-31', 10, null),
('Customer of the week', '2016-01-31', '2019-01-31', null, 200);


insert into Reservation
(CheckInDate, CheckOutDate, CustomerId, PromotionCodeId)
values
('2018-05-01', '2018-05-04', 1, 1),
('2017-05-01', '2017-06-04', 2, 2),
('2008-02-21', '2008-03-04', 3, 3),
('2019-06-21', '2019-06-24', 4, 4),
('2019-01-14', '2019-01-24', 5, 5),
('2018-11-01', '2018-11-06', 6, 1),
('2020-12-31', '2021-01-04', 7, 2),
('2018-04-21', '2018-04-25', 1, null),
('2018-05-01', '2018-05-04', 2, null),
('2018-04-01', '2018-04-04', 3, null);

insert into Amenity
(Description)
values 
('Picture of Blair'),
('Private pool'),
('Lake View'),
('Smart Tv');

insert into Room 
(RoomNumber, Floor, OccupancyLimit, Type)
values 
(101, 1, 2, 'Double'),
(102, 1, 4, 'Queen'),
(103, 1, 6, 'Double'),
(104, 1, 8, 'King');

insert into RoomAmenity
(RoomId, AmenityId)
values 
(1, 2),
(3, 1),
(4, 2),
(3, 3);

insert into RoomInReservation
(RoomId, ReservationId)
values 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(1, 5),
(2, 6),
(3, 7),
(4, 8), 
(1, 9), 
(2, 10),
(3, 1),
(4, 2),
(1, 3);

insert into Guest
(FirstName, LastName, Age, RoomInReservationId)
values 
('Blair', 'Wagner', 24, 1),
('Busy', 'Bear', 101, 4),
('Termite', 'Pest', 10, 6),
('Fran', 'Dog', 15, 10),
('Kendal', 'Christan', 55, 3),
('Lance', 'Armstrong', 97, 2);



insert into AddOn
(Description, Cost, CostStartDate, CostEndDate)
values 
('Food', 10.00, '2017-07-01', '2019-07-10'),
('Beer', 15.00,  '2017-05-01', '2019-05-31'),
('Photo with Blair', 900.00, '2017-01-01', '2019-01-31');

insert into AddOnForRoom
(RoomInReservationId, AddOnId, DatePurchased)
values
(1, 1, '2018-03-02'),
(2, 2, '2018-04-03'),
(3, 3, '2018-05-04'),
(4, 3, '2018-05-05');

insert into RoomPrice
(RoomId, CostStartDate, CostEndDate, Cost)
values
(1, '2017-01-01', '2017-01-05', 100.00),
(2, '2017-02-01', '2017-02-05', 100.00),
(3, '2017-03-01', '2017-03-05', 100.00),
(4, '2017-04-01', '2017-04-05', 100.00),
(1, '2017-05-01', '2017-05-05', 100.00),
(2, '2017-06-01', '2017-06-05', 100.00),
(3, '2017-07-01', '2017-07-05', 100.00),
(4, '2017-08-01', '2017-08-05', 100.00);
