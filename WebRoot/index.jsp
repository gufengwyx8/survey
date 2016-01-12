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
		<s:if test="loginUser.role==@com.survey.model.User@ADMIN_ROLE">
			<div>
				<a href="addSurvey">添加问卷</a>
			</div>
		</s:if>
		<div>
			<table class="detail_table">
				<tr>
					<th>
						问卷编号
					</th>
					<th>
						问卷标题
					</th>
					<th>
						发布时间
					</th>
				</tr>
				<s:iterator value="surveyList" var="s">
					<tr>
						<td>
							<s:property value="#s.id" />
						</td>
						<td>
							<s:property value="#s.title" />
						</td>
						<td>
							<s:date name="#s.date" format="yyyy-MM-dd" />
						</td>
						<td>
							<a href="showQuestion?survey.id=<s:property value='#s.id'/>">查看</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
