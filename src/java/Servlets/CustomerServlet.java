package Servlets;

import Models.Customer;
import Controllers.CustomerController;
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

@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})

public class CustomerServlet extends HttpServlet {

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
                String contact_no = request.getParameter("contact_no");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                int loyalty = Integer.parseInt(request.getParameter("loyalty"));
                String date_time = request.getParameter("date_time");
                Customer obj = new Customer();
                obj.setName(name);
                obj.setContact_no(contact_no);
                obj.setEmail(email);
                obj.setAddress(address);
                obj.setLoyalty(loyalty);
                obj.setDate_time(date_time);
                try {
                    CustomerController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                String name = request.getParameter("name");
                String contact_no = request.getParameter("contact_no");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                int loyalty = Integer.parseInt(request.getParameter("loyalty"));
                String date_time = request.getParameter("date_time");
                Customer obj = new Customer();
                obj.setCustomer_id(customer_id);
                obj.setName(name);
                obj.setContact_no(contact_no);
                obj.setEmail(email);
                obj.setAddress(address);
                obj.setLoyalty(loyalty);
                obj.setDate_time(date_time);
                try {
                    CustomerController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                Customer obj = new Customer();
                obj.setCustomer_id(customer_id);
                try {
                    CustomerController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Customer> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = CustomerController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getCustomer_id() + "_" + list.get(i).getName() + "_" + list.get(i).getContact_no() + "_" + list.get(i).getEmail() + "_" + list.get(i).getAddress() + "_" + list.get(i).getLoyalty() + "_" + list.get(i).getDate_time() + "_";
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
