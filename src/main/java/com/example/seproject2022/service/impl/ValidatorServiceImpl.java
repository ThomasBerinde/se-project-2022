package com.example.seproject2022.service.impl;

import com.example.seproject2022.exception.CustomException;
import com.example.seproject2022.service.ValidatorService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Base64;

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
    public void validateIsAuthenticated(String role, String uri) throws CustomException {
        if (role == null) {
            throw new CustomException(UNAUTHENTICATED, HttpStatus.UNAUTHORIZED, uri);
        }
        if (!role.equals(ROLE_USER) && !role.equals(ROLE_ADMIN)) {
            throw new CustomException(UNAUTHENTICATED, HttpStatus.UNAUTHORIZED, uri);
        }
    }

    @Override
    public void validateIsAdmin(String role, String uri) throws CustomException {
        validateIsAuthenticated(role, uri);
        if (!role.equals(ROLE_ADMIN)) {
            throw new CustomException(String.format(UNAUTHORIZED, ROLE_ADMIN), HttpStatus.FORBIDDEN, uri);
        }
    }

    @Override
    public void validateIsUser(String role, String uri) throws CustomException {
        validateIsAuthenticated(role, uri);
        if (!role.equals(ROLE_USER)) {
            throw new CustomException(String.format(UNAUTHORIZED, ROLE_USER), HttpStatus.FORBIDDEN, uri);
        }
    }
}
