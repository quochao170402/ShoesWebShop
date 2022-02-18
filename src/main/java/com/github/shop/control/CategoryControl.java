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

@WebServlet(name = "CategoryControl", value = "/category")
public class CategoryControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("categoryId");
        if (category == null) request.getRequestDispatcher("/shop/home").forward(request, response);
        else {
            ProductDAOImpl productDAO = new ProductDAOImpl();

            String index = request.getParameter("index");
            if (index == null) {
                index = "1";
            }
            Product lastProduct = productDAO.getLatest();
            List<Product> productList = productDAO.pagingByCategory(Integer.parseInt(index), 6, Integer.parseInt(category));
            List<Category> categoryList = new CategoryDAOImpl().getAll();

            int size = productList.size();
            int numberPages = size / 6 + ((size % 6 == 0) ? 0 : 1);
            int pageSize = 6;
            if (size < 6) {
                pageSize = size;
            }

            request.setAttribute("tag", category);
            request.setAttribute("listSize", size);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("numberPage", numberPages);
            request.setAttribute("index", index);
            request.setAttribute("productList", productList);
            request.setAttribute("categoryList", categoryList);
            request.setAttribute("lastProduct", lastProduct);
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
