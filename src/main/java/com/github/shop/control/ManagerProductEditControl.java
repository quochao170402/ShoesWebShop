package com.github.shop.control;

import com.github.shop.dao.impl.CategoryDAOImpl;
import com.github.shop.dao.impl.ProductDAOImpl;
import com.github.shop.entity.Account;
import com.github.shop.entity.Category;
import com.github.shop.entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerProductEditControl", value = "/manager/product/edit")
public class ManagerProductEditControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = new ProductDAOImpl().getById(Integer.parseInt(id));
        List<Category> categoryList = new CategoryDAOImpl().getAll();
        request.setAttribute("product",product);
        request.setAttribute("listCategory",categoryList);
        request.getRequestDispatcher("/EditProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String price = request.getParameter("price");
        String title = request.getParameter("title");
        String description= request.getParameter("description");
        String categoryId = request.getParameter("categoryId");
        new ProductDAOImpl().update(Integer.parseInt(id),name,image,Double.parseDouble(price),title,description,Integer.parseInt(categoryId));
        response.sendRedirect("/shop/manager/product");
    }
}
