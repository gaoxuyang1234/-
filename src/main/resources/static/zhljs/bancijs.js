/**
 * Created by 朱翰林 on 2018/7/20.
 */
var pageSize = 4;//设置每页显示条数
var total;
//数据总条数
$("#sid").hide();
//alert(total);
var index = 1;
$(function () {
    // alert("初始化开始！1")
    funchaxun(index);//分页初始化

});

function PageCallback(index, jq) { //前一个表示当前点击的那个分页的页数索引值，后一个参数表示装载容器。
    funchaxun(index);
}


//班次信息搜索
function funchaxun(index) {
    $("#tbs").empty();
    var radio1 = $("input[name='radio1']:checked").val();
    $.ajax({
        url: "/shift/list",
        type: 'post',
        async: false,
        dataType: 'json',
        data: {"shiftName": radio1, "currentPage": index, "pagesize": pageSize},
        success: function (data) {
            // alert(data.data);

            if (data == null) {
                console.log(data);
                alert("未检索到班次信息！");
                // window.location.href = "http://localhost:8080/accept/test2"

            } else {
                console.log(data);
                //alert("检索到信息！");
                //  window.location.href = "http://localhost:8080/accept/test3"

                //  window.location.href = "http://localhost:8080/accept/test3"
                //data = [];
                //for (var i = 0; i < 50; i++) data.push({})
                // var pagesize = 15, totalrecord = data.length;
                total = data["2"].length;
                for (var i = 0; i < data["1"].length; i++) {
                    var sid = data["1"][i].shiftId;
                    var trs = '';
                    trs += '<tr>';//大于显示的条数隐藏起来
                    trs += '<td ><a id="' + sid + '"type="hidden">' + data["1"][i].createTime + '</a></td>';
                    trs += '<td>' + data["1"][i].shiftName + '</td>';
                    trs += '<td>' + data["1"][i].startHourTime + ':' + data["1"][i].startMinuteTime + '</td>';
                    // trs += '<td>' + data[i].startMinuteTime + '</td>';
                    trs += '<td>' + data["1"][i].endHourTime + ':' + data["1"][i].endMinuteTime + '</td>';
                    // trs += '<td>' + data[i].endMinuteTime + '</td>';
                    trs += '<td>' + data["1"][i].sysAdministrator.administratorName + '</td>';
                    trs += '<td>' + data["1"][i].sysAdministrator.administratorCode + '</td>';
                    if (data["1"][i].state=="1") {
                        trs += '<td>' + '有效' + '</td>';
                    }else if (data["1"][i].state =="2"){
                        trs += '<td>' + '无效' + '</td>';
                    }else {
                        trs += '<td>' + '未填写' + '</td>';
                    }

                    trs += '<td ><a href="javascript:void(0)" class="Inquiry_btn"  data-toggle="modal" data-target="#myModal" onclick="shiftinfo(' + sid + ')">' + '修改' + '</a><a href="javascript:void(0)" class="Inquiry_btn"  onclick="userdelete(' + sid + ')">' + '删除' + '</td>';
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


//根据id获取信息
function shiftinfo(sid) {
    //alert(sid);

    $("#sid").html(sid);
    $.ajax({
        url: "/shift/shiftinfo",
        type: 'post',
        dataType: 'json',
        data: {"shiftId": sid},
        success: function (data) {


            // alert(data.data);
            if (data.resultCode == "200") {
                // console.log(data.data.userName);
                //alert(data.SysUser.userName);
                console.log("=====================")
                console.log(data);
                // alert("修改成功");
                //alert(data.data.shiftName);
              //  console.log(data.data.shiftName);
                //console.log($("#uName").val());
                // window.location.href = "http://localhost:8080/accept/test2"
                // window.location.reload();
                //$().val(data.data.userName);
                //console.log($("#uName").find("option")[0].length)
                $("#uName").find("option").each(function (i,o) {
                    // alert($(this).val());
                   // console.log(i+":"+$(o).val())

                    if ($(o).val() == data.data.shiftName) {
                        // alert(this.val());
                        $(o).prop("selected", true);


                    }
                });
                $("#startHour").find("option").each(function () {
                    if ($(this).val() == data.data.startHourTime) {
                        $(this).attr('selected', true);
                    }
                });
                $("#startMinute").find("option").each(function () {
                    if ($(this).val() == data.data.startMinuteTime) {
                        $(this).attr('selected', true);
                    }
                });

                $("#endHour").find("option").each(function () {
                    if ($(this).val() == data.data.endHourTime) {
                        $(this).attr('selected', true);
                    }
                });

                $("#endMinute").find("option").each(function () {
                    if ($(this).val() == data.data.endMinuteTime) {
                        $(this).attr('selected', true);
                    }
                });
                // $("#aTime2").val(data.data.userCode);
                // $("#dName2").val(data.data.cardNo);
                // $("#sName2").val(data.data.mobile);
                // alert(data.data.state);
                $("input[name='state2']").each(function () {
                    if ($(this).val() == data.data.state) {
                        $(this).attr("checked", "checked");
                    }
                });
            } else {
                console.log(data);
                // alert("修改失败");
                //  window.location.href = "http://localhost:8080/accept/test3"
                // window.location.reload();
            }
        }
    });

}

//绑定下拉框

function bd() {
   // alert("111111111");
    $.ajax({
        url: "/sysadm/alladminfo",
        type: 'post',
        dataType: 'json',

        success: function (data) {
            console.log(data.data);

            if (data.resultCode == "200") {
                console.log(data.data);
            //动态绑定下拉框
                for (var i = 0; i < data.data.length; i++) {
                    $("#rName").append("<option value='"+data.data[i].administratorId+"'>" + data.data[i].administratorName + "</option>");
                }

            } else if (data.resultCode == "995") {

              alert("获取信息失败！")
            }


            else {
                console.log(data);
                alert("系统错误，请联系工作人员！");
                //  window.location.href = "http://localhost:8080/accept/test3"
                //  window.location.reload();
            }
        }
    });

}


//班次信息增加
function addshift() {
    //获取系统当前时间
    var date = new Date(+new Date()+8*3600*1000).toISOString().replace(/T/g,' ').replace(/\.[\d]{3}Z/,'');
    //alert(date);
    console.log("进入方shiftadd法");
    var uName = $("#uName2").val();
    var aTime = $("#startHour2").val();//开始时间
    // console.log(aTime);
    alert(aTime);
    var dName = $("#startMinute2").val();//开始分钟
    var sName = $("#endHour2").val();//结束时间
    //console.log(sName);
    alert(sName);
    var eName = $("#endMinute2").val();//结束分钟
    var rName=  $("#rName").val();//创建人id
    alert(rName);
    var state = $("input[name='state']:checked").val();

    if (eval(aTime) > eval(sName)) {
        alert("开始时间不能大于结束时间！！");
        return false;

    } else if (eval(aTime) == eval(sName)) {
        if (eval(dName) >= eval(eName)) {
            alert("开始时间不能大于或等于结束时间！！");
            return false;
        } else {
            alert("可以添加！");
            var vvv = {
                'shiftName': uName,
                'startHourTime': aTime,
                'startMinuteTime': dName,
                'endHourTime': sName,
                'endMinuteTime': eName,
                'createUserId':rName,
                'state':state,
                'createTime':date

            };
            $.ajax({
                url: "/shift/add",
                type: 'post',
                dataType: 'json',
                data: vvv,
                success: function (data) {
                    console.log(data.data);

                    if (data.resultCode == "200") {
                        console.log(data);
                        alert("恭喜！添加成功！");
                        // window.location.href = "http://localhost:8080/accept/test2"
                        window.location.reload();

                    } else if (data.resultCode == "992") {

                        alert("用户信息已经存在，不能重复添加!");
                        window.location.reload();
                    }


                    else {
                        console.log(data);
                        alert("很抱歉！添加失败，请联系工作人员！");
                        //  window.location.href = "http://localhost:8080/accept/test3"
                        //  window.location.reload();
                    }
                }
            });


            return true;
        }
    } else {
        alert("可以添加！");
        var vvv = {
            'shiftName': uName,
            'startHourTime': aTime,
            'startMinuteTime': dName,
            'endHourTime': sName,
            'endMinuteTime': eName,
            'createUserId':rName,
            'state':state,
            'createTime':date
        };
        $.ajax({
            url: "/shift/add",
            type: 'post',
            dataType: 'json',
            data: vvv,
            success: function (data) {
                console.log(data.data);

                if (data.resultCode == "200") {
                    console.log(data);
                    alert("恭喜！添加成功！");
                    // window.location.href = "http://localhost:8080/accept/test2"
                    window.location.reload();

                } else if (data.resultCode == "992") {

                    alert("用户信息已经存在，不能重复添加!");
                    window.location.reload();
                }


                else {
                    console.log(data);
                    alert("很抱歉！添加失败，请联系工作人员！");
                    //  window.location.href = "http://localhost:8080/accept/test3"
                    //  window.location.reload();
                }
            }
        });


        return true;


    }


}


//班次信息修改
function updateshift() {

    console.log("进入方法");
    var sid = $("#sid").html();
    var uName = $("#uName").val();
    var aTime = $("#startHour").val();
    var dName = $("#startMinute").val();
    var sName = $("#endHour").val();
    var eName = $("#endMinute").val();

   // var state2 = $("input[name='state2']:checked").val();


    if (eval(aTime) > eval(sName)) {
        alert("开始时间不能大于结束时间！！");
        return false;

    } else if (eval(aTime) == eval(sName)) {
        if (eval(dName) >= eval(eName)) {
            alert("开始时间不能大于结束时间！！");
            return false;
        } else {
            var vvv = {
                'shiftId': sid,
                'shiftName': uName,
                'startHourTime': aTime,
                'startMinuteTime': dName,
                'endHourTime': sName,
                'endMinuteTime': eName

            };

            $.ajax({
                url: "/shift/update",
                type: 'post',
                dataType: 'json',
                data: vvv,
                success: function (data) {
                    // alert(data.data);

                    if (data != null) {
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
            return true;

        }

    }
    else {
        var vvv = {
            'shiftId': sid,
            'shiftName': uName,
            'startHourTime': aTime,
            'startMinuteTime': dName,
            'endHourTime': sName,
            'endMinuteTime': eName


        };

        $.ajax({
            url: "/shift/update",
            type: 'post',
            dataType: 'json',
            data: vvv,
            success: function (data) {
                // alert(data.data);

                if (data != null) {
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

               return true;
    }







}
//删除
function userdelete(sid) {

    console.log("进入班次删除方法");
    console.log(sid);
    $.ajax({
        url: "/shift/delete",
        type: 'post',
        dataType: 'json',
        data: {"shiftId": sid},
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


//
// //添加模态框显示
//
// function modelxianshi() {
//     // 建立模态框对象
//     //var modalBox = {};
//     /*获取模态框*/
//     console.log("进入modelxianshi方法")
//     var modal = document.getElementById("myModal2");
//     modal.show();
//     /*获得触发按钮*/
//     // modalBox.add = document.getElementById("add");
//     /*获得关闭按钮*/
//     // modalBox.closeBtn = document.getElementById("closeBtn");
//
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
//     //模态框初始化
//     // modalBox.init = function() {
//     //     this.add.onclick = function () {
//     //         this.show();
//     //     };
//     //
//     //     this.outsideClick()
//     //
//     // };
//     //
//     // modalBox.init();
// }
//
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


