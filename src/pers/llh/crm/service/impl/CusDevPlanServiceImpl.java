package pers.llh.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.llh.crm.dao.CusDevPlanDao;
import pers.llh.crm.entity.CusDevPlan;
import pers.llh.crm.service.CusDevPlanService;

/**
 * 客户开发计划Service实现类
 * 
 * @author lilonghua
 *
 */
@Service("cusDevPlanService")
public class CusDevPlanServiceImpl implements CusDevPlanService {

	@Resource
	private CusDevPlanDao cusDevPlanDao;

	@Override
	public List<CusDevPlan> findCusDevPlan(Map<String, Object> map) {
		return cusDevPlanDao.findCusDevPlan(map);
	}

	@Override
	public Long getTotalCusDevPlan(Map<String, Object> map) {
		return cusDevPlanDao.getTotalCusDevPlan(map);
	}

	@Override
	public int addCusDevPlan(CusDevPlan cusDevPlan) {
		return cusDevPlanDao.addCusDevPlan(cusDevPlan);
	}

	@Override
	public int updateCusDevPlan(CusDevPlan cusDevPlan) {
		return cusDevPlanDao.updateCusDevPlan(cusDevPlan);
	}

	@Override
	public int deleteCusDevPlan(String id) {
		return cusDevPlanDao.deleteCusDevPlan(id);
	}

	@Override
	public CusDevPlan findById(String id) {
		return cusDevPlanDao.findById(id);
	}

}
