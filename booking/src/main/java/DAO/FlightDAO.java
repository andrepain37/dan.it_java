package DAO;

import booking.Flight;

import java.util.List;

public interface FlightDAO {
    void saveFlight(Flight item);
    Flight get(int index);
    List<Flight> getAll();
    boolean remove(int index);
    boolean remove(Flight item);
    void saveDB(String path);
    void readDB(String path);
    void loadToDB(List<Flight> list);
}
