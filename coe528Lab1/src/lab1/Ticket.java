package lab1;



/**
 *
 * @author stabeeb
 */
public class Ticket {
    //Instance
    private Passenger passenger; // ?? make these objects private ??
    private Flight flight;
    private double price;
    private int ticketNumber;
    private static int ticketNum = 0; // to create a unique ID for every ticket
    
    
    public Ticket(Passenger p, Flight flight, double price) {
        this.passenger = p;
        this.flight = flight;
        this.price = price;
        this.ticketNumber = ticketNum;
        ticketNum++;
        
    }
    
    
    @Override
    public String toString() {
        return this.passenger.getName() + ", Flight " + this.flight.getFlightNumber() + "," + this.flight.getOrigin() + " to " + this.flight.getDestination() + " ," +
                this.flight.getDepartureTime() + ", original price: " + this.flight.getOriginalPrice() + ", ticket price:" + this.price;
                
    }
    
    
}
