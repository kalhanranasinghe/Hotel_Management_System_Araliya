package Servlets;

import Models.User;
import Controllers.UserController;
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

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})

public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                String full_name = request.getParameter("full_name");
                String user_type = request.getParameter("user_type");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String date_time = request.getParameter("date_time");
                User obj = new User();
                obj.setFull_name(full_name);
                obj.setUser_type(user_type);
                obj.setUsername(username);
                obj.setPassword(password);
                obj.setDate_time(date_time);
                try {
                    UserController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int user_id = Integer.parseInt(request.getParameter("user_id"));
                String full_name = request.getParameter("full_name");
                String user_type = request.getParameter("user_type");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String date_time = request.getParameter("date_time");
                User obj = new User();
                obj.setUser_id(user_id);
                obj.setFull_name(full_name);
                obj.setUser_type(user_type);
                obj.setUsername(username);
                obj.setPassword(password);
                obj.setDate_time(date_time);
                try {
                    UserController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int user_id = Integer.parseInt(request.getParameter("user_id"));
                User obj = new User();
                obj.setUser_id(user_id);
                try {
                    UserController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<User> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = UserController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getUser_id() + "_" + list.get(i).getFull_name() + "_" + list.get(i).getUser_type() + "_" + list.get(i).getUsername() + "_" + list.get(i).getPassword() + "_" + list.get(i).getDate_time() + "_";
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
