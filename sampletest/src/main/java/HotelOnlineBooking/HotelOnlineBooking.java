package HotelOnlineBooking;

import java.util.Date;
import java.util.List;

//User
//Room
//Hotel
//Booking
//Address
//Facilities
public class HotelOnlineBooking {

	public enum RoomStatus {
		EMPTY, NOT_EMPTY;
	}
	
	public enum RoomType {
		SINGLE, DOUBLE, TRIPLE;
	}
	
	public enum PaymentsStatus {
		PAID, UNPAID;
	}
	
	public enum Facility {
		LIFT, POWER_BACKUP, HOT_WATER, BREAKFAST_FREE, SWIMMING_POOL;
	}
	
	class User {
		int userId;
		String name;
		Date dateOfBirth;
		String mobNo;
		String emailId;
		String sex;
	}
	
	class Room {
		int hotelId;
		int roomId;
		RoomType roomType;
		RoomStatus roomStatus;
	}
	
	class Hotel {
		int hotelId;
		String hotelName;
		Address address;
		
		//hotel contains the list of rooms
		List<Room> rooms;
		float rating;
		Facilities facilities;
		
	}
	
	class Booking {
		int bookingId;
		int userId;
		int hotelId;
		
		List<Room> bookedRooms;
		
		int amount;
		PaymentsStatus status_of_payment;
	    Date bookingTime;
	    Duration duration;
	}
	
	class Address {
		String city;
		String pincode;
		String state;
		String streetNo;
		String landmark;
	}
	
	class Duration {
		Date from;
		Date to;
	}
	
	class Facilities {
		List<Facility> facilitiesList;
	}
	
}
