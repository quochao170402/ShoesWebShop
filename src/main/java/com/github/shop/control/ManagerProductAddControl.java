package com.github.shop.control;

import com.github.shop.dao.impl.ProductDAOImpl;
import com.github.shop.entity.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ManagerProductAddControl", value = "/manager/product/add")
public class ManagerProductAddControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id, String name, String image, double price, String title, String description, int categoryId, int sellerId
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String price = request.getParameter("price");
        String title = request.getParameter("title");
        String description= request.getParameter("description");
        String categoryId = request.getParameter("categoryId");
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        int sellerId = account.getUserId();
        new ProductDAOImpl().add(name,image,Double.parseDouble(price),title,description,Integer.parseInt(categoryId),sellerId);
        response.sendRedirect("/shop/manager/product");
    }
}
