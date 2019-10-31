package ParkingLotDesignPattern;

public abstract class Vehicle {
	private String vehicleNumber;
	private final VehicleType type;
	private ParkingTicketStatus ticket;
	
	public Vehicle(VehicleType type) {
		this.type = type;
	}
	
	public void assignTicket(ParkingTicketStatus ticket) {
		this.ticket = ticket;
	}
	
	class Car extends Vehicle {
		public Car() {
			super(VehicleType.CAR);
		}
	}
	
	class Truck extends Vehicle {
		public Truck() {
			super(VehicleType.TRUCK);
		}
	}
}
