


use cardealership;


create table if not exists vehicle_types(
id int primary key auto_increment,
    type varchar(100) not null

);


create table if not exists brand(
id int primary key auto_increment,
name varchar(100) not null

);

create table if not exists models(
id int primary key auto_increment,
brand_id int not null,
name varchar(100) not null,

foreign key(brand_id) references brand(id)
);


create table if not exists vehicles(
id int primary key auto_increment,
    type_id int not null,
    model_id int not null,
    color varchar(100) not null,
    interiorColor varchar(100) not null,
    year int not null,
    transmissionType varchar(25) not null,
    mileage int not null,
    msrp decimal(12,4) not null,
    image varchar(100),
    new boolean,vehicles
    
    foreign key(type_id) references vehicle_types(id),
	foreign key(model_id) references models(id)
	
);


create table if not exists users(
id int primary key auto_increment,
    type enum('admin', 'seller') not null,
    email varchar(100) not null,
    password varchar(100) not null,
    address varchar(100)
);

create table appointments(
id int primary key auto_increment,  
    vehicle_id int not null,
    user_id int not null,
    created_at datetime default CURRENT_TIMESTAMP,
    appointment_date datetime not null,
    
    foreign key(user_id) references users(id),
    foreign key(vehicle_id) references vehicles(id)

);

create table if not exists sales(
id int primary key auto_increment, 
    user_id int not null,
    seller_id int not null,
    total decimal(12,4),
    
    foreign key(user_id) references users(id),
    foreign key(seller_id) references users(id)

);


create table if not exists specials(
id int primary key auto_increment, 
MemorialDay float
);


create table if not exists contact(
id int primary key auto_increment,
name varchar(50) not null,
email varchar(100) not null,
phoneNumber varchar(18) not null,
message varchar(1000) not null
);




