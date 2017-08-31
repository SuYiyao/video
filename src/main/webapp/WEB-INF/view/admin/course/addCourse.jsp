<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>jieMian</title>
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
			<h1>添加课程</h1>
		</div>

		<form class="form-horizontal" action="${pageContext.request.contextPath }/course/addCourse.action" method="post">
			<div class="form-group">
				<label for="techer" class="col-sm-2 control-label">所属学科</label>
				<div class="col-sm-10">
					<select id="techer" class="form-control" name="subjectId">
						<option>请选择学科</option>
					<c:forEach var="co" items="${list }" varStatus="status" >
						<option value="${co.id }">${ co.subjectName }</option>
					</c:forEach>	
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="position" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="position" name="courseName"
						placeholder="课程标题">
				</div>
			</div>



			<div class="form-group">
				<label for="about" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="about" name="courseDescr"></textarea>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">

					<button type="submit" class="btn btn-default">保存</button>
					<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
				</div>
			</div>
		</form>

	</div>
</body>
</html>
