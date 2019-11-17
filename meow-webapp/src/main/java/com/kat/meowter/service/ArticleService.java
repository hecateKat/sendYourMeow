package com.kat.meowter.service;

import com.kat.persistance.dao.ArticleDao;
import com.kat.persistance.entities.TbUser;

import java.util.List;

public class ArticleService {

    private ArticleDao articleDao = new ArticleDao();

    public void addArticle(TbUser user, String content) {
        articleDao.add(user, content);
    }

    public List getArticles() {
        return articleDao.getArticles();
    }

}
