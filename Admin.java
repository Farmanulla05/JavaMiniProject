import java.util.*;
public class Admin {

	private final List<Flight> flights = new ArrayList<>();
	private final List<String> bookedFlights = new ArrayList<>();
	private String AdminName = "Farman";
	private String AdminPassword = "Farman123";
	
	
	public void addflightDetails(String flightNumber, String fromLocation,String toLocation,String date,String time) {
		Flight flight = new Flight(flightNumber,fromLocation,toLocation,date,time);
		flights.add(flight);
		System.out.println("Flight details added Successfully.");
		System.out.println("---------------------------------");
	}
	
	public List<Flight> getFlightDetails(){
		return flights;
	}
	
	public void logout() {
		System.out.println("Logout successfully");
	}
	
	public String getAdminName() {
		return AdminName;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	
	
	public void viewBookedFlights() {
			System.out.println("Booked Flights:");
			System.out.println("---------------------------------");
			for(String bookedFlight : bookedFlights) {
				if(bookedFlights.contains(bookedFlight)) {
					System.out.println(bookedFlight);
				}
			}if(bookedFlights.isEmpty()) {
				System.out.println("No flights are booked");
				System.out.println("---------------------------------");
			}
			}
	
	
	public void bookFlight(String flightInfo) {
		bookedFlights.add(flightInfo);
	}
	
	public void cancleBooking(String cancledBooking) {
		bookedFlights.remove(cancledBooking);
	}
	
}
