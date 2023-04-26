package com.gw.servlet;

import com.gw.criteria.NewsSearch;
import com.gw.criteria.PageBean;
import com.gw.pojo.News;
import com.gw.pojo.NewsType;
import com.gw.pojo.NewsVo;
import com.gw.service.NewsService;
import com.gw.service.TypeService;
import com.gw.service.impl.NewsServiceImpl;
import com.gw.service.impl.TypeServiceImpl;
import com.gw.utils.PageUtil;
import com.gw.utils.StringUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
/**
 * ClassName: NewsServlet
 * PackageName: com.gw.servlet
 * Description: 处理新闻模块请求的servlet
 *
 * @Author: 谢金宸
 * @Create: 2023.4.21 - 上午 9:14
 * @Version: 1.0
 */
@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NewsService newsService = new NewsServiceImpl();
    private TypeService typeService = new TypeServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理用户的请求
        //据action的值调用不同的方法
        String action = request.getParameter("action");

        if("backNewsList".equals(action)){
            backNewsList(request,response);
        }else if("deleteNews".equals(action)){
            deleteNews(request,response);
        }else if("toSave".equals(action)){
            toSave(request,response);
        }else if("saveNews".equals(action)){
            saveNews(request,response);
        }else if("selectNewsById".equals(action)){
            selectNewsById(request,response);
        }
    }

    protected void selectNewsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newsId = request.getParameter("newsId");
        News news = newsService.queryNewsById(Integer.parseInt(newsId));
        request.setAttribute("news",news);
        toSave(request,response);
        request.getRequestDispatcher("/background/news/newsSave.jsp").forward(request,response);
    }

    protected void saveNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //保存新闻
        String newsId = request.getParameter("newsId");//判断修改还是添加
        String isHot = request.getParameter("isHot");
        String isHead = request.getParameter("isHead");

        News news = new News();
        news.setTitle(request.getParameter("title"));
        news.setAuthor(request.getParameter("author"));
        news.setTypeId(Integer.parseInt(request.getParameter("typeId")));
        news.setContent(request.getParameter("content"));
        if(StringUtil.isNotEmpty(newsId)) {
            news.setNewsId(Integer.parseInt(newsId));
        }
        if(StringUtil.isNotEmpty(isHot)) {
            news.setIsHot(Integer.parseInt(isHot));
        }
        if(StringUtil.isNotEmpty(isHead)) {
            news.setIsHead(Integer.parseInt(isHead));
        }
        String type;
        int rlt;
        if(newsId==null || newsId.equals("")){
            //添加新闻
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String publishDate = dateTimeFormatter.format(now);
            news.setPublishDate(publishDate);
            rlt = newsService.addNews(news);
            type = "add";
        }else{
            //修改新闻
            rlt = newsService.updateNews(news);
            type = "update";
        }
        response.getWriter().print("{\"rlt\":"+rlt+",\"type\":\""+type+"\"}");
        response.getWriter().flush();
        response.getWriter().close();
    }

    protected void toSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有的类别
        List<NewsType> types = typeService.queryAllType();
        //将所有类别涉及到req域对象
        request.setAttribute("types",types);
        //请求转发到新闻的保存页面
        request.getRequestDispatcher("/background/news/newsSave.jsp").forward(request,response);


    }
    protected void deleteNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newsId = request.getParameter("newsId");
        int count = newsService.deleteNewsById(Integer.parseInt(newsId));
        PrintWriter out = response.getWriter();
        if(count > 0){
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }

    protected void backNewsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取查询条件
        String title = request.getParameter("title");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        //封装查询条件NewsSearch
        NewsSearch search = new NewsSearch();
        search.setTitle(title);
        search.setStartDate(startDate);
        search.setEndDate(endDate);

        //获取当前页
        String page = request.getParameter("page");

        if(StringUtil.isEmpty(page)){
            page = "1";
            //查询信息保存
            request.getSession().setAttribute("search",search);
        }else {
            //从session取得查询信息
            search = (NewsSearch) request.getSession().getAttribute("search");
        }
        //定义一页几条
        int pageNum = 6;

        //构建pageBean
        PageBean pageBean = new PageBean(Integer.parseInt(page), pageNum);
        List<NewsVo> news = newsService.queryNewsByPage(search,pageBean);
        //查询总条数
        long count = newsService.queryNewsCount(search);

//        //定义地址的字符串
        String url = request.getContextPath()+"/news?action=backNewsList";

//        //获取分页代码的字符串
        String pageCode = PageUtil.getPagation(url, (int)count,Integer.parseInt(page) , pageNum);

//        //加载到request
        request.setAttribute("news", news);
        request.setAttribute("pageCode", pageCode);
//
//
//        //请求转发           background/news/newsSave.jsp

        request.getRequestDispatcher("/background/news/newsList.jsp").forward(request, response);
    }
}
