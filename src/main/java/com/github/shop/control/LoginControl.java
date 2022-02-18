package com.github.shop.control;

import com.github.shop.dao.impl.AccountDAOImpl;
import com.github.shop.entity.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginControl", value = "/login")
public class LoginControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        Account account = (Account) session.getAttribute("account");
//        if (account!=null){
//            request.setAttribute("account",account);
//        }
//        request.getRequestDispatcher("Login.jsp").forward(request,response);
        response.sendRedirect("Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = new AccountDAOImpl().login(username,password);
        if (account==null){
            request.setAttribute("mess","Not found username or password");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("account",account);
            response.sendRedirect("home");
        }
    }
}
