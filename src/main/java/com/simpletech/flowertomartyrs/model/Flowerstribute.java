package com.simpletech.flowertomartyrs.model;

import com.simpletech.flowertomartyrs.annotations.dbmodel.Column;
import com.simpletech.flowertomartyrs.annotations.dbmodel.Id;
import com.simpletech.flowertomartyrs.annotations.dbmodel.Table;
import com.simpletech.flowertomartyrs.model.base.ModelBase;

/**
 * 数据库表flowerstribute
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Table("flowerstribute")
public class Flowerstribute extends ModelBase{

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
	 * 数据库列FlowerNumber
	 */
	@Column("FlowerNumber")
	private Integer flowerNumber;
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

	public Flowerstribute() {
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
	
	public Integer getFlowerNumber(){
		return this.flowerNumber;
	}

	public void setFlowerNumber(Integer flowerNumber) {
		this.flowerNumber = flowerNumber;
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