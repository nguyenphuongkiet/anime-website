/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.DBConfig;
import entity.AuthEntity;
import java.sql.*;

/**
 *
 * @author admin
 */
public class AuthRepository {
    
    Connection connect = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public AuthEntity login(String username, String password) throws SQLException {
        //select * from tbl User where email = ? and password=?
        String query = "select * from Auth where username=? and password=?";
        try {
            connect = new DBConfig().getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AuthEntity(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
        } catch (SQLException ex) {
            System.err.println("Error at Login");
        }
        return null;
    }
}
