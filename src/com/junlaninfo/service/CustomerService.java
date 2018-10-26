package com.junlaninfo.service;
/**
*  @author xuexionghui E-mail:413669152@qq.com
*  @version 创建时间：2018年10月26日 下午3:47:22 
*  
**/

import java.util.List;

import com.junlaninfo.domain.Customer;
/*
 * 客户的接口
 */
public interface CustomerService {
	
	
	public List<Customer>    findCustomerNoConnectDecidedzone();
	
	public List<Customer>    findCustomerConnectDecidedzone(String decidedZoneId);
	
	public void              makeCustomerConnectDecidedzone(String[]  customerIds,String decidedZoneId);

}
