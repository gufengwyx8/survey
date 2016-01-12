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

		<title>主页</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>

	<body>
		<jsp:include page="top.jsp"></jsp:include>
		修改密码：
		<s:form action="password" method="post">
			<s:password name="oldPassword" label="旧密码"></s:password>
			<s:password name="newPassword1" label="新密码"></s:password>
			<s:password name="newPassword2" label="新密码"></s:password>
			<font color="red"><s:property value="msg" />
			</font>
			<s:submit value="修改" />
		</s:form>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
