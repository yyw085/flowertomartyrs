package com.simpletech.flowertomartyrs.service.base;

import com.simpletech.flowertomartyrs.annotations.dbmodel.interpreter.Interpreter;
import com.simpletech.flowertomartyrs.dao.base.BaseDao;
import com.simpletech.flowertomartyrs.model.base.ModelBase;
import com.simpletech.flowertomartyrs.util.AfReflecter;
import com.simpletech.flowertomartyrs.util.JacksonUtil;
import com.simpletech.flowertomartyrs.util.Page;
import com.simpletech.flowertomartyrs.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 通用Service层实现基类
 * @param <T>
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
public class BaseServiceImpl<T> implements BaseService<T>{

	@Autowired
	BaseDao<T> baseDao;
	
	protected Class<T> clazz;
	
	public BaseServiceImpl() {
		this.clazz = AfReflecter.getActualTypeArgument(this, BaseServiceImpl.class, 0);
	}
	
	@Override
	public int insert(T model) throws Exception{
		ModelBase.check(model);
		ModelBase.fillNullID(model);
		return baseDao.insert(model);
	}
	
	@Override
	public int update(T model) throws Exception {
		T old = findById(getModelID(model));
		if (old == null) {
			throw new ServiceException("请求更新记录不存在或已经被删除！");
		}
		model = checkNullField(old, model);
		return baseDao.update(model);
	}

	@Override
	public int delete(Object id) throws Exception {
		return baseDao.delete(id);
	}

	@Override
	public T findById(Object id) throws Exception{
		return baseDao.findById(id);
	}

	@Override
	public List<T> findAll() throws Exception{
		return baseDao.findAll();
	}

	@Override
	public int delete(String id) throws Exception{
		return baseDao.delete(id);
	}

	@Override
	public List<T> findByPage(int limit, int start) throws Exception {
		return baseDao.findByPage(limit,start);
	}

	@Override
	public T findById(String id) throws Exception {
		return baseDao.findById(id);
	}
	
	@Override
	public Page<T> listByPage(int pageSize, int pageNo) throws Exception{
		int limit = pageSize; 
		int start = pageNo*pageSize;
		int totalRecord = baseDao.countAll();
		int totalPage = 1+totalRecord/pageSize;
		
		List<T> list = baseDao.findByPage(limit, start);
		
		return new Page<T>(pageNo,pageSize,totalPage,totalRecord,list){};
	}

	@Override
	public int countAll() throws Exception {
		return baseDao.countAll();
	}
	/**
	 * 检测非空字段
	 * @param old 老数据
	 * @param model 新数据model
	 */
	@SuppressWarnings("unchecked")
	protected T checkNullField(T old, T model) {
		try {
			Class<?> clazz = model.getClass();
			old = (T) JacksonUtil.toObject(JacksonUtil.toJson(old), clazz);
			for (Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);
				Object nfield = field.get(model);
				if (nfield != null) {
					field.set(old, nfield);
				}
			}
		} catch (Exception e) {

		}
		return old;
	}
	/**
	 * 获取ID字段
	 * @param model 数据model
	 */
	protected Object getModelID(T model) throws Exception {
		Class<?> clazz = model.getClass();
		Field field = Interpreter.getIdField(clazz);
		if (field != null) {
			field.setAccessible(true);
			return field.get(model);
		}
		return null;
	}
}
