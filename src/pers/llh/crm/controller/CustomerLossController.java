package pers.llh.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import pers.llh.crm.entity.CustomerLoss;
import pers.llh.crm.entity.PageBean;
import pers.llh.crm.service.CustomerLossService;
import pers.llh.crm.service.CustomerService;
import pers.llh.crm.util.ResponseUtil;
import pers.llh.crm.util.StringUtil;


/**
 * 客户流失Controller层
 * @author lilonghua
 *
 */
@Controller
@RequestMapping("/customerLoss")
public class CustomerLossController {
	
	@Resource
	private CustomerLossService customerLossService;
	
	@Resource
	private CustomerService customerService;

	/**
	 * 分页条件查询客户流失
	 * @param page
	 * @param rows
	 * @param s_customerLoss
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,CustomerLoss s_customerLoss,HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		customerService.checkCustomerLoss();
		map.put("cusName", StringUtil.formatLike(s_customerLoss.getCusName()));
		map.put("cusManager", StringUtil.formatLike(s_customerLoss.getCusManager()));
		map.put("state", s_customerLoss.getState());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		customerLossService.deleteChongFu();//删除重复数据
		List<CustomerLoss> customerLossList=customerLossService.find(map);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject result=new JSONObject();
		Long total=customerLossService.getTotal(map);
		JSONArray jsonArray=JSONArray.fromObject(customerLossList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 通过ID查找实体
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value="id")String id,HttpServletResponse response)throws Exception{
		CustomerLoss customerLoss=customerLossService.findById(id);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject=JSONObject.fromObject(customerLoss,jsonConfig);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	
}

