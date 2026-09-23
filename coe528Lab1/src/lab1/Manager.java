
package lab1;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author stabeeb
 */
public class Manager {
    //instance
    private ArrayList<Flight> flights;
    
    
    public Manager() {
        this.flights = new ArrayList<>();
    // global array for create flights,display available flights,getFlight
    
    }
    
    public void createFlights() {
        Scanner scanner = new Scanner(System.in); // should I initalize this here or next to ArrayList? recheck l8r
        
        System.out.print("\n ***********NOTE FOR TESTER:***************** \n make sure to add a flight with flight Number 324 and going from Toronto to New york \n"
                + "with a capacity/seat number above >= 4 for tests in main method to work \n");
        System.out.print("\n _______________________________________ \n");
        
        System.out.print("\n How many flights to add? \n");
        System.out.print("\n _______________________________________ \n");
        
        int flight_iterations = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < flight_iterations;i++) {
            System.out.print("\n Flight Number? (Enter below) \n");
            int flight_nbr = scanner.nextInt();
            scanner.nextLine();
                    
            System.out.print("\n Flight Origin? (Enter below) \n");
            String origin = scanner.nextLine();
            
            System.out.print("\n Flight Destination? (Enter below) \n");
            String destination = scanner.nextLine();
            
            System.out.print("\n Flight departure time? (Enter below) \n");
            String departureTime = scanner.nextLine();
            
            System.out.print("\n Flight Capacity? (Enter below) \n");
            int capacity = scanner.nextInt();
            scanner.nextLine();
            
            
            System.out.print("\n Flight Original Price? (Enter below) \n");
            double og_price = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("\n _______________________________________ \n");
            
            this.flights.add(new Flight(flight_nbr, origin, destination, departureTime, capacity, og_price));
        }
        
        
    }
    
    public void displayAvailableFlights(String origin, String destination) {
        System.out.print("\n _______________________________________ \n");
        System.out.print("Displaying all Available flights from " + origin + " to " + destination + "\n");
        
        
        for(int i = 0; i < this.flights.size();i++) {
            if (this.flights.get(i).getOrigin().replaceAll("\\s+", "").equalsIgnoreCase(
        origin.replaceAll("\\s+", "")) 
    && this.flights.get(i).getDestination().replaceAll("\\s+", "").equalsIgnoreCase(
        destination.replaceAll("\\s+", "")) 
    && this.flights.get(i).getNumberOfSeatsLeft() > 0) {
                
                System.out.print(this.flights.get(i).toString() + "\n") ;
            
                
            }
        }
        
        
        
    }
    
    public Flight getFlight(int flightNumber) {
        System.out.print("\n _______________________________________ \n");
        System.out.print("Displaying flights with flight number " + flightNumber + "\n");
        
        for(int i = 0; i < this.flights.size();i++) {
            if (this.flights.get(i).getFlightNumber() == (flightNumber) ) { //"int cannot be dereferenced"
                System.out.print(this.flights.get(i).toString() + "\n") ;
                
                return this.flights.get(i) ;
            } 
        }
        
        return null;
    }
    
    public void bookSeat(int flightNumber, Passenger p) {
        
        Flight flight = getFlight(flightNumber);
        if (flight == null) {
            System.out.print("Flight doesn't exist \n");
            return;
        }
        
        boolean seat_status = flight.bookASeat();
        if (!seat_status) {
            System.out.print("No seats available \n");
            return;
        }
        
        // this if statement is unneccesary
        if (flight != null && seat_status) {
            double finalPrice = p.applyDiscount(flight.getOriginalPrice()) ;
            Ticket ticket = new Ticket(p,flight,finalPrice) ;
            
            System.out.print(ticket + "\n");
        }  
        
        
    }
    
    public static void main(String[] args) {
    Manager manager = new Manager(); 
    manager.createFlights(); 
// make sure to add a flight with fNumber 324 and going from Toronto to New york with capacity > 3 for tests to work
    manager.displayAvailableFlights("Toronto", "New York");
    manager.getFlight(324);
    
    // all member cases
    
    Member big_member = new Member("big Mem", 37, 6);
    Member lil_member = new Member("lil Mem", 12, 2);
    NonMember nonmember = new NonMember("Non mem", 66);
    NonMember lil_nonmember = new NonMember("lil Non", 64);
    
    // all bookSeat cases
    manager.bookSeat(324, big_member);
    manager.bookSeat(324, lil_member);
    manager.bookSeat(324,nonmember);
    manager.bookSeat(324,lil_nonmember);
    }
}
