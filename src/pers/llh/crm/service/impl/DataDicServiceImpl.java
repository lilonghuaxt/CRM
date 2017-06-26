package pers.llh.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.llh.crm.dao.DataDicDao;
import pers.llh.crm.entity.DataDic;
import pers.llh.crm.service.DataDicService;

/**
 * 数据字典Service实现类
 * 
 * @author lilonghua
 *
 */
@Service("dataDicService")
public class DataDicServiceImpl implements DataDicService {

	@Resource
	private DataDicDao dataDicDao;

	@Override
	public List<DataDic> find(Map<String, Object> map) {
		return dataDicDao.find(map);
	}

	@Override
	public List<DataDic> findAll() {
		return dataDicDao.findAll();
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return dataDicDao.getTotal(map);
	}

	@Override
	public int update(DataDic dataDic) {
		return dataDicDao.update(dataDic);
	}

	@Override
	public int add(DataDic dataDic) {
		return dataDicDao.add(dataDic);
	}

	@Override
	public int delete(String id) {
		return dataDicDao.delete(id);
	}
}
