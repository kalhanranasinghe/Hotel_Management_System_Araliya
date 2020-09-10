package Servlets;

import Models.Grn;
import Controllers.GrnController;
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

@WebServlet(name = "GrnServlet", urlPatterns = {"/GrnServlet"})

public class GrnServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int stock_id = Integer.parseInt(request.getParameter("stock_id"));
                int supplier_id = Integer.parseInt(request.getParameter("supplier_id"));
                double qty = Double.parseDouble(request.getParameter("qty"));
                String ststus = request.getParameter("ststus");
                String date_time = request.getParameter("date_time");
                Grn obj = new Grn();
                obj.setStock_id(stock_id);
                obj.setSupplier_id(supplier_id);
                obj.setQty(qty);
                obj.setStstus(ststus);
                obj.setDate_time(date_time);
                try {
                    GrnController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int grn_id = Integer.parseInt(request.getParameter("grn_id"));
                int stock_id = Integer.parseInt(request.getParameter("stock_id"));
                int supplier_id = Integer.parseInt(request.getParameter("supplier_id"));
                double qty = Double.parseDouble(request.getParameter("qty"));
                String ststus = request.getParameter("ststus");
                String date_time = request.getParameter("date_time");
                Grn obj = new Grn();
                obj.setGrn_id(grn_id);
                obj.setStock_id(stock_id);
                obj.setSupplier_id(supplier_id);
                obj.setQty(qty);
                obj.setStstus(ststus);
                obj.setDate_time(date_time);
                try {
                    GrnController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int grn_id = Integer.parseInt(request.getParameter("grn_id"));
                Grn obj = new Grn();
                obj.setGrn_id(grn_id);
                try {
                    GrnController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Grn> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = GrnController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getGrn_id() + "_" + list.get(i).getStock_id() + "_" + list.get(i).getSupplier_id() + "_" + list.get(i).getQty() + "_" + list.get(i).getStstus() + "_" + list.get(i).getDate_time() + "_";
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
