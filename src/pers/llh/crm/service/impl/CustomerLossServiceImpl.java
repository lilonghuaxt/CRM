package pers.llh.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.llh.crm.dao.CustomerLossDao;
import pers.llh.crm.entity.CustomerLoss;
import pers.llh.crm.service.CustomerLossService;

/**
 * 客户流失Service实现类
 * @author lilonghua
 *
 */
@Service("customerLossService")
public class CustomerLossServiceImpl implements CustomerLossService{

	@Resource
	private CustomerLossDao customerLossDao;
	
	@Override
	public List<CustomerLoss> find(Map<String, Object> map) {
		return customerLossDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return customerLossDao.getTotal(map);
	}

	@Override
	public CustomerLoss findById(String id) {
		return customerLossDao.findById(id);
	}

	@Override
	public int update(CustomerLoss customerLoss) {
		return customerLossDao.update(customerLoss);
	}

	@Override
	public int add(CustomerLoss customerLoss) {
		return customerLossDao.add(customerLoss);
	}

	@Override
	public void deleteChongFu() {
		customerLossDao.deleteChongFu();
	}

}
