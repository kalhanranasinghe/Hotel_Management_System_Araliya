package Controllers;

import Models.Tour_booking;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tour_bookingController {

    Connector con = Connector.getInstance();

    private Tour_bookingController() {
    }

    private static final Tour_bookingController obj = new Tour_bookingController();

    public static Tour_bookingController getInstance() {
        return obj;
    }

    public void Save(Tour_booking data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO tour_booking(customer_id,no_of_members,date,total_price,date_time) values ('" + data.getCustomer_id() + "','" + data.getNo_of_members() + "','" + data.getDate() + "','" + data.getTotal_price() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Tour_booking data) throws Exception {
        con.getConnection();
        con.aud("UPDATE tour_booking SET customer_id  = '" + data.getCustomer_id() + "',no_of_members  = '" + data.getNo_of_members() + "',date  = '" + data.getDate() + "',total_price  = '" + data.getTotal_price() + "',date_time  = '" + data.getDate_time() + "' WHERE tour_booking_id = '" + data.getTour_booking_id() + "'");
    }

    public void Delete(Tour_booking data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM tour_booking WHERE tour_booking_id = '" + data.getTour_booking_id() + "'");
    }

    public List<Tour_booking> SearchAll() throws Exception {
        List<Tour_booking> objList = new ArrayList<Tour_booking>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM tour_booking");
        while (rset.next()) {
            Tour_booking obj = new Tour_booking();
            obj.setTour_booking_id(rset.getInt(1));
            obj.setCustomer_id(rset.getInt(2));
            obj.setNo_of_members(rset.getInt(3));
            obj.setDate(rset.getString(4));
            obj.setTotal_price(rset.getDouble(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<Tour_booking> Search(Tour_booking data) throws Exception {
        List<Tour_booking> objList = new ArrayList<Tour_booking>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM tour_booking WHERE tour_booking_id = '" + data.getTour_booking_id() + "'");
        while (rset.next()) {
            Tour_booking obj = new Tour_booking();
            obj.setTour_booking_id(rset.getInt(1));
            obj.setCustomer_id(rset.getInt(2));
            obj.setNo_of_members(rset.getInt(3));
            obj.setDate(rset.getString(4));
            obj.setTotal_price(rset.getDouble(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

}
