package com.gw.service;

import java.util.List;

import com.gw.criteria.NewsSearch;
import com.gw.criteria.PageBean;
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

	//
	
}
