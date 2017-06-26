package pers.llh.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import pers.llh.crm.entity.Contact;
import pers.llh.crm.service.ContactService;
import pers.llh.crm.util.ResponseUtil;
import pers.llh.crm.util.UUIDUtil;

/**
 * 交往管理controller层
 * 
 * @author lilonghua
 *
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

	@Resource
	private ContactService contactService;

	/*
	 * 实际操作中经常会碰到表单中的日期 字符串和Javabean中的日期类型的属性自动转换，
	 * 而springMVC默认不支持这个格式的转换，所以必须要手动配置， 自定义数据类型的绑定才能实现这个功能。
	 * 比较简单的可以直接应用springMVC的注解@initbinder和spring自带的WebDataBinder类和操作
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
	}

	/**
	 * 查询交往记录
	 * 
	 * @param cusId
	 * @param response
	 * @return
	 * @throws Exception
	 */

	// required 传参 当他为false 时 使用这个注解可以不传这个参数 true时必须传 required默认值是true
	@RequestMapping("/list")
	public String List(@RequestParam(value = "cusId", required = true) String cusId, HttpServletResponse response)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusId", cusId);
		List<Contact> contactList = contactService.find(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "customer" });// 使用setExcludes过滤不需要转换的属性
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(contactList, jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * 添加或修改交往记录
	 * 
	 * @param contact
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String sava(Contact contact, HttpServletResponse response) throws Exception {
		int resultTotal = 0;
		if (contact.getId() == null) {
			String id = UUIDUtil.getUUID();
			contact.setId(id);
			resultTotal = contactService.add(contact);
		} else {
			resultTotal = contactService.update(contact);
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
	 * 删除交往记录
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		contactService.delete(id);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
