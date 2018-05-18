package DownLoadServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "DownServlet")
public class DownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取需要下载文件的文件名
         */
        String fileName = request.getParameter("filename");
        /**
         * 利用ServletContext获得文件的绝对路径
         */
        String path = this.getServletContext().getRealPath("download/" + fileName);

        /**
         * 要下载文件的类型---客户端通过文件的mime类型去区分
         */
            response.setContentType(this.getServletContext().getMimeType(fileName));
        /**
         * 设置头信息-告诉客户端该文件是不是直接解析，而是以附件形式打开（下载）
         */
        response.setHeader("Content-Disposition","attachement;filename=fileName");


        /**
         * 获得该文件的输入，输出流  通过response获得的输出流，用于向客户端写内容
         */
        InputStream in = new FileInputStream(path);
        ServletOutputStream out = response.getOutputStream();
        /**
         * 文件拷贝代码（可以封装成模板）多次使用
         */
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }
}
