/**
 * Created by 朱翰林 on 2018/7/19.
 */
var pageSize = 4;//设置每页显示条数
var total;
;//数据总条数
//alert(total);
var index = 1;
$("#cid").hide();
$("#shijianfw").hide();
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

//补卡信息搜索
function funchaxun(index) {
   $("#tbs").empty();
    console.log("进入方法");
    var sidOrSname = $("#sidOrSname").val();
    var udeOrUname = $("#udeOrUname").val();
    var start = $("#start").val();
    var end = $("#end").val();
    var radio1 = $("input[name='radio1']:checked").val();
    var radio2 = $("input[name='radio2']:checked").val();
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
   // alert("======================");
    $.ajax({
        url: "/card/list",
        type: 'post',
        async: false,
        dataType: 'json',
        data:vvv,
        success: function (data) {
            // alert(data.data);
            if (data== null) {
               // console.log(data);
                alert("未检索到员工补卡信息！");
               // window.location.href = "http://localhost:8080/accept/test2"

            } else {
               // console.log(data);
                alert("检索到员工补卡信息");
              //  window.location.href = "http://localhost:8080/accept/test3"
                total = data["2"].length;
                for (var i = 0; i <  data["1"].length; i++) {
                    var cid = data["1"][i].cardId;
                    var trs = '';
                    trs += '<tr>';//大于显示的条数隐藏起来
                    trs += '<td ><a id="' + cid+ '"type="hidden">' + data["1"][i].createTime + '</a></td>'; //
                    trs += '<td>' + data["1"][i].sysUser.userName + '</td>';
                    trs += '<td>' + data["1"][i].sysUser.userCode + '</td>';
                    trs += '<td>' + data["1"][i].cardTime + '</td>';
                    trs += '<td>' + data["1"][i].cardPlace + '</td>';
                    trs += '<td>' + data["1"][i].cardReason + '</td>';
                    trs += '<td>' + data["1"][i].approver + '</td>';
                    if (data["1"][i].approverState =="1") {
                        trs += '<td>' + '通过' + '</td>';
                    }else if (data["1"][i].approverState =="2"){
                        trs += '<td>' + '未通过' + '</td>';
                    }else {
                        trs += '<td>' + '未填写' + '</td>';
                    }
                    trs += '<td>' + data["1"][i].approverReason + '</td>';
                    trs += '<td>' + data["1"][i].sysUser.department + '</td>';
                    if (data["1"][i].satte=="1") {
                        trs += '<td>' + '有效' + '</td>';
                    }else if (data["1"][i].satte =="2"){
                        trs += '<td>' + '无效' + '</td>';
                    }else {
                        trs += '<td>' + '未填写' + '</td>';
                    }
                    trs += '<td ><a href="javascript:void(0)" class="Inquiry_btn"  data-toggle="modal" data-target="#myModal" onclick="cardinfo('+cid+')">' + '修改' + '</a><a href="javascript:void(0)" class="Inquiry_btn"  onclick="carddel(' + cid + ')">' + '删除' + '</a></td>';
                    trs += '</tr>';
                    $("#tbs").append(trs);
                }


         
            }


        }
    });
}

