package pers.llh.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pers.llh.crm.entity.CustomerFw;
import pers.llh.crm.entity.CustomerGc;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pers.llh.crm.entity.Customer;
import pers.llh.crm.entity.PageBean;
import pers.llh.crm.service.CustomerService;
import pers.llh.crm.util.DateUtil;
import pers.llh.crm.util.ResponseUtil;
import pers.llh.crm.util.StringUtil;
import pers.llh.crm.util.UUIDUtil;

/**
 * 客户Controller层
 * 
 * @author lilonghua
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	private CustomerService customerService;

	/**
	 * 分页条件查询客户
	 * 
	 * @param page
	 * @param rows
	 * @param s_customer
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, Customer s_customer,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("khno", StringUtil.formatLike(s_customer.getKhno()));
		map.put("name", StringUtil.formatLike(s_customer.getName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Customer> customerList = customerService.find(map);
		Long total = customerService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(customerList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * 添加或者修改客户
	 * 
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Customer customer,HttpServletResponse response)throws Exception{
		int resultTotal=0; // 操作的记录条数
		if(customer.getId()==null){
			String id = UUIDUtil.getUUID();
			customer.setId(id);
			customer.setKhno("KH"+DateUtil.getCurrentDateStr()); // 动态生成客户编号
			resultTotal=customerService.add(customer);
		}else{
			resultTotal=customerService.update(customer);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 删除客户
	 * 
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			customerService.delete(idsStr[i]);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * 通过ID查找实体
	 * 
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {
		Customer customer = customerService.findById(id);
		JSONObject jsonObject = JSONObject.fromObject(customer);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

	/**
	 * 查询客户分析构成
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCustomerGc")
	public String findCustomerGc(HttpServletResponse response) throws Exception {
		List<CustomerGc> customerGcList = customerService.findCustomerGc();
		JSONArray jsonArray = JSONArray.fromObject(customerGcList);
		ResponseUtil.write(response, jsonArray);
		return null;
	}

	/**
	 * 查询客户服务分析
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCustomerFw")
	public String findCustomerFw(HttpServletResponse response) throws Exception {
		List<CustomerFw> customerFwList = customerService.findCustomerFw();
		JSONArray jsonArray = JSONArray.fromObject(customerFwList);
		ResponseUtil.write(response, jsonArray);
		return null;
	}
}
