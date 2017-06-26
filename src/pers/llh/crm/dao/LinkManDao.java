package pers.llh.crm.dao;

import java.util.List;
import java.util.Map;

import pers.llh.crm.entity.LinkMan;

/**
 * 联系人dao接口
 * 
 * @author lilonghua
 *
 */
public interface LinkManDao {

	/**
	 * 分页查询总数
	 * 
	 * @param map
	 * @return
	 */
	public List<LinkMan> find(Map<String, Object> map);

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 修改联系人
	 * 
	 * @param linkMan
	 * @return
	 */
	public int update(LinkMan linkMan);

	/**
	 * 添加联系人
	 * 
	 * @param linkMan
	 * @return
	 */
	public int add(LinkMan linkMan);

	/**
	 * 删除联系人
	 * 
	 * @param id
	 * @return
	 */
	public int delete(String id);

}
