package com.example.seproject2022.service;

import com.example.seproject2022.exceptions.AuthenticationException;

public interface ValidatorService {

    void validateIsAuthenticated(String elor) throws AuthenticationException;

    void validateIsAdmin(String elor) throws AuthenticationException;

    void validateIsUser(String elor) throws AuthenticationException;
}
