package pers.llh.crm.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pers.llh.crm.dao.LinkManDao;
import pers.llh.crm.entity.LinkMan;
import pers.llh.crm.service.LinkManService;

/**
 * 联系人Service实现类
 * 
 * @author lilonghua
 *
 */
@Service("linkManService")
public class LinkManServiceImpl implements LinkManService {

	@Resource
	private LinkManDao linkManDao;

	@Override
	public List<LinkMan> find(Map<String, Object> map) {
		return linkManDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return linkManDao.getTotal(map);
	}

	@Override
	public int update(LinkMan linkMan) {
		return linkManDao.update(linkMan);
	}

	@Override
	public int add(LinkMan linkMan) {
		return linkManDao.add(linkMan);
	}

	@Override
	public int delete(String id) {
		return linkManDao.delete(id);
	}
}
