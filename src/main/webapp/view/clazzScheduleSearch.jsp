<%--
  Created by IntelliJ IDEA.
  User: Monky
  Date: 2018/2/26
  Time: 16:57
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
<!--MF为第一节 MS为第二节 AT为第三节 AF为第四节 NF为第五节 -->
<script>
    $(document).ready(function () {
        var clazzNumber = getUrlParam("clazzNumber");
        var period = getUrlParam("period");
        initTable(clazzNumber,period);
    });

    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }

    function initTable(clazzNumber,period) {
        $.ajax({
            url:"http://localhost:8888/selectScheduleByClazzNumberAndPeriod",
            type:'post',
            data:{"clazzNumber":clazzNumber,"period":period},
            success:function (msg) {
                var ob = JSON.parse(msg);
                ob.forEach(function (t) {
                    var info;
                    if (t.weeks == "Mon"){
                        if(t.orders == "first"){
                            info = t.clazzName + "\n\t" + t.location + "\n" + t.teacher;
                            $("#MonMF").text(info);
                        }
                        if(t.orders == "second"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#MonMS").text(info);
                        }
                        if(t.orders == "thrid"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#MonAT").text(info);
                        }
                        if(t.orders == "fourth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#MonAF").text(info);
                        }
                        if(t.orders == "fifth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#MonNF").text(info);
                        }
                    }
                    if (t.weeks == "Tues"){
                        if(t.orders == "first"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#TuesMF").text(info);
                        }
                        if(t.orders == "second"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#TuesMS").text(info);
                        }
                        if(t.orders == "thrid"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#TuesAT").text(info);
                        }
                        if(t.orders == "fourth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#TuesAF").text(info);
                        }
                        if(t.orders == "fifth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#TuesNF").text(info);
                        }
                    }
                    if (t.weeks == "Wed"){
                        if(t.orders == "first"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#WedMF").text(info);
                        }
                        if(t.orders == "second"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#WedMS").text(info);
                        }
                        if(t.orders == "thrid"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#WedAT").text(info);
                        }
                        if(t.orders == "fourth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#WedAF").text(info);
                        }
                        if(t.orders == "fifth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#WedNF").text(info);
                        }
                    }
                    if (t.weeks == "Thur"){
                        if(t.orders == "first"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#ThurMF").text(info);
                        }
                        if(t.orders == "second"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#ThurMS").text(info);
                        }
                        if(t.orders == "thrid"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#ThurAT").text(info);
                        }
                        if(t.orders == "fourth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#ThurAF").text(info);
                        }
                        if(t.orders == "fifth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#ThurNF").text(info);
                        }
                    }
                    if (t.weeks == "Fri"){
                        if(t.orders == "first"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#FriMF").text(info);
                        }
                        if(t.orders == "second"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#FriMS").text(info);
                        }
                        if(t.orders == "thrid"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#FriAT").text(info);
                        }
                        if(t.orders == "fourth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#FriAF").text(info);
                        }
                        if(t.orders == "fifth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#FriNF").text(info);
                        }
                    }
                    if (t.weeks == "Sta"){
                        if(t.orders == "first"){
                            info = t.clazzName + "\n" + t.location + "\n" +t.teacher;
                            $("#SatMF").text(info);
                        }
                        if(t.orders == "second"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#StaMS").text(info);
                        }
                        if(t.orders == "thrid"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#StaAT").text(info);
                        }
                        if(t.orders == "fourth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#StaAF").text(info);
                        }
                        if(t.orders == "fifth"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#StaNF").text(info);
                        }
                    }
                    if (t.weeks == "Sun"){
                        if(t.orders == "first"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#SunMF").text(info);
                        }
                        if(t.orders == "second"){
                            info = t.clazzName + "\n" + t.location + "\n" + t.teacher;
                            $("#SunMS").text(info);
                        }
                        if(t.orders == "thrid"){
                            info = t.clazzName + "\n" + t.location + "\n" +  + t.teacher;
                            $("#SunAT").text(info);
                        }
                        if(t.orders == "fourth"){
                            info = t.clazzName + "\n" + t.location + "\n" +  + t.teacher;
                            $("#SunAF").text(info);
                        }
                        if(t.orders == "fifth"){
                            info = t.clazzName + "\n" + t.location + "\n" +  + t.teacher;
                            $("#SunNF").text(info);
                        }
                    }
                })
            }
        })
    }
