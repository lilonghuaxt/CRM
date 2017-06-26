package pers.llh.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pers.llh.crm.entity.PageBean;
import pers.llh.crm.entity.User;
import pers.llh.crm.service.UserService;
import pers.llh.crm.util.ResponseUtil;
import pers.llh.crm.util.StringUtil;
import pers.llh.crm.util.UUIDUtil;

/**
 * 用户Controller层
 * 
 * @author lilonghua
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	Object currentUser = null;
	
	/**
	 * 修改登录的接口，
	 * 把用户信息写入session
	 * @param user
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/loginUser")
	public void login1(User user,HttpServletResponse response,HttpServletRequest request) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		
		User resultUser=userService.login(user);
		if(resultUser==null){
			request.setAttribute("user", user);
			map.put("msg","输入有误，请核实！");
			JSONObject jsonObject = JSONObject.fromObject(map); 
			String json=jsonObject.toString();
			ResponseUtil.writeJosn(response, json); 
		}else{
			HttpSession session= request.getSession();
			session.setAttribute("currentUser", resultUser);
			session.setAttribute("userName", resultUser.getUserName());
			map.put("msg","登录成功");
			currentUser = session.getAttribute("userName");
			map.put("role", resultUser.getRoleName());
			JSONObject jsonObject = JSONObject.fromObject(map); 
			String json=jsonObject.toString();
			ResponseUtil.writeJosn(response, json);
		}
		
	}
	
	
	
	/**
	 * 分页条件查询用户
	 * 
	 * @param page
	 * @param rows
	 * @param s_user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, User s_user, HttpServletResponse response)
			throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", StringUtil.formatLike(s_user.getUserName()));// 模糊查询条件
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("currentUser", currentUser);//得到当前登录人username
		List<User> userList = userService.find(map);//查询
		Long total = userService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(userList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;

	}

	/**
	 * 添加或者修改用户
	 * 
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(User user, HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 操作的记录条数
		if (user.getId() == null) {
			String id = UUIDUtil.getUUID();
			user.setId(id);
			if("系统管理员"==user.getRoleName()){
				user.setIsVal("0");
			}else{
				user.setIsVal("1");
			}
			resultTotal = userService.add(user);
		} else {
			resultTotal = userService.update(user);
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
	 * 获取客户经理信息 下拉框数据用到
	 * 
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/customerManagerComboList")
	public String customerManagerComboList(HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleName", "客户经理");
		List<User> userList = userService.manager(map);
		JSONArray row = JSONArray.fromObject(userList);
		ResponseUtil.write(response, row);
		return null;
	}

	/**
	 * 删除用户
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
			//把整形对象Integer转换成基本数据类型int（整数）
			userService.delete(idsStr[i]);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * 修改用户密码
	 * 
	 * @param user
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(String id, String newPassword, HttpServletResponse response) throws Exception {
		User user = new User();
		user.setId(id);
		user.setPassword(newPassword);
		int resultTotal = userService.update(user);
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
	 * 用户注销
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();//销毁
		return "redirect:/index.jsp";
	}
}
