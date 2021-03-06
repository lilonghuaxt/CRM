<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	 if(<%=session.getAttribute("userName")%>==null)
	    {
	    alert("你未登陆，请先登陆！");
	    window.location.href="index.jsp"
	    }
	 });

 function searchCustomerLoss(){
	 $("#dg").datagrid('load',{
		"cusName":$("#s_cusName").val(),
		"cusManager":$("#s_cusManager").val(),
		"state":$("#s_state").combobox("getValue")
	 });
 }
 
 function formatState(val,row){
	 if(val==1){
		 return "确认流失";
	 }else{
		 return "正在流失";
	 }
 }
 

</script>
<title>Insert title here</title>
</head>
<body style="margin: 1px">
 <table id="dg" title="客户流失管理" class="easyui-datagrid"
   fitColumns="true" pagination="true" rownumbers="true"
   url="${pageContext.request.contextPath}/customerLoss/list.do" fit="true" toolbar="#tb">
   <thead>
   	<tr>
   		<th field="cb" checkbox="true" align="center"></th>
   		<th field="id" width="50" align="center">编号</th>
   		<th field="cusNo" width="50" align="center" hidden="true">客户编号</th>
   		<th field="cusName" width="100" align="center">客户名称</th>
   		<th field="cusManager" width="100" align="center">客户经理</th>
   		<th field="lastOrderTime" width="100" align="center">上次下单日期</th>
   		<th field="confirmLossTime" width="100" align="center">已流失天数</th>
   		<th field="state" width="80" align="center" formatter="formatState">客户状态</th>
   	</tr>
   </thead>
 </table>
 <div id="tb">
 	<div>
 		
 	</div>
 	<div>
 		&nbsp;客户名称：&nbsp;<input type="text" id="s_cusName" size="20" onkeydown="if(event.keyCode==13) searchCustomerLoss()"/>
 		&nbsp;客户经理：&nbsp;<input type="text" id="s_cusManager" size="20" onkeydown="if(event.keyCode==13) searchCustomerLoss()"/>
 		&nbsp;客户状态：&nbsp;<select class="easyui-combobox" id="s_state" editable="false" panelHeight="auto" >
 								<option value="">请选择...</option>	
 								<option value="0">正在流失</option>
 								<option value="1">确认流失</option>					
 		                    </select>
 		<a href="javascript:searchCustomerLoss()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
 	</div>
 </div>

</body>
</html>