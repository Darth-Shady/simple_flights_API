# Lab 1 — Flight Booking API

A simple flight booking system built around a `Manager` class that creates flights, lists availability, looks up flights by number, and books seats for different passenger types, applying discounts based on the passenger's type.

## Package

```
lab1
```

## Project Structure (7 files)

| File | Role |
|---|---|
| `Manager.java` | Orchestrates the system — creates flights via console input, displays available flights between an origin/destination, looks up a flight by number, and books seats |
| `Flight.java` | Represents a single flight: flight number, origin, destination, departure time, capacity, seats left, original price. Constructor throws `IllegalArgumentException` if origin equals destination (case-insensitive) |
| `Passenger.java` | Abstract base class holding `name` and `age`, with an abstract `applyDiscount(double price)` that subclasses must implement |
| `Member.java` | `Passenger` subtype with a `yearsOfMembership` field. Discount: 50% if `yearsOfMembership > 5`, 10% if `> 1`, otherwise none |
| `NonMember.java` | `Passenger` subtype with no membership field. Discount: 10% if `age > 65`, otherwise none |
| `Ticket.java` | Represents a booking confirmation for a passenger + flight + final price. Assigns each ticket a unique, auto-incrementing `ticketNumber` via a static counter |
| `FlightTest.java` | JUnit tests covering `Flight`'s constructor validation, seat booking, and `toString()` |

## Class Details

### `Flight`
Standard getters/setters for all fields. `bookASeat()` decrements `numberOfSeatsLeft` and returns `true` if a seat was available, `false` otherwise. `toString()` formats flight number, origin/destination, departure time, and price.

### `Passenger` (abstract)
Holds `name` and `age` with getters/setters. Declares `abstract double applyDiscount(double p)`, forcing each subtype to define its own pricing rule.

### `Member extends Passenger`
Adds `yearsOfMembership`. Tiered loyalty discount as described above.

### `NonMember extends Passenger`
Adds no new fields. Senior discount only, based on age.

### `Ticket`
Stores the passenger, flight, and final price. `ticketNumber` comes from a `static int ticketNum` counter shared across all `Ticket` instances, so each ticket gets a unique, incrementing ID. `toString()` reports the passenger's name, flight details, original price, and final ticket price.

### `Manager`
**Fields**
- `flights: ArrayList<Flight>` — the in-memory store of all created flights

**Methods**
- `createFlights()` — prompts via `Scanner` for how many flights to add, then reads each flight's number, origin, destination, departure time, capacity, and original price, and adds it to `flights`.
- `displayAvailableFlights(String origin, String destination)` — prints every flight matching the given origin/destination (whitespace- and case-insensitive) that still has seats left.
- `getFlight(int flightNumber)` — searches `flights` for a matching flight number, prints and returns it, or returns `null` if not found.
- `bookSeat(int flightNumber, Passenger p)` — looks up the flight, books a seat if available, applies the passenger's discount (polymorphically, via `Passenger.applyDiscount`) to compute the final price, and prints the resulting `Ticket`. Prints an error message if the flight doesn't exist or has no seats left.

## Testing

`FlightTest.java` covers `Flight` directly:
- **`testConstructor`** — verifies all getters return the values passed to the constructor, and that seats-left initializes to full capacity.
- **`testInvalidConstructor`** — confirms an `IllegalArgumentException` is thrown when origin equals destination.
- **`testBookASeat`** — confirms seats decrement correctly on booking and that booking fails once capacity is exhausted.
- **`testToString`** — checks that `toString()` includes the flight number, origin, destination, departure time, and price.

Run with JUnit 4:
```
mvn test
```
or via your IDE's test runner, provided `junit` is on the classpath.

## Running `Manager`

```
javac lab1/*.java
java lab1.Manager
```

The console will prompt for flight details. **Note:** `main()` expects a flight with flight number `324`, origin `Toronto`, destination `New York`, and capacity ≥ 4 to be entered, since the booking demo books 4 seats across a `Member` (37, 6 years — 50% discount), a `Member` (12, 2 years — 10% discount), a `NonMember` (66 — 10% senior discount), and a `NonMember` (64 — no discount).

## Known Quirks

- Input is read via `Scanner(System.in)` inside `createFlights()` rather than injected, which makes automated testing of that method harder — the JUnit tests instead exercise `Flight` directly.
- The `if (flight != null && seat_status)` check inside `bookSeat` is redundant, since execution can't reach that point with either being false/null.
- `Ticket.ticketNum` is a shared static counter across all `Ticket` instances — fine for a single run, but it won't reset between separate program executions or test runs sharing the same JVM.
