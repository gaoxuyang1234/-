$(function(){
	
        //隐藏编辑器
        $("#close").click(function () {
            $(".ke-container").hide()
            $(".textareaAppend").hide().css('z-index', '-90')
        });
         kedit('#kindEditor_demo','');
        
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
             return new Blob([u8arr], { type: mime });
           }
        //富文本截图
        $("#sendReport").click(function () {
        	$('#sendReport').attr('disabled',"true");//添加disabled属性 
            html2canvas(document.querySelector(".ke-edit")).then(canvas => {
                var img=canvas.toDataURL("image/jpg");
                img=dataURLtoBlob(img)
                var ktext=$(".ke-edit-iframe").contents().find(".ke-content").text();
                if((consReceipt=="02"||consReceipt=="04")&&(ktext.indexOf("*"))!=-1){
                	$('#sendReport').removeAttr("disabled"); //移除disabled属性 
                	alert(consReceipt=="02"?"请在'****'处完善需要补正的材料名称，并删除'****'!":"请在'****'处完善驳回的信息,并删除****");
                	return false;
                }
                var fo=new FormData();
                fo.append("file",img);
                fo.append("accnodeId",$("#accnodeId").val());
                fo.append("accId",$("#accId").val());
                fo.append("uId",$("#toUser").val());
                fo.append("aId",$("#aId").val());
                fo.append("receiptContent",ktext);
                fo.append("consReceipt",consReceipt);
                //------------5-29-------------
                //let{obj:{oname:uName,osex:sex,ocardNo:cardNo,omobile:mobile,oaddress:address},sName,aTime,proposer}=OBK;
                let{sName,aTime,proposer}=OBK;
                let{uname:uName,mobile}=proposer;
                fo.append("mobile",mobile);
                fo.append("uName",uName);
                fo.append("sName",sName);
                fo.append("aTime",aTime);
                $.ajax({
                	url:"/acc/filhz",
                	cache: false,
                	data:fo,
                	dataType:"JSON",
                	type:"POST",
                	processData: false,
        			contentType: false,
                	success:function(data){
                		 if(data["resultCode"]==200){
                		      alert("回执成功");
                		      location.reload();
                		 }else{
                	        	$('#sendReport').removeAttr("disabled"); //移除disabled属性 
                		        alert("回执失败");
                		 }
                	}
                })
            });
        });
	        
     // 修改密码
        $(".change_password").click(function () {
            //页面层
            layer.open({
                type: 1,
                title: false,
                skin: 'layui-layer-rim', //加上边框
                area: ['530px', '300px'], //宽高
                content: `<form action="" method="get" class="password_form">
            <div><label for="old_password">请输入旧密码</label></div>
            <input type="password" class="old_password">
            <div><label for="new_password_first">请输入新密码</label></div>
            <input type="password" class="new_password_first">
            <div><label for="new_password_second">请再次输入新密码</label></div>
            <input type="password" class="new_password_second">
            <button type="button" onclick="savePwd()" class="btn">保存</button>
        </form>
               `
            });
        });
        // 左边栏头部切换
        function change(ele) {
            $(ele).click(function () {
                $(this).parent().children().removeClass('treebox_title_checked');
                $(this).addClass('treebox_title_checked')
            });
        }
        change('.treebox_title_left');
        change('.treebox_title_right');

    });



/**
 * 密码修改
 */
function savePwd(){
    //旧密码
    var oldPwd=$(".old_password").val();
    //新密码
    var newPwd=$(".new_password_first").val();
    //确认密码
    var reqPwd=$(".new_password_second").val();
    if(oldPwd==""||oldPwd==null){
        layer.msg("请输入原密码");
        return;
    }
    if(newPwd==""||newPwd==null){
        layer.msg("请输入新密码");
        return;
    }
    if(reqPwd==""||reqPwd==null){
        layer.msg("请输入确认密码");
        return;
    }
    if(reqPwd!=newPwd){
        layer.msg("两次输入密码不一致");
        return;
    }
    $.ajax({
        url:"/acc/updatePwd",
        type:"POST",
        data:{
            newPwd:newPwd,
            oldPwd:oldPwd,
            reqPwd:reqPwd
        },
        dataType:"json",
        success:function (data) {
            if(data["resultCode"]==200){
                //修改成功
                layer.msg(data["message"],{time:2000},function () {
                    window.location.href="/accept/tologin"
                });
            }else{
                layer.msg(data["message"])
                $(".old_password").val("");
                $(".new_password_first").val("");

                $(".new_password_second").val("");
            }
        }
    })
}

/**
 * 执行删除业务的操作
 * 
 */
;(function fund1(){
	$("#delyewu").click(function(){
		let accId=$("#accId").val();
		let aId=$("#aId").val();
	   if(accId&&aId){
		var bool=confirm("您正准备删除这个业务,确定吗?");
		if(bool){
			$.post("/acc/delApplys",{aId:aId,accId:accId},function(data){
					if(data["resultCode"]==200){
						alert("删除成功!!");
						location.reload();
					}else{alert("删除失败!!")}
			},"JSON");
		}
		}
		
	})
	
	
	
})();

//权限管理
function quanxian(){
	let roles=$.trim($("#roles").val());
	console.log("----这个角色的权限包括------");
	console.log(roles);
	$("#isdeal").click(function(){
		inxStr="A1";  //受理环节		
  	    fun01();
	})
	$("#isok").click(function(){
      	 inxStr="A2"; //审批环节
      	fun01();
    })
    if(roles.includes(obj_n["R3"])){		//审批
    	$("#isok").show().css("pointer-events","none"); //禁止点击
    	inxStr="A2";
    }
	if(roles.includes(obj_n["R1"])){		//待办
		$("#isdeal").show().css("pointer-events","none"); //禁止点击
    	inxStr="A1";
    	
	}
	if(roles.includes(obj_n["R1"])&&roles.includes(obj_n["R3"])){
    	$("#isok").css("pointer-events","");
    	$("#isdeal").css("pointer-events","").addClass("treebox_title_checked");
    }
    if(roles.includes(obj_n["R2"])){
    	inxStr="A1";
    	if(roles.includes(obj_n["R3"])){
    		$("#isdeal").show().css("pointer-events","").addClass("treebox_title_checked");
    		$("#isok").show().css("pointer-events","");
    	}else{
    		$("#isdeal").show().css("pointer-events","none");
    	}
    }
   inxStr=="A1"?($("#buthz").show(),$("#butqs").show()):($("#butsp").show(),$("#butspbh").show())
    
    
}
