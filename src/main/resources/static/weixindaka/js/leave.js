/**
 * Created by 朱翰林 on 2018/8/6.
 */



//补卡原因字数动态显示
	$("#leaveReason").keydown(function () {
	    var max = 30;
	    var value = $(this).val();//获取文本框的字符数
	
	    var coun = $("#contentCountLeft");//获取字数显示对象
	    if (value.length > max) {
	        $(this).val(value.substring(0, max));
	        coun.html(0);
	
	    } else {
	        coun.html(max - value.length);
	
	    }
	
	}).keyup(function () {
	
	    var max = 30;
	    var value = $(this).val();
	    var coun = $("#contentCountLeft");
	    if (value.length > max) {
	        $(this).val(value.substring(0, max));
	        coun.html(0);
	    } else {
	
	        coun.html(max - value.length);
	
	    }
	
	});

//获取当前时间后面一周的时间(开始时间)
function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
    //alert(dd.getDate);
    var y = dd.getFullYear();
    var m = dd.getMonth() + 1;//获取当前月份的日期
    var d = dd.getDate();
    return y + "-" + m + "-" + d;
}


$(
    function () {
        // alert(GetDateStr(0));
        // alert(GetDateStr(1));
        // alert(GetDateStr(2));
        // alert(GetDateStr(3));

        for (var i = 0; i < 7; i++) {

            var trs = '';

            trs += '<option value="' + GetDateStr(i) + '">' + GetDateStr(i) + '</option>';


            $("#leave-start-time").append(trs);
            endtimeinfo();

        }


    }
);


$(document).off('change', '#leave-start-time').on('change', '#leave-start-time', function () {

    endtimeinfo()
});


//获取当前时间后面一周的时间(结束时间)
function GetendStr(starttime, AddDayCount) {
    var dd = new Date(starttime);
    dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth() + 1;//获取当前月份的日期
    var d = dd.getDate();
    return y + "-" + m + "-" + d;
}


//动态获取结束时间

function endtimeinfo() {


    $("#leave-end-time").empty();
    $("#leave-end-time").append("<option id=" + 'end1' + " value=" + '0' + ">---请先选择开始日期(一次最多能请两天)--</option>");
    var starttime = $("#leave-start-time").val();
 
    for (var i = 0; i < 2; i++) {

        var trs = '';

        trs += '<option value="' + GetendStr(starttime, i) + '">' + GetendStr(starttime, i) + '</option>';

        $("#leave-end-time").append(trs);

    }


}


var path;
var flag = false;

//图片上传
function pictureupload() {
    //alert();
    //图片格式判断
    var filepath = $("#file").val();
    //检查是否为图片
    if (!isImage(filepath)) {
        return false;
    }
    //检查文件大小，不能超过2M
    if (!checkFileSize(filepath)) {
        return false;
    }

    var img_file = document.getElementById("file");
    var fileObj = img_file.files[0];//获取图片对象
    var fileName=fileObj.name;//获取文件名
    var  fileType=fileName.split(".")[1];//截取文件格式
    console.log(fileObj);
    let files = new FileReader();
    files.readAsDataURL(fileObj);//读取器读取
    files.onload = function () {
        let img = this.result;
        let bolb = dataURLtoBlob(img);//转二进制
        let formDate = new FormData();
        formDate.append("file", bolb);
        formDate.append("fileType",fileType);
        $.ajax({
            url: "/sysleave/pictureupload",
            type: 'post',
            dataType: 'json',
            processData: false,
            contentType: false,
            data: formDate,
            success: function (data) {
                if (data.resultCode == 400) {

                    alert(data.data);

                } else if (data.resultCode == 990) {

                    alert(data.data);
                } else {

                    console.log(data.data["path"]);
                    path = data.data["path"];
                    console.log(path);
                    flag = true;
                    alert("图片上传成功！");
                }

            }
        });
    };

}


//添加请假信息
function addleaveinfo() {
   
    //缓存
    let uid=localStorage.getItem("uid");
   

    if (flag == false) {
        alert("请先上传图片！");
        return;
    }

    var leaveStartTime = $("#leave-start-time").val();
    var leaveEndTime = $("#leave-end-time").val();

    if (leaveEndTime == "0") {
        alert("请选择结束时间！");
        return;

    }
    var leaveDay = $("#leave-days").html();
    var leaveReason = $("#leaveReason").val();
    if (leaveReason == "") {
        alert("请填写请假理由！");
        return;

    }

    var createTime = new Date(+new Date() + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '');
    var state = 1;


    var vals = {
        "leaveName": uid,
        "leaveStartTime": leaveStartTime,
        "leaveEndTime": leaveEndTime,
        "leaveDay": leaveDay,
        "leaveReason": leaveReason,
        "state": 1,
        "createTime": createTime,
        "picturePath": path

    };

    $.ajax({
        url: "/sysleave/addleaveinfo",
        type: 'post',
        dataType: 'json',
        data: vals,
        success: function (data) {
           alert(data.data)
            window.location.href = "../../adm/zhuye"	
        }
    });
}

//转字节
function dataURLtoBlob(dataURL) {
    var arr = dataURL.split(",");
    var mime = arr[0].match(/:(.*?);/)[1];
    var bStr = atob(arr[1]);
    var n = bStr.length;
    var u8arr = new Uint8Array(n);
    while (n--) {
        u8arr[n] = bStr.charCodeAt(n);
    }
    return new Blob([u8arr], {type: mime});
}




/* 检查是否为图片 */
function isImage(filepath) {
    //alert("1111");
    var extStart = filepath.lastIndexOf(".");
    var ext = filepath.substring(extStart, filepath.length).toUpperCase();
    if (ext != ".BMP" && ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
        alert("图片只能是bmp,png,gif,jpeg,jpg格式喔！");
        return false;
    }
    return true;
}


/* 检查图片大小，不能超过3M,支持IE、filefox、chrome */
function checkFileSize(filepath) {

    //alert("2222222");
    var maxsize = 2 * 1024 * 1024;//2M
    var errMsg = "上传的头像文件不能超过2M喔！！！";
    var tipMsg = "您的浏览器暂不支持上传头像，确保上传文件不要超过2M，建议使用IE、FireFox、Chrome浏览器。";

    try {
        var filesize = 0;
        var ua = window.navigator.userAgent;//判断浏览器类型
        if (ua.indexOf("MSIE") >= 1) {
            //IE
            var img = new Image();
            img.src = filepath;
            filesize = img.fileSize;//ie获取图片大小
        } else {
            //file_size = document.getElementById("imageFile").files[0].size;
            //不是ie获取图片大小
            filesize = $("#file")[0].files[0].size; //byte

        }

        if (filesize > 0 && filesize > maxsize) {
            alert(errMsg);
            return false;
        } else if (filesize == -1) {
            alert(tipMsg);
            return false;
        }
    } catch (e) {
        alert("头像上传失败，请重试");
        return false;
    }
    return true;
}


