package com.kat.meowter.service;

import com.kat.meowter.exception.IncorrectLoginOrPassword;
import com.kat.meowter.persistance.entities.TbUser;

public class UserService {

    public TbUser getTbUser(String login, String password) throws IncorrectLoginOrPassword {
        if (login.equals(password)) {
            return new TbUser(1, login);
        } else {
            throw new IncorrectLoginOrPassword("Incorrect login or password");
        }
    }
}
