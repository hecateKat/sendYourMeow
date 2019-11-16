package com.kat.meowter.service;

import com.kat.meowter.exception.IncorrectLoginOrPassword;
import com.kat.meowter.persistance.dao.UserDao;
import com.kat.meowter.persistance.entities.TbUser;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

public class UserService {

    private UserDao userDao = new UserDao();

    public TbUser getTbUser(String login, String password) throws IncorrectLoginOrPassword {
        TbUser userByLogin;
        try {
            userByLogin = userDao.getUserByLogin(login);
        } catch (NoResultException e) {
            throw new IncorrectLoginOrPassword("no user in database");
        } catch (NonUniqueResultException e) {
            throw new IncorrectLoginOrPassword("many users in database");
        }
        if (!userByLogin.getPassword().equals(password)) {
            throw new IncorrectLoginOrPassword("Incorrect password");
        }
        return userByLogin;
    }
}
