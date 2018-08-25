package web;

import domain.Product;
import service.AdminProductServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminProductListServlet")
public class AdminProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将请求传递到service层
        AdminProductServlet servlet = new AdminProductServlet();
        List<Product> productList = null;
        try {
            productList=servlet.findAllProduct();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //将ProductList放到request域对象中
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
    }
}
