package by.tms.finalProject.service;

import by.tms.finalProject.entity.*;
import by.tms.finalProject.repository.AdminRepository;
import by.tms.finalProject.repository.AdminRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean addAdmin(Admin admin) {
        try {
            adminRepository.addAdmin(admin);
            return true;
        }catch (ConstraintViolationException e){
            return false;
        }
    }

    @Override
    public Admin findAdmin(Admin admin) {
        try {
            return adminRepository.findAdmin(admin);
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public boolean findAdminByLogin(Admin admin) {
        try {
            adminRepository.findAdminByLogin(admin);
            return true;
        }catch (NoResultException e){
            return false;
        }
    }

    @Override
    public List<Passenger> getAllPassenger() {
        return adminRepository.getAllPassenger();
    }

    @Override
    public void addCompany(Company company) {
        adminRepository.addCompany(company);
    }

    @Override
    public void addAircraft(Aircraft aircraft) {
        adminRepository.addAircraft(aircraft);
    }

    @Override
    public void addCity(City city) {
        adminRepository.addCity(city);
    }

    @Override
    public void addCountry(Country country) {
        adminRepository.addCountry(country);
    }

    @Override
    public void addPlaceClass(PlaceClass placeClass) {
        adminRepository.addClassPlace(placeClass);
    }

    @Override
    public void addPlace(Place place) {
        adminRepository.addPlace(place);
    }

    @Override
    public void addFlight(Flight flight) {
        adminRepository.addFlight(flight);
    }


    @Override
    public Country findCountry(Country country) {
        try {
            return adminRepository.findCountry(country);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public City findCity(City city) {
        try {
            return adminRepository.findCity(city);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Company findCompany(Company company) {
        try {
            return adminRepository.findCompany(company);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Place findPlace(Place place) {
        try {
            return adminRepository.findPlace(place);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public PlaceClass findPlaceClass(PlaceClass placeClass) {
        try {
            return adminRepository.findPlaceClass(placeClass);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<Flight> getAllListFlights() {
        return adminRepository.getAllListFlights();
    }

    @Override
    public Aircraft findAircraft(Aircraft aircraft) {
        try {
            return adminRepository.findAircraft(aircraft);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Flight countFlight() {
        return adminRepository.countFlight();
    }

    @Override
    public Flight findFlightById(Integer id) {
        return adminRepository.findFlightById(id);
    }

    @Override
    public void deleteFlight(Flight flight) {
        adminRepository.deleteFlight(flight);
    }

//    @Override
//    public List<City> getAllCity() {
//        return adminRepository.getAllCity();
//    }

    @Override
    public void removeCity(City city) {
        adminRepository.removeCity(city);
    }

}
