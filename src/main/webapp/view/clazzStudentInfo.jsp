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
        var clazzNumber = getUrlParam("number");
        $("#table").bootstrapTable({
            url:"http://localhost:8888/selectStudentByClazzNumber?clazzNumber=" + clazzNumber,
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
                        var html = '<a href="javascript:Edit('+ index + ')">查看</a>';
                        return html;
                    }
                }
            ]}
        );
    }

    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }


    function Edit(index) {
        var data = $("#table").bootstrapTable('getData');
        var studentNumber = data[index].number;
        $(location).attr('href',"http://localhost:8888/view/clazzAStuentScore.jsp?studentNumber=" + studentNumber);
    }
</script>
<head>
    <title>班级学生信息</title>
</head>
<body>
<table id="table"></table>
</body>
</html>
