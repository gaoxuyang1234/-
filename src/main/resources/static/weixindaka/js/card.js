/**
 * Created by 朱翰林 on 2018/8/3.
 */



//初始化，加载当前用户信息,从cookie中获取用户id
$(
    function () {
      //缓存
        let uid=localStorage.getItem("uid");
       
        $.ajax({
            url: "/syscardcotroller/addcardinfo",
            type: 'post',
            dataType: 'json',
            data: {"uid": uid},
            success: function (data) {
                // alert(data.data);
                if (data.resultCode == "200") {
                    console.log(data.data);
                    //alert("获取用户信息成功");
                    
                    for (var i = 0; i < data.data.length; i++) {
                        var cid = data.data[i].punchId;
                        var trs = '';
                        if (data.data[i].punchStartTime == null && data.data[i].state == 1 && data.data[i].punchState != "2") {
                            trs += '<option value="' + cid + '">' + data.data[i].createTime + '(补签到)' + '</option>';
                        }
                        else if (data.data[i].punchEndTime == null && data.data[i].state == 1 && data.data[i].punchState != "2") {
                            trs += '<option value="' + cid + '" >' + data.data[i].createTime + '(补签退)' + '</option>';
                        }else{ alert("没有需要补卡的记录继续保持")}

                        $("#riqi").append(trs);
                    }
                } else {                   
                    alert("没有打卡记录");                  
                }
            }
        });


    }
);


$(document).off('change', '#riqi').on('change', '#riqi', function () {

    shiftinfo()
});


//获取班次列表
function shiftinfo() {

    $("#shift").empty();
    $("#shift").append("<option value=" + '0' + ">----请选择班次----</option>");

    $.ajax({
        url: "/sysshift/selallshinfo",
        type: 'post',
        dataType: 'json',
        //data: {"uid": 1},
        success: function (data) {
            // alert(data.data);
            if (data.resultCode == "200") {
                console.log(data.data);
                //alert("获取班次信息成功");
               
                for (var i = 0; i < data.data.length; i++) {
                   
                    var trs = '';
                    if (data.data[i].state == 1) {
                        trs += '<option value="' + data.data[i].shiftName + '" >' + data.data[i].shiftName + '</option>';
                    }   
                    $("#shift").append(trs);
                }

            } else {
                alert("查询不到班次信息！2")
            }
        }
    });


}


//补卡原因字数动态显示
$("#cardReason").keydown(function () {
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
    var fileObj = img_file.files[0];//获取图片对象数组  包括时间名字
    var fileName=fileObj.name;//获取文件名
    var  fileType=fileName.split(".")[1];//截取文件格式
    //console.log(fileType);
    let files = new FileReader();//FileReader读取器
    console.log(files);
    files.readAsDataURL(fileObj);//读取器读取
    files.onload = function () {
        let img = this.result;
        let bolb = dataURLtoBlob(img);//转二进制
        let formDate = new FormData();
        formDate.append("file", bolb);
        formDate.append("fileType",fileType);
        $.ajax({
            url: "/syscardcotroller/pictureupload",
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

//补卡信息添加

function addcardinfo() {
   
  
    let uid=localStorage.getItem("uid");

    if (flag == false) {
        alert("请先上传图片！");
        return;
    }


    var pid = $("#riqi").val();
    if (pid == "0") {
        alert("请选择日期！");
        return;
    }
    // alert(pid);
    var cardtime = $("#riqi option:checked").text();
    var cardtimesub = cardtime.substring(0, 10);
    // alert(cardtimesub);
    var place = $("#locale").html();
    var cardReason = $("#cardReason").val();
    if (cardReason == "") {
        alert("请填写补卡理由！");
        return;

    }
    var shiftName = $("#shift").val();
    if (shiftName == "0") {
        alert("请选择班次！");
        return;
    }
    var createTime = new Date(+new Date() + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '');
    var state = 1;


    var vals = {
        "cardUserId": uid,
        "pid": pid,
        "cardTime": cardtimesub,
        "cardReason": cardReason,
        "shiftName": shiftName,
        "createTime": createTime,
        "satte": state,
        "cardPlace": place,
        "picturePath": path
    };
    $.ajax({
        url: "/syscardcotroller/addcard",
        type: 'post',
        dataType: 'json',
        data: vals,
        success: function (data) {
            alert(data.data)
            window.location.href = "../../adm/zhuye";
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
        alert("头像只能是bmp,png,gif,jpeg,jpg格式喔！");
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


