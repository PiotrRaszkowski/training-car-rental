package pl.jitsolutions.training.cr.business.car.boundary;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import pl.jitsolutions.training.cr.business.car.entity.Car;

public class CarsProvider {

    public List<Car> getCars() {
        Car car1 = new Car();
        car1.setId(1);
        car1.setManufacturer("VW");
        car1.setModel("Passat");
        car1.setColor("Blue");
        car1.setRegisterNumber("GD76523");
        car1.setSeatsNumber(5);
        car1.setYear(2016);

        Car car2 = new Car();
        car2.setId(2);
        car2.setManufacturer("VW");
        car2.setModel("Polo");
        car2.setColor("Blue");
        car2.setRegisterNumber("GD76524");
        car2.setSeatsNumber(5);
        car2.setYear(2015);

        Car car3 = new Car();
        car3.setId(3);
        car3.setManufacturer("VW");
        car3.setModel("Passat");
        car3.setColor("White");
        car3.setRegisterNumber("GD76525");
        car3.setSeatsNumber(5);
        car3.setYear(1987);

        Car car4 = new Car();
        car4.setId(4);
        car4.setManufacturer("Opel");
        car4.setModel("Astra");
        car4.setColor("Pink");
        car4.setRegisterNumber("GA32523");
        car4.setSeatsNumber(5);
        car4.setYear(2011);

        Car car5 = new Car();
        car5.setId(5);
        car5.setManufacturer("Mazda");
        car5.setModel("MX-5");
        car5.setColor("Red");
        car5.setRegisterNumber("G0MAZDA");
        car5.setSeatsNumber(2);
        car5.setYear(2017);

        return Stream.of(car1, car2, car3, car4, car5).collect(Collectors.toList());
    }

    @Produces
    @AlternativeChoice
    public Car getAlternativeChoice() {
        Car car1 = new Car();
        car1.setId(1);
        car1.setManufacturer("VW");
        car1.setModel("Touran");
        car1.setColor("Yellow");
        car1.setRegisterNumber("GD75623");
        car1.setSeatsNumber(7);
        car1.setYear(2017);
        return car1;
    }

    public void clear(@Disposes @AlternativeChoice Car car) {
        System.out.println("usuwanie!");
    }
}
