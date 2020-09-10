package Servlets;

import Models.Tours;
import Controllers.ToursController;
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

@WebServlet(name = "ToursServlet", urlPatterns = {"/ToursServlet"})

public class ToursServlet extends HttpServlet {

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
                String start_location = request.getParameter("start_location");
                String end_location = request.getParameter("end_location");
                double price = Double.parseDouble(request.getParameter("price"));
                String special = request.getParameter("special");
                String description = request.getParameter("description");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Tours obj = new Tours();
                obj.setCategory(category);
                obj.setName(name);
                obj.setStart_location(start_location);
                obj.setEnd_location(end_location);
                obj.setPrice(price);
                obj.setSpecial(special);
                obj.setDescription(description);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    ToursController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int tours = Integer.parseInt(request.getParameter("tours"));
                String category = request.getParameter("category");
                String name = request.getParameter("name");
                String start_location = request.getParameter("start_location");
                String end_location = request.getParameter("end_location");
                double price = Double.parseDouble(request.getParameter("price"));
                String special = request.getParameter("special");
                String description = request.getParameter("description");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Tours obj = new Tours();
                obj.setTours(tours);
                obj.setCategory(category);
                obj.setName(name);
                obj.setStart_location(start_location);
                obj.setEnd_location(end_location);
                obj.setPrice(price);
                obj.setSpecial(special);
                obj.setDescription(description);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    ToursController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int tours = Integer.parseInt(request.getParameter("tours"));
                Tours obj = new Tours();
                obj.setTours(tours);
                try {
                    ToursController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Tours> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = ToursController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getTours() + "_" + list.get(i).getCategory() + "_" + list.get(i).getName() + "_" + list.get(i).getStart_location() + "_" + list.get(i).getEnd_location() + "_" + list.get(i).getPrice() + "_" + list.get(i).getSpecial() + "_" + list.get(i).getDescription() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
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
