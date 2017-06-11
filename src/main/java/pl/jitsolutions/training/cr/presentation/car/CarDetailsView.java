package pl.jitsolutions.training.cr.presentation.car;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.jitsolutions.training.cr.business.car.boundary.AlternativeChoice;
import pl.jitsolutions.training.cr.business.car.boundary.CarsProvider;
import pl.jitsolutions.training.cr.business.car.entity.Car;

@Named
@RequestScoped
public class CarDetailsView implements Serializable {

    private int selectedCarId;

    @Inject
    private CarsProvider carsProvider;

    private Car car;

    @Inject
    @AlternativeChoice
    private Car alternativeCar;

    public void init() {
        List<Car> cars = carsProvider.getCars();

        Optional<Car> foundCar = cars.stream().filter(car -> selectedCarId == car.getId()).findFirst();

        foundCar.ifPresent(car -> this.car = car);
    }

    public Car getCar() {
        return car;
    }

    public int getSelectedCarId() {
        return selectedCarId;
    }

    public void setSelectedCarId(int selectedCarId) {
        this.selectedCarId = selectedCarId;
    }

    public Car getAlternativeCar() {
        return alternativeCar;
    }

    public void setAlternativeCar(Car alternativeCar) {
        this.alternativeCar = alternativeCar;
    }
}
