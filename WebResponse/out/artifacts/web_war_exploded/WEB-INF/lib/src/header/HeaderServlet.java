package header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "HeaderServlet")
public class HeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 设置响应头
         */
        Date date = new Date();

        response.addHeader("name","zhangsan");//(String,String)
        response.addIntHeader("age",28);
        response.addDateHeader("birthday",date.getTime());

    }
}
