package Controllers;

import Models.Customer;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    Connector con = Connector.getInstance();

    private CustomerController() {
    }

    private static final CustomerController obj = new CustomerController();

    public static CustomerController getInstance() {
        return obj;
    }

    public void Save(Customer data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO customer(name,contact_no,email,address,loyalty,date_time) values ('" + data.getName() + "','" + data.getContact_no() + "','" + data.getEmail() + "','" + data.getAddress() + "','" + data.getLoyalty() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Customer data) throws Exception {
        con.getConnection();
        con.aud("UPDATE customer SET name  = '" + data.getName() + "',contact_no  = '" + data.getContact_no() + "',email  = '" + data.getEmail() + "',address  = '" + data.getAddress() + "',loyalty  = '" + data.getLoyalty() + "',date_time  = '" + data.getDate_time() + "' WHERE customer_id = '" + data.getCustomer_id() + "'");
    }

    public void Delete(Customer data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM customer WHERE customer_id = '" + data.getCustomer_id() + "'");
    }

    public List<Customer> SearchAll() throws Exception {
        List<Customer> objList = new ArrayList<Customer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM customer");
        while (rset.next()) {
            Customer obj = new Customer();
            obj.setCustomer_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setContact_no(rset.getString(3));
            obj.setEmail(rset.getString(4));
            obj.setAddress(rset.getString(5));
            obj.setLoyalty(rset.getInt(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public List<Customer> Search(Customer data) throws Exception {
        List<Customer> objList = new ArrayList<Customer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM customer WHERE customer_id = '" + data.getCustomer_id() + "'");
        while (rset.next()) {
            Customer obj = new Customer();
            obj.setCustomer_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setContact_no(rset.getString(3));
            obj.setEmail(rset.getString(4));
            obj.setAddress(rset.getString(5));
            obj.setLoyalty(rset.getInt(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

}
