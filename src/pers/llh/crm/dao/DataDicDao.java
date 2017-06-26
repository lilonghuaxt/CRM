package pers.llh.crm.dao;

import java.util.List;
import java.util.Map;

import pers.llh.crm.entity.DataDic;

/**
 * 数据字典Dao接口
 * 
 * @author lilonghua
 *
 */
public interface DataDicDao {

	/**
	 * 查询数据字典集合
	 * 
	 * @param map
	 */
	public List<DataDic> find(Map<String, Object> map);

	/**
	 * 查询所有的数据字典名称集和
	 * 
	 */
	public List<DataDic> findAll();

	/**
	 * 获取总记录数
	 * 
	 * @param map
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 修改数据字典
	 * 
	 * @param dataDic
	 */
	public int update(DataDic dataDic);

	/**
	 * 添加数据字典
	 * 
	 * @param dataDic
	 */
	public int add(DataDic dataDic);

	/**
	 * 删除数据字典
	 * 
	 * @param id
	 */
	public int delete(String id);
}
