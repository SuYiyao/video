<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">


<head>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/echarts-all.js"></script>  
	</head>
	<body>
		<div class="container theme-showcase" role="main">
			<div class="jumbotron">
				<h2>统计-统计分析</h2>
			</div>
		
    <div id="main" style="height:400px"></div>
    
     <script type="text/javascript">
     var theData = "${data}".split(",");
		var theTimes = "${times}".split(",");
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main')); 
        
        var option = {
            tooltip: {
                show: true
            },
            legend: {
                data:['课程平均播放次数']
            },
            xAxis : [
                {
                    type : 'category',
                    data : theData,
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    "name":"课程平均播放次数",
                    "type":"bar",
                    "data":theTimes
                }
            ]
        };
        myChart.setOption(option); 
    </script>
    </div>
</body>

</html>