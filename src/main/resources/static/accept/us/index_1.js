$(function(){

	$('.fancyboxVideo').fancybox({
		minWidth  : 400,
		minHeight : 500,
		
	});
	$('.fancybox').fancybox({
		
    	onCancel(){
    		
    	},
		beforeLoad(){           //加载前
    		
    	},   
		afterLoad(){		    //加载后
    		            
    	},   
		beforeShow(){           //打开前
    		let{time}=OBJSMS;
    		time&&time!=0?clearInterval(time):null;
    		$("#spanstr").html("");	
    		$("#zhis").html("");
    		$("#inline1").find("h3").html("短信呼叫")
    		$("#but_no").removeClass("button-primary");
    		$("#msg_str").html("正在发送短信...");
    	},
		afterShow(){			//打开后
    	   let objArr=OBJSMS["obj"];
    	   notice3(objArr);
    	   
    	},    
		beforeChange(){
    		
    	}, 
		beforeClose(){			//关闭前
    		          
    	}, 
		afterClose(){			//关闭后
    		let{time}=OBJSMS;
    		time&&time!=0?clearInterval(time):null;
    		OBJSMS["obj"]={};
    	}   
    });
	//过号
	$("#but_ok").click(function(){
		let bols= confirm("您确定要做过号处理吗?");
		if(bols){
			let lens=$(".treebox").offset().top;
			let {aid:aId,atime:aTime,isonline,mobile,sid:sId,state,uid:uId,uname:uName}=OBJSMS["obj"];
		$.post("/acc/updApplys",{aId,state:8,aTime,sId,uName,mobile})
 	  	 .then(function(data){
 	  		inxStr=="A1"&&sId?fun01(sId,function(bool,sId,strx){
 	            lickajax(sId,"", strx, function(strx,stry) {
 	       			let strz=strx.replace("{#0#}",stry).replace("{#1#}","display: block;");
 	                 $("#men").empty().append(strz)
 	                 $(".treebox").offset().top=lens;
 	                 ishide(8)
 	       		})
 	        }):location.reload();
 	  	 });
		$("#spanstr").html("<h4>正在发送过号信息,请稍后...<h4>")
		let{time}=OBJSMS;
		time&&time!=0?clearInterval(time):null;
		setTimeout(function() {
			$(".fancybox-close").click();
		},3000)
		
		}
	})
	//短信
	$("#but_no").click(function(){
	    if(!OBJSMS["butOk"]){return false};
	    let objArr=OBJSMS["obj"];
		$("#spanstr").html("");
		$("#msg_str").html("正在发送短信...");
		let{time}=OBJSMS;
		time&&time!=0?clearInterval(time):null;
		$("#but_no").removeClass("button-primary");
		OBJSMS["butOk"]=false;
		notice3(objArr);
	})
	
	
	$(".Chat_content_body_toolbar_first").click(function(){
		if($("#aId").val().length>0&&$("#isonline").val()==0){
			$("#hiddenVideo").click();
		}else if($("#aId").val().length==0){
			alert("请选择一个申请人!");
		}else if($("#isonline").val()!=0){
			alert("该申请人不在线，无法视频通话!");
		}
		
	});
	
})

function funSwal(title,text,fn){
	    swal({ 
		title: title, 
		text: text, 
		type: "warning", 
		showCancelButton: true, 
		closeOnConfirm: false, 
		confirmButtonText: "确定", 
		confirmButtonColor: "#ec6c62" 
	    },fn);
	}



