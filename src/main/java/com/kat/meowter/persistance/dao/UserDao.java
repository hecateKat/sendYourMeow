package com.kat.meowter.persistance.dao;

import com.kat.meowter.persistance.HibernateUtil;
import com.kat.meowter.persistance.entities.TbUser;
import org.hibernate.HibernateError;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.io.Serializable;

public class UserDao implements Serializable {

    public TbUser getUserByLogin(String login) throws HibernateError, NoResultException, NonUniqueObjectException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query query = session.createQuery("select e from " + TbUser.class.getName() + " e where e.login = :login");
            query.setParameter("login", login);
            session.beginTransaction();
            TbUser singleResult = (TbUser) query.getSingleResult();
            session.getTransaction().commit();
            return singleResult;
        }

//        try {
//            singleResult = (TbUser) query.getSingleResult();
//        }catch (NoResultException e) {
//            singleResult = null;
//        }
//        return singleResult;
    }

}
