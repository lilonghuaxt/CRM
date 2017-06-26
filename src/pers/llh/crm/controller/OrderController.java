package pers.llh.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import pers.llh.crm.entity.Order;
import pers.llh.crm.service.OrderService;
import pers.llh.crm.util.ResponseUtil;
import pers.llh.crm.util.UUIDUtil;

/**
 * 历史订单管理controller层
 * @author lilonghua
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	private OrderService orderService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
	}

	/**
	 * 查询历史订单
	 * @param cusId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String List(@RequestParam(value = "cusId",required = true)String cusId,HttpServletResponse response) throws Exception{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("cusId", cusId);
		List<Order> orderList = orderService.find(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customer" });// 使用setExcludes过滤不需要转换的属性
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(orderList, jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加或修改订单
	 * @param order
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String sava(Order order,HttpServletResponse response) throws Exception{
		int resultTotal=0;
		if(order.getId() == null){
			String id = UUIDUtil.getUUID();
			order.setId(id);
			resultTotal = orderService.add(order);
		}else{
			orderService.deleteLoss();
			resultTotal = orderService.update(order);
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 删除历史订单
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delelt(@RequestParam(value = "id")String id,HttpServletResponse response) throws Exception{
		orderService.delete(id);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
		
	}
}
