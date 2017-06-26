package pers.llh.crm.entity;

import java.util.Date;

/**
 * 客户流行实体类
 * @author lilonghua
 *
 */
public class CustomerLoss {

	private String id; // 编号
	private String cusNo; // 客户编号
	private String cusName; // 客户名称
	private String cusManager; // 客户经理
	private Date lastOrderTime; // 上次下单日期
	private int confirmLossTime; // 已流失天数
	private Integer state; // 状态 0 暂缓流失 1 确认流失
	private String cusOrderId; // 流失原因
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCusNo() {
		return cusNo;
	}
	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	
	public String getCusManager() {
		return cusManager;
	}
	public void setCusManager(String cusManager) {
		this.cusManager = cusManager;
	}
	public Date getLastOrderTime() {
		return lastOrderTime;
	}
	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}
	
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public int getConfirmLossTime() {
		return confirmLossTime;
	}
	public void setConfirmLossTime(int confirmLossTime) {
		this.confirmLossTime = confirmLossTime;
	}
	public String getCusOrderId() {
		return cusOrderId;
	}
	public void setCusOrderId(String cusOrderId) {
		this.cusOrderId = cusOrderId;
	}
	
	
}
