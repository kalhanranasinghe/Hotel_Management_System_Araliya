package Controllers;

import Models.Grn;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GrnController {

    Connector con = Connector.getInstance();

    private GrnController() {
    }

    private static final GrnController obj = new GrnController();

    public static GrnController getInstance() {
        return obj;
    }

    public void Save(Grn data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO grn(stock_id,supplier_id,qty,ststus,date_time) values ('" + data.getStock_id() + "','" + data.getSupplier_id() + "','" + data.getQty() + "','" + data.getStstus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Grn data) throws Exception {
        con.getConnection();
        con.aud("UPDATE grn SET stock_id  = '" + data.getStock_id() + "',supplier_id  = '" + data.getSupplier_id() + "',qty  = '" + data.getQty() + "',ststus  = '" + data.getStstus() + "',date_time  = '" + data.getDate_time() + "' WHERE grn_id = '" + data.getGrn_id() + "'");
    }

    public void Delete(Grn data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM grn WHERE grn_id = '" + data.getGrn_id() + "'");
    }

    public List<Grn> SearchAll() throws Exception {
        List<Grn> objList = new ArrayList<Grn>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM grn");
        while (rset.next()) {
            Grn obj = new Grn();
            obj.setGrn_id(rset.getInt(1));
            obj.setStock_id(rset.getInt(2));
            obj.setSupplier_id(rset.getInt(3));
            obj.setQty(rset.getDouble(4));
            obj.setStstus(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<Grn> Search(Grn data) throws Exception {
        List<Grn> objList = new ArrayList<Grn>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM grn WHERE grn_id = '" + data.getGrn_id() + "'");
        while (rset.next()) {
            Grn obj = new Grn();
            obj.setGrn_id(rset.getInt(1));
            obj.setStock_id(rset.getInt(2));
            obj.setSupplier_id(rset.getInt(3));
            obj.setQty(rset.getDouble(4));
            obj.setStstus(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

}
