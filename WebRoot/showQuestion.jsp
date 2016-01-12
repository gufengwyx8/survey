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
			<s:if test="loginUser.role==@com.survey.model.User@ADMIN_ROLE">
				<a href="addQuestion?survey.id=<s:property value='survey.id'/>">添加问题</a>
			</s:if>
			<s:if test="loginUser==null">
				答题前请登录
			</s:if>
			<s:elseif test="loginUser.role==@com.survey.model.User@ADMIN_ROLE">
				管理员不能答题
			</s:elseif>
			<s:elseif test="survey.answeredUser.contains(loginUser)">
				已提交答案
			</s:elseif>
			<s:else>
				<a href="start?survey.id=<s:property value='survey.id'/>">开始答题</a>
			</s:else>
			<s:if test="loginUser.role==@com.survey.model.User@ADMIN_ROLE">
				<a href="showAnsweredUser?survey.id=<s:property value='survey.id'/>">查看已提交答案</a>
			</s:if>
		</div>
		<div>
			<table class="detail_table">
				<tr>
					<th>
						问题编号
					</th>
					<th>
						问题内容
					</th>
					<th>
						问题类型
					</th>
				</tr>
				<s:iterator value="questionList" var="q" status="i">
					<tr>
						<td>
							<s:property value="#i.index+1" />
						</td>
						<td>
							<s:property value="#q.content" />
						</td>
						<td>
							<s:property value="#q.type.toString()" />
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div>
			<a href="index">返回</a>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
