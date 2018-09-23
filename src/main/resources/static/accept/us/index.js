$(function(){
	Ibutqs();
	Ibutsp();

})

function Ibutqs(){
	$("#butqs").click(function(){
		var sId= $.trim($("#sId").val());
		var aId=$.trim($("#aId").val());
		if(!sId&&!aId){alert("请选择业务申请人!!"); return false};
		$.ajax({
		  url:"/acc/accUsRec",
		  dataType:"JSON",
		  type:"POST",
		  data:{aId:aId,sId:sId},
		  success:function(data){
			  if(data["resultCode"]==200){
			   $(".textareaAppend").show().css('z-index', '1');
			   $(".ke-container").show();
			   consReceipt="02";
			   var appUser= data["data"]["appUser"];
		   	   var accObj=data["data"]["accObj"];
		   	   var appFileName=data["data"]["appFileName"];
			   var strX= Istr();
			   strX=strX.replace("{aId}",appUser["aId"])
               .replace("{obj}",accObj["uname"])
               .replace(new RegExp("{date}","gm"),Idate())
       		   .replace("{bus}",appUser["sName"])
       		   .replace("{list}",(function(){
       		     var str=""; var arrs=[];
       		   if(appFileName&&appFileName["appCName"]){
       		   		  arrs=arrs.concat(appFileName["appCName"].split("%#%"));
       		   	   }
       		   if(appFileName&&appFileName["appFName"]){
       	              arrs=arrs.concat(appFileName["appFName"].split("%#%"));
       		   	   }
       		   	 $.each(arrs,function(i,o){str+="&nbsp;&nbsp;"+(i+1)+"、"+o+";</br>";}) 	
       		   		    return str;		
       		      })())
       		      .replace(new RegExp("{company}","gm"),appUser["dName"])
       		      .replace("{uName}",appUser["uName"])
       		   	  .replace("{endDate}",appUser["endDate"]||10)
       		   	  .replace("{acccode}",$("#accCode").val());
		           kedit('#kindEditor_demo',strX);
			  }
			 
			  
		  }		  
		})
		
	})
}



function Istr(){
    var str="";
    if(PDID==3){
    	str+=`<p style="text-align:center;">
    	<strong><span style="font-size:24px;">{company}为民服务中心</span></strong>
    	</p>
    	<p style="text-align:center;">
    	<span style="font-size:18px;"><strong>补正通知书</strong></span>
    	</p>`;
    }else{
    	str+=`<p style="text-align:center;">
    	<span style="font-size:18px;"><strong>{company}补正通知书</strong></span>
    	</p>`;
    }
    	str+='<div style="padding:0 20px">'
    	str+='<p style="text-align:right;">'
    	str+='<span style="font-size:12px;">编号：{aId}</span>'
    	str+='</p>'
    	str+='<span style="font-size:12px;">{obj}</span><br />'
   		str+='<span style="font-size:12px;">&nbsp; 本行政机关于{date}收到您申请的{bus}所上</span><span style="font-size:12px;">传的</span><span style="font-size:12px;">下载材料：<br/>'
    	str+='</span><span style="font-size:12px;">{list}</span>'
    	str+='<p>'
    	str+='<span style="font-size:12px;">&nbsp; 经核查，上述申请材料未全，您还需要补充下列材料：</span></br>'
    	str+='<span style="font-size:12px;">&nbsp;&nbsp;1、*****</span></br>'
    	str+='<span style="font-size:12px;">请您将上述需要补正的材料提交至本窗口,材料齐全后,本机关按照规定办理。</span><span style="font-size:12px;">审批时间({endDate}工作日个) 自材料补正齐全后开始计算</span>'
    	str+='</p>'
    	str+='<span style="font-size:12px;">&nbsp; &nbsp; &nbsp; &nbsp; 特此通知。</span> <br />'
    	str+='<p style="text-align:right;">'
        str+='<p>'
    	str+='<span style="font-size:12px;"> &nbsp; &nbsp; &nbsp;&nbsp;受理员工号：{acccode}</span>'
        str+='</p>'
    	//str+='<p>'
	    //str+='<span style="font-size:12px;"> &nbsp; &nbsp; &nbsp;&nbsp;本窗口联系电话：****</span>'
        //str+='</p>'
        str+='<p style="text-align:right;">'
    	str+='<span style="font-size:12px;">责任单位：{company}</span>'
    	str+='</p>'
    	str+='<span style="font-size:12px;">'
    	str+='<div style="text-align:right;">'
    	str+='<span style="font-size:12px;">日期：{date}</span><span style="font-size:12px;"></span>'
    	str+='</div>'
    	str+='</span><span style="font-size:12px;">申请人：{uName}</span>'
		str+='</div>'
		return str;
}

