package Controllers;

import Models.Reservation;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {

    Connector con = Connector.getInstance();

    private ReservationController() {
    }

    private static final ReservationController obj = new ReservationController();

    public static ReservationController getInstance() {
        return obj;
    }

    public void Save(Reservation data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO reservation(room_id,start_date,end_date,no_of_members,total,status,date_time) values ('" + data.getRoom_id() + "','" + data.getStart_date() + "','" + data.getEnd_date() + "','" + data.getNo_of_members() + "','" + data.getTotal() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Reservation data) throws Exception {
        con.getConnection();
        con.aud("UPDATE reservation SET room_id  = '" + data.getRoom_id() + "',start_date  = '" + data.getStart_date() + "',end_date  = '" + data.getEnd_date() + "',no_of_members  = '" + data.getNo_of_members() + "',total  = '" + data.getTotal() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE reservation_id = '" + data.getReservation_id() + "'");
    }

    public void Delete(Reservation data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM reservation WHERE reservation_id = '" + data.getReservation_id() + "'");
    }

    public List<Reservation> SearchAll() throws Exception {
        List<Reservation> objList = new ArrayList<Reservation>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM reservation");
        while (rset.next()) {
            Reservation obj = new Reservation();
            obj.setReservation_id(rset.getInt(1));
            obj.setRoom_id(rset.getInt(2));
            obj.setStart_date(rset.getString(3));
            obj.setEnd_date(rset.getString(4));
            obj.setNo_of_members(rset.getInt(5));
            obj.setTotal(rset.getDouble(6));
            obj.setStatus(rset.getString(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }

    public List<Reservation> Search(Reservation data) throws Exception {
        List<Reservation> objList = new ArrayList<Reservation>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM reservation WHERE reservation_id = '" + data.getReservation_id() + "'");
        while (rset.next()) {
            Reservation obj = new Reservation();
            obj.setReservation_id(rset.getInt(1));
            obj.setRoom_id(rset.getInt(2));
            obj.setStart_date(rset.getString(3));
            obj.setEnd_date(rset.getString(4));
            obj.setNo_of_members(rset.getInt(5));
            obj.setTotal(rset.getDouble(6));
            obj.setStatus(rset.getString(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }

}
