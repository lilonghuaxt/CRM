package pers.llh.crm.dao;

import java.util.List;
import java.util.Map;
import pers.llh.crm.entity.CustomerService;
/**
 * 客户服务Dao接口
 * 
 * @author lilonghua
 *
 */
public interface CustomerServiceDao {

	/**
	 * 添加客户服务
	 * 
	 * @param customerService
	 * @return
	 */
	public int add(CustomerService customerService);

	/**
	 * 查询客户服务
	 * 
	 * @param map
	 * @return
	 */
	public List<CustomerService> find(Map<String, Object> map);

	/**
	 * 查询客户服务记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 修改客户服务
	 * 
	 * @param customerService
	 * @return
	 */
	public int update(CustomerService customerService);
}
