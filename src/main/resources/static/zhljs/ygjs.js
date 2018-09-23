/**
 * Created by 朱翰林 on 2018/7/20.
 */



var pageSize = 4;//设置每页显示条数
var total;
;//数据总条数
//alert(total);
var index = 1;
$("#uid").hide();
$(function () {
    // alert("初始化开始！1")
    funchaxun(index);//分页初始化

});

function PageCallback(index, jq) { //前一个表示当前点击的那个分页的页数索引值，后一个参数表示装载容器。
    funchaxun(index);
}

// 验证手机号
function isPhoneNo(sName) {
    var pattern = /^1[34578]\d{9}$/;
    return pattern.test(sName);
}

// 验证中文名称
function isChinaName(name) {
    var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
    return pattern.test(name);
}


//验证身份证
function testId(value) {
    var vcity = {
        11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古",
        21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏",
        33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南",
        42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆",
        51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃",
        63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外"
    };

    // 判断是否为空
    //不为空返回true
    isEmpty = function (card) {
        if (/^\s*$/.test(card) === true) {
            return true;
        }
    };
    //检查号码是否符合规范，包括长度，类型
    isCardNo = function (card) {
        if (isEmpty(card)) {
            return true;
        }
        //这个代码表示身份证可以为空
        //身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
        var reg = /(^\d{15}$)|(^\d{17}(\d|X)$)/;
        if (reg.test(card) === false) {
            return false;
        }
        return true;
    };

    //截取身份证前两位,校验省份
    checkProvince = function (card) {
        if (isEmpty(card)) {
            return true;
        }
        var province = card.substr(0, 2);
        if (vcity[province] == undefined) {
            return false;
        }
        return true;
    };

    //检查生日是否正确
    checkBirthday = function (card) {
        if (isEmpty(card)) {
            return true;
        }
        var len = card.length;
        //身份证15位时，次序为省（3位）市（3位）年（2位）月（2位）日（2位）校验位（3位），皆为数字
        if (len == '15') {
            var re_fifteen = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;
            var arr_data = card.match(re_fifteen);
            var year = arr_data[2];
            var month = arr_data[3];
            var day = arr_data[4];
            var birthday = new Date('19' + year + '/' + month + '/' + day);
            return verifyBirthday('19' + year, month, day, birthday);
        }
        //身份证18位时，次序为省（3位）市（3位）年（4位）月（2位）日（2位）校验位（4位），校验位末尾可能为X
        if (len == '18') {
            var re_eighteen = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
            var arr_data = card.match(re_eighteen);
            var year = arr_data[2];//截取年份
            var month = arr_data[3];//截取月份
            var day = arr_data[4];//截取日期
            var birthday = new Date(year + '/' + month + '/' + day);//格式化得到生日日期 date类型
            return verifyBirthday(year, month, day, birthday);
        }
        return false;
    };

    //校验日期
    verifyBirthday = function (year, month, day, birthday) {
        var now = new Date();
        var now_year = now.getFullYear();//获得当前年份
        //年月日是否合理，与年份，月份，日分别做对比
        if (birthday.getFullYear() == year && (birthday.getMonth() + 1) == month && birthday.getDate() == day) {
            //判断年份的范围（3岁到100岁之间)
            var time = now_year - year;
            if (time >= 3 && time <= 100) {
                return true;
            }
            return false;
        }
        return false;
    };

    //校验位的检测
    checkParity = function (card) {
        if (isEmpty(card)) {
            return true;
        }
        //15位转18位
        card = changeFivteenToEighteen(card);
        var len = card.length;
        if (len == '18') {
            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
            var cardTemp = 0, i, valnum;
            for (i = 0; i < 17; i++) {
                cardTemp += card.substr(i, 1) * arrInt[i];
            }
            valnum = arrCh[cardTemp % 11];
            if (valnum == card.substr(17, 1)) {
                return true;
            }
            return false;
        }
        return false;
    };

    //15位转18位身份证号
    changeFivteenToEighteen = function (card) {
        if (isEmpty(card)) {
            return true;
        }
        if (card.length == '15') {
            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
            var cardTemp = 0, i;
            card = card.substr(0, 6) + '19' + card.substr(6, card.length - 6);
            for (i = 0; i < 17; i++) {
                cardTemp += card.substr(i, 1) * arrInt[i];
            }
            card += arrCh[cardTemp % 11];
            return card;
        }
        return card;
    };

    //checkCard = function () {
    var card = value;
    //校验长度，类型
    if (isCardNo(card) === false) {
        //alert('您输入的身份证号码不正确，请重新输入');
        //document.getElementById('card_no').focus;
        return false;
    }
    //检查省份
    if (checkProvince(card) === false) {
        return false;
    }
    //校验生日
    if (checkBirthday(card) === false) {
        return false;
    }
    //检验位的检测
    if (checkParity(card) === false) {
        return false;
    }

    return true;
}

