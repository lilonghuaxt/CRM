package pers.llh.crm.entity;

/**
 * 数据字典实体类
 * 
 * @author lilonghua
 *
 */
public class DataDic {

	private String id; // 编号
	private String dataDicName; // 数据字典名称
	private String dataDicValue; // 数据字典值

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDataDicName() {
		return dataDicName;
	}

	public void setDataDicName(String dataDicName) {
		this.dataDicName = dataDicName;
	}

	public String getDataDicValue() {
		return dataDicValue;
	}

	public void setDataDicValue(String dataDicValue) {
		this.dataDicValue = dataDicValue;
	}

}
