<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一定时间内，只能发送一次请求</title>
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4/themes/icon.css" />
<script type="text/javascript" src="/js/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript">
	var flag = false;
	var time = 10;
	var btn;
	function mytest(obj){
		if(!flag){
			alert("请求触发");
			flag =true;
			//setInterval循环执行的函数
			btn = setInterval("count()", 1000);
		}else{
			alert("您的操作过于频繁，请稍后再试。。。。");
		}
	}
	function count(){
		if(time >= 0){
			msg = "距离下次点击还有"+time +"s";
			$("#btn").val(msg);
			--time;
		}else{
			$("#btn").val("提交");
			clearInterval(btn);
			flag = false;
			time = 10;
		}
	}
</script>
</head>
<body>
	<input type="button" id="btn" value="提交" onclick="mytest(this)"/> 
</body>
</html>