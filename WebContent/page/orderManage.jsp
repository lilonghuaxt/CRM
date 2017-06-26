<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
 
 $(function(){	
	 $.post("${pageContext.request.contextPath}/customer/findById.do",{id:'${param.cusId}'},function(result){
		 $("#khno").val(result.khno);
		 $("#name").val(result.name);
		},"json");
	 
	 $("#dg").edatagrid({
		url:'${pageContext.request.contextPath}/order/list.do?cusId=${param.cusId}',
		saveUrl:'${pageContext.request.contextPath}/order/save.do?customer.id=${param.cusId}',
		updateUrl:'${pageContext.request.contextPath}/order/save.do',
		destroyUrl:'${pageContext.request.contextPath}/order/delete.do'
	 });
 });
 
 
 
</script>
<title>Insert title here</title>
</head>
<body style="margin: 15px">
 
 <div id="p" class="easyui-panel" title="客户基本信息" style="width: 700px;height: 100px;padding: 10px">
 	<table cellspacing="8px">
   		<tr>
   			<td>客户编号：</td>
   			<td><input type="text" id="khno" name="khno" readonly="readonly"/></td>
   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
   			<td>客户名称</td>
   			<td><input type="text" id="name" name="name" readonly="readonly"/></td>
   		</tr>
   	</table>
 </div>
 
 <br/>
 <table id="dg" title="历史订单管理" style="width:700px;height:250px"
   toolbar="#toolbar" idField="id" rownumbers="true" fitColumns="true" singleSelect="true">
   <thead>
   	<tr>
   		<th field="id" width="100">编号</th>
   		<th field="orderLinkman" width="90" editor="{type:'validatebox',options:{required:true}}">订单联系人</th>
   		<th field="phone" width="100" editor="{type:'validatebox',options:{required:true}}">联系人电话</th>
   		<th field="orderDate" width="110" editor="{type:'datebox',options:{required:true}}">最近一次订单时间</th>
   		<th field="overview" width="250" editor="{type:'validatebox',options:{required:true}}">概要</th>
   	</tr>
   </thead>
 </table>
 
 <div id="toolbar">
 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加</a>
 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow');$('#dg').edatagrid('reload')">保存</a>
 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">撤销行</a>
 </div>
</body>
</html>