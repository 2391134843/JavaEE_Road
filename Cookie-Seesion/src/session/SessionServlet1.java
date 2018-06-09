package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet1")
public class SessionServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 创建属于该客户端（回话）的私有的session区域
         * request.getSession()方法内部会判断 该客户端是否在服务器端已经存在session
         * 如果该客户端在此服务器不存在session 那么就会创建一个新的session对象
         * 如果该客户端在此服务器已经存在session 则 获得已经存在的session并返回
         * 一个浏览器属于一个客户端
         */
        HttpSession session = request.getSession();
        String id = session.getId();
        response.getWriter().write("JSESSIONID: "+id );

        session.setAttribute("name","lisi");
    }
}
