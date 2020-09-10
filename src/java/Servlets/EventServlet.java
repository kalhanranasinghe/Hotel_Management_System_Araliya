package Servlets;

import Models.Event;
import Controllers.EventController;
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

@WebServlet(name = "EventServlet", urlPatterns = {"/EventServlet"})

public class EventServlet extends HttpServlet {

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
                String date = request.getParameter("date");
                String time = request.getParameter("time");
                int no_of_members = Integer.parseInt(request.getParameter("no_of_members"));
                double price = Double.parseDouble(request.getParameter("price"));
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Event obj = new Event();
                obj.setCategory(category);
                obj.setDate(date);
                obj.setTime(time);
                obj.setNo_of_members(no_of_members);
                obj.setPrice(price);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    EventController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int event_id = Integer.parseInt(request.getParameter("event_id"));
                String category = request.getParameter("category");
                String date = request.getParameter("date");
                String time = request.getParameter("time");
                int no_of_members = Integer.parseInt(request.getParameter("no_of_members"));
                double price = Double.parseDouble(request.getParameter("price"));
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Event obj = new Event();
                obj.setEvent_id(event_id);
                obj.setCategory(category);
                obj.setDate(date);
                obj.setTime(time);
                obj.setNo_of_members(no_of_members);
                obj.setPrice(price);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    EventController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int event_id = Integer.parseInt(request.getParameter("event_id"));
                Event obj = new Event();
                obj.setEvent_id(event_id);
                try {
                    EventController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Event> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = EventController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getEvent_id() + "_" + list.get(i).getCategory() + "_" + list.get(i).getDate() + "_" + list.get(i).getTime() + "_" + list.get(i).getNo_of_members() + "_" + list.get(i).getPrice() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
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
