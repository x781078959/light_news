package com.gw.servlet;

import com.gw.dto.UserDto;
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
            //登录
            login(request, response);
        }else if("logout".equals(action)){
            //调用退出登陆的方法
            logout(request, response);
        }else{
            request.getRequestDispatcher("/background/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置网页响应类型
        doPost(request, response);
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.清除session
        HttpSession session=request.getSession();
        session.removeAttribute("curUser");
        //2.跳转到登陆页
        response.sendRedirect("/background/login.jsp");
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password= request.getParameter("password");
        UserDto userDto = this.userService.login(userName, password);
        switch (userDto.getCode()) {
            case -1 -> {
                request.setAttribute("usernameError", "用户名不存在");
                request.getRequestDispatcher("/background/login.jsp").forward(request, response);
            }
            case -2 -> {
                request.setAttribute("passwordError", "密码错误");
                request.getRequestDispatcher("/background/login.jsp").forward(request, response);
            }
            case 0 -> {
                //跳转到登录成功界面
                HttpSession session = request.getSession();
                session.setAttribute("curUser", userDto.getUser());
                String msg = "<script>alert('登录成功');</script>";
                request.getSession().setAttribute("userDto", userDto);
                //放到request域对象里面
                //request.setAttribute("msg", msg);
                request.getRequestDispatcher("/background/main.jsp").forward(request, response);
            }
        }
//        if(user!=null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("curUser", user);
//            String msg="<script>alert('登录成功');</script>";
//            //放到request域对象里面
//            request.setAttribute("msg", msg);
//            request.getRequestDispatcher("/background/main.jsp").forward(request, response);
//        }else {
//            String error="<script>alert('用户名或密码错误');</script>";
//            String msg = "<div>该用户不存在或密码错误!登录失败</div>";
//            //放到request域对象里面，共享给login.jsp
//            request.setAttribute("error", error);
//            //请求转发
//            //String msg = "<script>alert('登录失败')</script>";
//            request.setAttribute("msg", msg);
//            request.getRequestDispatcher("/background/login.jsp").forward(request, response);
//        }
    }
}
