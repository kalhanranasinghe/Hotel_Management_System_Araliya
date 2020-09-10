package Servlets;

import Models.Tour_booking;
import Controllers.Tour_bookingController;
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

@WebServlet(name = "Tour_bookingServlet", urlPatterns = {"/Tour_bookingServlet"})

public class Tour_bookingServlet extends HttpServlet {

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
                int no_of_members = Integer.parseInt(request.getParameter("no_of_members"));
                String date = request.getParameter("date");
                double total_price = Double.parseDouble(request.getParameter("total_price"));
                String date_time = request.getParameter("date_time");
                Tour_booking obj = new Tour_booking();
                obj.setCustomer_id(customer_id);
                obj.setNo_of_members(no_of_members);
                obj.setDate(date);
                obj.setTotal_price(total_price);
                obj.setDate_time(date_time);
                try {
                    Tour_bookingController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int tour_booking_id = Integer.parseInt(request.getParameter("tour_booking_id"));
                int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                int no_of_members = Integer.parseInt(request.getParameter("no_of_members"));
                String date = request.getParameter("date");
                double total_price = Double.parseDouble(request.getParameter("total_price"));
                String date_time = request.getParameter("date_time");
                Tour_booking obj = new Tour_booking();
                obj.setTour_booking_id(tour_booking_id);
                obj.setCustomer_id(customer_id);
                obj.setNo_of_members(no_of_members);
                obj.setDate(date);
                obj.setTotal_price(total_price);
                obj.setDate_time(date_time);
                try {
                    Tour_bookingController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int tour_booking_id = Integer.parseInt(request.getParameter("tour_booking_id"));
                Tour_booking obj = new Tour_booking();
                obj.setTour_booking_id(tour_booking_id);
                try {
                    Tour_bookingController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Tour_booking> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = Tour_bookingController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getTour_booking_id() + "_" + list.get(i).getCustomer_id() + "_" + list.get(i).getNo_of_members() + "_" + list.get(i).getDate() + "_" + list.get(i).getTotal_price() + "_" + list.get(i).getDate_time() + "_";
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
