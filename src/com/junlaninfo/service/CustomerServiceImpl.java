package com.junlaninfo.service;

import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.junlaninfo.domain.Customer;
import com.junlaninfo.utils.HibernateUtils;

/**
*  @author xuexionghui E-mail:413669152@qq.com
*  @version 创建时间：2018年10月26日 下午3:47:49 
*  客户的实现类
*  
**/
public class CustomerServiceImpl implements CustomerService {
    /*
     * 查询没有和定区关联的客户
     * @see com.junlaninfo.service.CustomerService#findCustomerNoConnectDecidedzone()
     */
	@Override
	public List<Customer> findCustomerNoConnectDecidedzone() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		String hql="from  Customer where decidedZoneId is null";
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();
		transaction.commit();
		session.close();
		return customers;
	}
	/*
	 * 查询已和定区关联的客户
	 * @see com.junlaninfo.service.CustomerService#findCustomerConnectDecidedzone(java.lang.String)
	 */

	@Override
	public List<Customer> findCustomerConnectDecidedzone(String decidedZoneId) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		String hql="from Customer where decidedZoneId is ? ";   //设置占位符
		
		Query query = session.createQuery(hql);
		query.setString(0, decidedZoneId);   //定区的id值
		
		List<Customer> customers = query.list();
		transaction.commit();
		session.close();
		return customers;
	}

	@Override
	public void makeCustomerConnectDecidedzone(String[] customerIds, String decidedZoneId) {
		//通过id值，先找到客户，然后将定区的id值设置进去
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		if (customerIds!=null) {
			for (String  customerId : customerIds) {
				Customer customer=(Customer) session.get(Customer.class, customerId);
			    customer.setDecidedZoneId(decidedZoneId);
			}
		}
		
		transaction.commit();
		session.close();
		
	}

}
