package Controllers;

import Models.Employee;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {

    Connector con = Connector.getInstance();

    private EmployeeController() {
    }

    private static final EmployeeController obj = new EmployeeController();

    public static EmployeeController getInstance() {
        return obj;
    }

    public void Save(Employee data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO employee(name,address,nic,email,contact,basic_salary,designation,date_time) values ('" + data.getName() + "','" + data.getAddress() + "','" + data.getNic() + "','" + data.getEmail() + "','" + data.getContact() + "','" + data.getBasic_salary() + "','" + data.getDesignation() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Employee data) throws Exception {
        con.getConnection();
        con.aud("UPDATE employee SET name  = '" + data.getName() + "',address  = '" + data.getAddress() + "',nic  = '" + data.getNic() + "',email  = '" + data.getEmail() + "',contact  = '" + data.getContact() + "',basic_salary  = '" + data.getBasic_salary() + "',designation  = '" + data.getDesignation() + "',date_time  = '" + data.getDate_time() + "' WHERE employee_id = '" + data.getEmployee_id() + "'");
    }

    public void Delete(Employee data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM employee WHERE employee_id = '" + data.getEmployee_id() + "'");
    }

    public List<Employee> SearchAll() throws Exception {
        List<Employee> objList = new ArrayList<Employee>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM employee");
        while (rset.next()) {
            Employee obj = new Employee();
            obj.setEmployee_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setNic(rset.getString(4));
            obj.setEmail(rset.getString(5));
            obj.setContact(rset.getString(6));
            obj.setBasic_salary(rset.getDouble(7));
            obj.setDesignation(rset.getString(8));
            obj.setDate_time(rset.getString(9));
            objList.add(obj);
        }

        return objList;
    }

    public List<Employee> Search(Employee data) throws Exception {
        List<Employee> objList = new ArrayList<Employee>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM employee WHERE employee_id = '" + data.getEmployee_id() + "'");
        while (rset.next()) {
            Employee obj = new Employee();
            obj.setEmployee_id(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setNic(rset.getString(4));
            obj.setEmail(rset.getString(5));
            obj.setContact(rset.getString(6));
            obj.setBasic_salary(rset.getDouble(7));
            obj.setDesignation(rset.getString(8));
            obj.setDate_time(rset.getString(9));
            objList.add(obj);
        }

        return objList;
    }

}
