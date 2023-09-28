import java.util.*;
public class AirlineMain {

	public static void main(String[] args) {
		AirlineReservationSystem airlinesystem = new AirlineReservationSystem();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("Welcome to Aerofly Airlines");
		System.out.println("---------------------------------");
		while(true) {
			try {
				
			
			System.out.println("1. Admin Login");
			System.out.println("2. User Menu");
			System.out.println("3. Exit");
			System.out.println("---------------------------------");
			System.out.println("Enter your choice: ");
			System.out.println("---------------------------------");
			int choice = sc.nextInt();
			System.out.println("---------------------------------");
			switch(choice) {
			
			case 1:
				System.out.println("Enter Admin User Name");
				System.out.println("---------------------------------");
				String Aname = sc.next();
				System.out.println("---------------------------------");
				System.out.println("Enter Admin Password");
				System.out.println("---------------------------------");
				String Apass = sc.next();
				System.out.println("---------------------------------");
				airlinesystem.AdminLoin(Aname, Apass);;
				break;
			case 2:
				airlinesystem.usermenu();
				break;
			case 3:
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Try again.");
				System.out.println("---------------------------------");
			}
			}catch (InputMismatchException e) {
				System.out.println("Invalid Input. Please enter a valid choice (1,2 or 3).");
				sc.nextLine();
			}
		}

	}

}
