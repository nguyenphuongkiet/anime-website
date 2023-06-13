/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.DBConfig;
import entity.FilmEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class FilmRepository {
    
    public ArrayList<FilmEntity> getAll() throws SQLException{
        ArrayList<FilmEntity> list = new ArrayList<>();
        Connection cn = DBConfig.getConnection();
        PreparedStatement pst;
        ResultSet rs = null;
        if (cn != null) {
            String query = "select * from film";
            pst = cn.prepareStatement(query);
            rs = pst.executeQuery();
        }
        while(rs.next()) {
            FilmEntity entity = new FilmEntity();
            entity.setId(rs.getInt(1));
            entity.setName(rs.getString(2));
            entity.setDescription(rs.getString(3));
            entity.setThumbnailurl(rs.getString(4));
            list.add(entity);
        }
        return list;
    }
    
    public ArrayList<FilmEntity> getSideBar() throws SQLException{
        ArrayList<FilmEntity> list = new ArrayList<>();
        Connection cn = DBConfig.getConnection();
        PreparedStatement pst;
        ResultSet rs = null;
        if (cn != null) {
            String query = "select top 4 * from film";
            pst = cn.prepareStatement(query);
            rs = pst.executeQuery();
        }
        while(rs.next()) {
            FilmEntity entity = new FilmEntity();
            entity.setId(rs.getInt(1));
            entity.setName(rs.getString(2));
            entity.setDescription(rs.getString(3));
            entity.setThumbnailurl(rs.getString(4));
            list.add(entity);
        }
        return list;
    }
    
    public ArrayList<FilmEntity> getTreding() throws SQLException{
        ArrayList<FilmEntity> list = new ArrayList<>();
        Connection cn = DBConfig.getConnection();
        PreparedStatement pst;
        ResultSet rs = null;
        if (cn != null) {
            String query = "select top 6 * from film";
            pst = cn.prepareStatement(query);
            rs = pst.executeQuery();
        }
        while(rs.next()) {
            FilmEntity entity = new FilmEntity();
            entity.setId(rs.getInt(1));
            entity.setName(rs.getString(2));
            entity.setDescription(rs.getString(3));
            entity.setThumbnailurl(rs.getString(4));
            list.add(entity);
        }
        return list;
    }
    
    public FilmEntity getDetail(int id) throws SQLException{
        FilmEntity film = new FilmEntity();

        Connection con = DBConfig.getConnection();
        PreparedStatement pstm = con.prepareStatement("select * from film where id = ?");
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            film.setId(rs.getInt("id"));
            film.setName(rs.getString("name"));
            film.setDescription(rs.getString("description"));
            film.setThumbnailurl(rs.getString("thumbnailurl"));
        }
        con.close();
        return film;
    }
    
    public static void main(String[] args) throws SQLException {
        FilmRepository repo = new FilmRepository();
        FilmEntity fe = new FilmEntity();
        fe = repo.getDetail(12);
        System.out.println(fe);
    }
}
