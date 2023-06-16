package com.gw.servlet;

import com.gw.dao.CkeditorImageDAO;
import org.apache.commons.io.FilenameUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: CKEditorImageServlet
 * PackageName: com.gw.servlet
 *
 * @Description:
 * @Author: 谢金宸
 * @Create: 2023/6/9 19:00
 * @Version: 1.0
 */
    @WebServlet(name = "CKEditorImageServlet",urlPatterns = "/CKEditorImageServlet",initParams = {@WebInitParam(name = "allowedImageExtensions",value = "jpg|gif|jpeg|png|bmp")})
    public class CKEditorImageServlet extends HttpServlet {
        private static final long serialVersionUID = -735481391001655214L;
        private CkeditorImageDAO ckeditorImageDAO;

    /**
     * Servlet初始化方法
     */
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils
                .getRequiredWebApplicationContext(this.getServletContext());
        ckeditorImageDAO = (CkeditorImageDAO) ac.getBean("ckeditorImageDAO");
    }

    public void destroy() {
        ckeditorImageDAO = null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        String extensionName = FilenameUtils.getExtension(fileName);
        response.setContentType("image/" + extensionName);
        BufferedImage bufferImage = ckeditorImageDAO.getFromDisk(fileName);
        ImageIO.write(bufferImage, extensionName, response.getOutputStream());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        String imageURL = "";
        try {
            imageURL = ckeditorImageDAO.saveTODisk(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // CKEditorFuncNum是回调时显示的位置，这个参数必须有
        String callback = request.getParameter("CKEditorFuncNum");
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
                + ",'" + imageURL + "',''" + ");");
        out.println("</script>");
        out.flush();
        out.close();
    }

}
