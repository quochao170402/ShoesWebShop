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

@WebServlet(name = "ManagerProductControl", value = "/manager/product")
public class ManagerProductControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        List<Product> productList = new ProductDAOImpl().paging(Integer.parseInt(index), 6);
        int size = new ProductDAOImpl().getAll().size();
        int numberPages = size / 6 + 1;

        int pageSize = 6;
        if (size < 6) {
            pageSize = size;
        }

        List<Category> categoryList = new CategoryDAOImpl().getAll();

        request.setAttribute("listSize", size);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("numberPage", numberPages);
        request.setAttribute("index", index);
        request.setAttribute("listProduct", productList);
        request.setAttribute("listCategory", categoryList);
        request.getRequestDispatcher("../ManagerProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
