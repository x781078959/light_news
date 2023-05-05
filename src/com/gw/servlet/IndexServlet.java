package com.gw.servlet;

import com.gw.dao.TypeDao;
import com.gw.pojo.LinkVo;
import com.gw.pojo.News;
import com.gw.pojo.NewsType;
import com.gw.pojo.NewsVo;
import com.gw.service.LinkService;
import com.gw.service.NewsService;
import com.gw.service.TypeService;
import com.gw.service.impl.LinkServiceImpl;
import com.gw.service.impl.NewsServiceImpl;
import com.gw.service.impl.TypeServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: IndexServlet
 * PackageName: com.gw.servlet
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.5.5 上午 10:34
 * @Version: 1.0
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    NewsService newsService=new NewsServiceImpl();
    TypeService typeService=new TypeServiceImpl();
    public IndexServlet() {
        super();
    }
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取新闻类型
        List<NewsType> newsTypeList=typeService.queryAllType();
        req.setAttribute("newsTypeList", newsTypeList);
        //最近更新
        List<News> newestNewsList=newsService.newestNewsList();
        req.setAttribute("newestNewsList", newestNewsList);
        //热点新闻
        List<News> hotNewsList=newsService.hotNewsList();
        req.setAttribute("hotNewsList", hotNewsList);
        //获取新闻类型新闻
        List<List<NewsVo>> allIndexNewsList=new ArrayList<>();
        if(newsTypeList!=null && newsTypeList.size()!=0){
            for(int i=0;i<newsTypeList.size();i++){
                NewsType newsType=newsTypeList.get(i);
                List<NewsVo> oneSubList=newsService.allIndexNewsList(newsType.getNewsTypeId());
                allIndexNewsList.add(oneSubList);
            }
        }
        req.setAttribute("allIndexNewsList", allIndexNewsList);
        //获取友情链接
        LinkService linkService = new LinkServiceImpl();
        List<LinkVo> links = linkService.getAllLinks();
		req.setAttribute("links", links);
        req.getRequestDispatcher("index_all.jsp").forward(req, resp);
    }

}