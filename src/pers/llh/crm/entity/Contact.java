package pers.llh.crm.entity;

import java.util.Date;

/**
 * 交往记录
 * 
 * @author lilonghua
 *
 */
public class Contact {

	private String id;// 编号
	private Customer customer;// 所属客户
	private Date contactTime;// 交往时间
	private String address;// 交往地点
	private String overView;// 概要

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getContactTime() {
		return contactTime;
	}

	public void setContactTime(Date contactTime) {
		this.contactTime = contactTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}
}
