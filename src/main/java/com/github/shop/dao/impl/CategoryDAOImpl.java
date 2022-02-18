package com.github.shop.dao.impl;

import com.github.shop.context.DBContext;
import com.github.shop.dao.CategoryDAO;
import com.github.shop.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    Connection conn = new DBContext().getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "select * from category";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
