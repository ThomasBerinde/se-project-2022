package com.example.seproject2022.service;

import com.example.seproject2022.exception.CustomException;

public interface ValidatorService {

    void validateIsAuthenticated(String jwt,
                                 String uri) throws CustomException;

    void validateIsAdmin(String jwt,
                         String uri) throws CustomException;

    void validateIsUser(String jwt,
                        String uri) throws CustomException;
}
