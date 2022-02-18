package com.github.shop.control;

import com.github.shop.dao.impl.CategoryDAOImpl;
import com.github.shop.dao.impl.ProductDAOImpl;
import com.github.shop.entity.Category;
import com.github.shop.entity.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailControl", value = "/detail")
public class DetailControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        ProductDAOImpl productDAO = new ProductDAOImpl();
        Product product = productDAO.getById(Integer.parseInt(productId));
        Product lastProduct = productDAO.getLatest();
        List<Category> categoryList = new CategoryDAOImpl().getAll();
        request.setAttribute("detail",product);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("lastProduct", lastProduct);
        request.getRequestDispatcher("Detail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
