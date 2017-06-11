package pl.jitsolutions.training.cr.business.car.boundary;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.jitsolutions.training.cr.business.car.entity.Car;

@Path("carsResource")
@Stateless
public class CarsResource {

    @EJB
    private CarsProvider carsProvider;

    @EJB
    private CarCreator carCreator;

    @Path("getCars")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Car> getCars() {

        return carsProvider.getCars();
    }

    @Path("createCar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response createCar(Car car) {
        System.out.println("Saving car = " + car);

        carCreator.save(car);

        return Response.status(Response.Status.CREATED).build();
    }

    @Path("getCarById")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCarById(@QueryParam("id") Long id) {
        return carsProvider.getCarById(id);
    }

    @Path("/getCarByRegNo/{regNo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCarByReqNo(@PathParam("regNo") String regNo) {
        return carsProvider.getCarByRegNo(regNo);
    }
}
