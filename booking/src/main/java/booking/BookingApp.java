package booking;

import DAO.ActionDAO;
import actions.Action;
import actions.Actions;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static utils.ConfigFiles.*;

public class BookingApp {

    private final AppData appData = new AppData();
    List<ActionDAO> allActions = Actions.getAll(appData);

    public BookingApp() {
        appData.getFlight().readDB(FLIGHT_FILE);
        appData.getBooking().readDB(BOOKING_FILE);
    }


    private void printMainMenu() {
        AtomicInteger index = new AtomicInteger();
        allActions
                .stream()
                .forEach(a -> System.out.printf("%d. %s (Нажмите %s)\n", index.incrementAndGet(), a.getDesc(), a.getTitleAction()));
    }

    public void start() {


        Scanner in = new Scanner(System.in);
        Optional<ActionDAO> action;
        Boolean die = false;
        do {
            printMainMenu();
            System.out.println("Выберите действие:");


            String commandUser = in.nextLine().trim();
            action = allActions
                    .stream()
                    .filter(a -> a.getTitleAction().equalsIgnoreCase(commandUser))
                    .findFirst();

            if (action.isPresent()) {
                action.get().doAction();
                die = action.get().exit();
            } else {
                System.out.println("Данной команды нету");
            }

        } while (!die);
    }
}
