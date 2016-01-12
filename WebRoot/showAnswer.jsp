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
		<script type="text/javascript" src="js/jquery-min.js"></script>
	</head>

	<body>
		<jsp:include page="top.jsp"></jsp:include>
		<div>
			<div>
				用户编号：<s:property value="user.id"/>
				用户名：<s:property value="user.name"/>
			</div>
			<s:iterator value="answerList" var="a" status="i">
				<div style="margin: 20px 0;">
					<div>
						<s:property value="#i.index+1+'、'" />
						<s:property value="#a.question.content" />
						(<s:property value="#a.question.type"/>)
					</div>
					<div>
						答案:<s:property value="#a.content"/>
					</div>
				</div>
			</s:iterator>
		</div>
		<div><a href="showAnsweredUser?survey.id=<s:property value='survey.id'/>">返回</a></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
