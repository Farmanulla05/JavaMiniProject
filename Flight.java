import java.util.*;
public class Flight {
private String FlightNumber;
private String From;
private String To;
private String Date;
private String Time;


public Flight(String FlightNumber,String From,String To,String Date,String Time) {
	this.FlightNumber = FlightNumber;
	this.From = From;
	this.To = To;
	this.Date = Date;
	this.Time = Time;
	
}

public String getFlightDetails() {
	return "Flight Number : "+FlightNumber+ "\n  Departure City : "+From+ "\n  Destination City : "+To
			+ "\n  Date : "+Date+"\n  Time: "+Time;
	
}

public String getFromLocation() {
	return From ;
}

public String getToLocation() {
	
	return To;
}


}