function Idate(){
     var myDate = new Date()
     myDate= myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate();
     return myDate;
}


function Ibutsp(){
	$("#butsp").click(function(){
		     var sId= $.trim($("#sId").val());
		     var aId=$.trim($("#aId").val());
		     if(aId&&sId){
		        $(".textareaAppend").show().css('z-index', '1');
		        $(".ke-container").show();
		        let obj={aId,sId};
		        $.ajax({url:"/acc/accUsRec",dataType:"JSON",type:"POST",
		          data:obj,success:function(data){
		   		  if(data["resultCode"]==200){
		   		    let {appUser,accObj,appFileName,extend}=data["data"];
		   		     consReceipt="03";
		   		     var strX=Ifunstr(appUser["mail"]);
		   		         strX=strX.replace("{aId}",appUser["aId"])
		   		            .replace("{obj}",accObj["uname"])
		   		            .replace(new RegExp("{date}","gm"),(function(){
		   		                var myDate = new Date()
		   		                myDate= myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate();
		   		                return myDate;
		   		            })())
		   		            .replace("{bus}",appUser["sName"])
		   		            .replace("{list}",(function(){
		   		             var str="";
		   		             var arrs=[];
		   		             if(appFileName&&appFileName["appCName"]){
		   		             	  arrs=arrs.concat(appFileName["appCName"].split("%#%"));
		   		             }
		   		             if(appFileName&&appFileName["appFName"]){
		   		             	  arrs=arrs.concat(appFileName["appFName"].split("%#%"));
		   		             }
		   		               $.each(arrs,function(i,o){
		   		               		str+="&nbsp; &nbsp;&nbsp;"+(i+1)+"、"+o+";</br>";
		   		               }) 	
		   		            	return str;		
		   		            })())
		   		           .replace(new RegExp("{company}","gm"),appUser["dName"])
		   		           .replace("{uName}",appUser["uName"])
		   		           .replace("{endDate}",appUser["endDate"]||10)
		   		           .replace("{acccode}",$("#accCode").val())
		   		           .replace("{address}", addressk);
						   kedit('#kindEditor_demo',strX);
		   			}else{
		   			    alert("数据有误");
		   			   }
		   			}
		   			}) 
		        }else{
		             alert("请选择业务申请人!!");
		        }
		       		
		   })
	
		   
		$("#butspbh").click(function(){
			 var sId= $.trim($("#sId").val());
		     var aId=$.trim($("#aId").val());
		     if(aId&&sId){
		        $(".textareaAppend").show().css('z-index', '1');
		        $(".ke-container").show();
		        let obj={aId,sId};
		        $.ajax({url:"/acc/accUsRec",dataType:"JSON",type:"POST",
		          data:obj,success:function(data){
		   		  if(data["resultCode"]==200){
		   		    let {appUser,accObj,appFileName,extend}=data["data"];
		   		     consReceipt="04";
		   		     var strX=Ifunbh();
		   		         strX=strX.replace("{aId}",appUser["aId"])
		   		            .replace("{obj}",accObj["uname"])
		   		            .replace(new RegExp("{date}","gm"),(function(){
		   		                var myDate = new Date()
		   		                myDate= myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate();
		   		                return myDate;
		   		            })())
		   		            .replace("{bus}",appUser["sName"])
		   		            .replace("{list}",(function(){
		   		             var str="";
		   		             var arrs=[];
		   		             if(appFileName&&appFileName["appCName"]){
		   		             	  arrs=arrs.concat(appFileName["appCName"].split("%#%"));
		   		             }
		   		             if(appFileName&&appFileName["appFName"]){
		   		             	  arrs=arrs.concat(appFileName["appFName"].split("%#%"));
		   		             }
		   		               $.each(arrs,function(i,o){
		   		               		str+="&nbsp; &nbsp;&nbsp;"+(i+1)+"、"+o+";</br>";
		   		               }) 	
		   		            	return str;		
		   		            })())
		   		           .replace(new RegExp("{company}","gm"),appUser["dName"])
		   		           .replace("{uName}",appUser["uName"])
		   		           .replace("{endDate}",appUser["endDate"]||10)
		   		           .replace("{acccode}",$("#accCode").val())
						   kedit('#kindEditor_demo',strX);
		   			}else{
		   			    alert("数据有误");
		   			   }
		   			}
		   			}) 
		        }else{
		             alert("请选择业务申请人!!");
		        }
		})
	
}


