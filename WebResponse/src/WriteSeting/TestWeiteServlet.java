package WriteSeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestWeiteServlet")
public class TestWeiteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type","text/html;" +
                "charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("1 ways");
        response.getWriter().write("2 ways" + "\n");

//      response.setCharacterEncoding("UTF-8");

        response.getWriter().write("中国");


    }
}
