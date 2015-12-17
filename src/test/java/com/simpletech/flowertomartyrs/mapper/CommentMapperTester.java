package com.simpletech.flowertomartyrs.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simpletech.flowertomartyrs.aspect.LoggingAspect;
import com.simpletech.flowertomartyrs.model.Comment;
import com.simpletech.flowertomartyrs.util.JacksonUtil;

/**
 * 数据库表comment的Mapper层测试类
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class CommentMapperTester {

	
	@Autowired
	CommentMapper mapper;

	@Before
	public void setUp() {
		LoggingAspect.log = false;
	}

	@Test
	public void insert() throws Exception{
		Comment model = new Comment();
		Object result = mapper.insert(model);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void update() throws Exception {
		Comment model = new Comment();
		Object result = mapper.update(model);
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void delete() throws Exception {
		Object result = mapper.delete("1");
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}
	
	@Test
	public void countAll() throws Exception {
		Object result = mapper.countAll();
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}

	@Test
	public void findAll() throws Exception {
		Object result = mapper.findAll("");
		System.out.println(JacksonUtil.toJson(result).replace("{","\n{"));
	}

}
