package com.cvillegas.app.main.exceptions;

public class RoleNotFoundException extends IllegalArgumentException {
    public RoleNotFoundException(String s) {
        super(s);
    }
}
