package Checking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 利用session域实现验证码的验证效果
         */
        request.setCharacterEncoding("UTF-8");
        //获得页面输入的验证码
        String checkCode_client = request.getParameter("check_image");
        //获得生成图片的文字的验证码
        String checkCode_session = (String) request.getSession().getAttribute("check-session");
        request.setAttribute("check1",checkCode_session);
        System.out.println(checkCode_session);
        //验证图片验证码和输入的验证码是否是一致的
        if (!checkCode_client.equals(checkCode_session)) {
            request.setAttribute("loginInfo", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        } else {
            response.sendRedirect("http://www.baidu.com");
        }

    }
}
