package pl.jitsolutions.training.cr.business.car.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.jitsolutions.training.cr.business.car.entity.Car;
import pl.jitsolutions.training.cr.business.car.entity.Manufacturer;

@Stateless
public class CarsProvider {

    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Car> getCars() {
        TypedQuery<Car> query = entityManager.createQuery("SELECT c FROM Car c", Car.class);
        return query.getResultList();
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
