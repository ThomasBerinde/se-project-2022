package com.example.seproject2022.service.impl;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.service.ValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidatorServiceImpl implements ValidatorService {

    private static final String UNAUTHORIZED = "Unauthorized, you must have the role '%s' to access this resource";
    private static final String UNAUTHENTICATED = "User is not authenticated";
    private static String ROLE_ADMIN;
    private static String ROLE_USER;

    @Value("${adminRole}")
    public void setAdminRole(String adminRole) {
        ROLE_ADMIN = adminRole;
    }

    @Value("${userRole}")
    public void setUserRole(String userRole) {
        ROLE_USER = userRole;
    }

    @Override
    public void validateIsAuthenticated(String jwt, String uri) throws CustomException {
        if (jwt == null) {
            throw new CustomException(UNAUTHENTICATED, HttpStatus.UNAUTHORIZED, uri);
        }
        if (!jwt.equals(ROLE_USER) && !jwt.equals(ROLE_ADMIN)) {
            throw new CustomException(UNAUTHENTICATED, HttpStatus.UNAUTHORIZED, uri);
        }
    }

    @Override
    public void validateIsAdmin(String jwt, String uri) throws CustomException {
        validateIsAuthenticated(jwt, uri);
        if (!jwt.equals(ROLE_ADMIN)) {
            throw new CustomException(String.format(UNAUTHORIZED, ROLE_ADMIN), HttpStatus.FORBIDDEN, uri);
        }
    }

    @Override
    public void validateIsUser(String jwt, String uri) throws CustomException {
        validateIsAuthenticated(jwt, uri);
        if (!jwt.equals(ROLE_USER)) {
            throw new CustomException(String.format(UNAUTHORIZED, ROLE_USER), HttpStatus.FORBIDDEN, uri);
        }
    }
}
