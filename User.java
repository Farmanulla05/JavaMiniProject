import java.util.*;
public class User {
	private final List<String> user = new ArrayList<>();
	private final List<String> userBookings = new ArrayList<>();
	private String currentUser;
	private final Admin admin;
	
	public User(Admin admin) {
		this.admin = admin;
	}
	
	
	public boolean userLogin(String Username, String userPassword) {
		int userIndex = user.indexOf(Username);
		if(userIndex !=-1 &&user.get(userIndex+1).equals(userPassword)) {
			currentUser = Username;
			System.out.println("User Login Successfull");
			System.out.println("---------------------------------");
			return true;
		}else {
			System.out.println("Login failed. Invalid Username or Password");
			System.out.println("---------------------------------");
			return false;
		}
	}
	
	
	public void signup(String username,String password) {
		if(!user.contains(username)) {
			user.add(username);
			user.add(password);
			System.out.println("User Registration Successfull.");
			System.out.println("---------------------------------");
		}else {
			System.out.println("Signup failed. User Already exists.");
			System.out.println("---------------------------------");
		}
	}
	
	
	public void bookFlight(String fromLocation,String toLocation, List<Flight> flights) {
		System.out.println("Avilable Flights: ");
		System.out.println("---------------------------------");
		int flightIndex = 0;
		for(Flight flight : flights) {
			if(flight.getFromLocation().equalsIgnoreCase(fromLocation)&&
					flight.getToLocation().equalsIgnoreCase(toLocation)) {
				System.out.println((flightIndex + 1)+"."+flight.getFlightDetails());
				System.out.println("---------------------------------");
				flightIndex++;
			}
		}
		if(flightIndex == 0) {
			System.out.println("No flights available for the selected route.");
			System.out.println("---------------------------------");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the index of the flight to reserve (or 0 to cancle): ");
		System.out.println("---------------------------------");
		int choice = sc.nextInt();
		System.out.println("---------------------------------");
		if(choice >= 1 && choice <= flightIndex) {
			Flight selectedFlight = flights.get(choice - 1);
			String bookingInfo = currentUser +" booked the following flight:\n"+ selectedFlight.getFlightDetails();
			admin.bookFlight(bookingInfo);
			userBookings.add(bookingInfo);
			System.out.println("Reservation successful.");
			System.out.println("---------------------------------");
		}else if(choice != 0) {
			System.out.println("Invalid flight index.");
			System.out.println("---------------------------------");
		}
		
	}
	
	
	
	
	public void logout() {
		currentUser = null;
		System.out.println("User logged out.");
		System.out.println("---------------------------------");
	}
	
	public List<String> getUserBookings(){
		return userBookings;
	}
	
	
	public void viewBooking() {
		boolean foundBookings = false;
		int index = 0;
		for(String booking : userBookings) {
			if(booking.startsWith(currentUser)) {
				
				System.out.println("Your Reservations.");
					System.out.println("---------------------------------");
					System.out.println((index+1)+ "."+booking);
					index++;
					foundBookings = true;
			}
		}
		if(!foundBookings) {
			System.out.println("No Bookings in the username as: "+currentUser);
			System.out.println("---------------------------------");
		}
	}
	
	
	
	public void cancleResrvation() {
		Scanner sc = new Scanner(System.in);
		boolean foundBookings = false;
		int index = 0;
		
		System.out.println("Your Resrvations");
		System.out.println("---------------------------------");
		for(String bookings : userBookings) {
			if(bookings.startsWith(currentUser)) {
				System.out.println((index +1)+". "+bookings);
				index++;
				foundBookings = true;
			}
		}
		if(!foundBookings) {
			System.out.println("No bookins found in the Username : "+currentUser);
			System.out.println("---------------------------------");
			return;
		}
		System.out.println("Do you want to cancle Bookings? (yes/no)");
		String cancleChoice = sc.next();
		if(cancleChoice.equals("yes")) {
			System.out.println("Enter the index of Booking to cancle.");
			int cancleIndex = sc.nextInt();
			
			if(cancleIndex >= 1 && cancleIndex <= index) {
				
				String cancledBookings = userBookings.get( cancleIndex - 1 );
				admin.cancleBooking(cancledBookings);
				userBookings.remove(cancleIndex - 1);
				System.out.println(cancledBookings+" has been cancled.");
			}else {
				System.out.println("Invalid choice.");
			}
		}else {
			System.out.println("No Bookings were cancled.");
		}
	}
	
	
}
