package ParkingLotDesignPattern;

public enum VehicleType {
	MOTORBIKE, CAR, VAN, TRUCK, ELECTRIC 
}

enum ParkingSpotType {
	HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
}

enum AccountStatusType {
	ACTIVE, BLOCK, BANNED, COMPROMISED, ARCHIVED, UNKNOW
}

enum ParkingTicketStatus {
	PAID, ACTIVE, LOST
}

class Address {
	private String streeetAddress;
	private String city;
	private String state;
	private String pincode;
	private String country;
}

class Person {
	private String name;
	private Address address;
	private String email;
	private String phone;
}
