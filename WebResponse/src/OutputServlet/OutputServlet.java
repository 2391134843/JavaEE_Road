package OutputServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "OutputServlet")
public class OutputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("a.jpg");
        //用IO读取到该文件
        InputStream in = new FileInputStream(path);
        //将该文件写入到response的缓冲区中
        OutputStream out = response.getOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }
}
