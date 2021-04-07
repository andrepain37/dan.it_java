package booking;

import controllers.BookingController;
import controllers.FlightController;

public class AppData {

    private final BookingController booking = new BookingController();
    private final FlightController flight = new FlightController();

    public BookingController getBooking() {
        return this.booking;
    }

    public FlightController getFlight() {
        return this.flight;
    }


}
