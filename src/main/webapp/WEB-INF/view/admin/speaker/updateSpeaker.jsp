<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>jieMian</title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">视频管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="#">视频管理</a></li>
            <li class="active"><a href="#about">主讲人管理</a></li>
            <li><a href="#contact">课程管理</a></li>
            <li><a href="#contact">统计分析</a></li>
            
            
          </ul>
           <ul class="nav navbar-nav navbar-right ">
	         <li><a href="#">admin</a></li>
		     <li><a class="glyphicon glyphicon-log-out"></a></li>
		  </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>编辑主讲人-主讲人管理</h1>
      </div>
      
		<form class="form-horizontal" action="${pageContext.request.contextPath }/speaker/editSpeaker.action" method="post">
  			<div class="form-group">
    			<label for="name" class="col-sm-2 control-label">名字</label>
    			<div class="col-sm-10">
      				<input type="text" class="form-control" id="name "  placeholder="主讲人姓名" name="speakerName" value="${speaker.speakerName }">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="position" class="col-sm-2 control-label">职位</label>
    			<div class="col-sm-10">
      				<input type="text" class="form-control" id="position"  placeholder="主讲人职位" name="speakerJob" value="${speaker.speakerJob }">
    			</div>
  			</div>
  			
  			<div class="form-group">
    			<label for="picture" class="col-sm-2 control-label">头像图片</label>
    			<div class="col-sm-10">
      				<input type="text" class="form-control" id="picture"  placeholder="主讲人头像地址,网络图片" name="speakerHeadUrl" value="${speaker.speakerHeadUrl }">
    			</div>
  			</div>
  		
  			<div class="form-group">
    			<label for="about" class="col-sm-2 control-label">简介</label>
    			<div class="col-sm-10">
      				<textarea  class="form-control" id="about" name="speakerDescr">${speaker.speakerDescr }</textarea>
    			</div>
  			</div>
  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		    	<input type="hidden" name="id" value="${speaker.id }">
		    	<button type="submit" class="btn btn-primary">保存</button>
		
		      <a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
		    </div>
		  </div>
		</form>
	
	</div>	
	</body>
</html>

