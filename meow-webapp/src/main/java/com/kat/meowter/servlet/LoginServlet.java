package com.kat.meowter.servlet;

import com.kat.meowter.exception.IncorrectLoginOrPassword;
import com.kat.meowter.service.UserService;
import com.kat.persistance.entities.TbUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        TbUser tbUser = null;
        try {
            tbUser = userService.getTbUser(login, password);
        } catch (IncorrectLoginOrPassword e) {
            e.printStackTrace();
            resp.sendRedirect("login.jsp");
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", tbUser);
        resp.sendRedirect("index.jsp");
    }
}
