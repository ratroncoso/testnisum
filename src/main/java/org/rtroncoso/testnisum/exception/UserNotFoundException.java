package org.rtroncoso.testnisum.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super("Could not find employeeo se encuentra usuario id: " + id);
    }
}
