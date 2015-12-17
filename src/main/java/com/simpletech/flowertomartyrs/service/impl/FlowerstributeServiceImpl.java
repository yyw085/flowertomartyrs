package com.simpletech.flowertomartyrs.service.impl;

import com.simpletech.flowertomartyrs.dao.FlowerstributeDao;
import com.simpletech.flowertomartyrs.model.Flowerstribute;
import com.simpletech.flowertomartyrs.model.base.ModelBase;
import com.simpletech.flowertomartyrs.service.FlowerstributeService;
import com.simpletech.flowertomartyrs.service.base.BaseServiceImpl;
import com.simpletech.flowertomartyrs.util.Page;
import com.simpletech.flowertomartyrs.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据库表flowerstribute的Service接实现
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Service
public class FlowerstributeServiceImpl extends BaseServiceImpl<Flowerstribute> implements FlowerstributeService{

	@Autowired
	FlowerstributeDao dao;
	
	@Override
	public int insert(Flowerstribute model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return dao.insert(model);
	}
	
	@Override
	public int update(Flowerstribute model) throws Exception {
		Flowerstribute old = findById(getModelID(model));
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
	public Flowerstribute findById(Object id) throws Exception{
		return dao.findById(id);
	}

	@Override
	public List<Flowerstribute> findAll() throws Exception{
		return dao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return dao.delete(id);
	}

	@Override
	public List<Flowerstribute> findByPage(int limit, int start) throws Exception {
		return dao.findByPage(limit,start);
	}

	@Override
	public Flowerstribute findById(String id) throws Exception {
		return dao.findById(id);
	}
	
	@Override
	public Page<Flowerstribute> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = dao.countAll();
		int totalPage = 1 + (totalRecord - 1) / pageSize;
		
		List<Flowerstribute> list = dao.findByPage(limit, start);
		
		return new Page<Flowerstribute>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return dao.countAll();
	}
}
