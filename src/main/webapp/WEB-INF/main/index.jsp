<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" /> 
    </head>
    <body class="index">
        <!--导航区域开始-->
        <div id="index_navi">
            <!-- jstl 中有可以替代 include的标签 -->
			<%-- <%@include file="../nav.jsp" %> --%>
			<c:import url="../nav.jsp"></c:import>
            
        </div>
    </body>
</html>
