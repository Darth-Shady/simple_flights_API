package lab1;


import org.junit.Test;
import static org.junit.Assert.*;


public class FlightTest {


    @Test
    public void testConstructor() {
        Flight f = new Flight(
            1030,
            "Toronto",
            "Kolkata",
            "03/02/99 7:50 PM",
            100,
            1000.0
        );

        assertEquals(1030, f.getFlightNumber());
        assertEquals("Toronto", f.getOrigin());
        assertEquals("Kolkata", f.getDestination());
        assertEquals("03/02/99 7:50 PM", f.getDepartureTime());
        assertEquals(100, f.getCapacity());
        assertEquals(100, f.getNumberOfSeatsLeft());
        assertEquals(1000.0, f.getOriginalPrice(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        new Flight(
            1030,
            "Toronto",
            "Toronto",
            "03/02/99 7:50 PM",
            100,
            1000.0
        );
    }

    @Test
    public void testBookASeat() {
        Flight f = new Flight(
            2000,
            "Toronto",
            "Iqaluit",
            "9:00 PM",
            2,
            8.0
        );

        assertTrue(f.bookASeat());
        assertEquals(1, f.getNumberOfSeatsLeft());

        assertTrue(f.bookASeat());
        assertEquals(0, f.getNumberOfSeatsLeft());

        assertFalse(f.bookASeat());
    }

    @Test
    public void testToString() {
        Flight f = new Flight(
            3000,
            "Dubai",
            "Tokyo",
            "11:30 PM",
            300,
            12.0
        );

        String s = f.toString();

        assertTrue(s.contains("3000"));
        assertTrue(s.contains("Dubai"));
        assertTrue(s.contains("Tokyo"));
        assertTrue(s.contains("11:30 PM"));
        assertTrue(s.contains("12"));
    }

}
