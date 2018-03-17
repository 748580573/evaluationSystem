<%--
  Created by IntelliJ IDEA.
  User: Monky
  Date: 2018/2/27
  Time: 17:22
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
        init();
    });
    function  init() {
        $("#table").bootstrapTable({
            url:"http://localhost:8888/selectStudentMulitScore",
            method:'get',
            dataType:"json",
            search:true,
            clickToSelect: true,
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
                    field:'name',
                    title:'课程名',
                    align:'center'
                },{
                    field:'type',
                    title:'课程类型',
                    align:'center'
                },{
                    field:'score',
                    title:'成绩',
                    align:'center'
                },
            ]}
        );
    }
</script>
<head>
    <title>综测成绩查询</title>
</head>
<body>
<table id="table"></table>
</body>
</html>
