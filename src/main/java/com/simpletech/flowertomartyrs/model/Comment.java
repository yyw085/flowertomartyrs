package com.simpletech.flowertomartyrs.model;

import com.simpletech.flowertomartyrs.annotations.dbmodel.Column;
import com.simpletech.flowertomartyrs.annotations.dbmodel.Id;
import com.simpletech.flowertomartyrs.annotations.dbmodel.Table;
import com.simpletech.flowertomartyrs.model.base.ModelBase;

/**
 * 数据库表comment
 * @author zimu
 * @date 2015-12-17 15:07:45 中国标准时间
 */
@Table("comment")
public class Comment extends ModelBase{

	/**
	 * 数据库列CID
	 */
	@Id
	@Column("CID")
	private String cID;
	/**
	 * 数据库列UserName
	 */
	@Column("UserName")
	private String userName;
	/**
	 * 数据库列Comment
	 */
	@Column("Comment")
	private String comment;
	/**
	 * 数据库列Audit
	 */
	@Column("Audit")
	private String audit;
	/**
	 * 数据库列CreateTime
	 */
	@Column("CreateTime")
	private java.util.Date createTime;
	/**
	 * 数据库列UpdateTime
	 */
	@Column("UpdateTime")
	private java.util.Date updateTime;
	/**
	 * 数据库列DeleteSign
	 */
	@Column("DeleteSign")
	private String deleteSign;

	public Comment() {
	}
	
	public String getCID(){
		return this.cID;
	}

	public void setCID(String cID) {
		this.cID = cID;
	}
	
	public String getUserName(){
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getComment(){
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getAudit(){
		return this.audit;
	}

	public void setAudit(String audit) {
		this.audit = audit;
	}
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getDeleteSign(){
		return this.deleteSign;
	}

	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign;
	}
	
}