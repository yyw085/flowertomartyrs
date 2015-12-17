package com.simpletech.flowertomartyrs.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simpletech.flowertomartyrs.model.Userinfo;
import com.simpletech.flowertomartyrs.util.JacksonUtil;

/**
 * 数据库表userinfo 的Controller层测试类
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class UserinfoControllerTester {

	@Autowired
	UserinfoController controller;
	
	@Test
	public void add() throws Exception{
		Userinfo model = new Userinfo();
		Object result = controller.add(model);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void update() throws Exception {
		Userinfo model = new Userinfo();
		Object result = controller.update(model);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void delete() throws Exception {
		Object result = controller.delete("1");
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void count() throws Exception {
		Object result = controller.count();
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void get() throws Exception {
		Object result = controller.get("1");
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void listByPage() throws Exception {
		Object result = controller.listByPage(6, 0);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}

}
