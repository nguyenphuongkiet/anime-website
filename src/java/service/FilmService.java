/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.FilmEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import repository.FilmRepository;

/**
 *
 * @author admin
 */
public class FilmService {
    FilmRepository fp = new FilmRepository();
    
    public ArrayList<FilmEntity> getTreding() throws SQLException{
        return fp.getTreding();
    }
    
    public ArrayList<FilmEntity> getAll() throws SQLException{
        return fp.getAll();
    }
    
    public ArrayList<FilmEntity> getSideBar() throws SQLException{
        return fp.getSideBar();
    }
    
    public FilmEntity getDetail(int id) throws SQLException{
        return fp.getDetail(id);
    }
}
