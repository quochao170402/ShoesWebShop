package com.github.shop.filter;

import com.github.shop.entity.Account;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterAuthentication")
public class FilterAuthentication implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            if (account.getIsAdmin() == 1) {
                chain.doFilter(request, response);
            } else {
                String uri = req.getRequestURI();
                int isSeller = account.getIsSeller();
                if (uri.contains("/manager/product") && isSeller == 1) {
                    chain.doFilter(request, response);
                } else {
                    resp.sendRedirect("home");
                }
            }
        } else {
            resp.sendRedirect("login");
        }
    }
}
