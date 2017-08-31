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
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">视频管理系统</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">视频管理</a></li>
					<li><a href="#about">主讲人管理</a></li>
					<li><a href="#contact">课程管理</a></li>
					<li><a href="#contact">统计分析</a></li>


				</ul>
				<ul class="nav navbar-nav navbar-right ">
					<li><a href="#">admin</a></li>
					<li><a class="glyphicon glyphicon-log-out"></a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>编辑视频信息-视频管理</h1>
		</div>

		<form class="form-horizontal" action="${pageContext.request.contextPath }/video/editVideo.action" method="post">
			<div class="form-group">
				<label for="vidioTitle" class="col-sm-2 control-label">视频标题</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="vidioTitle"
						placeholder="视频标题" name="videoTitle" value="${video.videoTitle }">
				</div>
			</div>
			<div class="form-group">
				<label for="techer" class="col-sm-2 control-label">主讲人</label>
				<div class="col-sm-10">
					<select id="techer" class="form-control" name="speakerId">
						<option value="">请选择主讲人</option>
					<c:forEach var="sp" items="${speakerList }">
						<option value="${sp.id }" ${sp.id==video.speakerId?"selected":"" }>${sp.speakerName}</option>
					</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="course" class="col-sm-2 control-label">所属课程</label>
				<div class="col-sm-10">
					<select id="course" class="form-control" name="courseId">
					
						<option value="">请选择课程</option>
					<c:forEach var="co" items="${courseList }">
						<option value="${co.id }" ${co.id==video.courseId?"selected":"" }>${co.courseName }</option>
					</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="vidioTime" class="col-sm-2 control-label">视频时长</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="vidioTime"
						placeholder="视频时长(秒)" name="videoLength" value="${video.videoLength }">
				</div>
			</div>
			<div class="form-group">
				<label for="picture" class="col-sm-2 control-label">封面图片</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="picture"
						placeholder="视频封面图片地址,网络图片" name="videoImageUrl" value="${video.videoImageUrl }">
				</div>
			</div>
			<div class="form-group">
				<label for="vidioAddress" class="col-sm-2 control-label">视频播放地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="vidioAddress"
						placeholder="视频播放地址,网络地址" name="videoUrl" value="${video.videoUrl }">
				</div>
			</div>
			<div class="form-group">
				<label for="vidioAbout" class="col-sm-2 control-label">视频简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="vidioAbout" name="videoDescr">${video.videoDescr }</textarea>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="hidden" name="id" value="${video.id }">
					<button type="submit" class="btn btn-primary">保存</button>
					<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
				</div>
			</div>
		</form>

	</div>
</body>
</html>
