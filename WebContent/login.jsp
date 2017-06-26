<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(function(){
    $("#dig").dialog({
        title:"CRM客户关系管理系统登录",
        modal:true,  //是否将窗体显示为模式化窗口
        collapsible:false, //是否显示可折叠按钮
        minimizable:false, //是否显示最小化按钮
        closable: false,
        buttons:[{
            text:"登录",
            handler:function(){
                $.ajax({
                    url:"${pageContext.request.contextPath}/user/loginUser.do",
                    type:"post",
                    data:$("#loginForm").serialize(),
                    dataType:"json",
                    success:function(data){
                        alert(data.msg);
                        if(data.msg=="登录成功"){
                        	$("#dig").dialog("close");
                            if(data.role=="系统管理员"){
                            	 window.location.href="CRMMAINADMIN";
                            } else{
                            	 window.location.href="CRMMAIN";
                            }
                           
                        }
                    },
                    error:function(data){
                        alert("error"+data.msg);
                    }
                })
            }
        }]
    });
})
</script>

    <div id="dig" style="width:400px;height:200px">
        <form id="loginForm">
            <table>
                <tr>
                    <td>账户：</td><td><input type="text" name="userName"></td>
                </tr>
                <tr>
                    <td>密码：</td><td><input type="password" name="password"></td>
                </tr>
                <tr>
                	<td>角色：</td>
                	<td>
							<select id="roleName" name="roleName" class="input" style="margin-top: 15px;height: 24px">
								<option value="">请选择用户类型...</option>
								<option value="系统管理员"  ${'系统管理员'==user.roleName?'selected':'' }>系统管理员</option>
								<option value="销售主管"  ${'销售主管'==user.roleName?'selected':'' }>销售主管</option>
								<option value="客户经理"  ${'客户经理'==user.roleName?'selected':'' }>客户经理</option>
								<option value="高管"  ${'高管'==user.roleName?'selected':'' }>高管</option>
							</select>
						</td>
                </tr>
            </table>
        </form>
    </div>