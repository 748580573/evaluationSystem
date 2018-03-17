<%--
  Created by IntelliJ IDEA.
  User: Monky
  Date: 2018/3/1
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
        $("#bt").click(function () {
            addSchedule();
        })
    });

    function addSchedule() {
        var clazzNumber = $("#clazzNumber").val();                //班级号
        var courseNumber = $("#courseNumber").val();             //课程号
        var name = $("#name").val();                             //课程姓名
        var location = $("#location").val();                     //上课地点
        var  teacherNumber = $("#teacherNumber").val();
        var teacher = $("#teacher").val();                       //任课教师
        var period = $("#period").val();                         //学期
        var credit = $("#credit").val();                         //学分
        var type = $("#type").val();
        var week = $("#time").val();                             //上课时间
        if(week == "周一"){
            week = "Mon";
        }else if(week == "周二"){
            week = "Tues"
        }else if(week == "周三"){
            week = "Wed";
        }else if(week == "周四"){
            week = "Thur";
        }else if(week == "周五"){
            week = "Fri";
        }else if(week == "周六"){
            week = "Sta";
        }else if(week == "周末"){
            week = "Sun";
        }
        var order = $("#order").val();                           //课次
        if(order == "1"){
            order = "first";
        }else if(order == "2"){
            order = "second";
        }else if(order == "3"){
            order = "thrid";
        }else if(order == "4"){
            order = "fourth";
        }else if(order == "5"){
            order = "fifth";
        }
        $.ajax({
            url:"http://localhost:8888/addSchedule",
            type:'post',
            data:{"clazzNumber":clazzNumber,"courseNumber":courseNumber,"clazzName":name,
                  "location":location,"teacherNumber":teacherNumber,"teacher":teacher,"period":period,"credit":credit,
                  "weeks":week,"orders":order,"type":type},
            success:function (msg) {
                var ob = JSON.parse(msg);
                console.log(ob);
                if(ob.isOK == 0){
                    alert("该时间段已设置课程！");
                }else{
                    alert("课程添加成功!");
                }
            }
        })
    }
</script>
<head>
    <title>课程添加</title>
</head>
<body>
<div class="table-responsive" style="border: 0px solid gainsboro">
    <div style="width: auto;height: 3%;background-color: gainsboro">课表添加</div>
    <form action="" >
        <div class="table-responsive">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td  class="rightAlign">学&ensp;&ensp;  &ensp; 期</td>
                    <td>
                        <select class="form-control col-sm-6" style="margin-left:4%;" id="period" >
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                        </select>
                    </td>
                    <td  class="rightAlign">班级编号：</td>
                    <td>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="clazzNumber" placeholder="班级编号" required>
                        </div>
                    </td>
                    <td  class="rightAlign">课程编号：</td>
                    <td>
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="courseNumber" placeholder="课程编号" required>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td  class="rightAlign">课程名：</td>
                    <td>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="name" placeholder="课程名" required>
                        </div>
                    </td>
                    <td class="rightAlign">时间：</td>
                    <td>
                        <select class="form-control col-sm-6" style="margin-left:4%;" id="time" >
                            <option>周一</option>
                            <option>周二</option>
                            <option>周三</option>
                            <option>周四</option>
                            <option>周五</option>
                            <option>周六</option>
                            <option>周末</option>
                        </select>
                    </td>
                    <td  class="rightAlign">上课地点</td>
                    <td>
                        <div class=" col-sm-8">
                            <input type="text" class="form-control" id="location" placeholder="上课地点" required>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="rightAlign">课次</td>
                    <td>
                        <select class="form-control col-sm-6" style="margin-left:4%;" id="order" >
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </td>
                    <td class="rightAlign">任课教师编号</td>
                    <td >
                        <div class="col-sm-8">
                            <input type="text" class="form-control " id="teacherNumber" placeholder="任课教师编号" required>
                        </div>
                    </td>
                    <td class="rightAlign">任课教师：</td>
                    <td>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="teacher" placeholder="任课教师" required>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="rightAlign">学分：</td>
                    <td>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="credit"  placeholder="学分" required>
                        </div>
                    </td>
                    <td class="rightAlign">学分：</td>
                    <td>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="type"  placeholder="课程类型" required>
                        </div>
                    </td>
                    <td class="rightAlign"></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="rightAlign"></td>
                    <td></td>
                    <td class="rightAlign"><button id="bt"  class="btn btn-default" onclick="studnetAdd()">提交</button></td>
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
