<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>login</title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.min.js"></script>
		
		<script type="text/javascript">
$(function(){
	$("#checkForm").validate({
		rules:{
			loginName:{
				required:true
			},
			loginPwd:{
				required:true
			} 
		},
		messages:{
			loginName:{
				required:"用户名不能为空"
			},
			loginPwd:{
				required:"请输入密码"
			}
		}
	});
});


</script>
		
		
	</head>
	<body>	
		<div style="margin: auto; padding-top: 250px; width: 300px; height: 300px;">
		<img src="${pageContext.request.contextPath }/img/logo.png" />
		<form action="${pageContext.request.contextPath }/admin/login.action" id="checkForm">
			<div class="form-group">
    			<input type="text" class="form-control" name="loginName" value="admin" placeholder="用户名">
  			</div>
  			<div class="form-group">
    			<input type="password" class="form-control" name="loginPwd" value="admin" placeholder="登录密码">
  			</div>
  			
  			<div >
				<button type="submit" class="form-control btn btn-success">登录</button>
			</div>
		</form>
		</div>
	</body>

</html>