package web;

import domain.Categroy;
import service.AdminProductServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminAddProductUI")
public class AdminAddProductUI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminProductServlet productServlet = new AdminProductServlet();
        List<Categroy> categroyList = null;
        try {
            categroyList = productServlet.findAllCategroy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //将categroyList放到域对象中
        request.setAttribute("categoryList", categroyList);
        request.getRequestDispatcher("/admin/product/add.jsp").forward(request, response);
    }
}
