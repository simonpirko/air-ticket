package by.tms.finalProject.service;

import by.tms.finalProject.entity.*;

import java.sql.Date;
import java.util.List;

public interface PassengerService {
    boolean addPassenger(Passenger passenger);
    Passenger findPassenger(Passenger passenger);
    boolean findPassengerByLogin(Passenger passenger);
    void changePassenger(Passenger passenger);
    List<Flight> getAllFlights();
    Flight reservePlace(City cityFrom, City cityTo);
    void reserve(Reservation reservation);
    String placeRandomEcoClass();
    Reservation findPlace(String seat);
}
