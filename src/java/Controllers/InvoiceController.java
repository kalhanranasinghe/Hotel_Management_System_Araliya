package Controllers;

import Models.Invoice;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InvoiceController {

    Connector con = Connector.getInstance();

    private InvoiceController() {
    }

    private static final InvoiceController obj = new InvoiceController();

    public static InvoiceController getInstance() {
        return obj;
    }

    public void Save(Invoice data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO invoice(customer_id,bonus,price,date_time) values ('" + data.getCustomer_id() + "','" + data.getBonus() + "','" + data.getPrice() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Invoice data) throws Exception {
        con.getConnection();
        con.aud("UPDATE invoice SET customer_id  = '" + data.getCustomer_id() + "',bonus  = '" + data.getBonus() + "',price  = '" + data.getPrice() + "',date_time  = '" + data.getDate_time() + "' WHERE invoice_id = '" + data.getInvoice_id() + "'");
    }

    public void Delete(Invoice data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM invoice WHERE invoice_id = '" + data.getInvoice_id() + "'");
    }

    public List<Invoice> SearchAll() throws Exception {
        List<Invoice> objList = new ArrayList<Invoice>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM invoice");
        while (rset.next()) {
            Invoice obj = new Invoice();
            obj.setInvoice_id(rset.getInt(1));
            obj.setCustomer_id(rset.getInt(2));
            obj.setBonus(rset.getDouble(3));
            obj.setPrice(rset.getString(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

    public List<Invoice> Search(Invoice data) throws Exception {
        List<Invoice> objList = new ArrayList<Invoice>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM invoice WHERE invoice_id = '" + data.getInvoice_id() + "'");
        while (rset.next()) {
            Invoice obj = new Invoice();
            obj.setInvoice_id(rset.getInt(1));
            obj.setCustomer_id(rset.getInt(2));
            obj.setBonus(rset.getDouble(3));
            obj.setPrice(rset.getString(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

}
