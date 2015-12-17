package com.simpletech.flowertomartyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.simpletech.flowertomartyrs.model.Userinfo;
import com.simpletech.flowertomartyrs.dao.base.BaseDaoMybatisMYSQLImpl.MybatisMultiDao;


/**
 * 数据库表userinfo的mapper接口
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
public interface UserinfoMapper extends MybatisMultiDao<Userinfo>{

	/**
	 * 插入一条新数据
	 * @param model 添加的数据
	 * @return 改变的行数
	 */
	@Insert("INSERT INTO userinfo ( UserID , UserName , Password , CreateTime , DeleteSign ) VALUES ( #{userID} , #{userName} , #{password} , #{createTime} , #{deleteSign} )")
	int insert(Userinfo model) throws Exception;
	/**
	 * 根据ID删除
	 * @param id 数据的主键ID
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM userinfo WHERE UserID=#{id}")
	int delete(@Param("id") Object id) throws Exception;
	/**
	 * 更新一条数据
	 * @param model 更新的数据
	 * @return 改变的行数
	 */
	@Update("UPDATE userinfo SET UserID=#{userID} , UserName=#{userName} , Password=#{password} , CreateTime=#{createTime} , DeleteSign=#{deleteSign} WHERE UserID=#{userID} ")
	int update(Userinfo model) throws Exception;
	/**
	 * 统计全部出数据
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM userinfo")
	int countAll() throws Exception;
	/**
	 * 根据ID获取
	 * @param id 主键ID
	 * @return null 或者 主键等于id的数据
	 */
	@Select("SELECT UserID userID , UserName userName , Password password , CreateTime createTime , DeleteSign deleteSign FROM userinfo WHERE UserID=#{id}")
	Userinfo findById(@Param("id") Object id) throws Exception;
	/**
	 * 获取全部数据
	 * @return 全部数据列表
	 */
	@Select("SELECT UserID userID , UserName userName , Password password , CreateTime createTime , DeleteSign deleteSign FROM userinfo ${order}")
	List<Userinfo> findAll(@Param("order") String order) throws Exception;
	/**
	 * 分页查询数据
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 分页列表数据
	 */
	@Select("SELECT UserID userID , UserName userName , Password password , CreateTime createTime , DeleteSign deleteSign FROM userinfo ${order} LIMIT ${start},${limit}")
	List<Userinfo> findByPage(@Param("order") String order,@Param("limit") int limit,@Param("start") int start) throws Exception;
	/**
	 * 选择性删除
	 * @param where SQL条件语句
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM userinfo ${where}")
	int deleteWhere(@Param("where") String where) throws Exception;
	/**
	 * 根据属性值删除
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 改变的行数
	 */
	@Delete("DELETE FROM userinfo WHERE ${propertyName}=#{value}")
	int deleteByPropertyName(@Param("propertyName") String propertyName,@Param("value") Object value) throws Exception;
	/**
	 * 选择性统计
	 * @param where SQL条件语句
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM userinfo ${where}")
	int countWhere(@Param("where") String where) throws Exception;
	/**
	 * 根据属性统计
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 统计数
	 */
	@Select("SELECT COUNT(*) FROM WHERE ${propertyName}=#{value}")
	int countByPropertyName(@Param("propertyName") String propertyName,@Param("value") Object value) throws Exception;
	/**
	 * 选择性查询
	 * @param where SQL条件语句
	 * @return 符合条件的列表数据
	 */
	@Select("SELECT UserID userID , UserName userName , Password password , CreateTime createTime , DeleteSign deleteSign FROM userinfo ${where} ${order}")
	List<Userinfo> findWhere(@Param("order") String order,@Param("where") String where) throws Exception;
	/**
	 * 选择性分页查询
	 * @param where SQL条件语句
	 * @param limit 最大返回
	 * @param start 起始返回
	 * @return 符合条件的列表数据
	 */
	@Select("SELECT UserID userID , UserName userName , Password password , CreateTime createTime , DeleteSign deleteSign FROM userinfo ${where} ${order} LIMIT ${start},${limit}")
	List<Userinfo> findWhereByPage(@Param("order") String order,@Param("where") String where,@Param("limit") int limit,@Param("start") int start) throws Exception;
	/**
	 * 根据属性查询
	 * @param propertyName 数据库列名
	 * @param value 值
	 * @return 返回符合条件的数据列表
	 */
	@Select("SELECT UserID userID , UserName userName , Password password , CreateTime createTime , DeleteSign deleteSign FROM userinfo WHERE ${propertyName}=#{value} ${order}")
	List<Userinfo> findByPropertyName(@Param("order") String order,@Param("propertyName") String propertyName,@Param("value") Object value) throws Exception;
}