<%--
  Created by IntelliJ IDEA.
  User: Monky
  Date: 2018/2/27
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--js-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<!--css-->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
<script>
    $(document).ready(function () {
        go();
    })
    //跳转页面
    function go() {
        $("#classManager").click(function () {
            $("#ifm").attr("src","http://localhost:8888/view/clazzInfo.jsp");
        });
        $("#scheduleManager").click(function () {
            $("#ifm").attr("src","http://localhost:8888/view/scheduleAdd.jsp");
        });
        $("#peopleInfo").click(function () {
            $("#ifm").attr("src","http://localhost:8888/view/studentScoreModify.jsp");
        });
        $("#addStudent").click(function () {
            $("#ifm").attr("src","http://localhost:8888/view/studentAdd.jsp");
        });
        $("#addTeacher").click(function () {
            $("#ifm").attr("src","http://localhost:8888/view/teacherAdd.jsp");
        });
        $("#allTeacher").click(function () {
            $("#ifm").attr("src","http://localhost:8888/view/teacherSelectAll.jsp");
        });
        $("#mulitScore").click(function () {
            $("#ifm").attr("src","http://localhost:8888/view/studentMulitScore.jsp");
        });
    }
    $("#passModify").click(function () {
        $("#ifm").attr("src","http://localhost:8888/view/userPasswordModify.jsp");
    });
</script>
<head>
    <title>教务处</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="#">Logo</a>

    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a id="classManager" class="nav-link" href="#">班级管理</a>
        </li>
        <li  class="nav-item">
            <a id="scheduleManager" class="nav-link" href="#">课程管理</a>
        </li>
        <li id="mulitScore" class="nav-item">
            <a class="nav-link" href="#">综测成绩</a>
        </li>
        <li id="passModify" class="nav-item">
            <a class="nav-link" href="#">密码修改</a>
        </li>


        <!-- Dropdown -->
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                人员管理
            </a>
            <div class="dropdown-menu">
                <a id="allTeacher" class="dropdown-item" href="#">教师管理</a>
                <a id="addStudent" class="dropdown-item" href="#">学生管理</a>
                <a id="addTeacher" class="dropdown-item" href="#">教师添加</a>
            </div>
        </li>
    </ul>
    <form class="form-inline" style="position: relative;left: 60%;margin: 1px;">
        <input class="form-control" type="text" placeholder="Search">
        <button class="btn btn-success" type="button">Search</button>
    </form>
</nav>
<hr>
<div class="container-fluid" style="width: 100%;">
    <iframe id="ifm" width="100%" height="80%" src=""></iframe>
</div>
</body>
</html>
