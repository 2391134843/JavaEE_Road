package DownLoadServlet;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

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
        fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
        /**
         * 利用ServletContext获得文件的绝对路径
         */
        String path = this.getServletContext().getRealPath("download/" + fileName);

        //获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");
        //根据不同浏览器进行不同的编码
        String filenameEncoder = " ";
        if (agent.contains("MSIE")) {
            // IE浏览器
            filenameEncoder = URLEncoder.encode(fileName, "utf-8");
            filenameEncoder = filenameEncoder.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filenameEncoder = "=?utf-8?B?"
                    + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filenameEncoder = URLEncoder.encode(fileName, "utf-8");
        }

        /**
         * 要下载文件的类型---客户端通过文件的mime类型去区分
         */
            response.setContentType(this.getServletContext().getMimeType(fileName));
        /**
         * 设置头信息-告诉客户端该文件是不是直接解析，而是以附件形式打开（下载）
         */
        response.setHeader("Content-Disposition","attachement;filename="+filenameEncoder);

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
