package com.simpletech.flowertomartyrs.service.base;

import com.simpletech.flowertomartyrs.dao.base.BaseDao;
import com.simpletech.flowertomartyrs.util.Page;

/**
 * 通用Service层接口
 * @param <T>
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
public interface BaseService<T> extends BaseDao<T>{
	int delete(String id) throws Exception;
	T findById(String id) throws Exception;
	Page<T> listByPage(int pageSize, int pageNo) throws Exception;
}
