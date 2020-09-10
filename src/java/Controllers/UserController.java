package Controllers;

import Models.User;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    Connector con = Connector.getInstance();

    private UserController() {
    }

    private static final UserController obj = new UserController();

    public static UserController getInstance() {
        return obj;
    }

    public void Save(User data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO user(full_name,user_type,username,password,date_time) values ('" + data.getFull_name() + "','" + data.getUser_type() + "','" + data.getUsername() + "','" + data.getPassword() + "','" + data.getDate_time() + "') ");
    }

    public void Update(User data) throws Exception {
        con.getConnection();
        con.aud("UPDATE user SET full_name  = '" + data.getFull_name() + "',user_type  = '" + data.getUser_type() + "',username  = '" + data.getUsername() + "',password  = '" + data.getPassword() + "',date_time  = '" + data.getDate_time() + "' WHERE user_id = '" + data.getUser_id() + "'");
    }

    public void Delete(User data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM user WHERE user_id = '" + data.getUser_id() + "'");
    }

    public List<User> SearchAll() throws Exception {
        List<User> objList = new ArrayList<User>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM user");
        while (rset.next()) {
            User obj = new User();
            obj.setUser_id(rset.getInt(1));
            obj.setFull_name(rset.getString(2));
            obj.setUser_type(rset.getString(3));
            obj.setUsername(rset.getString(4));
            obj.setPassword(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<User> Search(User data) throws Exception {
        List<User> objList = new ArrayList<User>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM user WHERE user_id = '" + data.getUser_id() + "'");
        while (rset.next()) {
            User obj = new User();
            obj.setUser_id(rset.getInt(1));
            obj.setFull_name(rset.getString(2));
            obj.setUser_type(rset.getString(3));
            obj.setUsername(rset.getString(4));
            obj.setPassword(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

}
