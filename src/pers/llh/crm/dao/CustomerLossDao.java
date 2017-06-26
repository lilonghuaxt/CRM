package pers.llh.crm.dao;

import java.util.List;
import java.util.Map;

import pers.llh.crm.entity.CustomerLoss;

/**
 * 客户流失Dao接口
 * @author lilonghua
 *
 */
public interface CustomerLossDao {

	
	/**
	 * 删除重复数据
	 * @return
	 */
	public void deleteChongFu();
	/**
	 * 查询客户流失集合
	 * @param map
	 * @return
	 */
	public List<CustomerLoss> find(Map<String,Object> map);
	
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 添加客户已流失记录
	 * @param customerLoss
	 * @return
	 */
	public int add(CustomerLoss customerLoss);
	
	
	/**
	 * 添加客户正在流失记录
	 * @param customerLoss
	 * @return
	 */
	public int addLossing(CustomerLoss customerLoss);
	
	/**
	 * 通过Id查找实体
	 * @param id
	 * @return
	 */
	public CustomerLoss findById(String id);
	
	/**
	 * 修改客户流失记录
	 * @param customerLoss
	 * @return
	 */
	public int update(CustomerLoss customerLoss);
	
	/**
	 * 删除客户流失记录
	 * @param id
	 * @return
	 */
	public int delete(String id);
}

