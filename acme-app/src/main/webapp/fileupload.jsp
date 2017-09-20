<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link href="static/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" />
<script  src="static/js/jquery-2.1.1.min.js"></script>
<script  src="static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<style>
	.container{
		margin-top: 15%;
		margin-left: 20%;
	}
</style>
</head>
<body>
	<div class="container">
		<form action="<%=request.getContextPath()%>/file/fileUpload" method="POST" enctype="multipart/form-data">
			File: <input type="file" name="file"/><br/>
			<input type="submit" value="上传"/>
</form>
	</div>
</body>
</html>