package Servlets;

import Models.Employee;
import Controllers.EmployeeController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/EmployeeServlet"})

public class EmployeeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String nic = request.getParameter("nic");
                String email = request.getParameter("email");
                String contact = request.getParameter("contact");
                double basic_salary = Double.parseDouble(request.getParameter("basic_salary"));
                String designation = request.getParameter("designation");
                String date_time = request.getParameter("date_time");
                Employee obj = new Employee();
                obj.setName(name);
                obj.setAddress(address);
                obj.setNic(nic);
                obj.setEmail(email);
                obj.setContact(contact);
                obj.setBasic_salary(basic_salary);
                obj.setDesignation(designation);
                obj.setDate_time(date_time);
                try {
                    EmployeeController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int employee_id = Integer.parseInt(request.getParameter("employee_id"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String nic = request.getParameter("nic");
                String email = request.getParameter("email");
                String contact = request.getParameter("contact");
                double basic_salary = Double.parseDouble(request.getParameter("basic_salary"));
                String designation = request.getParameter("designation");
                String date_time = request.getParameter("date_time");
                Employee obj = new Employee();
                obj.setEmployee_id(employee_id);
                obj.setName(name);
                obj.setAddress(address);
                obj.setNic(nic);
                obj.setEmail(email);
                obj.setContact(contact);
                obj.setBasic_salary(basic_salary);
                obj.setDesignation(designation);
                obj.setDate_time(date_time);
                try {
                    EmployeeController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int employee_id = Integer.parseInt(request.getParameter("employee_id"));
                Employee obj = new Employee();
                obj.setEmployee_id(employee_id);
                try {
                    EmployeeController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Employee> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = EmployeeController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getEmployee_id() + "_" + list.get(i).getName() + "_" + list.get(i).getAddress() + "_" + list.get(i).getNic() + "_" + list.get(i).getEmail() + "_" + list.get(i).getContact() + "_" + list.get(i).getBasic_salary() + "_" + list.get(i).getDesignation() + "_" + list.get(i).getDate_time() + "_";
                        stringList.add(s);
                    }
                    String b = String.join("~", stringList);
                    response.getWriter().println(b);
                } catch (Exception ex) {
                    //Error
                }

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
