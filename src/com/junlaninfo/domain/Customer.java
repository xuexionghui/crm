package com.junlaninfo.domain;

import java.io.Serializable;

/**
*  @author xuexionghui E-mail:413669152@qq.com
*  @version 创建时间：2018年10月26日 下午3:31:05 
*  
**/
public class Customer   implements Serializable {
   
	private String id;
	private String  name;
	private String   telephone;
	private String address;
	
	private String decidedZoneId;   //关联定区

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDecidedZoneId() {
		return decidedZoneId;
	}

	public void setDecidedZoneId(String decidedZoneId) {
		this.decidedZoneId = decidedZoneId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", telephone=" + telephone + ", decidedZoneId=" + decidedZoneId
				+ "]";
	}
	

}
