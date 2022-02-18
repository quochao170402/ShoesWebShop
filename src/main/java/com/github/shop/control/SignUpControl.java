package com.github.shop.control;

import com.github.shop.dao.impl.AccountDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpControl", value = "/signup")
public class SignUpControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");

        if (!password.equals(confirm)){
            request.setAttribute("mess","Password do not match");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("confirm",confirm);
            request.getRequestDispatcher("SignUp.jsp").forward(request,response);
        }else{
            int value = new AccountDAOImpl().signup(username,password);
            if (value==0){
                request.setAttribute("mess","Account was existed!");
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                request.setAttribute("confirm",confirm);
                request.getRequestDispatcher("SignUp.jsp").forward(request,response);
            }else{
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
        }
    }
}
