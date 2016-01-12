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
			<table class="detail_table">
				<tr>
					<td>
						问卷标题
					</td>
					<td>
						<s:property value="survey.title" />
					</td>
				</tr>
				<tr>
					<td>
						问卷描述
					</td>
					<td>
						<s:property value="survey.description" />
					</td>
				</tr>
				<tr>
					<td>
						发布时间
					</td>
					<td>
						<s:date name="survey.date" format="yyyy-MM-dd" />
					</td>
				</tr>
			</table>
		</div>
		<div>
			<table class="detail_table">
				<tr>
					<th>
						用户编号
					</th>
					<th>
						用户名
					</th>
					<th>
						用户类型
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="survey.answeredUser" var="u" status="i">
					<tr>
						<td>
							<s:property value="#i.index+1" />
						</td>
						<td>
							<s:property value="#u.name" />
						</td>
						<td>
							<s:property value="#u.role" />
						</td>
						<td>
							<a href="showAnswer?survey.id=<s:property value='survey.id'/>&user.id=<s:property value='#u.id'/>">查看答案</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div><a href="showQuestion?survey.id=<s:property value='survey.id'/>">返回</a></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
