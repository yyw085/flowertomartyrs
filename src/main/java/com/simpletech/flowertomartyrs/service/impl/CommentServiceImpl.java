package com.simpletech.flowertomartyrs.service.impl;

import com.simpletech.flowertomartyrs.dao.CommentDao;
import com.simpletech.flowertomartyrs.model.Comment;
import com.simpletech.flowertomartyrs.model.base.ModelBase;
import com.simpletech.flowertomartyrs.service.CommentService;
import com.simpletech.flowertomartyrs.service.base.BaseServiceImpl;
import com.simpletech.flowertomartyrs.util.Page;
import com.simpletech.flowertomartyrs.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表comment的Service接实现
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService{

	@Autowired
	CommentDao dao;
	
	@Override
	public int insert(Comment model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(Comment model) throws Exception {
		Comment old = findById(getModelID(model));
		if (old == null) {
			throw new ServiceException("请求更新记录不存在或已经被删除！");
		}
		model = checkNullField(old, model);
		return dao.update(model);
	}

	@Override
	public int delete(Object id) throws Exception {
		return dao.delete(id);
	}

	@Override
	public Comment findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<Comment> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<Comment> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit,start);
	}

	@Override
	public Comment findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<Comment> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<Comment> list = dao.findByPage(limit, start);
		
		return new Page<Comment>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}
}
