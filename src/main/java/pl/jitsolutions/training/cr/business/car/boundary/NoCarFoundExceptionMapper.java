package pl.jitsolutions.training.cr.business.car.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import pl.jitsolutions.training.cr.business.car.entity.NoCarFoundException;

@Provider
public class NoCarFoundExceptionMapper implements ExceptionMapper<NoCarFoundException> {
    @Override
    public Response toResponse(NoCarFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
    }
}
