/**
 * Created by 朱翰林 on 2018/7/23.
 */

var pageSize = 4;//设置每页显示条数
var total;

$("#oid").hide();
//数据总条数
//alert(total);
$("#shijianfw").hide();
var index = 1;
$(function () {
    // alert("初始化开始！1")
    funchaxun(index);//分页初始化

});

//根据不同状态显示不同单选框
$(function () {
    $("input[name='shijian']").click(function () {
        if ($(this).val() == 1) {
            // $("#createtime").hide();
           // $("input[name='radio2']:first").attr("checked",false);
            $("#start").val("");
            $("#end").val("");
            $('#start').attr("disabled",true);
            $('#end').attr("disabled",true);
            $("#shijianfw").show();
        } else {
           // $("input[name='radio2']").val("");
          //  alert( $("input:radio:first").val());
          //  $("input:radio:first").attr("checked","checked");
          //  alert(  $("input[name='radio2']:first").val());
            $("input[name='radio2']").removeAttr("checked");


            $('#start').attr("disabled",false);
            $('#end').attr("disabled",false);
            $("#createtime").show();

            $("#shijianfw").hide();
        }
    });
});


//审核字数动态显示
$("#textarea").keydown(function () {
    var max = 50;
    var value = $(this).val();//获取文本框的字符数

    var coun = $("#contentCountLeft");//获取字数显示对象
    if (value.length > max) {
        $(this).val(value.substring(0, max));
        coun.html(0);

    } else {
        coun.html(max - value.length);

    }

}).keyup(function () {

    var max = 50;
    var value = $(this).val();
    var coun = $("#contentCountLeft");
    if (value.length > max) {
        $(this).val(value.substring(0, max));
        coun.html(0);
    } else {

        coun.html(max - value.length);

    }

});


function PageCallback(index, jq) { //前一个表示当前点击的那个分页的页数索引值，后一个参数表示装载容器。
    funchaxun(index);
}


//加班信息搜索
function funchaxun(index) {
    // alert("111111");
    $("#tbs").empty();
    var sidOrSname = $("#sidOrSname").val();
    var udeOrUname = $("#udeOrUname").val();
    var start = $.trim($("#start").val());
    var end = $.trim($("#end").val());
    var radio1 = $("input[name='radio1']:checked").val();
    var radio2 = $("input[name='radio2']:checked").val();
    //alert(start);
    //alert(radio2);
    var vvv = {
        'username': sidOrSname,
        'usercode': udeOrUname,
        'beginDate': start,
        'endDate': end,
        'state': radio1,
        'shijian': radio2,
        "currentPage": index,
        "pagesize": pageSize
    };
    console.log(vvv);

    if (start.length > 0 && end.length > 0) {
        var startTmp = start.split("-");
        var endTmp = end.split("-");
        var sd = new Date(startTmp[0], startTmp[1], startTmp[2]);
        var ed = new Date(endTmp[0], endTmp[1], endTmp[2]);
        if (sd.getTime() > ed.getTime()) {
            alert("开始日期不能大于结束日期");
            return false;
        }
    }

   // alert(start);

    $.ajax({
        url: "/overtime/list",
        type: 'post',
        async: false,
        dataType: 'json',
        data: vvv,
        success: function (data) {
            // alert(data.data);

            if (data == null) {
                console.log(data);
                alert("未检索到员工加班信息！");
                // window.location.href = "http://localhost:8080/accept/test2"

            } else {
                console.log(data);
                //alert("检索到员工加班信息");
                //  window.location.href = "http://localhost:8080/accept/test3"

                //  window.location.href = "http://localhost:8080/accept/test3"
                //data = [];
                //for (var i = 0; i < 50; i++) data.push({})
                total = data["2"].length;
                // var pagesize = 15, totalrecord = data.length;
                for (var i = 0; i < data["1"].length; i++) {
                    var oid = data["1"][i].overtimeId;
                    var trs = '';
                    trs += '<tr>';//大于显示的条数隐藏起来
                    trs += '<td ><a id="' + oid + '"type="hidden">' + data["1"][i].createTime + '</a></td>';
                    trs += '<td>' + data["1"][i].sysUser.userName + '</td>';
                    trs += '<td>' + data["1"][i].sysUser.userCode + '</td>';
                    trs += '<td>' + data["1"][i].overtimeStartTime + '---' + data["1"][i].overtimeEndTime + '</td>';
                    trs += '<td>' + data["1"][i].overtimeReason + '</td>';
                    trs += '<td>' + data["1"][i].reviewer + '</td>';
                    if (data["1"][i].reviewerState == "1") {
                        trs += '<td>' + '通过' + '</td>';
                    } else if (data["1"][i].reviewerState == "2") {
                        trs += '<td>' + '未通过' + '</td>';

                    } else {
                        trs += '<td>' + '未填写' + '</td>';
                    }
                    trs += '<td>' + data["1"][i].reviewerReason + '</td>';
                    trs += '<td>' + data["1"][i].sysUser.department + '</td>';
                    if (data["1"][i].state == "1") {
                        trs += '<td>' + '有效' + '</td>';
                    } else if (data["1"][i].state == "2") {
                        trs += '<td>' + '无效' + '</td>';
                    } else {
                        trs += '<td>' + '未填写' + '</td>';
                    }

                    trs += '<td ><a href="javascript:void(0)" class="Inquiry_btn"  data-toggle="modal" data-target="#myModal" onclick="overtimeinfo(' + oid + ')">' + '修改' + '</a><a href="javascript:void(0)" class="Inquiry_btn"  onclick="overtimedel(' + oid + ')">' + '删除' + '</a></td>';
                    trs += '</tr>';
                    $("#tbs").append(trs);
                }
            }
        }
    });
}

