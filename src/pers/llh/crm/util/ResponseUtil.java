package pers.llh.crm.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 写数据返回页面工具类
 * @author lilonghua
 *
 */
public class ResponseUtil {

	public static void write(HttpServletResponse response,Object o)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
	
	 public static void writeJosn(HttpServletResponse response,String jsonStr){

	        try {

	            response.setContentType("text/html");
	            response.setHeader("Pragma", "No-cache");//设置页面不缓存
	            response.setHeader("Cache-Control", "no-cache");
	            response.setCharacterEncoding("UTF-8");
	            PrintWriter out= response.getWriter(); //获取流
	            out.print(jsonStr);
	            out.flush();
	            out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
