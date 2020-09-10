package Controllers;

import Models.Housekeeping;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HousekeepingController {

    Connector con = Connector.getInstance();

    private HousekeepingController() {
    }

    private static final HousekeepingController obj = new HousekeepingController();

    public static HousekeepingController getInstance() {
        return obj;
    }

    public void Save(Housekeeping data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO housekeeping(employee_id,task,description,status,date_time) values ('" + data.getEmployee_id() + "','" + data.getTask() + "','" + data.getDescription() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Housekeeping data) throws Exception {
        con.getConnection();
        con.aud("UPDATE housekeeping SET employee_id  = '" + data.getEmployee_id() + "',task  = '" + data.getTask() + "',description  = '" + data.getDescription() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE housekeeping_id = '" + data.getHousekeeping_id() + "'");
    }

    public void Delete(Housekeeping data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM housekeeping WHERE housekeeping_id = '" + data.getHousekeeping_id() + "'");
    }

    public List<Housekeeping> SearchAll() throws Exception {
        List<Housekeeping> objList = new ArrayList<Housekeeping>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM housekeeping");
        while (rset.next()) {
            Housekeeping obj = new Housekeeping();
            obj.setHousekeeping_id(rset.getInt(1));
            obj.setEmployee_id(rset.getInt(2));
            obj.setTask(rset.getString(3));
            obj.setDescription(rset.getString(4));
            obj.setStatus(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<Housekeeping> Search(Housekeeping data) throws Exception {
        List<Housekeeping> objList = new ArrayList<Housekeeping>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM housekeeping WHERE housekeeping_id = '" + data.getHousekeeping_id() + "'");
        while (rset.next()) {
            Housekeeping obj = new Housekeeping();
            obj.setHousekeeping_id(rset.getInt(1));
            obj.setEmployee_id(rset.getInt(2));
            obj.setTask(rset.getString(3));
            obj.setDescription(rset.getString(4));
            obj.setStatus(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

}
