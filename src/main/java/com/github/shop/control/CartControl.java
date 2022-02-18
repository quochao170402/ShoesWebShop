package com.github.shop.control;

import com.github.shop.entity.ProductCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "CartControl", value = "/cart")
public class CartControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<Integer, ProductCart> map = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        if (map == null) {
            map = new HashMap<>();
        }

        List<ProductCart> list = new ArrayList<ProductCart>(map.values());
        request.setAttribute("list",list);
        request.getRequestDispatcher("Cart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
