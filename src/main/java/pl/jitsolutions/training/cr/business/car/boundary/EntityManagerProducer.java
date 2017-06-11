package pl.jitsolutions.training.cr.business.car.boundary;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    @CarRentalDatabase
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
