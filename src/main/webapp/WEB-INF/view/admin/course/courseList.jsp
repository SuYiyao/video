<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="syy" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>课程管理</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath }/css/jquery-confirm.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-confirm.js"></script>
<script type="text/javascript">
function deleteInfo(id) {
	$.confirm({
		title: '提示',
	    content: '确定要删除此条记录吗?',
	    buttons: {
	        confirm: {
	        	text: '确定',
	        	action: function () {
	        		$.ajax({
	        			url:"${pageContext.request.contextPath }/admin/course/deleteCourse.action",
	        			dataType:"text",
	        			type:"post",
	        			data:{"id":id},
	        			success:function(msg){
	        				if(msg=="success"){
	        					location.reload();
	        				}
	        			}
	        		});
	        	}
	        },
	        cancel: { 
	        	text: '取消',
	        	function () {
	        	},
	    	}
	    }
		
	});
}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/view/admin/header.jsp">
		<jsp:param value="course" name="fromJsp"/>
	</jsp:include>
	<div class="container theme-showcase" role="main">
		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>课程列表-课程管理</h1>
		</div>
		<div class="box">
			<div>
				<a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/course/addCourse.action"">添加课程</a>
			</div>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th class="col-md-0">序号</th>
					<th class="col-md-1">标题</th>
					<th class="col-md-1">学科</th>
					<th class="col-md-10">简介</th>
					<th class="col-md-1">编辑</th>
					<th class="col-md-1">删除</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${not empty page.rows }">
			<c:forEach var="courseVO" items="${page.rows }" varStatus="status">
				<tr>
					<th scope="row">${status.count+(page.page-1)*5  }</th>
					<td>${courseVO.courseName }</td>
					<td>${courseVO.subjectName }</td>
					<td>${courseVO.courseDescr}</td>
					<td><a class="glyphicon glyphicon-edit" aria-hidden="true" href="${pageContext.request.contextPath }/admin/course/editCourse.action?id=${courseVO.id}"></a></td>
					<td><a class="glyphicon glyphicon-trash" aria-hidden="true" href="#" onclick="deleteInfo(${courseVO.id})"></a></td>
				</tr>
			</c:forEach>
			</c:if>
			<c:if test="${empty page.rows }">
 				<tr><td>当前查询结果为空!</td></tr>
 			</c:if>
			</tbody>
		</table>
		<syy:page url="${pageContext.request.contextPath }/admin/course/courseList.action"></syy:page>
	</div>
</body>
</html>
