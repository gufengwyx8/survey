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
			<s:form action="start" method="post" theme="simple">
				<s:hidden name="survey.id" />
				<s:iterator value="questionList" var="q" status="i">
					<s:hidden name="answerList[%{#i.index}].question.id"
						value="%{#q.id}" />
					<div style="margin: 20px 0;">
						<div>
							<s:property value="#i.index+1+'、'" />
							<s:property value="#q.content" />
						</div>
						<s:if test="#q.type==@com.survey.model.Type@ONE">
							<s:radio list="{#q.choose1,#q.choose2,#q.choose3,#q.choose4}"
								name="answerList[%{#i.index}].content"></s:radio>
						</s:if>
						<s:elseif test="#q.type==@com.survey.model.Type@MANY">
							<s:checkbox name="answerList[%{#i.index}].content"
								fieldValue="%{#q.choose1}"></s:checkbox>
							<s:property value="#q.choose1" />
							<s:checkbox name="answerList[%{#i.index}].content"
								fieldValue="%{#q.choose2}"></s:checkbox>
							<s:property value="#q.choose2" />
							<s:checkbox name="answerList[%{#i.index}].content"
								fieldValue="%{#q.choose3}"></s:checkbox>
							<s:property value="#q.choose3" />
							<s:checkbox name="answerList[%{#i.index}].content"
								fieldValue="%{#q.choose4}"></s:checkbox>
							<s:property value="#q.choose4" />
						</s:elseif>
						<s:elseif test="#q.type==@com.survey.model.Type@TEXT">
							<s:textfield name="answerList[%{#i.index}].content" />
						</s:elseif>
					</div>
				</s:iterator>
				<s:submit value="提交" />
			</s:form>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
