package pers.llh.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.llh.crm.dao.ContactDao;
import pers.llh.crm.entity.Contact;
import pers.llh.crm.service.ContactService;

/**
 * 交往管理server实现层
 * 
 * @author lilonghua
 *
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Resource
	private ContactDao contactDao;

	@Override
	public List<Contact> find(Map<String, Object> map) {
		return contactDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return contactDao.getTotal(map);
	}

	@Override
	public int update(Contact contact) {
		return contactDao.update(contact);
	}

	@Override
	public int add(Contact contact) {
		return contactDao.add(contact);
	}

	@Override
	public int delete(String id) {
		return contactDao.delete(id);

	}
}