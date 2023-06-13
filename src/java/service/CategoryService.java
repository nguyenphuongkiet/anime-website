/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.CategoryEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import repository.CategoryRepository;

/**
 *
 * @author admin
 */
public class CategoryService {
    CategoryRepository cr = new CategoryRepository();
    public ArrayList<CategoryEntity> getAllCategory() throws SQLException{
        return cr.getAllCategory();
    }
}
