package Fooowrd;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 从request域中存数据
         */
        request.setAttribute("name", "lucy");

        /**
         * 请求转发到servlet2中去，地址不变，但可以显示servlet2中的数据
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet2");

//        RequestDispatcher dispatcher1 = request.getRequestDispatcher("/")
        dispatcher.forward(request,response);
//        dispatcher.forward(request,response);
    }
}