</script>
<style>
    .table-bordered th,
    .table-bordered td {
        border: 1px solid #000 !important;
    }
</style>
<head>
    <title>学生课表</title>
</head>
<body>
<div class="table-responsive" style="border: 2px solid gainsboro">
    <form action=""  >
        <div class="table-responsive">
            <table class="table table-bordered " style="margin-top:30px;">
                <caption>
                    <h2 style="margin-top:40px; color:white;" align="center">课程表</h2>
                </caption>
                <thead>
                <tr>
                    <td colspan="2"   align="center" valign="middle">时间</td>
                    <td colspan="5" align="center" valign="middle">上课</td>
                    <td colspan="2" align="center" valign="middle">休息</td>

                </tr>
                </thead>
                <tbody>
                <tr >
                    <td></td>
                    <td></td>

                    <td align="center" valign="middle">星期一</td>
                    <td align="center" valign="middle">星期二</td>
                    <td align="center" valign="middle">星期三</td>
                    <td align="center" valign="middle">星期四</td>
                    <td align="center" valign="middle">星期五</td>
                    <td align="center" valign="middle">星期六</td>
                    <td align="center" valign="middle">星期日</td>
                </tr>
                <tr >
                    <td rowspan="4" valign="middle" align="center">上午</td>
                    <td align="center" valign="middle">第1节</td>
                    <td id="MonMF" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="TuesMF" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="WedMF" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="ThurMF" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="FriMF" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="SatMF" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="SunMF" rowspan="2" align="center" valign="middle">休息</td>
                </tr>
                <tr>
                    <td align="center" valign="middle">第2节</td>
                </tr>
                <tr >
                    <td align="center" valign="middle">第3节</td>
                    <td id="MonMS" rowspan="2"  align="center" valign="middle">休息</td>
                    <td id="TuesMS" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="WedMS" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="ThurMS" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="FriMS" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="SatMS" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="SunMS" rowspan="2" align="center" valign="middle">休息</td>
                </tr>
                <tr>
                    <td align="center" valign="middle">第4节</td>
                </tr>

                <tr >
                    <td rowspan="4" valign="middle" align="center">下午</td>
                    <td align="center" valign="middle">第5节</td>
                    <td id="MonAT" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="TuesAT" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="WedAT" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="ThurAT" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="FriAT" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="SatAT" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="SunAT" rowspan="2" align="center" valign="middle">休息</td>
                </tr>
                <tr>
                    <td align="center" valign="middle">第6节</td>
                </tr>
                <tr >
                    <td align="center" valign="middle">第7节</td>
                    <td id="MonAF" rowspan="2"  align="center" valign="middle">休息</td>
                    <td id="TuesAF" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="WedAF" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="ThurAF" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="FirAF" align="center" rowspan="2" valign="middle">休息</td>
                    <td id="SatAF" rowspan="2" align="center" valign="middle">休息</td>
                    <td id="SunAF" rowspan="2" align="center" valign="middle">休息</td>
                </tr>
                <tr>
                    <td align="center" valign="middle">第8节</td>
                </tr>
                <tr >
                    <td rowspan="4" valign="middle" align="center">晚上</td>
                    <td align="center" valign="middle">第9节</td>
                    <td id="MonNF" rowspan="3" align="center" valign="middle">休息</td>
                    <td id="TuesNF" rowspan="3" align="center" valign="middle">休息</td>
                    <td id="WedNF" align="center" rowspan="3" valign="middle">休息</td>
                    <td id="ThurNF" align="center" rowspan="3" valign="middle">休息</td>
                    <td id="FirNF" align="center" rowspan="3" valign="middle">休息</td>
                    <td id="SatNF" align="center" rowspan="3" valign="middle">休息</td>
                    <td id="SunNF" align="center" rowspan="3" valign="middle">休息</td>
                </tr>
                <tr>
                    <td align="center" valign="middle">第10节</td>
                </tr>
                <tr >
                    <td align="center" valign="middle">第11节</td>
                </tr>


                </tbody>
            </table>
        </div>
    </form>
</div>
</body>
</html>