//审批回执.replace("{address}", addressk);
function Ifunstr(mail){
	let maistr=""
	mail==2?maistr="本部门将在10个工作日内将证件发送至您的地址：{address},请注意查收":maistr="请您在10个工作日内到本部门领取证件"
    var strX="";
	if(PDID==3){
    	strX+=`<p style="text-align:center;">
    	<strong><span style="font-size:24px;">{company}为民服务中心</span></strong>
    	</p>
    	<p style="text-align:center;">
    	<span style="font-size:18px;"><strong>审批通知书</strong></span>
    	</p>`;
    }else{
    	strX+=`<p style="text-align:center;">
    	<span style="font-size:18px;"><strong>{company}审批通知书</strong></span>
    	</p>`;
    }
    	strX+='<div style="padding:0 20px">'
    	strX+='<p style="text-align:right;">'
    	strX+='<span style="font-size:12px;">编号：{aId}</span>'
    	strX+='</p>'
    	strX+='<span style="font-size:12px;">{obj}</span><br />'
   		strX+='<span style="font-size:12px;">&nbsp; &nbsp; 本行政机关于{date}收到您申请的{bus}所上传的下载材料：</span><br/>'
    	strX+='</span><span style="font-size:12px;">{list}</span>'
    	strX+='<p>'
    	strX+='<span style="font-size:12px;">&nbsp; &nbsp; 经核查，上述申请材料齐全，符合法定形式，现已审批完毕,'+maistr+'</span></br>'
    	strX+='&nbsp; &nbsp; &nbsp;<span style="font-size:12px;">如有特殊情况，另行通知</span>'
    	strX+='</p>'
    	strX+='<span style="font-size:12px;">&nbsp; &nbsp; &nbsp; &nbsp; 特此通知。</span> <br />'
    	strX+='<p style="text-align:right;">'
    	strX+='<p>'
	    strX+='<span style="font-size:12px;">&nbsp; &nbsp; &nbsp; &nbsp;审批员工号：{acccode}</span>'
        strX+='</p>'
        strX+='<p style="text-align:right;">'
    	strX+='<span style="font-size:12px;">责任单位：{company}</span>'
    	strX+='</p>'
    	strX+='<span style="font-size:12px;">'
    	strX+='<div style="text-align:right;">'
    	strX+='<span style="font-size:12px;">日期：{date}</span>'
    	strX+='</div>'
    	strX+='</span><span style="font-size:12px;">申请人：{uName}</span>'
		strX+='</div>'
		return strX;
}

//审批驳回

function Ifunbh(){
    var strX="";
    if(PDID==3){
    	strX+=`<p style="text-align:center;">
    	<strong><span style="font-size:24px;">{company}为民服务中心</span></strong>
    	</p>
    	<p style="text-align:center;">
    	<span style="font-size:18px;"><strong>审批驳回通知书</strong></span>
    	</p>`;
    }else{
    	strX+=`<p style="text-align:center;">
    	<span style="font-size:18px;"><strong>{company}审批驳回通知书</strong></span>
    	</p>`;
    }
    	strX+='<div style="padding:0 20px">'
    	strX+='<p style="text-align:right;">'
    	strX+='<span style="font-size:12px;">编号：{aId}</span>'
    	strX+='</p>'
    	strX+='<span style="font-size:12px;">{obj}</span><br />'
   		strX+='<span style="font-size:12px;">&nbsp; &nbsp; 本行政机关于{date}收到您申请的{bus}所上传的下载材料：</span><br/>'
    	strX+='</span><span style="font-size:12px;">{list}</span>'
    	strX+='<p>'
    	strX+='<span style="font-size:12px;">&nbsp; &nbsp; 经审查，上述申请材料存在以下问题:</span></br>'
    	strX+='&nbsp; &nbsp; <span style="font-size:12px;">1.****</span>'
    	strX+='</p>'
    	strX+='<span style="font-size:12px;">&nbsp; &nbsp; &nbsp; &nbsp;现予驳回,特此通知。</span> <br />'
    	strX+='<p style="text-align:right;">'
    	strX+='<p>'
	    strX+='<span style="font-size:12px;">&nbsp; &nbsp; &nbsp; &nbsp;审批员工号：{acccode}</span>'
        strX+='</p>'
        strX+='<p style="text-align:right;">'
    	strX+='<span style="font-size:12px;">责任单位：{company}</span>'
    	strX+='</p>'
    	strX+='<span style="font-size:12px;">'
    	strX+='<div style="text-align:right;">'
    	strX+='<span style="font-size:12px;">日期：{date}</span>'
    	strX+='</div>'
    	strX+='</span><span style="font-size:12px;">申请人：{uName}</span>'
		strX+='</div>'
		return strX;
}