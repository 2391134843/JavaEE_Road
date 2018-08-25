package web;

import domain.Categroy;
import domain.Product;
import service.AdminProductServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminUpdateProductServlet")
public class AdminUpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.回显数据
        String pid = request.getParameter("pid");
        AdminProductServlet adminProductServlet = new AdminProductServlet();
        Product product = new Product();
        try {
            product = adminProductServlet.findAllProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Categroy> categroyList = null;
        try {
            categroyList = adminProductServlet.findAllCategroy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //将categroyList放到域对象中
        request.setAttribute("categoryList", categroyList);

        request.setAttribute("product",product);

        request.getRequestDispatcher("/admin/product/edit.jsp").forward(request,response);
    }
}
