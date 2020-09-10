package Controllers;

import Models.Tours;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ToursController {

    Connector con = Connector.getInstance();

    private ToursController() {
    }

    private static final ToursController obj = new ToursController();

    public static ToursController getInstance() {
        return obj;
    }

    public void Save(Tours data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO tours(category,name,start_location,end_location,price,special,description,status,date_time) values ('" + data.getCategory() + "','" + data.getName() + "','" + data.getStart_location() + "','" + data.getEnd_location() + "','" + data.getPrice() + "','" + data.getSpecial() + "','" + data.getDescription() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Tours data) throws Exception {
        con.getConnection();
        con.aud("UPDATE tours SET category  = '" + data.getCategory() + "',name  = '" + data.getName() + "',start_location  = '" + data.getStart_location() + "',end_location  = '" + data.getEnd_location() + "',price  = '" + data.getPrice() + "',special  = '" + data.getSpecial() + "',description  = '" + data.getDescription() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE tours = '" + data.getTours() + "'");
    }

    public void Delete(Tours data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM tours WHERE tours = '" + data.getTours() + "'");
    }

    public List<Tours> SearchAll() throws Exception {
        List<Tours> objList = new ArrayList<Tours>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM tours");
        while (rset.next()) {
            Tours obj = new Tours();
            obj.setTours(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setName(rset.getString(3));
            obj.setStart_location(rset.getString(4));
            obj.setEnd_location(rset.getString(5));
            obj.setPrice(rset.getDouble(6));
            obj.setSpecial(rset.getString(7));
            obj.setDescription(rset.getString(8));
            obj.setStatus(rset.getString(9));
            obj.setDate_time(rset.getString(10));
            objList.add(obj);
        }

        return objList;
    }

    public List<Tours> Search(Tours data) throws Exception {
        List<Tours> objList = new ArrayList<Tours>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM tours WHERE tours = '" + data.getTours() + "'");
        while (rset.next()) {
            Tours obj = new Tours();
            obj.setTours(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setName(rset.getString(3));
            obj.setStart_location(rset.getString(4));
            obj.setEnd_location(rset.getString(5));
            obj.setPrice(rset.getDouble(6));
            obj.setSpecial(rset.getString(7));
            obj.setDescription(rset.getString(8));
            obj.setStatus(rset.getString(9));
            obj.setDate_time(rset.getString(10));
            objList.add(obj);
        }

        return objList;
    }

}
