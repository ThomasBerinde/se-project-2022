package com.example.seproject2022.service.impl;

import com.example.seproject2022.exceptions.AuthenticationException;
import com.example.seproject2022.service.ValidatorService;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    private final String ROLE_USER = "USER";
    private final String ROLE_ADMIN = "ADMIN";
    private String decodedElor;

    private void decodeElorHeader(String elor) throws AuthenticationException {
        if (elor == null) {
            throw new AuthenticationException("User is not authenticated");
        }
        byte[] decodedBytes = Base64.getDecoder()
                                    .decode(elor);
        decodedElor = new String(decodedBytes);
    }

    @Override
    public void validateIsAuthenticated(String elor) throws AuthenticationException {
        decodeElorHeader(elor);
        if (!decodedElor.equals(ROLE_USER) && !decodedElor.equals(ROLE_ADMIN)) {
            throw new AuthenticationException("User is not authenticated");
        }
    }

    @Override
    public void validateIsAdmin(String elor) throws AuthenticationException {
        validateIsAuthenticated(elor);
        if (!decodedElor.equals(ROLE_ADMIN)) {
            throw new AuthenticationException("Unauthorised, you must have the role 'USER' to access this resource");
        }
    }

    @Override
    public void validateIsUser(String elor) throws AuthenticationException {
        validateIsAuthenticated(elor);
        if (!decodedElor.equals(ROLE_USER)) {
            throw new AuthenticationException("Unauthorised, you must have the role 'ADMIN' to access this resource");
        }
    }
}
