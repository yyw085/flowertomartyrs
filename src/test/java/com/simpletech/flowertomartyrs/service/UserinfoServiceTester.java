package com.simpletech.flowertomartyrs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simpletech.flowertomartyrs.model.Userinfo;
import com.simpletech.flowertomartyrs.util.JacksonUtil;

/**
 * 数据库表userinfo的Service层测试类
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class UserinfoServiceTester {

	@Autowired
	UserinfoService service;
	
	@Test
	public void insert() throws Exception{
		Userinfo model = new Userinfo();
		Object result = service.insert(model);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void update() throws Exception {
		Userinfo model = new Userinfo();
		Object result = service.update(model);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void delete() throws Exception {
		Object result = service.delete("1");
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void countAll() throws Exception {
		Object result = service.countAll();
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}

	@Test
	public void findByPage() throws Exception {
		Object result = service.findByPage(5,0);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}

}
