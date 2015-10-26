
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>莆田水务集团</title>
	<link rel="stylesheet" href="<%=basePath %>resources/css/bootstrap/bootstrap.css">
</head>
<body>

	hello welcome ${user.name }
	<form action="file/upload.do" method="post" enctype="multipart/form-data">
	Desc:<input type="text" name="desc">
	file:<input type="file" name="file">
	<button class="bt btn-primary" type="submit">上传</button>
	</form>
	<script src="<%=basePath %>resources/js/bootstrap/jquery-1.11.3.min.js"></script>
	<script src="<%=basePath %>resources/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>