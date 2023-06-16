package com.gw.filter;


import com.gw.utils.Constants;
import com.gw.utils.ExcludeResourceUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter",
        urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = Constants.ENCODING,value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {
    private String ENCODING = null;

/**
     * 初始化filter会回调
     * @param filterConfig
     * @throws ServletException
 * */


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.ENCODING = filterConfig.getInitParameter("ENCODING");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/html;charset=utf-8");
        //过滤器排除静态资源
        String requestURI = httpServletRequest.getRequestURI();
        if (!ExcludeResourceUtil.shouldExclude(requestURI)){
            httpServletRequest.setCharacterEncoding(ENCODING);
            httpServletResponse.setCharacterEncoding(ENCODING);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
