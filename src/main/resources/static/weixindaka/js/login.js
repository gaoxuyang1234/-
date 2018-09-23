/**
 * Created by 朱翰林 on 2018/7/31.
 */

// 验证手机号
function isPhoneNo(sName) {
    var pattern = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
    return pattern.test(sName);
}
//




//验证手机号码是否11位，控制获取验证码按钮状态
function upperCase() {
 
    var phone = $("#cellphone").val();
    if (isPhoneNo($.trim($('#cellphone').val())) == true) {
        $('#btn').attr('disabled', false);
        $("#btn").removeClass("noclick").addClass("click");
    } else {
        $("#btn").removeClass("click").addClass("noclick");
    }
}
$('#cellphone').on("input", function () {
    upperCase();
});
//获取验证码两次相隔60秒
var countdown = 60;

//获取验证码
function sendyzm() {
    var obj = $("#btn");
    settime(obj);
    //获取手机号码
    var phone = $('#cellphone').val();


    var myDate = new Date();
    // alert(myDate)
    //获取当前年
    var year=myDate.getFullYear();

    //获取当前月
    var month=myDate.getMonth()+1;
    //获取当前日
    var date=myDate.getDate();
    var h=myDate.getHours();       //获取当前小时数(0-23)
    var m=myDate.getMinutes();     //获取当前分钟数(0-59)
    var s=myDate.getSeconds();

    var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;

  

    $.ajax({
        url: "/sysuser/fsyzm",
        type: 'post',
        dataType: 'json',
        data: {"phone": phone,"fsshijian":now},
        success: function (data) {
   
            console.log(data.data);
            if (data.respCode == "00141") {
                alert("一小时内发送给单个手机次数超过限制!请稍后再试！");
           
            } else if (data.respCode == "00025") {
                alert("手机号格式错误！请检查手机号！");
              

            } else {
                //alert("验证码已经发送，请注意查收！")

            }
        }
    });


}

$('#yzm').on("input", function () {
    yanzyzm();
});

//验证验证码
function yanzyzm() {
    var myDate = new Date();
   
//获取当前年
    var year=myDate.getFullYear();

//获取当前月
    var month=myDate.getMonth()+1;
//获取当前日
    var date=myDate.getDate();
    var h=myDate.getHours();       //获取当前小时数(0-23)
    var m=myDate.getMinutes();     //获取当前分钟数(0-59)
    var s=myDate.getSeconds();

    var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;

    var yzm = $("#yzm").val();
    if (yzm.length == 6) {
        $.ajax({
            url: "/sysuser/yzyzm",
            type: 'post',
            dataType: 'json',
            data: {"yzm": yzm,"yzshijian":now},
            success: function (data) {
                // alert(data.data);
                console.log(data.data);
                if (data.resultCode == "200") {
                    //alert("验证成功！");
                    $("#topunch").removeClass("noclick").addClass("click");
                    $("#topunch").attr('disabled', false);
                } else if(data.resultCode == "400"){
                     alert("验证码已经失效，请重新获取！")
                }
                else if(data.resultCode == "993") {
                    alert("系统错误！");
                }else {
                    alert("验证失败！请重新输入！")

                }
            }
        });
    }
}


//发送验证码倒计时
function settime(obj) {
    if (countdown == 0) {
        obj.attr('disabled', false);
        obj.val("获取验证码");
        $("#btn").removeClass("noclick").addClass("click");
        countdown = 60;
        return;
    } else {
        obj.attr('disabled', true);
        obj.val("重新发送(" + countdown + ")");
        countdown--;
        $("#btn").removeClass("click").addClass("noclick");
    }
    setTimeout(function () {
        settime(obj)
    }, 1000)
}


function yanzhen() {

    var str = '';
//判断名称是否为中文
    if ($.trim($('#uName').val()).length == 0) {
        str += '员工姓名没有输入\n';
        $('#uName').focus();
    }
//验证码验证

    //提交验证

    if (str != '') {
        alert(str);
        return false;
    }

    var uName = $("#uName").val();//姓名或者工号
    var phone = $("#cellphone").val();//电话
    var check = "";//判断是姓名还是工号

    if (isNaN(uName)) {
        check = "useName";
    } else {
        check = "useCode";
    }

    var vvv = {
        "uName": uName,
        "mod": phone,
        "code": check

    };

    $.ajax({
        url: "/sysuser/login",
        type: 'post',
        dataType: 'json',
        data: vvv,
        success: function (data) {
            // alert(data.data);

        	
        	
    
        	if (data.resultCode == "200") {
                //alert("恭喜您！登陆成功！");
                //把用户id存入缓存
                localStorage.setItem("uid",data.data.userId );
                window.location.href = "../../adm/zhuye"

            } else if (data.resultCode == "997") {
                alert("员工信息无效！请联系工作人员！：110");                
            } else {
               
                alert("登陆失败！请检查用户名和密码！");
               
            }
        }
    });


}