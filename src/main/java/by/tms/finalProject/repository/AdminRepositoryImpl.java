package by.tms.finalProject.repository;

import by.tms.finalProject.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAdmin(Admin admin) {
        try {
            entityManager.persist(admin);
        }catch (PersistenceException e){
            throw new ArithmeticException(e.getMessage());
        }
    }

    @Override
    public Admin findAdmin(Admin admin) {
        String query = "select a from Admin a where a.login = :login and a.password = :password";
        return (Admin) entityManager.createQuery(query)
                .setParameter("login", admin.getLogin())
                .setParameter("password", admin.getPassword())
                .getSingleResult();
    }

    @Override
    public Admin findAdminByLogin(Admin admin) {
        String query = "select a from Admin a where a.login = :login";
        return (Admin) entityManager.createQuery(query)
                .setParameter("login", admin.getLogin())
                .getSingleResult();
    }

    @Override
    public List<Passenger> getAllPassenger() {
        String query = "select p from Passenger p";
        return entityManager.createQuery(query)
                .getResultList();
    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public void addAircraft(Aircraft aircraft) {
        entityManager.persist(aircraft);
    }

    @Override
    public void addCity(City city) {
        entityManager.persist(city);
    }

    @Override
    public void addCountry(Country country) {
        entityManager.persist(country);
    }

    @Override
    public PlaceClass addClassPlace(PlaceClass placeClass) {
        entityManager.persist(placeClass);
        return placeClass;
    }

    @Override
    public void addPlace(Place place) {
        entityManager.persist(place);
    }

    @Override
    public void addFlight(Flight flight) {
        entityManager.persist(flight);
    }

    @Override
    public Country findCountry(Country country) {
        String query = "select c from Country c where c.nameCountry = :name";
        return (Country) entityManager.createQuery(query)
                .setParameter("name", country.getNameCountry())
                .getSingleResult();
    }

    @Override
    public City findCity(City city) {
        String query = "select c from City c where c.nameCity = :name";
        return (City) entityManager.createQuery(query)
                .setParameter("name", city.getNameCity())
                .getSingleResult();
    }

    @Override
    public Company findCompany(Company company) {
        String query = "select c from Company c where c.nameCompany = :name";
        return (Company) entityManager.createQuery(query)
                .setParameter("name", company.getNameCompany())
                .getSingleResult();
    }

    @Override
    public Place findPlace(Place place) {
        String query = "select p from Place p where p.seat = :seat";
        return (Place) entityManager.createQuery(query)
                .setParameter("seat", place.getSeat())
                .getSingleResult();
    }

    @Override
    public PlaceClass findPlaceClass(PlaceClass placeClass) {
        String query = "select pc from PlaceClass pc where pc.name = :classPlaceName";
        return (PlaceClass) entityManager.createQuery(query)
                .setParameter("classPlaceName", placeClass.getName())
                .getSingleResult();
    }

    @Override
    public List<Flight> getAllListFlights() {
        String query = "select f from Flight f join f.cityFrom cf join f.cityTo ct";
        return (List<Flight>) entityManager.createQuery(query)
                .getResultList();
    }

    @Override
    public Aircraft findAircraft(Aircraft aircraft) {
        String query = "select a from Aircraft a where a.nameAircraft = :name";
        return (Aircraft) entityManager.createQuery(query)
                .setParameter("name", aircraft)
                .getSingleResult();
    }

    @Override
    public Flight countFlight() {
        String query = "select f from Flight f where f.id = max(f.id)";
        return (Flight) entityManager.createQuery(query)
                .getSingleResult();
    }

    @Override
    public Flight findFlightById(Integer id) {
        return entityManager.find(Flight.class, id);
    }

    @Override
    public void deleteFlight(Flight flight) {
        entityManager.remove(flight);
    }

//    @Override
//    public List<City> getAllCity() {
//        String query = "select c from City c";
//        return entityManager.createQuery(query)
//                .getResultList();
//    }

    @Override
    public void removeCity(City city) {
        String query = "select c from City c where c.nameCity = :name";
        City city1 = (City) entityManager.createQuery(query).setParameter("name", city.getNameCity()).getSingleResult();
        entityManager.remove(city1);
    }

}
