<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="content" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>用户名:</td>
	            <td><input class="easyui-textbox" type="text" name="userName" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <input type="hidden" name="id"></input>
	        <tr>
	            <td>密码:</td>
	            <td><input class="easyui-textbox" type="password" name="password" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>姓名:</td>
	            <td><input class="easyui-textbox" name="name" data-options="validType:'length[0,150]',required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>年龄:</td>
	            <td><input class="easyui-numberbox" type="text" name="age" data-options="min:1,max:100,precision:0,required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>性别:</td>
	            <td>
	            	<input class="easyui-radio" type="radio" name="sex" value="1" checked="checked"/> 男
	            	<input class="easyui-radio" type="radio" name="sex" value="2"/> 女
	            </td>
	        </tr>
	        <tr>
	            <td>出生日期:</td>
	            <td>
	                <input class="easyui-datebox" type="text" name="birthday" data-options="required:true" />
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm();">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm();">重置</a>
	</div>
</div>
<script type="text/javascript">
	function submitForm(){
		if(!$('#content').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		/* $.post("/user/save",$("#content").serialize(), function(data){
			alert(data);
			if(data.status == 200){
				$.messager.alert('提示','新增会员成功!');
				$('#userAdd').window('close');
				$("#userList").datagrid("reload");
				clearForm();//第二次点击新增时清除第一次新增的数据
			}else{
				$.messager.alert('提示','新增会员失败!');
			}
		}); */
		$.ajax({
			   type: "POST",
			   url: "/rest/user",
			   data: $("#content").serialize(),
			    success: function(){
				   $.messager.alert('提示','操作成功1!');
					$('#userAdd').window('close');
					$("#userList").datagrid("reload");
					clearForm();//第二次点击新增时清除第一次新增的数据
			   } /*,
			   error:function(){
				   $.messager.alert('提示','新增会员失败!');
			   } */
				  /*  statusCode: {
					           201: function() {
					        	   	$.messager.alert('提示','新增会员成功!');
									$('#userAdd').window('close');
									$("#userList").datagrid("reload");
									clearForm();//第二次点击新增时清除第一次新增的数据
					  			},
					  			204:function(){
					  				 	$.messager.alert('提示','修改会员成功!');
										$('#userAdd').window('close');
										$("#userList").datagrid("reload");
										clearForm();//第二次点击新增时清除第一次新增的数据
					  			},
					  			500:function(){
					  				 $.messager.alert('提示','服务器出错了!');
					  			}
				   } */
			});
		
		
	}
	function clearForm(){
		$('#content').form('reset');
	}
	
	$(function(){
    	var parent = window.parent;
    	var rowData = parent.getSelectionRow();
    	$("#content").form("load",rowData);
    	
    	/* $.ajax({
    		   type: "PUT",
    		   url: "/rest/user",
    		   data:rowData,
    		   success: function(){
    			   $.messager.alert('提示','修改会员成功!');
    			   clearForm();
    		   },
    		   error:function(){
				   $.messager.alert('提示','修改会员失败!');
			   }
    		}); */
    });
</script>