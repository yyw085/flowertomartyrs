package com.simpletech.flowertomartyrs.model;

import com.simpletech.flowertomartyrs.annotations.dbmodel.Column;
import com.simpletech.flowertomartyrs.annotations.dbmodel.Id;
import com.simpletech.flowertomartyrs.annotations.dbmodel.Table;
import com.simpletech.flowertomartyrs.model.base.ModelBase;

/**
 * 数据库表userinfo
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Table("userinfo")
public class Userinfo extends ModelBase{

	/**
	 * 数据库列UserID
	 */
	@Id
	@Column("UserID")
	private String userID;
	/**
	 * 数据库列UserName
	 */
	@Column("UserName")
	private String userName;
	/**
	 * 数据库列Password
	 */
	@Column("Password")
	private String password;
	/**
	 * 数据库列CreateTime
	 */
	@Column("CreateTime")
	private java.util.Date createTime;
	/**
	 * 数据库列DeleteSign
	 */
	@Column("DeleteSign")
	private String deleteSign;

	public Userinfo() {
	}
	
	public String getUserID(){
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUserName(){
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public String getDeleteSign(){
		return this.deleteSign;
	}

	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign;
	}
	
}