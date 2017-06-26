package pers.llh.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.llh.crm.dao.CustomerServiceDao;
import pers.llh.crm.entity.CustomerService;
import pers.llh.crm.service.CustomerServiceService;

/**
 * 客服服务Service实现类
 * 
 * @author lilonghua
 *
 */
@Service("customerServiceService")
public class CustomerServiceServiceImpl implements CustomerServiceService {

	@Resource
	private CustomerServiceDao customerServiceDao;

	@Override
	public int add(pers.llh.crm.entity.CustomerService customerService) {
		return customerServiceDao.add(customerService);
	}

	@Override
	public List<CustomerService> find(Map<String, Object> map) {
		return customerServiceDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return customerServiceDao.getTotal(map);
	}

	@Override
	public int update(CustomerService customerService) {
		return customerServiceDao.update(customerService);
	}

}
