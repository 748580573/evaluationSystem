<%--
  Created by IntelliJ IDEA.
  User: Monky
  Date: 2018/2/25
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--js-->
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>


<!--css-->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
<link href="../css/jquery-ui.min.css">
<script>

    $(document).ready(function () {
        init();
        search();
    });
    function dialog(index) {
        $("#aaa").modal("toggle");
        $("#sub").off().on("click",function () {
            $("#sub").attr('disabled',"true");
            var data = $("#table").bootstrapTable('getData');
            var score = $("#score").val();
            var courseNumber = data[index].courseNumber;
            var studentNumber = data[index].studentNumber;
            var clazzNumber = data[index].clazzNumber;
            $.ajax({
                url:"http://localhost:8888/updateScore",
                method:"post",
                cache:false,
                async:false,
                data:{"courseNumber":courseNumber,"studentNumber":studentNumber,"score":score,"clazzNumber":clazzNumber},
                success:function (msg) {
                    var ob = JSON.parse(msg);
                    if(ob[0].flag != 0){
                        $('#table').bootstrapTable('load',ob);
                        $("#sub").removeAttr("disabled");
                    }else{
                        alert("输入成绩格式不对");
                    }
                },
                error:function () {
                    $("#com").removeAttr("disabled");
                }
            });
            $("#com").removeAttr("disabled");
            $("#aaa").modal("hide");
        })
    }
    function  init() {
        $("#table").bootstrapTable({
            url:"http://localhost:8888/initScore",
            method:'get',
            dataType:"json",
            search:true,
            clickToSelect: true,
            // queryParamsType : "undefined",
            /* queryParams:function (params) {
                 return {
                     pageSize:params.pageSize,
                     pageIndex:params.pageNumber,
                     name:$.trim($("#txtTitle").val())
                 }
             },*/

            columns:[
                { checkbox: true,
                    width:100
                },{
                    title:'序号',
                    width:150,
                    align:'center',
                    formatter:function (value,row,index) {
                        return index + 1;
                    }
                },{
                    title:'课程编号',
                    field:'courseNumber',
                    align:'center'
                },{
                    title:"班级编号",
                    field:"clazzNumber",
                    align:"center",
                },{
                    field:'name',
                    title:'课程名',
                    align:'center'
                },{
                    field:'studentName',
                    title:'学生名字',
                    align:'center'
                },{
                    field:'type',
                    title:'课程类型',
                    align:'center'
                },{
                    field:'score',
                    title:'成绩',
                    align:'center'
                },{
                    field:'credit',
                    title:'学分',
                    align:'center'
                },{
                    title: '操作',
                    field: 'courseNumber',
                    width:150,
                    align:'center',
                    formatter: function (value, row, index) {
                        var html = '<a href="javascript:Edit('+ index + ')">编辑</a>';
                        return html;
                    }
                }
            ]}
        );
    }
    //删除操作
    /*function Delete(value) {
        if (confirm("确定删除姓名：" + value + "吗？"))
        {
            $.ajax({
                type:"post",
                url:"http://localhost:8888/deleteStudent",
                data:{"number":value},
                success:function (msg) {
                    var ob = JSON.parse(msg);
                    $('#table').bootstrapTable('load',ob);
                }
            })
        }
    }*/
    <!-- 模态 -->
    function Edit(index) {
        dialog(index);


    }

    function search() {
        $("#com").off().on("click",function () {
            $("#com").attr('disabled',"true");
            var grade = $("#grade").val();
            var major = $("#major").val();
            var orders = $("#orders").val();
            $.ajax({
                url:"http://localhost:8888/getScoreListByClassAndSchedule",
                type:"post",
                data:{"grade":grade,"major":major,"orders":orders},
                cache:false,
                async:false,
                success:function (msg) {
                    var ob = JSON.parse(msg);
                    console.log(ob[0].courseNumber);
                    $('#table').bootstrapTable('load',ob);
                    $("#com").removeAttr("disabled");
                },
                error:function () {
                    $("#com").removeAttr("disabled");
                }
            });
        });
    }
</script>

<head>
    <title>Title</title>
</head>
<body>

<div class=".container-fluid row" style="margin-top: 2%;display: inline-block">
    <form class="form-inline" style="margin-left: 60%;width: 100%;">
        <div class="form-group">
            <input type="text" class="form-control" style="margin-left: 2%;" id="grade" placeholder="年级">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" style="margin-left: 2%;" id="major" placeholder="专业">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" style="margin-left: 2%;" id="orders" placeholder="班级">
        </div>
    </form>
</div>
<input id="com" type="submit" style="height:5%;margin-left:23%;display: inline-block" class="btn btn-default" value="查询"/>

<hr>
<!--模态框-->
<div id="aaa" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <form>
                <div class="form-group">
                    <input id="score" style="margin-left:15%;margin-right:10%;margin-top: 10%;" type="text" class="form-control col-md-8" id="exampleInputEmail1" placeholder="成绩">
                    <input id="sub" style="margin-left:30%;margin-right: 20%;margin-top: 5%;" type="button" class="form-control col-md-4 " value="提交">
                </div>

            </form>

        </div>
    </div>
</div>

<table id="table"></table>
</body>
</html>
