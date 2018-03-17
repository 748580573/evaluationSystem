<%--
  Created by IntelliJ IDEA.
  User: Monky
  Date: 2018/2/25
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--js-->
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<!--css-->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
<script>
    $(document).ready(function () {
        $("#sm").click(function () {
            teacherAdd();
        })
    });

    function teacherAdd() {
        var number = $("#number").val();
        var name = $("#name").val();
        var sex = $("#sex").val();
        var institution = $("#institution").val();
        var major = $("#major").val();
        var phone = $("#phone").val();
        $.ajax({
            url:"http://localhost:8888/addTeacher",
            type:"post",
            data:{"number":number,"name":name,"sex":sex,
                "institution":institution,"major":major,"phone":phone},
            success:function (msg) {
                var ob = $.parseJSON(msg);
                if(ob[0].flag.eq(1)){
                    alert("添加成功");
                }else {
                    alert("添加失败");
                }
            }
        });
    }

</script>
<style>
    table td{
        border: 1px solid transparent !important;
    }
</style>
<head>
    <title>添加教师</title>
</head>
<body>
<div class="table-responsive" style="border: 0px solid gainsboro">
    <form action="" >
        <div class="table-responsive">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td  class="rightAlign">教工号：</td>
                    <td><input id="number" type="text"/></td>
                    <td  class="rightAlign">教师姓名：</td>
                    <td><input id="name" type="text"/></td>
                    <td  class="rightAlign">性&ensp;&ensp;  &ensp; 别：</td>
                    <td><input id="sex" type="text"/></td>
                </tr>
                <tr>
                    <td  class="rightAlign">联系方式：</td>
                    <td><input id="phone" type="text"/></td>
                    <td class="rightAlign">所属学院：</td>
                    <td><input id="institution"  type="text"/></td>
                    <td  class="rightAlign">专&ensp;&ensp;  &ensp; 业：</td>
                    <td><input id="major" type="text"/></td>
                </tr>
                <tr>
                    <td class="rightAlign"></td>
                    <td></td>
                    <td class="rightAlign"><button id="sm"  class="btn btn-default">提交</button></td>
                    <td><button type="reset" class="btn btn-default">重置</button></td>
                    <td class="rightAlign"></td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>
</body>
</html>
