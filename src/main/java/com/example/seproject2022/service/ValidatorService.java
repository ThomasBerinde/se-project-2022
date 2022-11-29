package com.example.seproject2022.service;

import com.example.seproject2022.exception.CustomException;

public interface ValidatorService {

    void validateIsAuthenticated(String role,
                                 String uri) throws CustomException;

    void validateIsAdmin(String role,
                         String uri) throws CustomException;

    void validateIsUser(String role,
                        String uri) throws CustomException;
}
