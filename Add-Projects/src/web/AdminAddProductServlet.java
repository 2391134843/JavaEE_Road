package web;

import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import service.AdminProductServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "AdminAddProductServlet")
public class AdminAddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从请求中获取参数数据
//        Map<String, String[]> productMap = request.getParameterMap();
//        Product product = new Product();
//        try {
//        //2.封装数据
//            BeanUtils.populate(product, productMap);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        product.setPimage("products/1/c_0033.jpg");
//            //3.3 setPdate
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String pdate = format.format(new Date());
//        product.setPdate(pdate);
//           //3.4 set pflge
//        product.setPflag(0);
        request.setCharacterEncoding("UTF-8");

        //1、获取数据
        Map<String, String[]> properties = request.getParameterMap();
        //2、封装数据
        Product product = new Product();
        try {
            BeanUtils.populate(product, properties);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //此位置Product已经封装完毕----将表单的数据封装完毕
        //手动设置表单中没有数据
        //2）、private String pimage;
        product.setPimage("products/1/c_0033.jpg");
        //3）、private String pdate;//上架日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String pdate = format.format(new Date());
        product.setPdate(pdate);
        //4）、private int pflag;//商品是否下载 0代表未下架
        product.setPflag(0);

        //4.传递参数至服务层
        AdminProductServlet adminProductServlet = new AdminProductServlet();
        try {
            adminProductServlet.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //跳转到list页面，如果不牵扯到参数可以用跳转

        response.sendRedirect("/adminProductList");
    }
}
