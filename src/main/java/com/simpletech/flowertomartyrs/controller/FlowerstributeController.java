package com.simpletech.flowertomartyrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpletech.flowertomartyrs.annotations.Intent;
import com.simpletech.flowertomartyrs.controller.base.GeneralController;
import com.simpletech.flowertomartyrs.model.Flowerstribute;
import com.simpletech.flowertomartyrs.service.FlowerstributeService;

/**
 * 数据库表flowerstribute 的Controller层实现
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@RestController
@Intent("数据库表flowerstribute")
@RequestMapping("flowerstribute")
public class FlowerstributeController extends GeneralController<Flowerstribute>{

	@Autowired
	FlowerstributeService service;
	
	/**
	 * 添加信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("add")
	public Object add(@RequestBody Flowerstribute model) throws Exception {
		service.insert(model);
		return null;
	}

	/**
	 * 更新信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("update")
	public Object update(@RequestBody Flowerstribute model) throws Exception {
		service.update(model);
		return null;
	}

	/**
	 * 根据ID获取信息
	 * @param ID
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("get/{ID}")
	public Object get(@PathVariable String ID) throws Exception {
		Object model = service.findById(ID);
		if (model == null) {
			return "null";
		}
		return model;
	}

	/**
	 * 根据ID删除
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("delete/{ID}")
	public Object delete(@PathVariable String ID) throws Exception {
		service.delete(ID);
		return null;
	}

	/**
	 * 统计全部
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("count")
	public Object count() throws Exception {
		return service.countAll();
	}

	/**
	 * 获取全部列表
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("list")
	public Object list() throws Exception {
		return service.findAll();
	}

	/**
	 * 获取分页列表
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws Exception 
	 */
	@Override
	@RequestMapping("list/{pageSize}/{pageNo}")
	public Object listByPage(@PathVariable int pageSize,@PathVariable int pageNo) throws Exception {
		return service.listByPage(pageSize, pageNo);
	}

}
