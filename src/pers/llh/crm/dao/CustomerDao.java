package pers.llh.crm.dao;

import java.util.List;
import java.util.Map;

import pers.llh.crm.entity.CustomerFw;
import pers.llh.crm.entity.CustomerGc;
import pers.llh.crm.entity.Customer;

/**
 * 客户Dao接口
 * 
 * @author lilonghua
 *
 */
public interface CustomerDao {

	/**
	 * 查询客户
	 * 
	 * @param map
	 * @return
	 */
	public List<Customer> find(Map<String, Object> map);

	/**
	 * 获取记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 添加客户
	 * @param customer
	 * @return
	 */
	public int add(Customer customer);
	
	/**
	 * 修改客户
	 * @param customer
	 * @return
	 */
	public int update(Customer customer);

	/**
	 * 删除客户
	 * 
	 * @param id
	 * @return
	 */
	public int delete(String id);

	/**
	 * 通过Id查找实体
	 * 
	 * @param id
	 * @return
	 */
	public Customer findById(String id);


	/**
	 * 查询客户构成
	 * 
	 * @return
	 */
	public List<CustomerGc> findCustomerGc();

	/**
	 * 查询客户服务分析
	 * 
	 * @return
	 */
	public List<CustomerFw> findCustomerFw();
	
	/**
	 * 查找流失的客户 1个月未下单的客户
	 * @return
	 */
	public List<Customer> findLossCustomer();

}
