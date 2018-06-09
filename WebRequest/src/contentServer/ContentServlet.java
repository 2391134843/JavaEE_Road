package contentServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "ContentServlet")
public class ContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 所有方法，get，post都适用
         */
        /**
         * 1.获取单个表单的值
         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        /**
         * 2.获得多个表单的值（复选框）
         */
        String[] hobbys = request.getParameterValues("hobby");
        for (String hobby : hobbys) {
            System.out.println(hobby);
        }
        /**
         * 3.获得所有请求的参数名称（了解）
         */
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        /**
         * 4.获得所有参数 参数分装到一个Map<String,String[]>
         */
        System.out.println("获得所有参数-------------------------------------------");
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey());
            for (String str : entry.getValue()) {
                System.out.println(str);
            }
            System.out.println("----------------------------------------------");
        }

    }
}
