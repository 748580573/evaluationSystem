<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
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

    //初始化
    function  init() {
        $("#table").bootstrapTable({
            url:"http://localhost:8888/test",
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
                    field:'name',
                    title:'Name',
                    align:'center'
                },{
                    field:'price',
                    title:'Price',
                    align:'center'
                },{
                    title: '操作',
                    field: 'bookId',
                    width:150,
                    align:'center',
                    formatter: function (value, row, index) {
                        var html = '<a href="javascript:EditBook('+ value + ')">编辑</a>';
                        html += '　<a href="javascript:DeleteBook(' + value + ')">删除</a>';
                        return html;
                    }
                }
            ]}
        );
    }
    //编辑操作
    function EditBook(bookId){

        alert("编辑操作，姓名：" + bookId);
    }
    //删除操作
    function DeleteBook(bookId) {
        if (confirm("确定删除姓名：" + bookId + "吗？"))
        {
            alert("执行删除操作");
        }
    }
    
    
    function SearchData() {
        $.ajax({
            type:'post',
            url:"http://localhost:8888/hello",
            data:{"test":"hello"},
            success:function (msg) {
                var ob = JSON.parse(msg);
                $('#table').bootstrapTable('load',ob);
            }
        });
    }
</script>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="#">Logo</a>

    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#">Link 1</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link 2</a>
        </li>

        <!-- Dropdown -->
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                Dropdown link
            </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Link 1</a>
                <a class="dropdown-item" href="#">Link 2</a>
                <a class="dropdown-item" href="#">Link 3</a>
            </div>
        </li>
    </ul>
    <form class="form-inline" style="position: relative;left: 60%;margin: 1px;">
        <input class="form-control" type="text" placeholder="Search">
        <button class="btn btn-success" type="button">Search</button>
    </form>
</nav>
<br>

<div class="container body-content" style="padding-top:20px;">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form class="form-inline">
                <div class="row">
                    <div class="col-sm-8">
                        <label class="control-label">图书名称：</label>
                        <input id="txtTitle" type="text" class="form-control"/>
                    </div>
                </div>

                <div class="row " style="margin-top:20px;">
                    <div class="col-sm-12">
                        <input id="query" class="btn btn-primary" type="button" value="查询" onclick="SearchData()" >
                    </div>
                </div>
            </form>
        </div>
    </div>

    <table id="table"></table>
</div>
</body>
</html>
