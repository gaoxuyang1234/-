/**
 * Created by 朱翰林 on 2018/8/1.
 */



//进入页面获得用户信息 user表！
$( function () {
        //缓存
        let uid=localStorage.getItem("uid");
        $.ajax({
            url: "/sysuser/userInfo",
            type: 'post',
            dataType: 'json',
            data: {"uid": uid},
            success: function (data) {
                if (data.resultCode == "200") {
                    $("#uName").html(data.data.userName);
                    $("#department").html(data.data.department);
                } else {
                    alert("获取用户信息失败！");
                }
            }
        });
    }
);

//进入页面根据uid获得用户当月的信息
$( function () {
        detailsinfo()
    }
)
//
$(document).off('change', '#sTime').on('change', '#sTime', function () {
    detailsinfo()
});
//根据下拉框的值获取用户考勤各项信息总数
function detailsinfo() {
    $("#tbs").empty();   
    //缓存
    let uid=localStorage.getItem("uid");
    
    var subname = $("#sTime").val().split("-");
    var year = subname[0];
    var month = subname[1];
    var vals = {
        "uid": uid,
        "year": year,
        "month": month

    };
    $.ajax({
        url: "/sysuser/count",
        type: 'post',
        dataType: 'json',
        data: vals,
        success: function (data) {
            //alert(data.data);

            if (data.resultCode == "200") {
                console.log(data.data);
              //  alert("获取用户信息成功");               
                if (data.data[0] == 0) {
                    $("#cq").html(data.data[0]).css("color", "red");
                } else {
                    $("#cq").html(data.data[0]).css("color", "blue");
                }
                if (data.data[1] == 0) {
                    $("#zc").html(data.data[1]).css("color", "red");
                } else {
                    $("#zc").html(data.data[1]).css("color", "blue");
                }
                if (data.data[2] == 0) {
                    $("#qj").html(data.data[2]).css("color", "red");
                } else {
                    $("#qj").html(data.data[2]).css("color", "blue");
                }
                if (data.data[3] == 0) {
                    $("#cd").html(data.data[3]).css("color", "red");
                } else {
                    $("#cd").html(data.data[3]).css("color", "blue");
                }
                if (data.data[4] == 0) {
                    $("#zt").html(data.data[4]).css("color", "red");
                } else {
                    $("#zt").html(data.data[4]).css("color", "blue");
                }
                if (data.data[5] == 0) {
                    $("#qk").html(data.data[5]).css("color", "red");
                } else {
                    $("#qk").html(data.data[5]).css("color", "blue");
                }
                if (data.data[6] == 0) {
                    $("#kg").html(data.data[6]).css("color", "red");
                } else {
                    $("#kg").html(data.data[6]).css("color", "blue");
                }
                if (data.data[7] == 0) {
                    $("#rest").html(data.data[7]).css("color", "red");
                } else {
                    $("#rest").html(data.data[7]).css("color", "blue");
                }
            } else {
                alert("获取用户信息失败！");
                
            }
        }
    });
}

//获取矿工具体日期
function kgjilu() {
    $("#tbs").empty();
    $("#liebiao").html("⭐旷工日期");
   
    //获得缓存
    let uid=localStorage.getItem("uid");

    var subname = $("#sTime").val().split("-");
    var year = subname[0];
    var month = subname[1];


    var vals = {
        "uid": uid,
        "year": year,
        "month": month

    };

    $.ajax({
        url: "/sysuser/kgtime",
        type: 'post',
        dataType: 'json',
        data: vals,
        success: function (data) {
            //alert(data.data);

            console.log(data.data);

            //  alert("获取用户信息成功");
            if (data.data.length == 0) {
                alert("无旷工信息！恭喜您本月没有矿工记录，请继续努力！")
            } else {

                for (var i = 0; i < data.data.length; i++) {
                    // alert(uid);
                    var subtime = data.data[i].createTime.split("-");//截取时间
                    var year = subtime[0];
                    //alert(year);
                    var month = subtime[1] - 1;
                    //alert(month);
                    var day = subtime[2];
                    // alert(day);
                    var xingqi = new Date(year, month, day);
                    var xingqis = xingqi.getDay();
                    // alert(xingqis);
                    var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                    var trs = '';

                    trs += '<p>' + data.data[i].createTime + '(' + weekDay[xingqis] + ')' + '</p>';//矿工日期

                    $("#tbs").append(trs);
                }

            }

        }
    });

}


//获取请假具体时间

