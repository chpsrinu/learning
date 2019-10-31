package ParkingLotDesignPattern;

public abstract class Account {
	private String userName;
	private String password;
	private AccountStatusType status;
	private Person person;
	
	public abstract boolean resetPassword();
}

class Admin extends Account {
	public boolean addParkingFloor(ParkingFloor floor);
	public boolean addParkingSpot(String floorName, ParkingSpotType spot);
	public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);
	public boolean addCustomerInfoPanel(String floorName, CustomerPanel infoPanel);
	
	publci boolean addEntrancePanel(EntrancePanel entrancePanel);
	public boolean addExitPanel(ExitPanel exitPanel);
}

class ParkingAttendent extends Account {
	public boolean processTicket(String TicketNumber);
}


