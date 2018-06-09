package header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        /**
//         * 设置状态码 302
//         */
//        response.setStatus(302);
//        /**
//         * 设置重定向资源
//         */
//        response.setHeader("Location","/servlet2");
//        response.sendRedirect("/servlet2");
//        response.sendRedirect("https://www.baidu.com");
        /**
         * 设置自动更新  以秒为单位
         */
        response.setHeader("refresh","10;url=http://www.xiaolitongxue.top");

    }
}
