/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DBConnector.Connector;
import Models.User;
import java.sql.ResultSet;

/**
 *
 * @author Roshan Withanage
 */
public class LoginController {

    Connector con = Connector.getInstance();
    User user = new User();

    private LoginController() {
    }

    private static final LoginController obj = new LoginController();

    public static LoginController getInstance() {
        return obj;
    }

    public User Login(String username, String password) throws Exception {

        con.getConnection();
        ResultSet rs = con.srh("SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'");
        if (rs.next()) {

            user.setUser_id(rs.getInt(1));
            user.setFull_name(rs.getString(2));
            user.setUser_type(rs.getString(3));
        }

        return user;
    }
}