//分页layui
layui.use('laypage', function () {
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
//获取用户信息
function cardinfo(cid) {
    //alert(cid);
    $("#cid").html(cid);
    $.ajax({
        url: "/card/cardinfo",
        type: 'post',
        dataType: 'json',
        data: {"cardId": cid},
        success: function (data) {

            // alert(data.data);
            if (data != null) {
                //console.log(data.data.userName);
                //alert(data.SysUser.userName);
                console.log(data);
                // alert("修改成功");
                // window.location.href = "http://localhost:8080/accept/test2"
                // window.location.reload();
                $("#uName").val( data.data.sysUser.userName);
                $("#aTime").val(data.data.sysUser.userCode);
                $("#dName").val( data.data.cardTime);
                $("#sName").val( data.data.cardPlace);
                $("#mobile").val(data.data.cardReason);
                $("#textarea").val(data.data.approverReason);
                // alert(data.data.state);
                //显示字数限制初始值
                var max=50;
                var value = $("#textarea").val();//获取文本框的字符数

                var coun = $("#contentCountLeft");//获取字数显示对象
                coun.html(max-value.length);//初始值





                $("input[name='state']").each(function () {
                    if ($(this).val() == data.data.approverState) {
                        $(this).attr("checked", "checked");
                    }

                });


                if(data.data.satte=="2"){
                    $("#state").show();
                    $("#state2").hide();
                    $("input[name='state2']").each(function () {
                        if ($(this).val() == data.data.satte) {
                            $(this).attr("checked", "checked");
                        }

                    });

                }else {
                    $("#state").hide();
                    $("#state2").hide();
                    $("input[name='state3']").each(function () {
                        if ($(this).val() == data.data.satte) {
                            $(this).attr("checked", "checked");
                        }

                    });


                }

            } else {
                console.log(data);
                // alert("修改失败");
                //  window.location.href = "http://localhost:8080/accept/test3"
                // window.location.reload();
            }
        }
    });


}









//补卡修改
function cardupdtae() {

    var cid= $("#cid").html();
    //alert(cid);
    console.log("进入方userupdate法");
    // var uName = $("#uName").val();//姓名
    // var aTime = $("#aTime").val();//工号
    // var dName = $("#dName").val();//时间
    var sName = $("#sName").val();//地点
    var reason =  $("#mobile").val();//原因
    var textarea = $("#textarea").val();//备注
    var  apprstate= $("input[name='state']:checked").val();//审批状态
    var  state= $("input[name='state2']:checked").val();//状态
 
    var vvv = {
        'cardId':cid,
        'cardPlace': sName,
        'approverState':apprstate,
        'cardReason': reason,
        'approverReason':textarea,
        'satte':state

    };

    $.ajax({
        url: "/card/update",
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

//补卡删除

function carddel(cid) {
    console.log("进入请假删除方法");
    console.log(cid);
    $.ajax({
        url: "/card/delete",
        type: 'post',
        dataType: 'json',
        data: {"cardId": cid},
        success: function (data) {
           // alert(data.resultCode);

            if (data.resultCode == "200") {
                console.log(data.data);
                // $("#"+uid).remove();
                alert("恭喜您！删除成功！");

                // window.location.href = "http://localhost:8080/accept/test2"
                window.location.reload();

            } else if (data.resultCode == "1204") {

                alert("很抱歉！删除失败，不能重复删除！")

            }else if(data.resultCode=="995"){
                alert("找不到数据，可能状态没有填写，请联系管理员!")

            }else {
                console.log(data.data);
                alert("很抱歉！删除失败，请联系工作人员！");
                //  window.location.href = "http://localhost:8080/accept/test3"
                //  window.location.reload();
            }
        }
    });

    
}


//
// //修改模态框显示
//
// function modelxianshi2() {
//
//     console.log("进入modelxianshi方法")
//     var modal = document.getElementById("myModal");
//     modal.show();
//     /*当用户点击模态框内容之外的区域，模态框也会关闭*/
//     this.outsideClick = function () {
//
//         //  var modal = this.modal;
//         window.onclick = function (event) {
//             //判断是不是model元素发生了，返回发生的节点或者元素
//             if (event.target == modal) {
//                 modal.style.display = "none";
//             }
//         }
//     };
//
// }


//分页


function fenye() {
    data = [];
    for (var i = 0; i < 50; i++) data.push({})
    var pagesize = 15, totalrecord = data.length;
    for (var i = 0; i < totalrecord; i++) {
        var cid = data[i].cardId;
        var trs = '';
        trs += '<tr' + (i >= pagesize ? ' style="display:none"' : '') + '>';//大于显示的条数隐藏起来
        trs += '<td ><a id="' + cid+ '"type="hidden">' + data[i].createTime + '</a></td>'; //
        trs += '<td>' + data[i].userName + '</td>';
        trs += '<td>' + data[i].userCode + '</td>';
        trs += '<td>' + data[i].cardTime + '</td>';
        trs += '<td>' + data[i].cardPlace + '</td>';
        trs += '<td>' + data[i].cardReason + '</td>';
        trs += '<td>' + data[i].approver + '</td>';
        trs += '<td>' + data[i].approverState + '</td>';
        trs += '<td>' + data[i].approverReason + '</td>';
        trs += '<td>' + data[i].depName + '</td>';
        trs += '<td ><a href="javascript:void(0)" class="Inquiry_btn"  data-toggle="modal" data-target="#myModal" >' + '修改' + '</a></td>';
        trs += '</tr>';
        $("#tbs").append(trs);
    }
    $('#pg').pagination({
        totalData:totalrecord,//总记录数
        showData: pagesize,//每页记录数
        coping: true,
        homePage: '首页',
        endPage: '末页',
        prevContent: '上页',
        nextContent: '下页',
        callback: function (that) {
            var current = that.getCurrent() - 1;//返回的页数从1开始

            $("#tbs").find('tr').hide().filter(':gt(' + (current * pagesize - 1) + ')').filter(':lt(' + (pagesize) + ')').show()
            //ajax获取，传递current参数获取要的页数据
        }
    });

}
