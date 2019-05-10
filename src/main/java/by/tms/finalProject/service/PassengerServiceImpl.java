package by.tms.finalProject.service;

import by.tms.finalProject.entity.*;
import by.tms.finalProject.repository.PassengerRepository;
import org.hibernate.JDBCException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public boolean addPassenger(Passenger passenger) {
       try {
           passengerRepository.addPassenger(passenger);
           return true;
       }catch (ArithmeticException e){
           return false;
       }
    }

    @Override
    public Passenger findPassenger(Passenger passenger) {
       try {
           return passengerRepository.findPassenger(passenger);
       }catch (NoResultException e){
           return null;
       }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean findPassengerByLogin(Passenger passenger) {
        try {
            passengerRepository.findPassengerByLogin(passenger);
            return true;
        }catch (NoResultException e){
            return false;
        }
    }

    @Override
    public void changePassenger(Passenger passenger) {
        passengerRepository.changePassenger(passenger);
    }

    @Override
    public List<Flight> getAllFlights() {
        return passengerRepository.getAllFlights();
    }

    @Override
    public Flight reservePlace(City cityFrom, City cityTo) {
        try {
            return passengerRepository.reservePlace(cityFrom, cityTo);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void reserve(Reservation reservation) {
        passengerRepository.reserve(reservation);
    }

    @Override
    public String placeRandomEcoClass() {
        return passengerRepository.placeRandomEcoClass();
    }

    @Override
    public Reservation findPlace(String seat) {
        return passengerRepository.findPlace(seat);
    }
}