//console.log("==========")
// 搜索
function funchaxun(index) {
    //alert("进入员工搜索！");
    //index=this.index;
    $("#tbs").empty();
    console.log(index);
    console.log("进入员工信息搜索方法");
    var sidOrSname = $("#sidOrSname").val();
    console.log(sidOrSname);
    var udeOrUname = $("#udeOrUname").val();
    // console.log(udeOrUname);
    var start = $("#start").val();
    //console.log(start);
    var end = $("#end").val();
    var didOrDname = $("#didOrDname").val();
    // console.log(didOrDname);
    var telOrDname = $("#telOrDname").val();
    // var radio1 = $("input[name='radio1']:checked").val();
    // var radio2 = $("input[name='radio2']:checked").val();
    var vvv = {
        'userName': sidOrSname,
        'userCode': udeOrUname,
        'beginDate': start,
        'endDate': end,
        'cardNo': didOrDname,
        'mobile': telOrDname,
        "currentPage": index,
        "pagesize": pageSize
    };

    //console.log(vvv);
    // alert(openId);
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
    // console.log(vvv);
    // alert(index);
    // alert("11111111111")
    //alert(sidOrSname);
    $.ajax({
        url: "/user/list",
        type: 'post',
        async: false,
        dataType: 'json',
        data: vvv,

        success: function (data) {
            // alert(data.data);
            //  alert();
            // console.log(data);
            // console.log(vvv);
            if (data == null) {
                // console.log(data);
                alert("未检索到员工信息！");
                // window.location.href = "http://localhost:8080/accept/test2"

            } else {
                //  console.log(data);
                //alert("检索到员工信息");

                //  alert(data);
                //  window.location.href = "http://localhost:8080/accept/test3"
                // data = [];
                // for (var i = 0; i < 50; i++) data.push({})

                // var pagesize = 15;
                total = data["2"].length;
                // alert(total);
                for (var i = 0; i < data["1"].length; i++) {
                    var uid = data["1"][i].userId;
                    // alert(uid);
                    var trs = '';
                    trs += '<tr  id="' + uid + '">';//大于显示的条数隐藏起来
                    trs += '<td >' + data["1"][i].createTime + '</a></td>';
                    trs += '<td >' + data["1"][i].userName + '</td>';//姓名
                    trs += '<td>' + data["1"][i].userCode + '</td>';//工号
                    trs += '<td>' + data["1"][i].cardNo + '</td>';//身份证号
                    trs += '<td>' + data["1"][i].mobile + '</td>';//电话号码
                    if (data["1"][i].state == "1") {
                        trs += '<td>' + '有效' + '</td>';
                    } else if (data["1"][i].state == "2") {
                        trs += '<td>' + '无效' + '</td>';
                    } else {
                        trs += '<td>' + '未填写' + '</td>';
                    }

                    trs += '<td>' + data["1"][i].department + '</td>';
                    trs += '<td ><a href="javascript:void(0)" class="Inquiry_btn"  data-toggle="modal" data-target="#myModal2" onclick="userinfo(' + uid + ')">' + '修改' + '</a><a href="javascript:void(0)" class="Inquiry_btn"  onclick="userdelete(' + uid + ')">' + '删除' + '</a></td>';
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

//获取选中
function userinfo(uid) {
    alert(uid);
    $("#uid").html(uid);
    $.ajax({
        url: "/user/userinfo",
        type: 'post',
        dataType: 'json',
        data: {"userId": uid},
        success: function (data) {

            // alert(data.data);
            if (data != null) {
                console.log(data.data.userName);
                //alert(data.SysUser.userName);
                console.log(data);
                // alert("修改成功");
                // window.location.href = "http://localhost:8080/accept/test2"
                // window.location.reload();
                $("#uName2").val(data.data.userName);
                $("#aTime2").val(data.data.userCode);
                $("#dName2").val(data.data.cardNo);
                $("#sName2").val(data.data.mobile);
                $("#department").val(data.data.department);
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

//修改
function userupdate() {
    console.log("进入方法");
    var uid = $("#uid").html();
    // alert($(this).parent().prev().text());
    // console.log($(this).parent());
    // var uu = $(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().html();
    // var aa = $(this).parent().prev().prev().prev().prev().prev().prev().prev().html();
    // var dd = $(this).parent().prev().prev().prev().prev().prev().prev().html();
    // var ss = $(this).parent().prev().prev().prev().prev().prev().html();
    // //alert(ss);
    // // console.log("进入方userupdate法");
    // // var uName1 = $("#sidOrSname").val();
    // // var aTime1 = $("#udeOrUname").val();
    // // var dName1 = $("#didOrDname").val();
    // // var sName1 = $("#telOrDname").val();
    //
    // $("#uName2").attr('value', uu);
    // $("#aTime2").attr('value', aa);
    // $("#dName2").attr('value', dd);
    // $("#sName2").attr('value', ss);


    var uName = $("#uName2").val();
    var aTime = $("#aTime2").val();
    var dName = $("#dName2").val();
    var sName = $("#sName2").val();
    var department = $("#department").val();

    var state = $("input[name='state2']:checked").val();

    var vvv = {
        'userId': uid,
        'userName': uName,
        'userCode': aTime,
        'cardNo': dName,
        'mobile': sName,
        'department': department,
        'state': state
    };

    $.ajax({
        url: "/user/update",
        type: 'post',
        dataType: 'json',
        data: vvv,
        success: function (data) {
            // alert(data.data);

            if (data.resultCode = "200") {
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

//添加
function useradd() {

    console.log("进入方useradd法");

    var str = '';

    // 判断名称是否为中文
    if($.trim($('#uName').val()).length == 0) {
        str += '员工姓名没有输入\n';
        $('#uName').focus();
    } else {
        if(isChinaName($.trim($('#uName').val())) == false) {
            str += '员工姓名名称不合法，请输入中文\n';
            $('#uName').focus();
        }
    }
    // 判断部门是否为中文
    if($.trim($('#mobile').val()).length == 0) {
        str += '员工所属部门没有输入\n';
        $('#mobile').focus();
    } else {
        if(isChinaName($.trim($('#mobile').val())) == false) {
            str += '员工所属部门名称不合法,请输入中文\n';
            $('#mobile').focus();
        }
    }

    //验证工号
    if ($.trim($('#aTime').val()).length == 0) {
        str += '工号没有输入\n';
        $('#aTime').focus();
    } else {
        if (isNaN($("#aTime").val())) {
            str += '工号不合法，请输入数字\n';
            $('#aTime').focus();
        }
    }


    //验证手机号
    if ($.trim($('#sName').val()).length == 0) {
        str += '手机号没有输入\n';
        $('#sName').focus();
    } else {
        if (isPhoneNo($.trim($('#sName').val())) == false) {
            str += '手机号码不正确\n';
            $('#sName').focus();
        }
    }
    //验证身份证

    var selectdName=$('#dName').val();
    var flag=testId(selectdName);
    alert(flag);

    if($.trim(selectdName).length == 0) {
        str += '身份证号码没有输入\n';
        $('#dName').focus();
    } else {
        if(flag == false) {
            str += '身份证号不正确；\n';
            $('#dName').focus();
        }else {
            //15位转18为身份证
            selectdName=flag;

        }
    }

    if(str != '') {
        alert(str);
        return false;
    }

    var date = new Date(+new Date() + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '');
    var uName = $("#uName").val();//姓名
    var aTime = $("#aTime").val();//工号
    var dName = $("#dName").val();//身份证
    var sName = $("#sName").val();//电话
    var department = $("#mobile").val();//部门
    var vvv = {
        'userName': uName,
        'userCode': aTime,
        'cardNo': dName,
        'mobile': sName,
        'department': department,
        'createTime': date,
        'state': 1

    };
    $.ajax({
        url: "/user/add",
        type: 'post',
        dataType: 'json',
        data: vvv,
        success: function (data) {
            // alert(data.data);

            if (data.resultCode == "200") {
                console.log(data);
                alert("添加成功");
                // window.location.href = "http://localhost:8080/accept/test2"
                window.location.reload();

            } else if (data.resultCode == "1205") {

                alert("用户信息已经存在，不能重复添加!请检查工号！");
                // window.location.reload();
            }


            else if (data.resultCode == "1206") {
                alert("用户信息已经存在，不能重复添加!请检查身份证！");

            }
            else if(data.resultCode=="992"){

                alert("用户信息已经存在，不能重复添加!请检查身份证和工号！");
            }else {
                console.log(data);
                alert("添加失败，请联系工作人员！");
                //  window.location.href = "http://localhost:8080/accept/test3"
                //  window.location.reload();
            }
        }
    });
}

//删除
function userdelete(uid) {
    console.log("进入员工删除方法");
    console.log(uid);
    $.ajax({
        url: "/user/delete",
        type: 'post',
        dataType: 'json',
        data: {"userId": uid},
        success: function (data) {
            alert(data.resultCode);

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
//
// //添加模态框显示
//
// function modelxianshi() {
//     // 建立模态框对象
//     //var modalBox = {};
//     /*获取模态框*/
//     console.log("进入modelxianshi方法");
//     var modal = document.getElementById("myModal");
//     $("myModal").attr(" aria-hidden","false");
//     /*获得触发按钮*/
//     console.log("11111");
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
//     var modal = document.getElementById("myModal2");
//     //modal.show();
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
