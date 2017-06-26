package pers.llh.crm.service;

import java.util.List;
import java.util.Map;

import pers.llh.crm.entity.CustomerLoss;


/**
 * 客户流失Sevice层
 * @author lilonghua
 *
 */
public interface CustomerLossService {

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
	 * 添加客户流失
	 * @param customerLoss
	 * @return
	 */
	public int add(CustomerLoss customerLoss);
	/**
	 * 删除重复数据
	 */
	public void deleteChongFu();
}

