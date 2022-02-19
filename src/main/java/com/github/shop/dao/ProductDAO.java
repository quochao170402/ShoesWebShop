package com.github.shop.dao;

import com.github.shop.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAll();
    List<Product> getByCategory(int categoryId);
    List<Product> paging(int index,int pageSize);
    List<Product> pagingByCategory(int index,int pageSize,int categoryId);
    Product getById(int productId);
    Product getLatest();
    List<Product> search(String key);
    int add(String name, String image, double price, String title, String description, int categoryId, int sellerId);
    int update(int id,String name, String image, double price, String title, String description, int categoryId);
    int delete(int id);
}
