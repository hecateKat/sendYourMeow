package com.kat.persistance.dao;

import com.kat.persistance.HibernateUtil;
import com.kat.persistance.entities.TbArticle;
import com.kat.persistance.entities.TbUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ArticleDao {

    public void add(TbUser user, String content) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            TbArticle tbArticle = new TbArticle();
            tbArticle.setContent(content);
            tbArticle.setUser(user);
            session.beginTransaction();
            session.save(tbArticle);
            session.getTransaction().commit();
        }
    }

    public List getArticles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select e from TbArticle e");
            session.getTransaction().commit();
            return query.getResultList();
        }
    }
}
