package com.gw.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gw.pojo.News;
import com.gw.utils.JdbcUtilsV2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gw.criteria.NewsSearch;
import com.gw.criteria.PageBean;
import com.gw.dao.NewDao;
import com.gw.utils.StringUtil;
import com.gw.pojo.NewsVo;

public class NewDaoImpl implements NewDao{

	QueryRunner qr = new QueryRunner(JdbcUtilsV2.getDataSource());

	@Override
	public List<NewsVo> selectNewsByPage(NewsSearch newsSearch, PageBean pageBean) {
		//sql会根据情况变化
		StringBuffer sql = new StringBuffer();
		sql.append("select newsId,title,typeName,publishDate ")//要注意加+空格
				.append("FROM t_news t1 ")
				.append("INNER JOIN t_newstype t2 ")
				.append("ON t1.typeId = t2.newsTypeId ");
		sql.append("where 1 = 1 ");

		//创建一个存放占位符的值的集合
		List<Object> paramList = new ArrayList<>();
		//根据查询条件的情况，拼接sql
		if(newsSearch != null){
			String title = newsSearch.getTitle();
			String startDate = newsSearch.getStartDate();
			String endDate = newsSearch.getEndDate();
			int typeId = newsSearch.getTypeId();
			//如果NewsSearch的title不为null则，有此查询条件
			if(StringUtil.isNotEmpty(title)){
				sql.append("and title like ? ");
				paramList.add("%"+title+"%");
			}
			//判断起始时间不为空，则有此查询条件

			if(StringUtil.isNotEmpty(startDate)){
				sql.append("and publishDate > ? ");
				paramList.add(startDate);
			}
			//如果结束时间不为空，则有此查询条件
			if(StringUtil.isNotEmpty(endDate)){
				sql.append("and publishDate < ? ");
				paramList.add(endDate);
			}
			//如果类别存在（不为-1），则有此查询条件
			if(typeId!=-1){
				sql.append("and typeId = ? ");
				paramList.add(typeId);
			}
		}


		sql.append("ORDER BY publishDate DESC ");
		sql.append("LIMIT ?,? ");

		//设置起始索引
		paramList.add(pageBean.getStart());
		//设置一页几条
		paramList.add(pageBean.getPageSize());

		//将存放占位符值的集合转为数组
		Object[] params = paramList.toArray();

		try {
			return qr.query(sql.toString(), new BeanListHandler<>(NewsVo.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}


	public long selectNewsCount(NewsSearch newsSearch) {
		//sql根据查询条件的有无，是会发生变化的，当某个查询条件存在时，对应要拼接上其sql部分

		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) as total ")
				.append("from t_news t1 ")
				.append("INNER JOIN t_newstype t2 ")
				.append("on t1.typeId = t2.newsTypeId ");
		sql.append("where 1=1 ");

		//创建一个存放占位符的值的集合
		List<Object> paramList = new ArrayList<>();


		//根据查询条件的有无，拼接sql
		if(newsSearch!=null){

			String title = newsSearch.getTitle();//标题查询条件
			String startDate =newsSearch.getStartDate();//开始时间查询条件
			String endDate = newsSearch.getEndDate();//结束时间查询条件
			int typeId = newsSearch.getTypeId();//类别查询条件
			//如果NewsSearch的title不为null则，有此查询条件
			if(StringUtil.isNotEmpty(title)){
				sql.append("and title like ? ");
				paramList.add("%"+title+"%");
			}
			//判断起始时间不为空，则有此查询条件

			if(StringUtil.isNotEmpty(startDate)){
				sql.append("and publishDate > ? ");
				paramList.add(startDate);
			}
			//如果结束时间不为空，则有此查询条件
			if(StringUtil.isNotEmpty(endDate)){
				sql.append("and publishDate < ? ");
				paramList.add(endDate);
			}
			//如果类别存在（不为-1），则有此查询条件
			if(typeId!=-1){
				sql.append("and typeId = ? ");
				paramList.add(typeId);
			}

		}

		//将存放占位符值的集合转为数组
		Object[] params = paramList.toArray();
		try {
			return qr.query(sql.toString(), new ScalarHandler<>(), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int addNews(News news) {
		String sql ="insert into t_news values(null,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {news.getTitle(), news.getContent(), news.getPublishDate(), news.getAuthor(), news.getTypeId(),news.getClick(),news.getIsHead(),
				news.getIsImage(),news.getImageName(),news.getIsHot()};
		try {
			return  qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteNewsById(int id) {
		String sql = "DELETE FROM t_news WHERE newsId =?";
		try {
			return qr.update(sql, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public News selectNewsById(int id) {
		String sql = "SELECT * FROM t_news t1,t_newsType t2 WHERE t1.typeId=t2.newsTypeId AND t1.newsId=?";
		try {
			return qr.query(sql, new BeanHandler<>(News.class), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateNewsById(News news) {
		String sql = "UPDATE t_news SET title=?,content=?,author=?,typeId=?,isHead=?,isHot=?,isImage=?,imageName=? WHERE newsId =?";
		Object[] params = {news.getTitle(), news.getContent(), news.getAuthor(), news.getTypeId(),
				news.getIsHead(), news.getIsHot(), news.getIsImage(),news.getImageName(),news.getNewsId()};
		try {
			return qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean existNewByTypeId(int typeId) {
		String sql = "SELECT COUNT(*) count FROM t_news WHERE typeId=?";
		long result = 0;
		QueryRunner queryRunner = new QueryRunner(JdbcUtilsV2.getDataSource());
		try {
			result = queryRunner.query(sql, new ScalarHandler<Long>(), typeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result > 0 ? true : false;
	}

	@Override
	public List<News> newestNewsList() {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM t_news ");
		sql.append("ORDER BY publishDate DESC LIMIT 0,8 ");
		QueryRunner queryRunner=new QueryRunner(JdbcUtilsV2.getDataSource());
		try {
			return queryRunner.query(sql.toString(), new BeanListHandler<>(News.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<News> hotNewsList() {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM t_news WHERE isHot=1 ");
		sql.append("ORDER BY publishDate DESC LIMIT 0,8 ");
		QueryRunner queryRunner=new QueryRunner(JdbcUtilsV2.getDataSource());
		try {
			return queryRunner.query(sql.toString(), new BeanListHandler<>(News.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<NewsVo> allIndexNewsList(int typeId) {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM  t_news,t_newsType ");
		sql.append("WHERE typeId=newsTypeId AND typeId=? ");
		sql.append("ORDER BY publishDate DESC ");
		sql.append("LIMIT 0,8");
		List<NewsVo> list=null;
		QueryRunner queryRunner=new QueryRunner(JdbcUtilsV2.getDataSource());
		try {
			list= queryRunner.query(sql.toString(), new BeanListHandler<>(NewsVo.class), typeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int newsClick(int newsId) {
		String sql="UPDATE t_news SET click=click+1 WHERE newsId=?";
		int result=0;
		QueryRunner queryRunner=new QueryRunner(JdbcUtilsV2.getDataSource());
		try {
			result=queryRunner.update(sql, newsId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
