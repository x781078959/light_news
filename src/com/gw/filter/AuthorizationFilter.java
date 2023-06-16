package com.gw.filter;


import com.gw.dto.UserDto;
import com.gw.utils.ExcludeResourceUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: AuthorizationFilter
 * PackageName:
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.4.30 下午 1:24
 * @Version: 1.0
 * */


@WebFilter(filterName = "AuthorizationFilter",
        urlPatterns = {"/*"})
public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //过滤器排除静态资源

        String requestURI = httpServletRequest.getRequestURI();
        if (ExcludeResourceUtil.shouldExclude(requestURI)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpSession session = httpServletRequest.getSession();
            UserDto userDto = (UserDto) session.getAttribute("userDto");
            String contextPath = httpServletRequest.getContextPath();
            String path = requestURI.substring(contextPath.length());
            if(userDto == null){
                if("/user".equals(path)){
                    filterChain.doFilter(servletRequest,servletResponse);
                }else { //未登录且访问的路径不是公共路径
                    httpServletRequest.getRequestDispatcher("/index").forward(httpServletRequest,httpServletResponse);
                }
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }
}