//分页layui
layui.use('laypage', function () {
    //alert("2222222")
    var laypage = layui.laypage;
    //alert(total);
    laypage.render({
        elem: 'Pagination',
        count: total,
        limit: pageSize,
        jump: function (ojb, first) {
            //  alert("111111");
            // alert(total);
            //alert(total);
            if (!first) {
                //do something
                // alert("进入方法");
                // alert(ojb.curr);
                //this.index=ojb.curr;
                PageCallback(ojb.curr);
            }
        }
    })

});

//获取选中
function overtimeinfo(oid) {
    //alert(oid);
    $("#oid").html(oid);
    $.ajax({
        url: "/overtime/overtimeinfo",
        type: 'post',
        dataType: 'json',
        data: {"overtimeId": oid},
        success: function (data) {

            // alert(data.data);
            if (data != null) {
                //console.log(data.data.userName);
                //alert(data.SysUser.userName);
                console.log(data);
                // alert("修改成功");
                // window.location.href = "http://localhost:8080/accept/test2"
                // window.location.reload();
                // alert(data.data.sysUser.userName);
                $("#uName").val(data.data.sysUser.userName);
                $("#aTime").val(data.data.sysUser.userCode);
                $("#dName").val(data.data.overtimeStartTime);
                $("#eName").val(data.data.overtimeEndTime);
                $("#sName").val(data.data.sysUser.department);
                $("#mobile").val(data.data.overtimeReason);
                $("#textarea").val(data.data.reviewerReason);
                // alert(data.data.state);

                //显示字数限制初始值
                var max = 50;
                var value = $("#textarea").val();//获取文本框的字符数

                var coun = $("#contentCountLeft");//获取字数显示对象
                coun.html(max - value.length);//初始值

                //选区审核状态
                $("input[name='state']").each(function () {
                    if ($(this).val() == data.data.reviewerState) {
                        $(this).attr("checked", "checked");
                    }

                });
                if (data.data.state == "2") {
                    $("#state").show();
                    $("#state2").hide();
                    $("input[name='state2']").each(function () {
                        if ($(this).val() == data.data.state) {
                            $(this).attr("checked", "checked");
                        }

                    });

                } else {
                    $("#state").hide();
                    $("#state2").hide();
                    $("input[name='state3']").each(function () {
                        if ($(this).val() == data.data.state) {
                            $(this).attr("checked", "checked");
                        }

                    });


                }
                //选取状态


            } else {
                console.log(data);
                // alert("修改失败");
                //  window.location.href = "http://localhost:8080/accept/test3"
                // window.location.reload();
            }
        }
    });


}


//加班修改
function cardupdtae() {
    var oid = $("#oid").html();
    // alert(oid);
    console.log("进入方userupdate法");
    //var uName = $("#uName").val();//姓名
    // var aTime = $("#aTime").val();//工号
    // var dName = $("#dName").val();//加班开始时间
    // var eName = $("#eName").val();//加班结束时间
    //var department=$("#sName").val();//部门
    // alert(dName);
    //var reason = $("#mobile").val();//原因
    var textarea = $("#textarea").val();//备注
    var reviewerState = $("input[name='state']:checked").val();//审核状态
    var state = $("input[name='state2']:checked").val();//状态
    //alert(state);
    var vvv = {
        'overtimeId': oid,
        'reviewerState': reviewerState,
        'reviewerReason': textarea,
        'state': state


    };

    $.ajax({
        url: "/overtime/update",
        type: 'post',
        dataType: 'json',
        data: vvv,
        success: function (data) {
            // alert(data.data);

            if (data.resultCode == "200") {
                console.log(data);
                alert("修改成功");
                // window.location.href = "http://localhost:8080/accept/test2"
                window.location.reload();

            } else {
                console.log(data);
                alert("修改失败");
                //  window.location.href = "http://localhost:8080/accept/test3"
                // window.location.reload();
            }
        }
    });
}


//加班删除

function overtimedel(oid) {
    console.log("进入加班删除方法");
    console.log(oid);
    $.ajax({
        url: "/overtime/delete",
        type: 'post',
        dataType: 'json',
        data: {"overtimeId": oid},
        success: function (data) {
           //alert(data.resultCode);

            if (data.resultCode == "200") {
                console.log(data.data);
                // $("#"+uid).remove();
                alert("恭喜您！删除成功！");

                // window.location.href = "http://localhost:8080/accept/test2"
                window.location.reload();

            } else if (data.resultCode == "1204") {

                alert("很抱歉！删除失败，不能重复删除！")

            } else if (data.resultCode == "995") {
                alert("找不到数据，可能状态没有填写，请联系管理员!")

            } else {
                console.log(data.data);
                alert("很抱歉！删除失败，请联系工作人员！");
                //  window.location.href = "http://localhost:8080/accept/test3"
                //  window.location.reload();
            }
        }
    });
}
