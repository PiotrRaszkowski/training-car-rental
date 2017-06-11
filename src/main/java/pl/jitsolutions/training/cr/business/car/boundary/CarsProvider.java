package pl.jitsolutions.training.cr.business.car.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.jitsolutions.training.cr.business.car.entity.Car;
import pl.jitsolutions.training.cr.business.car.entity.Manufacturer;
import pl.jitsolutions.training.cr.business.car.entity.NoCarFoundException;

@Stateless
public class CarsProvider {

    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public List<Car> getCars() {
        TypedQuery<Car> query = entityManager.createQuery("SELECT c FROM Car c", Car.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Car getCarById(long id) {
        Car car = entityManager.find(Car.class, id);

        if (car == null) {
            throw new NoCarFoundException("No car found for id = " + id);
        }

        return car;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Car getCarByRegNo(String regNo) {
        TypedQuery<Car> query = entityManager.createNamedQuery(Car.GET_CAR_BY_REG_NO, Car.class);
        query.setParameter("regNo", regNo);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new NoCarFoundException("No car found for registration number = " + regNo);
        }
    }

    @Produces
    @AlternativeChoice
    public Car getAlternativeChoice() {
        Car car1 = new Car();
        car1.setId(1);
        car1.setManufacturer(Manufacturer.VW);
        car1.setModel("Touran");
        car1.setColor("Yellow");
        car1.setRegisterNumber("GD75623");
        car1.setSeatsNumber(7);
        car1.setYear(2017);
        return car1;
    }
}
