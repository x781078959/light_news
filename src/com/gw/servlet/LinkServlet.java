package com.gw.servlet;

import com.gw.pojo.LinkVo;
import com.gw.service.LinkService;
import com.gw.service.impl.LinkServiceImpl;
import com.gw.utils.StringUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: LinkServlet
 * PackageName: com.gw.servlet
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.5.4 下午 11:01
 * @Version: 1.0
 */
@WebServlet(urlPatterns = "/link")
public class LinkServlet extends HttpServlet {
    private LinkService linkService = new LinkServiceImpl();
    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type.equals("toLink")){
            toLink(req, resp);
        }else if("deleteLink".equals(type)){
            deleteLinkById(req, resp);
        }else if("selectLinkById".equals(type)){
            selectLinkById(req, resp);
        }else if("linkUpdate".equals(type)){
            linkUpdate(req, resp);
        }else if("saveLink".equals(type)){
            linkUpdate(req, resp);
        }
    }

    private void linkUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String linkId = req.getParameter("linkId");
        String linkName = req.getParameter("linkName");
        String linkUrl = req.getParameter("linkUrl");
        String linkEmail = req.getParameter("linkEmail");
        String orderNum = req.getParameter("orderNum");
        LinkVo linkVo = new LinkVo();

        linkVo.setLinkName(linkName);
        linkVo.setLinkUrl(linkUrl);
        linkVo.setLinkEmail(linkEmail);
        if(StringUtil.isNotEmpty(orderNum)) {
            linkVo.setOrderNum(Integer.parseInt(orderNum));
        }
        if(StringUtil.isNotEmpty(linkId)) {
            linkVo.setLinkId(Integer.parseInt(linkId));
        }
        String type = null;
        int rlt;
        if(linkId==null || linkId.equals("")){
            //添加
            rlt = linkService.addLink(linkVo);
        }else{
            rlt = linkService.updateLink(linkVo);
            type = "update";
        }
        resp.getWriter().print("{\"rlt\":"+rlt+",\"type\":\""+type+"\"}");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    protected void selectLinkById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String linkId = req.getParameter("linkId");
        LinkVo linkVo = linkService.queryLinkById(Integer.parseInt(linkId));
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        req.setAttribute("links", linkVo);
        req.getRequestDispatcher("/background/link/linkUpdate.jsp").forward(req,resp);
//        try(PrintWriter writer = resp.getWriter()) {
//            writer.print(linkVo);
//            writer.flush();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    protected void deleteLinkById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String linkId = req.getParameter("linkId");
        int count = linkService.deleteLinkById(Integer.parseInt(linkId));
        PrintWriter out = resp.getWriter();
        if(count > 0){
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }

    protected void toLink(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LinkVo> links = linkService.getAllLinks();
        req.setAttribute("links", links);
        req.getRequestDispatcher("/background/link/linkList.jsp").forward(req, resp);
    }
}
