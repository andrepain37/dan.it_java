package actions;

import DAO.ActionDAO;
import booking.AppData;

import java.util.ArrayList;
import java.util.List;


public class Actions {
    public static List<ActionDAO> getAll(AppData appData) {

        List<ActionDAO> actions = new ArrayList<>();
        actions.add(new ActionShowFlights(appData));
        actions.add(new ActionShowFlightById(appData));
        actions.add(new ActionAddToBooking(appData));
        actions.add(new ActionCancelBooking(appData));
        actions.add(new ActionShowMyFlights(appData));
        actions.add(new ActionExit(appData));

        return actions;

    }
}
