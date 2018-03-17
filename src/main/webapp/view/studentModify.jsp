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
        var studentNumber = getUrlParam("number");
        getDataBy();

    });

    function getDataBy() {
        $.ajax({
            url:"http://localhost:8888/selectStudentByNumber",
            type:'type',
            success:function (msg) {
                var ob = JSON.parse(msg);
                var number = ob.number;
                var name = ob.name;
                var enthic = ob.enthic;
                var sex = ob.sex;
                var institution = ob.institution;
                var major = ob.major;
                var grade = ob.grade;
                var clazzNumber = ob.clazzNumber;
                var fromSchool = ob.fromSchool;
                var phone = ob.phone;
                $("#number").val(number);
                $("#name").val(name);
                $("#enthic").val(enthic);
                $("#sex").val(sex);
                $("#institution").val(institution);
                $("#major").val(major);
                $("#grade").val(grade);
                $("#clazzNumber").val(clazzNumber);
                $("#fromSchool").val(fromSchool);
                $("#phone").val(phone);
            }
        });
    }
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }
</script>
<style>
    table td{
        border: 1px solid transparent !important;
    }
    .rightAlign{
        text-align: right;
    }
</style>
<head>
    <title>添加学生</title>
</head>
<body>
<div class="table-responsive" style="border: 0px solid gainsboro">
    <div style="width: auto;height: 3%;background-color: gainsboro">学生信息添加</div>
    <form action="" >
        <div class="table-responsive">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td  class="rightAlign">学生学号：</td>
                    <td><input id="number" type="text" readonly/></td>
                    <td  class="rightAlign" readonly>学生姓名：</td>
                    <td><input id="name" type="text" readonly/></td>
                    <td  class="rightAlign" >性&ensp;&ensp;  &ensp; 别：</td>
                    <td><input id="sex" type="text" readonly/></td>
                </tr>
                <tr>
                    <td  class="rightAlign">民&ensp;&ensp;  &ensp; 族：</td>
                    <td><input id="enthic" type="text" readonly/></td>
                    <td class="rightAlign">所属学院：</td>
                    <td><input id="institution"  type="text" readonly/></td>
                    <td  class="rightAlign">专&ensp;&ensp;  &ensp; 业：</td>
                    <td><input id="major" type="text" readonly/></td>
                </tr>
                <tr>
                    <td class="rightAlign">年&ensp;&ensp;  &ensp; 级：</td>
                    <td><input id="grade" type="text" readonly/></td>
                    <td class="rightAlign">班&ensp;&ensp;  &ensp; 级：</td>
                    <td ><input id="clazzNumber" type="text" readonly/></td>
                    <td class="rightAlign">来源学校：</td>
                    <td><input id="fromSchool" type="text" readonly/></td>
                </tr>
                <tr>
                    <td class="rightAlign">联系方式：</td>
                    <td><input id="phone" type="text" readonly/></td>
                    <td class="rightAlign"></td>
                    <td></td>
                    <td class="rightAlign"></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="rightAlign"></td>
                    <td></td>
                    <td class="rightAlign"><button id="sm"  class="btn btn-default" onclick="studnetAdd()">提交</button></td>
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
