package web;

import service.AdminProductServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminDelProductServlet")
public class AdminDelProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        AdminProductServlet adminProductServlet = new AdminProductServlet();

        try {
            adminProductServlet.delProduct(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/adminProductList");
    }
}
