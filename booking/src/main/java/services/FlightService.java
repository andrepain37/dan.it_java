package services;


import DAO.CollectionFlightDAO;
import DAO.FlightDAO;
import booking.Flight;

import java.util.List;

public class FlightService {

    private FlightDAO flightDao = new CollectionFlightDAO();

    public FlightDAO getFlightDao() {
        return flightDao;
    }

    public List<Flight> getAllFlights() {
        return flightDao.getAll();
    }

    public void displayAllFlights() {

        flightDao.getAll().forEach(System.out::println);

    }

    public void saveFlight(Flight flight) {

        flightDao.saveFlight(flight);

    }

    public void saveDB(String path) {

        flightDao.saveDB(path);

    }

    public void readDB(String path) {

        flightDao.readDB(path);

    }

    public void deleteFlight(int index) {

        flightDao.remove(index);

    }

    public void deleteFlight(Flight flight) {

        flightDao.remove(flight);

    }

    public int count() {

        return flightDao.getAll().size();

    }

    public Flight getFlightById(int index) {
        if (index < flightDao.getAll().size() && index >= 0) {
            return flightDao.getAll().get(index);
        } else {
            return null;
        }
    }


}
