/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author luisy
 */
public class Conexion {
        private final String driver = "com.mysql.jdbc.Driver";
        private final String user = "root";
        private final String password  = "root123";
        private final String url = "jdbc:mysql://localhost:3306/mascotasbd";

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
