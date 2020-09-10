package Servlets;

import Models.Supplier;
import Controllers.SupplierController;
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

@WebServlet(name = "SupplierServlet", urlPatterns = {"/SupplierServlet"})

public class SupplierServlet extends HttpServlet {

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
                String email = request.getParameter("email");
                String contact = request.getParameter("contact");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Supplier obj = new Supplier();
                obj.setName(name);
                obj.setAddress(address);
                obj.setEmail(email);
                obj.setContact(contact);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    SupplierController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int supplier_id = Integer.parseInt(request.getParameter("supplier_id"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String contact = request.getParameter("contact");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Supplier obj = new Supplier();
                obj.setSupplier_id(supplier_id);
                obj.setName(name);
                obj.setAddress(address);
                obj.setEmail(email);
                obj.setContact(contact);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    SupplierController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int supplier_id = Integer.parseInt(request.getParameter("supplier_id"));
                Supplier obj = new Supplier();
                obj.setSupplier_id(supplier_id);
                try {
                    SupplierController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Supplier> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = SupplierController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getSupplier_id() + "_" + list.get(i).getName() + "_" + list.get(i).getAddress() + "_" + list.get(i).getEmail() + "_" + list.get(i).getContact() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
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
