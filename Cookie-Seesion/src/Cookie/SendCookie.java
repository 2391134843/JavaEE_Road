package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SendCookie")
public class SendCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.创建一个Cookie对象
         */
        Cookie cookie = new Cookie("name", "zhangsan");

         // 1.1Cookie设置持久化时间----cookie信息在硬盘上保存的时间
        cookie.setMaxAge(10 * 60);//以秒为单位
        // 1.2为Cookie设置携带的路径
      //  cookie.setPath("/sendCookie");//有sendCookie才可以收到cookie
        cookie.setPath("/");//访问服务器下的所有资源都能携带cookie



        /**
         * 2.将cookie中存储的信息发送到客户端--头部
         */
        response.addCookie(cookie);

    }
}
