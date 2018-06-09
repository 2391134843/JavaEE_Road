package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetCookie")
public class GetCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获得客户端携带的Cookie的数据
        Cookie[] cookie = request.getCookies();
        //通过cookie名称获得想要的cookie
        for (Cookie cookie1 : cookie) {
            String cookieName = cookie1.getName();
            if (cookieName.equals("name")) {
                String cookieValue = cookie1.getValue();
                System.out.println(cookieValue);
            }
        }

    }
}
