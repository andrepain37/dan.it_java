package actions;

import DAO.ActionDAO;
import booking.Airports;
import booking.AppData;

import static utils.FormatDate.printNow;
import static utils.ConfigFormats.*;
import static utils.FormatString.showTitleForFlights;


public class ActionShowFlights extends Action implements ActionDAO {
    public ActionShowFlights(AppData appData) {
        super(appData);
    }

    @Override
    public String getTitleAction() {
        return "1";
    }

    @Override
    public String getDesc() {
        return "Онлайн-табло";
    }

    @Override
    public void doAction() {
        System.out.printf("%s\n", "Рейсы из аэропорта \"Жуляны\":" + printNow());
        showTitleForFlights();
        this.appData.getFlight().printAllSortedCurrent24Hours(FORMAT_FLIGHTS);

    }
}
