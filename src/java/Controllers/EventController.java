package Controllers;

import Models.Event;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventController {

    Connector con = Connector.getInstance();

    private EventController() {
    }

    private static final EventController obj = new EventController();

    public static EventController getInstance() {
        return obj;
    }

    public void Save(Event data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO event(category,date,time,no_of_members,price,status,date_time) values ('" + data.getCategory() + "','" + data.getDate() + "','" + data.getTime() + "','" + data.getNo_of_members() + "','" + data.getPrice() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Event data) throws Exception {
        con.getConnection();
        con.aud("UPDATE event SET category  = '" + data.getCategory() + "',date  = '" + data.getDate() + "',time  = '" + data.getTime() + "',no_of_members  = '" + data.getNo_of_members() + "',price  = '" + data.getPrice() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE event_id = '" + data.getEvent_id() + "'");
    }

    public void Delete(Event data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM event WHERE event_id = '" + data.getEvent_id() + "'");
    }

    public List<Event> SearchAll() throws Exception {
        List<Event> objList = new ArrayList<Event>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM event");
        while (rset.next()) {
            Event obj = new Event();
            obj.setEvent_id(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setDate(rset.getString(3));
            obj.setTime(rset.getString(4));
            obj.setNo_of_members(rset.getInt(5));
            obj.setPrice(rset.getDouble(6));
            obj.setStatus(rset.getString(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }

    public List<Event> Search(Event data) throws Exception {
        List<Event> objList = new ArrayList<Event>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM event WHERE event_id = '" + data.getEvent_id() + "'");
        while (rset.next()) {
            Event obj = new Event();
            obj.setEvent_id(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setDate(rset.getString(3));
            obj.setTime(rset.getString(4));
            obj.setNo_of_members(rset.getInt(5));
            obj.setPrice(rset.getDouble(6));
            obj.setStatus(rset.getString(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }

}
