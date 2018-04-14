<%--
  Created by IntelliJ IDEA.
  User: Mr-Wu
  Date: 2017/10/24
  Time: 20:22
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

<style>
    body{
        margin: 0;
        padding:0;
        width: 100%;
        height: auto;
        background-image: url("../image/bac.jpg");
        background-size: 100% 100%;
    }

    #log_box{
        margin: 0;
        padding: 0;
        height: 380px;
        width: 380px;
        background-repeat: no-repeat;
        background-image:url("../image/blank.jpg");
        background-size: 100% auto;
        position: absolute;
        left: 35%;
        top:20%;
    }
    #lab{
        position: absolute;
        top:20%;
        font-size: 24px;
        font-family: "Microsoft YaHei UI";
        color: white;
        width: 100%;
        height: auto;
        text-align: center;
    }

    #username{
        margin: auto;
        position: absolute;
        left: 15%;
        top:40%;
        width: 100%;
        height: auto;
        font-size:16px;
    }
    #pass{
        margin: auto;
        position: absolute;
        left: 15%;
        top:60%;
        width: 100%;
        height: auto;
        font-size:16px;
    }
    #subm{
        position: absolute;
        left: 30%;
        top:75%;
    }
</style>
<script>
    $(document).ready(function () {
        login();
    });
    function login() {
        $("#subm").click(function () {
            var account = $("#user").val();
            var password = $("#pa").val();
            if (user == ""){
                alert("账号不能为空");
            }else if (password == ""){
                alert("密码不能为空")
            }else {
                $.ajax({
                    url:"http://localhost:8888/userLogin",
                    type:'post',
                    data:{"account":account,"password":password},
                    success:function(msg){
                        var ob = JSON.parse(msg);
                        if(ob.type == "学生"){
                            $(location).attr('href',"http://localhost:8888/view/studentManager.jsp");
                        }else if(ob.type == "教师"){
                            $(location).attr('href',"http://localhost:8888/view/teacherMainManager.jsp");
                        }else if(ob.type == "教务处"){
                            $(location).attr('href',"http://localhost:8888/view/studyTeacherManager.jsp");
                        }
                    }
                });
            }
        })
    }
</script>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>登陆</title>
</head>
<body >

<form id="log" method="post">
    <div id="log_box">
        <div id="lab">登&nbsp;&nbsp;&nbsp;&nbsp;陆</div>
        <div id="username">
            用户名：<input id="user" type="text" name="username" autocomplete="off">
        </div><br><br>
        <div id="pass">
            密&nbsp;&nbsp;&nbsp;&nbsp;码：<input id="pa" type="password" name="password" autocomplete="off"/>
        </div>
        <div class="container">
            <input style="margin-left: 12%;" id="subm" type="button" class="btn btn-info" value="提&nbsp;&nbsp;&nbsp;&nbsp;交">
        </div>
    </div>
</form>

</body>
</html>
