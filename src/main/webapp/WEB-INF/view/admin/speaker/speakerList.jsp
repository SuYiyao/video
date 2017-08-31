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
			<h1>主讲人列表-主讲人管理</h1>
		</div>



		<div class="box">

			<a class="btn btn-primary" type="button" href="${pageContext.request.contextPath }/speaker/addSpeaker.action">添加主讲人</a>


			<div style="float: right;">
				<form class="form-inline" action="${pageContext.request.contextPath }/speaker/speakerList.action">

					<div class="form-group">
						<label for="name">名称</label> <input type="text"
							class="form-control" id="name" placeholder="主讲人名称" name="nameKey" value="${nameKey }">

					</div>
					<div class="form-group">
						<label for="position">职位</label> <input type="text"
							class="form-control" id="position" placeholder="主讲人职位" name="positionKey" value="${positionKey }">

					</div>





					<input class="btn btn-primary" type="submit" value="查询">

				</form>
			</div>


		</div>






		<table class="table table-hover">
			<thead>
				<tr>
					<th class="col-md-0">序号</th>
					<th class="col-md-1">名称</th>
					<th class="col-md-1">职位</th>
					<th class="col-md-10">简介</th>

					<th class="col-md-0">编辑</th>
					<th class="col-md-0">删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="speaker" items="${page.rows }" varStatus="status">
				<tr>
					<td scope="row">${status.count+(page.page-1)*5 }</td>
					<td>${speaker.speakerName }</td>
					<td>${speaker.speakerJob }</td>
					<td>${speaker.speakerDescr}</td>
					<td><a class="glyphicon glyphicon-edit" aria-hidden="true" href="${pageContext.request.contextPath }/speaker/editSpeaker.action?id=${speaker.id}"></a></td>
					<td><a class="glyphicon glyphicon-trash" aria-hidden="true" href="${pageContext.request.contextPath }/speaker/deleteSpeaker.action?id=${speaker.id}"></a></td>
				</tr>
			</c:forEach>


			</tbody>
		</table>
		<syy:page url="${pageContext.request.contextPath }/speaker/speakerList.action"></syy:page>


	</div>
</body>
</html>
