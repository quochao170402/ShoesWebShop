package com.github.shop.control;

import com.github.shop.dao.impl.ProductDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ManagerProductDeleteControl", value = "/manager/product/delete")
public class ManagerProductDeleteControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        new ProductDAOImpl().delete(Integer.parseInt(id));
        response.sendRedirect("/shop/manager/product");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
