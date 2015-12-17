package com.simpletech.flowertomartyrs.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.simpletech.flowertomartyrs.dao.base.BaseDaoImpl;
import com.simpletech.flowertomartyrs.dao.CommentDao;
import com.simpletech.flowertomartyrs.model.Comment;

/**
 * 数据库表comment的Dao实现
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{

	@Override
	public int insert(Comment t) throws Exception {
		return super.insert(t);
	}

	@Override
	public int update(Comment t) throws Exception {
		return super.update(t);
	}

	@Override
	public int delete(Object id) throws Exception {
		return super.delete(id);
	}

	@Override
	public int countAll() throws Exception {
		return super.countAll();
	}

	@Override
	public Comment findById(Object id) throws Exception {
		return super.findById(id);
	}

	@Override
	public List<Comment> findAll() throws Exception {
		return super.findAll();
	}

	@Override
	public List<Comment> findByPage(int limit, int start) throws Exception {
		return super.findByPage(limit, start);
	}
}

