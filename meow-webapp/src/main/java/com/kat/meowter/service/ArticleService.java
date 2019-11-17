package com.kat.meowter.service;

import com.kat.persistance.dao.ArticleDao;
import com.kat.persistance.entities.TbUser;

public class ArticleService {

    private ArticleDao articleDao = new ArticleDao();

    public void addArticle(TbUser user, String content) {
        articleDao.add(user, content);
    }

}
