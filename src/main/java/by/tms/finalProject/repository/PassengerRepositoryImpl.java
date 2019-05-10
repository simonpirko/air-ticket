package by.tms.finalProject.repository;

import by.tms.finalProject.entity.*;
import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Repository
public class PassengerRepositoryImpl implements PassengerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPassenger(Passenger passenger) {
        entityManager.persist(passenger);
    }

    @Override
    public Passenger findPassenger(Passenger passenger) {
        String query = "select p from Passenger p where p.login = :login and p.password = :password";
        return (Passenger) entityManager.createQuery(query)
                .setParameter("login", passenger.getLogin())
                .setParameter("password", passenger.getPassword())
                .getSingleResult();
    }

    @Override
    public Passenger findPassengerByLogin(Passenger passenger) {
           String query = "select p from Passenger p where p.login = :login";
           return (Passenger) entityManager.createQuery(query)
                   .setParameter("login", passenger.getLogin())
                   .getSingleResult();
    }

    @Override
    public void changePassenger(Passenger passenger) {
        entityManager.merge(passenger);
    }

    @Override
    public List<Flight> getAllFlights() {
        String query = "select f from Flight f order by f.flightDate";
        return entityManager.createQuery(query)
                .getResultList();
    }

    @Override
    public Flight reservePlace(City cityFrom, City cityTo) {
        String query = "select f from Flight f join f.cityFrom cf join f.cityTo ct where cf.nameCity = :cityFrom and ct.nameCity = :cityTo";
        return (Flight) entityManager.createQuery(query)
                .setParameter("cityFrom", cityFrom.getNameCity())
                .setParameter("cityTo", cityTo.getNameCity())
                .getSingleResult();
    }

    @Override
    public void reserve(Reservation reservation) {
        entityManager.persist(reservation);
    }

    @Override
    public String placeRandomEcoClass() {
        String query = "select max(p.seat) from Place p";
        return (String) entityManager.createQuery(query)
                .getSingleResult();
    }

    @Override
    public Reservation findPlace(String seat) {
        String query = "select r from Reservation r join r.place p where p.seat = :seat";
        return (Reservation) entityManager.createQuery(query)
                .setParameter("seat", seat)
                .getSingleResult();
    }

}
