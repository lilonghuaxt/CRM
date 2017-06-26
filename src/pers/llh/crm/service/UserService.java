package pers.llh.crm.service;

import java.util.List;
import java.util.Map;

import pers.llh.crm.entity.User;

/**
 * 用户Service接口
 * 
 * @author lilonghua
 *
 */
public interface UserService {

	/**
	 * 用户登录
	 */
	public User login(User user);

	/**
	 * 显示经理
	 * @param user
	 * @return
	 */
	public List<User> manager (Map<String, Object> map);
	/**
	 * 查询用户集合
	 */
	public List<User> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public int add(User user);

	/**
	 * 修改用户
	 * 
	 * @param user
	 */
	public int update(User user);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public int delete(String id);
}
