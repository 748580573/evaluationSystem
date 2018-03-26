<%--
  Created by IntelliJ IDEA.
  User: Monky
  Date: 2018/3/26
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>

<script>
    $(document).ready(function () {
        $("#sub").click(function () {
            var number = $("#number").val();
            var oldPassword = $("#oldPassword").val();
            var newPassword = $("#newPassword").val();
            $.ajax({
                url:"http://localhost:8888/updatePassword",
                type:"post",
                data:{"number":number,"oldPassword":oldPassword,"newPassword":newPassword},
                success:function (msg) {
                    var ob = JSON.parse(msg);
                    if (ob.isOK == "0"){
                        alert("修改失败");
                    }else{
                        alert("修改成功");
                    }
                }
            })
        })
    })
</script>

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
<link href="../css/jquery-ui.min.css">
<head>
    <title>Title</title>
</head>
<body>
<br><br>
<div>
    <form class="col-sm-4" style="left: 30%;">
        <div class="form-group col-sm-6">
            <label for="number">用户名</label>
            <input type="text" class="form-control" id="number" placeholder="用户名" autocomplete="off">
        </div>
        <div class="form-group col-sm-6">
            <label for="oldPassword">旧密码</label>
            <input type="password" class="form-control" id="oldPassword" placeholder="密码">
        </div>
        <div class="form-group col-sm-6">
            <label for="newPassword">新密码</label>
            <input type="password" class="form-control" id="newPassword" placeholder="密码">
        </div>
    </form>
    <input id="sub" class="btn btn-default" type="button" value="提交" style="margin-left:37%;"/>
</div>
</body>
</html>
