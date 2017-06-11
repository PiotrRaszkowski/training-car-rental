package pl.jitsolutions.training.cr.presentation.car;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.jitsolutions.training.cr.business.car.boundary.CarCreator;
import pl.jitsolutions.training.cr.business.car.entity.Car;
import pl.jitsolutions.training.cr.business.car.entity.Manufacturer;

@RequestScoped
@Named
public class AddCarView {

    @Inject
    private CarCreator carCreator;

    private Car car = new Car();

    public void save() {
        System.out.println("Saving car = " + car);

        carCreator.save(car);
    }

    public Manufacturer [] getManufacturers() {
        return Manufacturer.values();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
