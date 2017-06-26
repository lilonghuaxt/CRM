package pers.llh.crm.dao;

import java.util.List;
import java.util.Map;

import pers.llh.crm.entity.Order;

/**
 * 历史订单Dao接口
 * @author lilonghua
 *
 */
public interface OrderDao {

	/**
	 * 分页查询订单
	 * @param map
	 * @return
	 */
	public List<Order> find(Map<String, Object> map);
	
	/**
	 * 订单总数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	public int add(Order order);
	
	/**
	 * 更新修改订单
	 * @param order
	 * @return
	 */
	public int update(Order order);
	
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	public int delete(String id);
	
	/**
	 * 查找指定客户的最近的订单
	 * @param cusId
	 * @return
	 */
	public Order findLastOrderByCusId(String cusId);	
}
