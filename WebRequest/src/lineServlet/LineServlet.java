package lineServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "lineServlet.LineServlet")

/**
 * 获得行信息
 */
public class LineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获得请求方式
         */
        String method = request.getMethod();
        /**
         * 2.获得请求资源的相关内容
         * uri:/line
         * url: http:/localhost:8080/line
         */
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        /**
         * 3.获得应用的名称
         */
        String contextPath = request.getContextPath();
        /**
         * 4.获得地址后参数的字符串
         */

        String queryString = request.getQueryString();

        /**
         * 5.获得访问客户端的ip地址
         */
        String remoteAddr = request.getRemoteAddr();
        System.out.println("IP: "+remoteAddr);
        //打印API 输出的结果
        System.out.println("uri :" + requestURI );
        System.out.println("url :" + requestURL);
        System.out.println("method :" + method );
        System.out.println("web应用名 :" + contextPath);
        System.out.println("queryString:" + queryString);


    }
}
