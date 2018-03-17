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
<!--css-->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
<script>
    $(document).ready(function () {
        init();
    });
    function  init() {
        $("#table").bootstrapTable({
            url:"http://localhost:8888/selectTeacherStudent",
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
                    title:'学号',
                    field:'number',
                    align:'center'
                },{
                    field:'name',
                    title:'姓名',
                    align:'center'
                },{
                    field:'major',
                    title:'专业',
                    align:'center'
                },{
                    field:'grade',
                    title:'年级',
                    align:'center'
                },{
                    field:'clazzNumber',
                    title:'班级',
                    align:'center'
                },{
                    field:'institution',
                    title:'所属学院',
                    align:'center'
                },{
                    title: '操作',
                    field: 'number',
                    width:150,
                    align:'center',
                    formatter: function (value, row, index) {
                        var html = '<a href="javascript:Edit('+ value + ')">编辑</a>';
                        html += '　<a href="javascript:Delete(' + value + ')">删除</a>';
                        return html;
                    }
                }
            ]}
        );
    }
    //删除操作
    function Delete(value) {
        if (confirm("确定删除姓名：" + value + "吗？"))
        {
            $.ajax({
                type:"post",
                url:"http://localhost:8888/deleteStudent",
                data:{"number":value},
                success:function (msg) {
                    var ob = $.parseJSON(msg);
                    $('#table').bootstrapTable('load',ob);
                }
            })
        }
    }
    function Edit(value) {
        $(location).attr('href',"http://localhost:8888/view/studentModify.jsp?number=" + value);
    }
</script>
<head>
    <title>Title</title>
</head>
<body>
<table id="table"></table>
</body>
</html>
