<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="container">
	<div class="header">
		<div class="title">
			<div>
				问卷调查系统
			</div>
		</div>
		<ul>
			<s:if test="loginUser!=null">
				<li>
					欢迎
					<s:property value="loginUser.name" />
				</li>
				<li>
					<a href="logout">安全退出</a>
				</li>
			</s:if>
			<s:else>
				<li>
					<a href="reg">注册</a>
				</li>
				<li>
					<a href="login">登录</a>
				</li>
			</s:else>
		</ul>
	</div>
	<div class="navList">
		<ul>
		</ul>
	</div>
	<div class="main">
		<div class="mainBody">