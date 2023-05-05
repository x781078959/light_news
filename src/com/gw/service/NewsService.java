package com.gw.service;

import java.util.List;

import com.gw.criteria.NewsSearch;
import com.gw.criteria.PageBean;
import com.gw.pojo.News;
import com.gw.pojo.NewsVo;

/**
 * 新闻业务接口
 * @author Administrator
 *
 */
public interface NewsService {
	
	
	//分页查询新闻列表
		 List<NewsVo> queryNewsByPage(NewsSearch newsSearch,PageBean pageBean);
		//得到查询总条数
		long  queryNewsCount(NewsSearch newsSearch);

		int deleteNewsById(int id);
		int addNews(News news);
		int updateNews(News news);
		News queryNewsById(int id);
	/**
	 * 访问量
	 * @param newsId
	 * @return
	 */
	 int newsClick(int newsId);
	/**
	 * 查询新闻表中是否有此类别的新闻
	 * @param typeId
	 * @return
	 */
	 boolean existNewByTypeId(int typeId);

	/**
	 * 最近更新新闻
	 * @return
	 */
	 List<News> newestNewsList();

	/**
	 * 热点新闻
	 * @return
	 */
	 List<News> hotNewsList();

	/**
	 * 根据新闻类型获取新闻
	 * @return
	 */
	 List<NewsVo> allIndexNewsList(int typeId);
}
