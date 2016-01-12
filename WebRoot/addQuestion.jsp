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
			<s:form action="addQuestion" method="post" cssClass="detail_table">
				<s:hidden name="survey.id" />
				<s:textfield name="question.content" label="问题内容"
					cssStyle="width:100%;"></s:textfield>
				<s:select list="@com.survey.model.Type@values()" listKey="name()"
					listValue="toString()" name="question.type" label="问题类型" />
				<s:textfield name="question.choose1" label="备选答案1"
					cssStyle="width:100%;"></s:textfield>
				<s:textfield name="question.choose2" label="备选答案1"
					cssStyle="width:100%;"></s:textfield>
				<s:textfield name="question.choose3" label="备选答案1"
					cssStyle="width:100%;"></s:textfield>
				<s:textfield name="question.choose4" label="备选答案1"
					cssStyle="width:100%;"></s:textfield>
				<s:submit value="提交"></s:submit>
			</s:form>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>
