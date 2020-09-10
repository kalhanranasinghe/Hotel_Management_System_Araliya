<html>
    <%
        session.invalidate();

        response.sendRedirect("login.jsp");
    %>
</html>