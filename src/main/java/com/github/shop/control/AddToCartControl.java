package com.github.shop.control;

import com.github.shop.dao.impl.ProductDAOImpl;
import com.github.shop.entity.Product;
import com.github.shop.entity.ProductCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "AddToCartControl", value = "/addtocart")
public class AddToCartControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
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
        response.sendRedirect("cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
