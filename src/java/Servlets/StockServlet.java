package Servlets;

import Models.Stock;
import Controllers.StockController;
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

@WebServlet(name = "StockServlet", urlPatterns = {"/StockServlet"})

public class StockServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                String category = request.getParameter("category");
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                double qty = Double.parseDouble(request.getParameter("qty"));
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Stock obj = new Stock();
                obj.setCategory(category);
                obj.setName(name);
                obj.setPrice(price);
                obj.setQty(qty);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    StockController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int stock_id = Integer.parseInt(request.getParameter("stock_id"));
                String category = request.getParameter("category");
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                double qty = Double.parseDouble(request.getParameter("qty"));
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Stock obj = new Stock();
                obj.setStock_id(stock_id);
                obj.setCategory(category);
                obj.setName(name);
                obj.setPrice(price);
                obj.setQty(qty);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    StockController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int stock_id = Integer.parseInt(request.getParameter("stock_id"));
                Stock obj = new Stock();
                obj.setStock_id(stock_id);
                try {
                    StockController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Stock> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = StockController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getStock_id() + "_" + list.get(i).getCategory() + "_" + list.get(i).getName() + "_" + list.get(i).getPrice() + "_" + list.get(i).getQty() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
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
