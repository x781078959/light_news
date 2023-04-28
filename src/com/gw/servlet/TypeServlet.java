package com.gw.servlet;

import com.gw.pojo.NewsType;
import com.gw.service.TypeService;
import com.gw.service.impl.TypeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * ClassName: NewsServlet
 * PackageName: com.gw.servlet
 * Description:
 * <p>
 *
 * @ Author: 谢金宸
 * @ Create: 2023.4.14 - 上午 11:57
 * @ Version: 1.0
 */
@WebServlet("/type")
public class TypeServlet extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    private TypeService typeService = new TypeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("selectAll".equals(action)) {
            SelectAll(req, resp);
        }else if(action.equals("saveType")){
            SaveType(req, resp);
        }else if(action.equals("deleteType")){
            DeleteType(req, resp);
        }

    }

    protected void DeleteType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String typeName = req.getParameter("newsTypeId");
        System.out.println(typeName);
        PrintWriter out = resp.getWriter();
        int i = typeService.deleteType(Integer.parseInt(typeName));
        if(i>0){out.print("true");}else{out.print("false");}
        out.flush();out.close();
    }

    protected void SaveType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String typeName = req.getParameter("typeName");
        System.out.println(typeName);
        PrintWriter out = resp.getWriter();
        int i = typeService.addType(typeName);
        if(i>0){out.print("true");}else{out.print("false");}
        out.flush();out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void SelectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //准备所有类别的数据 -> 所有类别信息的数据
        List<NewsType> types = typeService.queryAllType();
        //将数据设置到request域中
        req.setAttribute("types", types);
        //请求转发 页面 background/newsType/newsTypeList.jsp
        req.getRequestDispatcher("/background/newsType/newsTypeList.jsp").forward(req, resp);
    }
}
