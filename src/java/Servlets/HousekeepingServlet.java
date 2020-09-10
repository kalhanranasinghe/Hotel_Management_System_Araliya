package Servlets;

import Models.Housekeeping;
import Controllers.HousekeepingController;
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

@WebServlet(name = "HousekeepingServlet", urlPatterns = {"/HousekeepingServlet"})

public class HousekeepingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int employee_id = Integer.parseInt(request.getParameter("employee_id"));
                String task = request.getParameter("task");
                String description = request.getParameter("description");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Housekeeping obj = new Housekeeping();
                obj.setEmployee_id(employee_id);
                obj.setTask(task);
                obj.setDescription(description);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    HousekeepingController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int housekeeping_id = Integer.parseInt(request.getParameter("housekeeping_id"));
                int employee_id = Integer.parseInt(request.getParameter("employee_id"));
                String task = request.getParameter("task");
                String description = request.getParameter("description");
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Housekeeping obj = new Housekeeping();
                obj.setHousekeeping_id(housekeeping_id);
                obj.setEmployee_id(employee_id);
                obj.setTask(task);
                obj.setDescription(description);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    HousekeepingController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int housekeeping_id = Integer.parseInt(request.getParameter("housekeeping_id"));
                Housekeeping obj = new Housekeeping();
                obj.setHousekeeping_id(housekeeping_id);
                try {
                    HousekeepingController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Housekeeping> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = HousekeepingController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getHousekeeping_id() + "_" + list.get(i).getEmployee_id() + "_" + list.get(i).getTask() + "_" + list.get(i).getDescription() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
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
