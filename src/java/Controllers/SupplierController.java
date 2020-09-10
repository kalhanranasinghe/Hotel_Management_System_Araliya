package Controllers;

import Models.Supplier;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplierController {

    Connector con = Connector.getInstance();

    private SupplierController() {
    }

    private static final SupplierController obj = new SupplierController();

    public static SupplierController getInstance() {
        return obj;
    }

    public void Save(Supplier data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO supplier(name,address,email,contact,status,date_time) values ('" + data.getName() + "','" + data.getAddress() + "','" + data.getEmail() + "','" + data.getContact() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Supplier data) throws Exception {
        con.getConnection();
        con.aud("UPDATE supplier SET name  = '" + data.getName() + "',address  = '" + data.getAddress() + "',email  = '" + data.getEmail() + "',contact  = '" + data.getContact() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE supplier_id = '" + data.getSupplier_id() + "'");
    }

    public void Delete(Supplier data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM supplier WHERE supplier_id = '" + data.getSupplier_id() + "'");
    }

    public List<Supplier> SearchAll() throws Exception {
        List<Supplier> objList = new ArrayList<Supplier>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM supplier");
        while (rset.next()) {
            Supplier obj = new Supplier();
            obj.setSupplier_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setEmail(rset.getString(4));
            obj.setContact(rset.getString(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public List<Supplier> Search(Supplier data) throws Exception {
        List<Supplier> objList = new ArrayList<Supplier>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM supplier WHERE supplier_id = '" + data.getSupplier_id() + "'");
        while (rset.next()) {
            Supplier obj = new Supplier();
            obj.setSupplier_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setEmail(rset.getString(4));
            obj.setContact(rset.getString(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

}
