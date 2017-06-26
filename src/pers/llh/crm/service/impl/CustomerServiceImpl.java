package pers.llh.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.llh.crm.entity.CustomerFw;
import pers.llh.crm.entity.CustomerGc;
import pers.llh.crm.entity.CustomerLoss;
import pers.llh.crm.entity.Order;
import pers.llh.crm.dao.CustomerDao;
import pers.llh.crm.dao.CustomerLossDao;
import pers.llh.crm.dao.OrderDao;
import pers.llh.crm.entity.Customer;
import pers.llh.crm.service.CustomerService;
import pers.llh.crm.util.DateDifferent;
import pers.llh.crm.util.UUIDUtil;

/**
 * 客户service实现类
 * 
 * @author lilonghua
 *
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerDao customerDao;
	
	@Resource
	private CustomerLossDao customerLossDao;
	
	@Resource
	private OrderDao orderDao;


	@Override
	public List<Customer> find(Map<String, Object> map) {
		return customerDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return customerDao.getTotal(map);
	}

	@Override
	public int add(Customer customer) {
		return customerDao.add(customer);
	}

	@Override
	public int update(Customer customer) {
		return customerDao.update(customer);
	}

	@Override
	public int delete(String id) {
		return customerDao.delete(id);
	}

	@Override
	public Customer findById(String id) {
		return customerDao.findById(id);
	}

	@Override
	public List<CustomerGc> findCustomerGc() {
		return customerDao.findCustomerGc();
	}

	@Override
	public List<CustomerFw> findCustomerFw() {
		return customerDao.findCustomerFw();
	}

	/**
	 * 查询用户订单，符合的添加到客户流失表
	 */
	@Override
	public void checkCustomerLoss() throws Exception {
		List<Customer> customerList=customerDao.findLossCustomer(); // 查找流失客户
		DateDifferent dateDifferent = new DateDifferent();	//实例化最后一次下单日期差类
		for(Customer c:customerList){
			CustomerLoss customerLoss=new CustomerLoss(); // 实例化客户流失实体
			String id = UUIDUtil.getUUID();
			customerLoss.setId(id);
			customerLoss.setCusNo(c.getKhno()); // 客户编号
			customerLoss.setCusName(c.getName()); // 客户名称
			customerLoss.setCusManager(c.getCusManager()); // 客户经理
			customerLoss.setCusOrderId(c.getId()); //id
			Order order=orderDao.findLastOrderByCusId(c.getId()); // 查找指定客户最近的订单
			if(order==null){
				customerLoss.setLastOrderTime(null);
			}else{
				customerLoss.setLastOrderTime(order.getOrderDate()); // 设置最近的下单日期	
				@SuppressWarnings("static-access")
				int dateBetween = dateDifferent.daysBetween(order.getOrderDate(), new Date());
				customerLoss.setConfirmLossTime(dateBetween);
				if((dateBetween>31)&&(dateBetween<=62)){
					customerLossDao.addLossing(customerLoss); //正在流失
				}else if(dateBetween>62){
					customerLossDao.add(customerLoss); // 添加到客户流失表.确认流失
				}	
			}
			c.setState(1); // 客户状态修改成1 流失状态
			customerDao.update(c); 
		}
		 
	}
}
