package by.tms.finalProject.repository;


import by.tms.finalProject.entity.*;

import java.util.List;

public interface AdminRepository {
    void addAdmin(Admin admin);
    Admin findAdmin(Admin admin);
    Admin findAdminByLogin(Admin admin);
    List<Passenger> getAllPassenger();
    void addCompany(Company company);
    void addAircraft(Aircraft aircraft);
    void addCity(City city);
    void addCountry(Country country);
    PlaceClass addClassPlace(PlaceClass placeClass);
    void addPlace(Place place);
    void addFlight(Flight flight);
    Country findCountry(Country country);
    City findCity(City city);
    Company findCompany(Company company);
    Place findPlace(Place place);
    PlaceClass findPlaceClass(PlaceClass placeClass);
    List<Flight> getAllListFlights();
    Aircraft findAircraft(Aircraft aircraft);
    Flight countFlight();
    Flight findFlightById(Integer id);
    void deleteFlight(Flight flight);
    //List<City> getAllCity();
    void removeCity(City city);

}
