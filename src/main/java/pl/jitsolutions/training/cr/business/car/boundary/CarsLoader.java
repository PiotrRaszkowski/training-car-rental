package pl.jitsolutions.training.cr.business.car.boundary;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.jitsolutions.training.cr.business.car.entity.Car;
import pl.jitsolutions.training.cr.business.car.entity.Manufacturer;

@Singleton
@Startup
public class CarsLoader {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        System.out.println("Loading cars...");

        Car car1 = new Car();
        car1.setManufacturer(Manufacturer.VW);
        car1.setModel("Passat");
        car1.setColor("Blue");
        car1.setRegisterNumber("GD76523");
        car1.setSeatsNumber(5);
        car1.setYear(2016);
        entityManager.persist(car1);

        Car car2 = new Car();
        car2.setManufacturer(Manufacturer.VW);
        car2.setModel("Polo");
        car2.setColor("Blue");
        car2.setRegisterNumber("GD76524");
        car2.setSeatsNumber(5);
        car2.setYear(2015);
        entityManager.persist(car2);

        Car car3 = new Car();
        car3.setManufacturer(Manufacturer.VW);
        car3.setModel("Passat");
        car3.setColor("White");
        car3.setRegisterNumber("GD76525");
        car3.setSeatsNumber(5);
        car3.setYear(2015);
        entityManager.persist(car3);

        Car car4 = new Car();
        car4.setManufacturer(Manufacturer.OPEL);
        car4.setModel("Astra");
        car4.setColor("Pink");
        car4.setRegisterNumber("GA32523");
        car4.setSeatsNumber(5);
        car4.setYear(2017);
        entityManager.persist(car4);

        Car car5 = new Car();
        car5.setManufacturer(Manufacturer.MAZDA);
        car5.setModel("MX-5");
        car5.setColor("Red");
        car5.setRegisterNumber("G0MAZDA");
        car5.setSeatsNumber(2);
        car5.setYear(2017);
        entityManager.persist(car5);
    }

}
