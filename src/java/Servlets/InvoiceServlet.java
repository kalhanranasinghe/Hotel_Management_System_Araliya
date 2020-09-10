package Servlets;

import Models.Invoice;
import Controllers.InvoiceController;
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

@WebServlet(name = "InvoiceServlet", urlPatterns = {"/InvoiceServlet"})

public class InvoiceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                double bonus = Double.parseDouble(request.getParameter("bonus"));
                String price = request.getParameter("price");
                String date_time = request.getParameter("date_time");
                Invoice obj = new Invoice();
                obj.setCustomer_id(customer_id);
                obj.setBonus(bonus);
                obj.setPrice(price);
                obj.setDate_time(date_time);
                try {
                    InvoiceController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
                int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                double bonus = Double.parseDouble(request.getParameter("bonus"));
                String price = request.getParameter("price");
                String date_time = request.getParameter("date_time");
                Invoice obj = new Invoice();
                obj.setInvoice_id(invoice_id);
                obj.setCustomer_id(customer_id);
                obj.setBonus(bonus);
                obj.setPrice(price);
                obj.setDate_time(date_time);
                try {
                    InvoiceController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
                Invoice obj = new Invoice();
                obj.setInvoice_id(invoice_id);
                try {
                    InvoiceController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Invoice> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = InvoiceController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getInvoice_id() + "_" + list.get(i).getCustomer_id() + "_" + list.get(i).getBonus() + "_" + list.get(i).getPrice() + "_" + list.get(i).getDate_time() + "_";
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
