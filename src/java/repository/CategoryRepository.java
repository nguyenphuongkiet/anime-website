/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.DBConfig;
import entity.CategoryEntity;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author admin
 */
public class CategoryRepository {
    public ArrayList<CategoryEntity> getAllCategory() throws SQLException{
        ArrayList<CategoryEntity> list = new ArrayList<>();
        Connection cn = DBConfig.getConnection();
        PreparedStatement pst;
        ResultSet rs = null;
        if (cn != null) {
            String query = "select * from category";
            pst = cn.prepareStatement(query);
            rs = pst.executeQuery();
        }
        while(rs.next()) {
            CategoryEntity entity = new CategoryEntity();
            entity.setId(rs.getInt(1));
            entity.setName(rs.getString(2));
            entity.setDescription(rs.getString(3));
            list.add(entity);
        }
        return list;
    }
    
    public static void main(String[] args) throws SQLException {
        CategoryRepository repo = new CategoryRepository();
        for(CategoryEntity e : repo.getAllCategory()){
            System.out.println(e);
        }
    }
}
