package com.islamgad.springboot.todowebapp.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isValid(String userName, String pass) {

        boolean validName = userName.equalsIgnoreCase("Islam Gad");
        boolean validPass = pass.equalsIgnoreCase("123");

        return validName && validPass;

    }
}
