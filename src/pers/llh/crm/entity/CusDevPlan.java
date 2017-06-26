package pers.llh.crm.entity;

import java.util.Date;

import pers.llh.crm.entity.SaleChance;

/**
 * 客户开发计划实体
 * 
 * @author lilonghua
 *
 */
public class CusDevPlan {

	private String id; // 编号
	private SaleChance saleChance; // 销售机会
	private String planItem; // 计划项
	private Date planDate; // 计划日期
	private String exeAffect; // 执行效果

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SaleChance getSaleChance() {
		return saleChance;
	}

	public void setSaleChance(SaleChance saleChance) {
		this.saleChance = saleChance;
	}

	public String getPlanItem() {
		return planItem;
	}

	public void setPlanItem(String planItem) {
		this.planItem = planItem;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public String getExeAffect() {
		return exeAffect;
	}

	public void setExeAffect(String exeAffect) {
		this.exeAffect = exeAffect;
	}

}
