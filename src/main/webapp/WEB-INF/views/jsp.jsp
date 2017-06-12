<%@ page import="com.songlea.springboot.demo.util.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String loginUserName = SecurityUtils.getLoginUserName(request);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP模板测试</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/plugins/table-1.11.1/bootstrap-table.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/plugins/table-1.11.1/extensions/sticky-header/bootstrap-table-sticky-header.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/plugins/artDialog4.1.7/skins/black.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/html5shiv-3.7.3/html5shiv.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/respond-1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<input type="hidden" id="urlPath" value="${pageContext.request.contextPath}">
<div class="container">
    <div class="row">
        <span class="glyphicon glyphicon-star"></span> 使用的模板:<span class="lead">jsp</span>
    </div>
    <div class="row">
        <span class="glyphicon glyphicon-user"></span> 欢迎您:<%=loginUserName%>
        <div class="row">

            <!--查询条件-->
            <div class="row mt20">
                <form class="form-inline">
                    <div class="form-group">
                        <label for="name">&nbsp;&nbsp;&nbsp;名称</label>
                        <input type="text" class="form-control" id="name" placeholder="请输入名称...">
                    </div>
                    <span>&nbsp;&nbsp;&nbsp;</span>
                    <div class="form-group">
                        <label for="compareStatus">同步状态</label>
                        <select class="form-control" id="compareStatus" name="compareStatus" style="min-width:120px;">
                            <option value="-1" selected>所有</option>
                            <option value="1">新增</option>
                            <option value="2">修改</option>
                            <option value="3">删除</option>
                        </select>
                    </div>
                    <span>&nbsp;&nbsp;&nbsp;</span>
                    <div class="form-group">
                        <label for="syncStartTime">同步时间</label>
                        <input type="text" id="syncStartTime" name="syncStartTime" class="form-control input-append date form_datetime" style="min-width: 205px;">
                        <label for="syncEndTime">至</label>
                        <input type="text" id="syncEndTime" name="syncEndTime" class="form-control input-append date form_datetime" style="min-width: 205px;">
                    </div>
                    <span>&nbsp;&nbsp;&nbsp;</span>
                    <div class="form-group">
                        <button class="btn btn-info" type="button" id="selectBtn">
                            <span class="glyphicon glyphicon-search"></span> 查询
                        </button>&nbsp;&nbsp;
                        <button class="btn btn-default" type="reset">
                            <span class="glyphicon glyphicon-refresh"></span> 重置
                        </button>
                    </div>
                </form>
            </div>
            <div class="table-responsive" id="syncHostTableDiv" style="min-height: 400px; margin-top: 10px;">
                <table id="syncHostTableBody"></table>
            </div>
        </div>
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/plugins/table-1.11.1/bootstrap-table.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/plugins/table-1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/plugins/datetimepicker/bootstrap-datetimepicker.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/plugins/datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.7/plugins/table-1.11.1/extensions/sticky-header/bootstrap-table-sticky-header.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/artDialog4.1.7/artDialog.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/demo.js"></script>
</body>
</html>
