package pl.jitsolutions.training.cr.business.car.boundary;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.jitsolutions.training.cr.business.car.entity.Car;

@Path("carsResource")
public class CarsResource {

    @EJB
    private CarsProvider carsProvider;

    @EJB
    private CarCreator carCreator;

    @Path("getCars")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars() {

        return carsProvider.getCars();
    }

    @Path("createCar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCar(Car car) {
        System.out.println("Saving car = " + car);

        carCreator.save(car);

        return Response.status(Response.Status.CREATED).build();
    }
}
