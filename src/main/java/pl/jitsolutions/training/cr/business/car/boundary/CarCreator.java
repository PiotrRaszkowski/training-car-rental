package pl.jitsolutions.training.cr.business.car.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.jitsolutions.training.cr.business.car.entity.Car;

@Stateless
public class CarCreator {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Car car) {
        entityManager.persist(car);
    }
}
