package pl.jitsolutions.training.cr.presentation.car;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.jitsolutions.training.cr.business.car.boundary.CarsProvider;
import pl.jitsolutions.training.cr.business.car.entity.Car;

@Named
@RequestScoped
public class CarsView {

    @Inject
    private CarsProvider carsProvider;

    public List<Car> getCars() {
       return carsProvider.getCars();
    }
}
