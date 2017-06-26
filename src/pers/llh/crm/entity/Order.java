package pers.llh.crm.entity;

import java.util.Date;

/**
 * 历史订单实体类
 * @author lilonghua
 *
 */
public class Order {

	private String id;//编号
	private Customer customer;//所属客户
	private String orderLinkman;//客户联系人
	private String phone;//电话
	private Date orderDate;//最近下单日期
	private String overview;//概要

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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getOrderLinkman() {
		return orderLinkman;
	}

	public void setOrderLinkman(String orderLinkman) {
		this.orderLinkman = orderLinkman;
	}
	
}
