package Servlets;

import Models.Room;
import Controllers.RoomController;
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

@WebServlet(name = "RoomServlet", urlPatterns = {"/RoomServlet"})

public class RoomServlet extends HttpServlet {

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
                int qty = Integer.parseInt(request.getParameter("qty"));
                double price = Double.parseDouble(request.getParameter("price"));
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Room obj = new Room();
                obj.setCategory(category);
                obj.setName(name);
                obj.setQty(qty);
                obj.setPrice(price);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    RoomController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int room_id = Integer.parseInt(request.getParameter("room_id"));
                String category = request.getParameter("category");
                String name = request.getParameter("name");
                int qty = Integer.parseInt(request.getParameter("qty"));
                double price = Double.parseDouble(request.getParameter("price"));
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Room obj = new Room();
                obj.setRoom_id(room_id);
                obj.setCategory(category);
                obj.setName(name);
                obj.setQty(qty);
                obj.setPrice(price);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    RoomController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int room_id = Integer.parseInt(request.getParameter("room_id"));
                Room obj = new Room();
                obj.setRoom_id(room_id);
                try {
                    RoomController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Room> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = RoomController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getRoom_id() + "_" + list.get(i).getCategory() + "_" + list.get(i).getName() + "_" + list.get(i).getQty() + "_" + list.get(i).getPrice() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
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
