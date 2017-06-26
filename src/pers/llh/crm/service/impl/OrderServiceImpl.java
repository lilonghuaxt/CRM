package pers.llh.crm.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.llh.crm.dao.CustomerDao;
import pers.llh.crm.dao.CustomerLossDao;
import pers.llh.crm.dao.OrderDao;
import pers.llh.crm.entity.Customer;
import pers.llh.crm.entity.CustomerLoss;
import pers.llh.crm.entity.Order;
import pers.llh.crm.service.OrderService;
import pers.llh.crm.util.DateDifferent;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Resource
	private CustomerLossDao customerLossDao;
	
	@Resource
	private CustomerDao customerDao;
	
	@Resource
	private OrderDao orderDao;

	@Override
	public List<Order> find(Map<String, Object> map) {
		return orderDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return orderDao.getTotal(map);
	}

	@Override
	public int add(Order order) {
		return orderDao.add(order);
	}

	@Override
	public int update(Order order) {
		return orderDao.update(order);
	}

	@Override
	public int delete(String id) {
		return orderDao.delete(id);
	}
	
	/**
	 * 查询用户订单 删除修改过并且单位时间内下过单的流失用户
	 */
	@Override
	public void deleteLoss() throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CustomerLoss> customerLossList = customerLossDao.find(map);// 查询流失客户表
		DateDifferent dateDifferent = new DateDifferent(); // 实例化最后一次下单日期差类
		List<Customer> customerList = customerDao.find(map);
		for (Customer c : customerList) {
			c.setState(0);
			customerDao.update(c);
		}
		for (CustomerLoss loss : customerLossList) {
			map.put("cusId", loss.getCusOrderId());
			List<Order> orderList = orderDao.find(map);// 查找历史订单表
			for (int i = 0; i < orderList.size(); i++) {
				Date orderDate = orderList.get(i).getOrderDate();// 获取历史订单的时间
				@SuppressWarnings("static-access")
				int dateBetween = dateDifferent.daysBetween(orderDate, new Date());
				if ((dateBetween > 1) && (dateBetween <= 31)) {
					Customer customer = orderList.get(i).getCustomer();
					String cusNo = customer.getKhno();
					customerLossDao.delete(cusNo);
				}
			}
		}
	}
}
