package Controllers;

import Models.Room;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomController {

    Connector con = Connector.getInstance();

    private RoomController() {
    }

    private static final RoomController obj = new RoomController();

    public static RoomController getInstance() {
        return obj;
    }

    public void Save(Room data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO room(category,name,qty,price,status,date_time) values ('" + data.getCategory() + "','" + data.getName() + "','" + data.getQty() + "','" + data.getPrice() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Room data) throws Exception {
        con.getConnection();
        con.aud("UPDATE room SET category  = '" + data.getCategory() + "',name  = '" + data.getName() + "',qty  = '" + data.getQty() + "',price  = '" + data.getPrice() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE room_id = '" + data.getRoom_id() + "'");
    }

    public void Delete(Room data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM room WHERE room_id = '" + data.getRoom_id() + "'");
    }

    public List<Room> SearchAll() throws Exception {
        List<Room> objList = new ArrayList<Room>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM room");
        while (rset.next()) {
            Room obj = new Room();
            obj.setRoom_id(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setName(rset.getString(3));
            obj.setQty(rset.getInt(4));
            obj.setPrice(rset.getDouble(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public List<Room> Search(Room data) throws Exception {
        List<Room> objList = new ArrayList<Room>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM room WHERE room_id = '" + data.getRoom_id() + "'");
        while (rset.next()) {
            Room obj = new Room();
            obj.setRoom_id(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setName(rset.getString(3));
            obj.setQty(rset.getInt(4));
            obj.setPrice(rset.getDouble(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

}
