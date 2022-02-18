package com.github.shop.control;

import com.github.shop.dao.impl.CategoryDAOImpl;
import com.github.shop.dao.impl.ProductDAOImpl;
import com.github.shop.entity.Category;
import com.github.shop.entity.Product;
import com.github.shop.entity.ProductCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "HomeControl", value = "/home")
public class HomeControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }

        Product lastProduct = productDAO.getLatest();
        List<Product> productList = productDAO.paging(Integer.parseInt(index), 6);
        List<Category> categoryList = categoryDAO.getAll();
        List<Product> allProduct = productDAO.getAll();

        int size = allProduct.size();
        int numberPages = size / 6 + 1;

        int pageSize = 6;
        if (size < 6) {
            pageSize = size;
        }

        request.setAttribute("listSize", size);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("numberPage", numberPages);
        request.setAttribute("index", index);
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("lastProduct", lastProduct);
        request.getRequestDispatcher("/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        HttpSession session = request.getSession();
        HashMap<Integer, ProductCart> map = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        if (map == null) {
            map = new HashMap<>();
        }

        int id = Integer.parseInt(productId);
        Product product = new ProductDAOImpl().getById(id);
        ProductCart productCart = null;
        if (!map.containsKey(id)) {
            productCart = new ProductCart(id, product.getName(), product.getImage(), product.getPrice(), 1);
        } else {
            productCart = map.get(id);
            productCart.setQuantity(productCart.getQuantity() + 1);
            productCart.setTotal();
        }

        map.put(id, productCart);
        session.setAttribute("cart", map);
        String action = request.getParameter("action");
        if (action.contains("detail")) {
            response.sendRedirect("detail");
        } else if (action.contains("category")) {
            response.sendRedirect("category");
        } else if (action.contains("home")) {
            response.sendRedirect("home");
        }

    }
}
