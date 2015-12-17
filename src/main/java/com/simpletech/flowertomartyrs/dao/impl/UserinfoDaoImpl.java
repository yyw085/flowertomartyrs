package com.simpletech.flowertomartyrs.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.simpletech.flowertomartyrs.dao.base.BaseDaoImpl;
import com.simpletech.flowertomartyrs.dao.UserinfoDao;
import com.simpletech.flowertomartyrs.model.Userinfo;

/**
 * 数据库表userinfo的Dao实现
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Repository
public class UserinfoDaoImpl extends BaseDaoImpl<Userinfo> implements UserinfoDao{

	@Override
	public int insert(Userinfo t) throws Exception {
		return super.insert(t);
	}

	@Override
	public int update(Userinfo t) throws Exception {
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
	public Userinfo findById(Object id) throws Exception {
		return super.findById(id);
	}

	@Override
	public List<Userinfo> findAll() throws Exception {
		return super.findAll();
	}

	@Override
	public List<Userinfo> findByPage(int limit, int start) throws Exception {
		return super.findByPage(limit, start);
	}
}

