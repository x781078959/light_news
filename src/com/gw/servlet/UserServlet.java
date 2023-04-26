package com.gw.servlet;

import com.gw.pojo.User;
import com.gw.service.UserService;
import com.gw.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private  static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if("login".equals(action)){
            login(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置网页响应类型
        doPost(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password= request.getParameter("password");
        User user = userService.login(userName, password);
        PrintWriter out = response.getWriter();
        if(user!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("curUser", user);
            response.sendRedirect("background/main.jsp");
        }else {
            String msg = "<script>alert('登录失败')</script>";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("background/login.jsp").forward(request, response);
            out.println("该用户不存在或密码错误" + "<a href=\"javascript:history.back(-1)\">返回登录</a>");//javascript:history.back(-1)
        }
    }
}
