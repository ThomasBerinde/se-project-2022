package com.example.seproject2022.service.impl;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.service.ValidatorService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    private static final String ROLE_USER = "USER";
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String UNAUTHORIZED = "Unauthorized, you must have the role '%s' to access this resource";
    private static final String UNAUTHENTICATED = "User is not authenticated";
    private String decodedElor;

    private void decodeElorHeader(String elor,
                                  String uri) throws CustomException {
        if (elor == null) {
            throw new CustomException(UNAUTHENTICATED, HttpStatus.UNAUTHORIZED, uri);
        }
        try {
            byte[] decodedBytes = Base64.getDecoder()
                                        .decode(elor);
            decodedElor = new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            throw new CustomException(UNAUTHENTICATED, HttpStatus.UNAUTHORIZED, uri);
        }
    }

    @Override
    public void validateIsAuthenticated(String elor,
                                        String uri) throws CustomException {
        decodeElorHeader(elor, uri);
        if (!decodedElor.equals(ROLE_USER) && !decodedElor.equals(ROLE_ADMIN)) {
            throw new CustomException(UNAUTHENTICATED, HttpStatus.UNAUTHORIZED, uri);
        }
    }

    @Override
    public void validateIsAdmin(String elor,
                                String uri) throws CustomException {
        validateIsAuthenticated(elor, uri);
        if (!decodedElor.equals(ROLE_ADMIN)) {
            throw new CustomException(String.format(UNAUTHORIZED, ROLE_ADMIN), HttpStatus.FORBIDDEN, uri);
        }
    }

    @Override
    public void validateIsUser(String elor,
                               String uri) throws CustomException {
        validateIsAuthenticated(elor, uri);
        if (!decodedElor.equals(ROLE_USER)) {
            throw new CustomException(String.format(UNAUTHORIZED, ROLE_USER), HttpStatus.FORBIDDEN, uri);
        }
    }
}
