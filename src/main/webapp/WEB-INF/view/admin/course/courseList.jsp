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
</head>
<body>
	

	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>课程列表-课程管理</h1>
		</div>



		<div class="box">
			<div>
				<a class="btn btn-primary" href="${pageContext.request.contextPath }/course/addCourse.action"">添加课程</a>
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
			<c:forEach var="courseVO" items="${page.rows }" varStatus="status">
				<tr>
					<th scope="row">${status.count+(page.page-1)*5  }</th>
					<td>${courseVO.courseName }</td>
					<td>${courseVO.subjectName }</td>
					<td>${courseVO.courseDescr}</td>
					<td><a class="glyphicon glyphicon-edit" aria-hidden="true" href="${pageContext.request.contextPath }/course/editCourse.action?id=${courseVO.id}"></a></td>
					<td><a class="glyphicon glyphicon-trash" aria-hidden="true" href="${pageContext.request.contextPath }/course/deleteCourse.action?id=${courseVO.id}"></a></td>
				</tr>
			</c:forEach>
				
			</tbody>
		</table>
		<syy:page url="${pageContext.request.contextPath }/course/courseList.action"></syy:page>
		


	</div>
</body>
</html>
