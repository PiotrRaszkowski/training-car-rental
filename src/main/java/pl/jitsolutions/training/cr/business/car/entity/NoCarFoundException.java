package pl.jitsolutions.training.cr.business.car.entity;

import javax.ejb.ApplicationException;

@ApplicationException
public class NoCarFoundException extends RuntimeException {
    public NoCarFoundException(String message) {
        super(message);
    }
}
