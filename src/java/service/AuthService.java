/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.AuthEntity;
import java.sql.SQLException;
import repository.AuthRepository;

/**
 *
 * @author admin
 */
public class AuthService {
    AuthRepository ar = new AuthRepository();
    
    public AuthEntity login(String username, String password) throws SQLException{
        return ar.login(username, password);
    }
}
