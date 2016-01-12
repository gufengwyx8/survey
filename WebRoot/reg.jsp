<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>" />

		<title>用户注册</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>

	<body>
		<jsp:include page="top.jsp"></jsp:include>
		用户注册：
		<s:form action="reg" method="post">
			<s:textfield name="user.name" label="用户名"></s:textfield>
			<s:password name="newPassword1" label="密码"></s:password>
			<s:password name="newPassword2" label="确认密码"></s:password>
			<font color="red"><s:property value="msg" />
			</font>
			<s:submit value="注册" />
		</s:form>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
