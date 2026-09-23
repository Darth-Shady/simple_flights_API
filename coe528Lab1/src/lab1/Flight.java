package lab1;


/**
 *
 * @author stabeeb
 */
public class Flight {
    //Instance:
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    public Flight(int flightNumber, 
            String origin, 
            String destination, 
            String departureTime, 
            int capacity,
            double originalPrice) {
        if ( origin.toLowerCase().equals(destination.toLowerCase()) ) { 
        throw new IllegalArgumentException();
        }
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.numberOfSeatsLeft = capacity;
        this.originalPrice = originalPrice;
        
        
    }
    //setters and getters for INSTANCE VARS
    // flightNumber
    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    // origin
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    // destination
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    // departureTime
    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    // capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // numberOfSeatsLeft
    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }

    // originalPrice
    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    public boolean bookASeat() {
        if (this.numberOfSeatsLeft > 0) {
            this.numberOfSeatsLeft --;
            return true;
        } else {return false;}
    }
    
    
    @Override
    public String toString() {
        return "Flight " + flightNumber + ", " +
               origin + " to " + destination + ", " +
               departureTime + ", original price: " +
               originalPrice + "$";
    }

    
    
    
}

    
