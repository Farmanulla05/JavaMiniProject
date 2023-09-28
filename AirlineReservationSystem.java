import java.util.*;
public class AirlineReservationSystem {

	private boolean loggedIn;
	private final Admin admin = new Admin();
	private final User user = new User(admin);
	
	public AirlineReservationSystem() {
		loggedIn = false;
	}
	
	public void adminmenu() {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("Admin Menu");
			System.out.println("---------------------------------");
			System.out.println("1. Add flight");
			System.out.println("2. View Booked flights");
			System.out.println("3. Logout");
			System.out.println("---------------------------------");
			System.out.println("Enter your choice: ");
			System.out.println("---------------------------------");
			int choice = sc.nextInt();
			System.out.println("---------------------------------");
			
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter flight number: ");
				System.out.println("---------------------------------");
				String flightNumber = sc.next();
				System.out.println("---------------------------------");
				System.out.println("Enter Departure Location: ");
				System.out.println("---------------------------------");
				String fromLocation = sc.next();
				System.out.println("---------------------------------");
				System.out.println("Enter Arrival Location");
				System.out.println("---------------------------------");
				String toLocation = sc.next();
				System.out.println("---------------------------------");
				System.out.println("Enter date: ");
				System.out.println("---------------------------------");
				String Date = sc.next();
				System.out.println("---------------------------------");
				System.out.println("Enter Time: ");
				System.out.println("---------------------------------");
				String Time = sc.next();
				System.out.println("---------------------------------");
				admin.addflightDetails(flightNumber, fromLocation, toLocation, Date, Time);
				break;
			case 2:
				admin.viewBookedFlights();
				break;
			case 3:
				admin.logout();
				return;
			default:
				System.out.println("Invalid choice. Try Again.");
				System.out.println("---------------------------------");
			}
		}
	}
	
	public void usermenu() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("User Menu");
			System.out.println("---------------------------------");
			if(!loggedIn) {
			System.out.println("1. Login");
			System.out.println("2. Signup");
			System.out.println("---------------------------------");
			}else {
				
			
			System.out.println("3. Book a Flight");
			System.out.println("4. View Bookings");
			System.out.println("5. Cancle Booking");
			System.out.println("6. Logout");
			System.out.println("---------------------------------");
			}
			System.out.println("Enter a choice: ");
			System.out.println("---------------------------------");
			int choice = sc.nextInt();
			System.out.println("---------------------------------");
			
			switch(choice) {
			
			case 1: 
				System.out.println("Enter username");
				System.out.println("---------------------------------");
				String userUsername = sc.next();
				System.out.println("---------------------------------");
				System.out.println("Enter Password");
				System.out.println("---------------------------------");
				String userPassword = sc.next();
				System.out.println("---------------------------------");
				loggedIn = user.userLogin(userUsername, userPassword);
				break;
			case 2:
				System.out.println("Enter New Username");
				System.out.println("---------------------------------");
				String newUsername = sc.next();
				System.out.println("---------------------------------");
				System.out.println("Enter New Password");
				System.out.println("---------------------------------");
				String newPassword = sc.next();
				System.out.println("---------------------------------");
				user.signup(newUsername, newPassword);
				break;
			case 3:
				if(loggedIn) {
					System.out.println("Enter Departure Location: ");
					System.out.println("---------------------------------");
					String fromLocation = sc.next();
					System.out.println("---------------------------------");
					System.out.println("Enter Destination Location: ");
					System.out.println("---------------------------------");
					String toLocation = sc.next();
					System.out.println("---------------------------------");
					List<Flight> avilableFlights = admin.getFlightDetails();
					user.bookFlight(fromLocation, toLocation, avilableFlights);
				}else {
					System.out.println("You need to login to reserve a flight.");
					System.out.println("---------------------------------");
				}
				break;
			case 4:
				   user.viewBooking();
				   break;
			case 5:
				  user.cancleResrvation();
				  break;
			case 6:
				loggedIn = false;
				user.logout();
				return;
			default:
				System.out.println("Invalid choice.Try again.");
				System.out.println("---------------------------------");
			}
			
		}
	}
	
	public void AdminLoin(String Adminusername, String AdminEnterPassword) {
		if(Adminusername.equals(admin.getAdminName())&&AdminEnterPassword.equals(admin.getAdminPassword())) {
			System.out.println("Admin Login SuccessFull");
			System.out.println("---------------------------------");
			adminmenu();
		}else {
			System.out.println("Invalid Admin Username and Admin Password");
			System.out.println("---------------------------------");
		}
		
	}
	
}
