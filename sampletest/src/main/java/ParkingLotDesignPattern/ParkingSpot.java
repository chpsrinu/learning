package ParkingLotDesignPattern;

public abstract class ParkingSpot {
	private String number;
	private boolean free;
	private VehicleType vehicle;
	private final ParkingSpotType type;
	
	public boolean IsFree();
	
	public ParkingSpot(ParkingSpotType type) {
		this.type = type;
	}
	
	public boolean assignVehicle(VehicleType vehicle) {
		this.vehicle = vehicle;
		free = false;
	}
	
	public boolean removeVehicle(VehicleType vehicle) {
		this.vehicle = null;
		free = true;
	}
	
	public class HandicappedSpot  extends ParkingSpot {
		public HandicappedSpot() {
			super(ParkingSpotType.HANDICAPPED);
		}
	}
	
	public class CompactSpot extends ParkingSpot {
		public CompactSpot() {
			super(ParkingSpotType.COMPACT);
		}
	}
	
	public class LargeSpot extends ParkingSpot {
		public LargeSpot() {
			super(ParkingSpotType.LargeSpot);
		}
	}
	
	public class ElectricSpot extends ParkingSpot {
		public ElectricSpot() {
			super(ParkingSpotType.ELECTRIC);
		}
	}
	
}
