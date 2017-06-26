package pers.llh.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.llh.crm.dao.SaleChanceDao;
import pers.llh.crm.entity.SaleChance;
import pers.llh.crm.service.SaleChanceService;

/**
 * 销售机会servic实现类
 * 
 * @author lilonghua
 *
 */
@Service("saleChanceService")
public class SaleChanceServiceImpl implements SaleChanceService {

	@Resource
	private SaleChanceDao saleChanceDao;

	@Override
	public List<SaleChance> find(Map<String, Object> map) {
		return saleChanceDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return saleChanceDao.getTotal(map);
	}

	@Override
	public int add(SaleChance saleChance) {
		return saleChanceDao.add(saleChance);
	}

	@Override
	public int update(SaleChance saleChance) {
		return saleChanceDao.update(saleChance);
	}

	@Override
	public int delete(String id) {
		return saleChanceDao.delete(id);
	}

	@Override
	public SaleChance findById(String id) {
		return saleChanceDao.findById(id);
	}

}
