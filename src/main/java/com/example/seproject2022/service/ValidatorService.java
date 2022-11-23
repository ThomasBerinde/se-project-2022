package com.example.seproject2022.service;

import com.example.seproject2022.exception.CustomException;

public interface ValidatorService {

    void validateIsAuthenticated(String elor,
                                 String uri) throws CustomException;

    void validateIsAdmin(String elor,
                         String uri) throws CustomException;

    void validateIsUser(String elor,
                        String uri) throws CustomException;
}