function qjjilu() {
    $("#liebiao").html("⭐请假日期");
    $("#tbs").empty();
    //获得缓存
    let uid=localStorage.getItem("uid");

    var subname = $("#sTime").val().split("-");
    var year = subname[0];
    var month = subname[1];


    var vals = {
        "uid": uid,
        "year": year,
        "month": month

    };

    $.ajax({
        url: "/sysuser/qjtime",
        type: 'post',
        dataType: 'json',
        data: vals,
        success: function (data) {
            //alert(data.data);

            console.log(data.data);

            //  alert("获取用户信息成功");
            if (data.data.length == 0) {
                alert("无请假信息！恭喜您本月没有请假记录，请继续努力！")
            } else {

                for (var i = 0; i < data.data.length; i++) {
                    // alert(uid);
                    var subtime = data.data[i].createTime.split("-");//截取时间
                    var year = subtime[0];
                    //alert(year);
                    var month = subtime[1] - 1;
                    //alert(month);
                    var day = subtime[2];
                    // alert(day);
                    var xingqi = new Date(year, month, day);
                    var xingqis = xingqi.getDay();
                    // alert(xingqis);
                    var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                    var trs = '';

                    trs += '<p>' + data.data[i].createTime + '(' + weekDay[xingqis] + ')' + '</p>';//矿工日期

                    $("#tbs").append(trs);
                }

            }

        }
    });

}


//获取迟到具体时间

function cdjilu() {
    $("#liebiao").html("⭐迟到日期");
    $("#tbs").empty();
    //获得缓存
    let uid=localStorage.getItem("uid");

    var subname = $("#sTime").val().split("-");
    var year = subname[0];
    var month = subname[1];

    var vals = {
        "uid": uid,
        "year": year,
        "month": month

    };

    $.ajax({
        url: "/sysuser/cdtime",
        type: 'post',
        dataType: 'json',
        data: vals,
        success: function (data) {
      
            //console.log(data.data);
            if (data.data.length == 0) {
                alert("无迟到信息！恭喜您本月没有迟到记录，请继续努力！")
            } else {
                for (var i = 0; i < data.data.length; i++) {
                     //alert(uid);
                    var subtime = data.data[i].createTime.split("-");//截取时间
                    var year = subtime[0];
                    //alert(year);
                    var month = subtime[1] - 1;
                   // alert(month);
                    var day = subtime[2];
                    // alert(day);
                    var xingqi = new Date(year, month, day);
                    var xingqis = xingqi.getDay();
                    //alert(xingqis);
                    var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                    var trs = '';

                    trs += '<p>' + data.data[i].createTime + '(' + weekDay[xingqis] + ')' + '</p>';//矿工日期

                    $("#tbs").append(trs);
                }

            }

        }
    });

}


//获取缺卡具体时间

function qkjilu() {
    $("#liebiao").html("⭐缺卡日期");
    $("#tbs").empty();
    //获得缓存
    let uid=localStorage.getItem("uid");
    
    var subname = $("#sTime").val().split("-");
    var year = subname[0];
    var month = subname[1];

    var vals = {
        "uid": uid,
        "year": year,
        "month": month

    };

    $.ajax({
        url: "/sysuser/qktime",
        type: 'post',
        dataType: 'json',
        data: vals,
        success: function (data) {

            console.log(data.data);

            if (data.data.length == 0) {
                alert("无缺卡信息！恭喜您本月没有缺卡记录，请继续努力！")
            } else {

                for (var i = 0; i < data.data.length; i++) {
                    // alert(uid);
                    var subtime = data.data[i].createTime.split("-");//截取时间
                    var year = subtime[0];
                    //alert(year);
                    var month = subtime[1] - 1;
                    //alert(month);
                    var day = subtime[2];
                    // alert(day);
                    var xingqi = new Date(year, month, day);
                    var xingqis = xingqi.getDay();
                    // alert(xingqis);
                    var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                    var trs = '';
                    trs += '<p>' + data.data[i].createTime + '(' + weekDay[xingqis] + ')' + '</p>';//矿工日期
                    $("#tbs").append(trs);
                }

            }

        }
    });

}

//获取早退具体时间

function ztjilu() {
    $("#liebiao").html("⭐早退日期");
    $("#tbs").empty();
    //获得缓存
    let uid=localStorage.getItem("uid");

    var subname = $("#sTime").val().split("-");
    var year = subname[0];
    var month = subname[1];

    var vals = {
        "uid": uid,
        "year": year,
        "month": month

    };

    $.ajax({
        url: "/sysuser/zttime",
        type: 'post',
        dataType: 'json',
        data: vals,
        success: function (data) {
            //alert(data.data);

            console.log(data.data);

            //  alert("获取用户信息成功");
            if (data.data.length == 0) {
                alert("无缺卡信息！恭喜您本月没有缺卡记录，请继续努力！")
            } else {

                for (var i = 0; i < data.data.length; i++) {
                    // alert(uid);
                    var subtime = data.data[i].createTime.split("-");//截取时间
                    var year = subtime[0];
                    //alert(year);
                    var month = subtime[1] - 1;
                    //alert(month);
                    var day = subtime[2];
                    // alert(day);
                    var xingqi = new Date(year, month, day);
                    var xingqis = xingqi.getDay();
                    // alert(xingqis);
                    var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
                    var trs = '';

                    trs += '<p>' + data.data[i].createTime + '(' + weekDay[xingqis] + ')' + '</p>';//矿工日期

                    $("#tbs").append(trs);
                }

            }

        }
    });

}




