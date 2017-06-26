package pers.llh.crm.dao;

import java.util.List;
import java.util.Map;

import pers.llh.crm.entity.User;

/**
 * 用户Dao接口
 *
 */
public interface UserDao {

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
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
	 * 
	 * @param map
	 * @return
	 */
	public List<User> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	public int add(User user);

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	public int update(User user);

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	public int delete(String id);
}