package pers.llh.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.llh.crm.dao.UserDao;
import pers.llh.crm.entity.User;
import pers.llh.crm.service.UserService;

/**
 * 用户Service实现类
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public List<User> find(Map<String, Object> map) {
		return userDao.find(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return userDao.getTotal(map);
	}

	@Override
	public int add(User user) {
		return userDao.add(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public int delete(String id) {
		return userDao.delete(id);
	}

	@Override
	public List<User> manager(Map<String, Object> map) {
		return userDao.manager(map);
	}
}
