package com.github.shop.dao;

import com.github.shop.entity.Account;

public interface AccountDAO {
    public Account login(String username, String password);
    public int signup(String username,String password);
}
