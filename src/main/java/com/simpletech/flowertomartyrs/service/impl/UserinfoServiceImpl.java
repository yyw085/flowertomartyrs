package com.simpletech.flowertomartyrs.service.impl;

import com.simpletech.flowertomartyrs.dao.UserinfoDao;
import com.simpletech.flowertomartyrs.model.Userinfo;
import com.simpletech.flowertomartyrs.model.base.ModelBase;
import com.simpletech.flowertomartyrs.service.UserinfoService;
import com.simpletech.flowertomartyrs.service.base.BaseServiceImpl;
import com.simpletech.flowertomartyrs.util.Page;
import com.simpletech.flowertomartyrs.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表userinfo的Service接实现
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Service
public class UserinfoServiceImpl extends BaseServiceImpl<Userinfo> implements UserinfoService{

	@Autowired
	UserinfoDao dao;
	
	@Override
	public int insert(Userinfo model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(Userinfo model) throws Exception {
		Userinfo old = findById(getModelID(model));
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
	public Userinfo findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<Userinfo> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<Userinfo> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit,start);
	}

	@Override
	public Userinfo findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<Userinfo> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<Userinfo> list = dao.findByPage(limit, start);
		
		return new Page<Userinfo>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}
}
