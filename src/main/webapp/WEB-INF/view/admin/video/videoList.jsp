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
<title>视频管理</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/jquery-confirm.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-confirm.js"></script>

<script type="text/javascript">
var count = 0;
function allCheck(m){
	$("input[name=choose]").prop("checked",m.checked);
	if(m.checked){
		count = $("input[name=choose]").length;
	}else{
		count = 0;
	}
	$("span")[0].innerHTML=count;
}
function deleteInfo(id){
	  /* var orConfirm = confirm("确定要删除此条记录吗?");
	   return (orConfirm);
	   //第一个参数表示提示框的标题,第二个参数表示框中文本框的内容,两个都可以省略
	   //返回值表示提示框中的输入框内容,只有点击确定以后才会进行返回 */
	$.confirm({
	    title: '提示',
	    content: '确定要删除此条记录吗?',
	    buttons: {
	        confirm: {
	        	text: '确定',
	        	action: function () {
	        		$.ajax({
	        			url:"${pageContext.request.contextPath }/video/deleteVideo.action",
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

	
	
function deleteAll(){
	if(count == 0){
		$.alert({
		    title: '警告',
		    content: '没有选中项',
		});
		return;
	}
	$.confirm({
	    title: '提示',
	    content: '看清楚哦,可是全部删除',
	    buttons: {
	        confirm: {
	        	text: '非常肯定',
	        	action: function () {
	        		$("#deleteAll").submit();
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
function selectBox(the){
	//alert(count);
	if(the.checked){
		count++;
	}else{
		count--;
	}
	$("span")[0].innerHTML=count;
	if(count == $("input[name=choose]").length){
		$("#checkAll").prop("checked",true);
	}else{
		$("#checkAll").prop("checked",false);
	}
}

</script>


</head>
<body>
	<div class="container theme-showcase" role="main">
		<div class="jumbotron">
			<h1>视频列表-视频管理</h1>
		</div>
		<div class="box">
			<a class="btn btn-primary" type="button" href="${pageContext.request.contextPath }/video/addVideo.action">添加视频</a>
			<a class="btn btn-primary" type="button" onclick="deleteAll()">
				批量删除<span class="badge">0</span>
			</a>
			<div style="float: right;">
				<form class="form-inline" action="${pageContext.request.contextPath }/video/videoList.action">
					<input type="text" class="form-control" placeholder="视频标题" name="videoTitle" value="${videoTitle}">
					<select class="form-control" name="speakerId">
						<option value="0">请选择主讲人</option>
					<c:forEach var="speaker" items="${speakerList }" varStatus="status">
						<option value="${ speaker.id}" ${speakerId==speaker.id ? "selected":"" }>${speaker.speakerName }</option>
					</c:forEach>
					</select> 
					<select class="form-control" name="courseId">
						<option value="0">请选择课程</option>
					<c:forEach var="course" items="${courseList }" varStatus="status">
						<option value="${course.id }" ${courseId==course.id ? "selected":"" }>${course.courseName }</option>
					</c:forEach>
					</select>
					<button class="btn btn-primary" type="submit">查询</button>
				</form>
			</div>
		</div>
		<form action="${pageContext.request.contextPath }/video/deleteAllVideo.action" id="deleteAll">
		<table class="table table-hover">
			<thead>
			
				<tr>
					<th class="col-md-0"><input type="checkbox" id="checkAll" onclick="allCheck(this)"></th>
					<th class="col-md-0">序号</th>
					<th class="col-md-1">标题</th>
					<th class="col-md-8">介绍</th>
					<th class="col-md-1">讲师</th>
					<th class="col-md-1">课程</th>
					<th class="col-md-1">时长(秒)</th>
					<th class="col-md-0">播放次数</th>
					<th class="col-md-0">编辑</th>
					<th class="col-md-0">删除</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${not empty page.rows }">
			<c:forEach var="video" items="${page.rows }" varStatus="status">
				<tr>
					<th><input type="checkbox" name="choose" value="${video.id }" onclick="selectBox(this)"></th>
					<th scope="row">${status.count+(page.page-1)*5 }</th>
					<td>${video.videoTitle }</td>
					<td>${video.videoDescr }</td>
					<td>${video.sName }</td>
					<td>${video.cName }</td>
					<td>${video.videoLength }</td>
					<td>${video.videoPlayTimes }</td>
					<td><a class="glyphicon glyphicon-edit" aria-hidden="true" href="${pageContext.request.contextPath }/video/editVideo.action?id=${video.id}"></a></td>
					<td><a class="glyphicon glyphicon-trash" aria-hidden="true" href="#" onclick="deleteInfo(${video.id})"></a></td>
				</tr>
			</c:forEach>
			</c:if>
			<c:if test="${empty page.rows }">
 				<tr><td>当前查询结果为空!</td></tr>
 			</c:if>
			</tbody>
		</table>
		</form>
		<syy:page url="${pageContext.request.contextPath }/video/videoList.action"></syy:page>
	</div>
</body>
</html>
