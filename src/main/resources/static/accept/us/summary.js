$(function(){
	$("#gosId").val()?$("#sidOrSname").val($("#gosId").val()):getCurrentMonth();
//	summLogin("",function(){
//		$("#pagination_4").empty().append(pagStr());
//	});
	summLogin("");
	paramevent();
	funclick();
	funModal();
	(function(){
		$.post("/sta/getdep").then(function(data){
			   let{dName,pDId}=data["data"];
			   dName&&pDId>2?$("#didOrDname").prop("disabled","true").prop("placeholder",dName):"";
		})
	})();
})

const OBJ={};
const ARRAY=[5,10,15,20,30];
const ModelObj={};

function summLogin(dataObj,fn){
	
	dataObj=dataObj||{currentPage:1,size:10,mas:funmas()};
	$.ajax({
		url:"/sta/uss",data:dataObj,async:false,dataType:"JSON",type:"POST",
		success:function(data){
		    let {data:{list,page}}= data;
		    let str=funstr(list);
			$("#tbs").empty().append(str||"<tr><td colspan=9>暂无数据</td></tr>");
			let{count,pageCount,size,currentPage}=page
			OBJ["count"]=count;
			OBJ["pageCount"]=pageCount;
			OBJ["size"]=size;
			OBJ["currentPage"]=currentPage;
			fn?fn():$("#pagination_4").empty().append(pagStr());
		}

	})

}

function getmail(){
	function funmail(mailCode,mailName){
		this.mailCode=mailCode;
		this.mailName=mailName;
	}
	
	return [
		new funmail("EMS","EMS"),
		new funmail("SF","顺丰速运"),
		new funmail("HTKY","百世快递"),
		new funmail("ZTO","中通快递"),
		new funmail("STO","申通快递"),
		new funmail("YTO","圆通快递"),
		new funmail("YD","韵达速递"),
		new funmail("YZPY","邮政快递包裹"),
		new funmail("HHTT","天天快递"),
		new funmail("JD","京东物流"),
	]
	
}

//拼接核心字符串
function funstr(list){
	let str=""
	$.each(list,function(i,obj){
		let{sName,uName,accCode,aId,sId,uId,aTime,state,dName,yuanFlag,zhengFlag,mail,lev}=obj;
		lev==1?lev="<span style='color:blue'>满意<span>":lev==2?lev="<span style='color:green'>一般<span>":lev==3?lev="<span style='color:red'>不满意<span>":"";
		state==0?state="已办结":
		state==1?state="未排队":
		state==2?state="未受理":
		state==3?state="受理中":
		state==4?state="已受理":
		state==5?state="受理驳回":
		state==6?state="审批通过":
		state==7?state="审批驳回":
		state="暂无数据";
		//<td width="10%">${mail==2?'需要':'否'}</td>
str+=`<tr ><td width="10%">${new Date(aTime).Format("yyyy-MM-dd")}</td>
        <td width="25%">${sName||"暂无数据"}</td>
        <td width="10%">${uName||"暂无数据"}</td>
        <td width="10%">${accCode||"暂无数据"}</td>
        <td width="10%">${state}</td>
        <td width="5%">${lev||"-"}</td>
        <td width="10%">${yuanFlag==2?'已收回':'-'}</td>
        <td width="10%">${mail==2&&zhengFlag==1?'需要':mail==2&&zhengFlag==2?"已邮寄":"-"}</td>
        <td width="10%" data-aId=${aId} data-uId=${uId}
      	 data-sId=${sId} data-accCode=${accCode} data-aTime=${aTime} data-dName=${dName} data-sName=${sName}>
         	<a class="icon_view icon_xiangqing" title="详情" id="icon_view">详情</a>
         	${yuanFlag==2?'<a class="icon_view icon_yuanFlag" title="详情" id="icon_view">原件</a>':""}
         	${mail==2?'<a class="icon_view icon_youji" title="邮寄" id="icon_youji">邮寄</a>':''} 
        </td>
        </tr>`;
	})
	return str;
}

        
function paramevent(){
	 let timer=0;
        //点击详情触发
       $(document).on("click",".icon_xiangqing",function(){
        		let obj= $(this).parent()[0].dataset;
        		let {aid:aId,uid:uId,sid:sId,acccode:accCode}=obj
        		obj={aId,uId,sId,accCode};
        		window.open(`/accept/goindex_x?aId=${aId}`);
       })
       
       $("#butCX").click(function(){
    	    funObj({});
            summLogin(OBJ,function(){
       			$("#pagination_4").empty().append(pagStr());
       		});
       })
      
       $("#udeOrUname")[0].oninput=function(){
    	   if(!timer){
    		   timer=setTimeout(function() {
    			   funObj({});
                   summLogin(OBJ,function(){
              			$("#pagination_4").empty().append(pagStr());
              		});
                   timer=0;
    		   },500)
    	   }
        }
       $("#sidOrSname")[0].oninput=function(){
    	   if(!timer){
    		   timer=setTimeout(function() {
    			   funObj({});
                   summLogin(OBJ,function(){
              			$("#pagination_4").empty().append(pagStr());
              		});
                   timer=0;
    		   },500)
    	   }
    	 
        }
       
       $("#didOrDname")[0].oninput=function(){
    	   if(!timer){
    		   timer=setTimeout(function() {
    			   funObj({});
                   summLogin(OBJ,function(){
              			$("#pagination_4").empty().append(pagStr());
              		});
                   timer=0;
    		   },500)
    	   }
    	 
        }

 }

function funclick(){
	$(document).on("click",".pagx",function(){
 	   let index= $(this).text()
 	   funObj({currentPage:index});
 	   summLogin(OBJ,function(){
			$("#pagination_4").empty().append(pagStr(undefined,index));
		});
    })
     $(document).on("click",".shouye",function(){ 	  
       funObj({});	
 	   summLogin(OBJ,function(){
			$("#pagination_4").empty().append(pagStr(undefined,1));
		});
    })  
    
     $(document).on("click",".prevye",function(){
    	let{currentPage}=OBJ;
       funObj({currentPage});	
 	   if(currentPage&&currentPage>1){OBJ["currentPage"]--}
 	   summLogin(OBJ,function(){
			$("#pagination_4").empty().append(pagStr(undefined,OBJ["currentPage"]));
		});
    })
    
      $(document).on("click",".nextye",FX)
      function FX(){
		  $(document).off('click',".nextye");
	    	setTimeout(function() {
	    	   funObj({currentPage:OBJ["currentPage"],pageCount:OBJ["pageCount"]});
	    	 	   if(OBJ["currentPage"]&&OBJ["currentPage"]<OBJ["pageCount"]){OBJ["currentPage"]++}
	    	 	   summLogin(OBJ,function(){
	    				$("#pagination_4").empty().append(pagStr(undefined,OBJ["currentPage"]));
	    			});
	    	    	 $(document).on('click',".nextye",FX);
	    	},200)
	     }

	
    
    $(document).on("click",".tailye",function(){
    	let {currentPage,pageCount}=OBJ;
       funObj({currentPage,pageCount});
 	   if(currentPage&&currentPage<pageCount){OBJ["currentPage"]=OBJ["pageCount"]}
 	   summLogin(OBJ,function(){
			$("#pagination_4").empty().append(pagStr(undefined,OBJ["currentPage"]));
		});
 	   
    })
    
    $(document).on("change",".selectid",function(){
    	funObj({size:$(this).val()});
 	   summLogin(OBJ,function(){
			$("#pagination_4").empty().append(pagStr());
		});
 	   
    })
    
    $(document).on("change","#inptval",function(){
 	   let num= $.trim($("#inptval").val());
 	   if(num&& /^[0-9]*$/.test(num)){
	    	num=Number(num);
	    	if(num>OBJ["pageCount"])
	    	$("#inptval").val(OBJ["pageCount"]);
	    }else{
	    	$("#inptval").val(1);
//	    	alert("请输入整数数字!!");
	    	return false;
	    }
    })
    $(document).on("click","#querens",function(){
 	   let num= parseInt($.trim($("#inptval").val()));
 	   if(num<=OBJ["pageCount"]&&num>=1){
 		   funObj({currentPage:num});
 		   summLogin(OBJ,function(){
 	   			$("#pagination_4").empty().append(pagStr(undefined,num,num));
 	   		});
 	   }
 	   
    })
    $(document).on("click","#refre",function(){
     	$("#sidOrSname").val("");
     	$("#udeOrUname").val("");
     	getCurrentMonth();
     	funObj({});
     	summLogin(OBJ,function(){
 	   			$("#pagination_4").empty().append(pagStr(undefined,1));
 	   		});
    
    })
	
	
}

 //参数索取
 function funmas(){
     maps={};
     let udeOrUname=$.trim($("#udeOrUname").val())
     let sidOrSname=$.trim($("#sidOrSname").val()) 
     let didOrDname=$.trim($("#didOrDname").val())
     let befDate=$.trim($("#start").val());
     let aftDate=$.trim($("#end").val());
     if(udeOrUname)
     maps["udeOrUname"]=udeOrUname;
     if(sidOrSname)
     maps["sidOrSname"]=sidOrSname;
     if(didOrDname)
     maps["didOrDname"]=didOrDname;
     if(befDate){
     maps["befDate"]=befDate;
     maps["aftDate"]=aftDate||(function(){
  	   let date= new Date().Format("yyyy-MM-dd");
  	   $("#end").val(date);return date;
     })();
     }
     return maps;
 }
   
 function funObj({mas=funmas(),count=0,pageCount=0,currentPage=1,size=OBJ["size"]}){
		OBJ["mas"]=mas;
		OBJ["count"]=count;
		OBJ["pageCount"]=pageCount;
		OBJ["currentPage"]=currentPage;
		OBJ["size"]=size;
}
 
 function pagStr(pagetotl=5,current=1,page=""){
	 let {pageCount,count,size,currentPage}=OBJ;
	 let str=`<div class="whj_jqueryPaginationCss-1">
	          <div class="whj_border whj_padding whj_bgc ${currentPage==1?"whj_hoverDisable":"whj_hover"} shouye" name="whj_firstPage">首页</div>
	          <div class="whj_border whj_padding whj_bgc ${currentPage==1?"whj_hoverDisable":"whj_hover"} prevye" name="whj_previousPage">上一页</div> 
	          {0}
	          <div class="whj_border whj_padding whj_bgc ${currentPage==pageCount?"whj_hoverDisable":"whj_hover"} nextye" name="whj_nextPage">下一页</div>
	          <div class="whj_border whj_padding whj_bgc ${currentPage==pageCount?"whj_hoverDisable":"whj_hover"} tailye" name="whj_lastPage">尾页</div>
	          <select class="whj_border whj_bgc  selectid" name="whj_pageSize" >
	 		   {1}
	          </select>
	          <div class="whj_padding whj_color">跳至</div>
	          <input type="text" id=inptval class="whj_border whj_color " name="whj_toPage" value="${page}">
	          <div class="whj_border whj_padding whj_bgc whj_hover" name="whj_confirm" id="querens">确认</div>
	          <div class="whj_border whj_padding whj_bgc whj_hover" name="whj_refresh" id="refre">刷新</div>
	          <div class="whj_padding whj_color">共${OBJ["pageCount"]||0}页</div></div>`
			   str=str.replace("{0}",(function(){
			    	let sub="";
			    	if(pageCount&&pageCount>0){
			    		let current2=1
			    		if(current>=3){current2=current,current2=current2-2}
			    		if(pageCount<pagetotl){pagetotl=pageCount};
			    		if(current==pageCount){pagetotl=3}
			    		if(pageCount-current<5){
			    			let zhi= pageCount-current2+1;
			    				zhi>5?pagetotl=pagetotl:pagetotl=zhi;
			    		}
			    		
			    		for(i=1;i<=pagetotl;i++){
			    		 sub+=`<div style="width:50px" class="whj_border whj_padding whj_bgc ${current&&current==current2?"whj_checked":"whj_hover"} pagx" name="whj_page" data-page="${current2}">${current2}</div>`
			    		   current2++;
			    		}
			    	}
			    	return sub;
			    })()).replace("{1}",function(){
			       let str="";
			       ARRAY.forEach(function(z,i){
	        	  str+=`<option value="${z}" ${z==OBJ["size"]?"selected=''":""}" >${z}条/页</option>`
	          		})
	              return str;
			    }.call(null))
			    return str;
 }
   
 /**
  * 处理模态框事件与其数据
  */
 function funModal(){
	  $("#myModal").on("hidden.bs.modal",function(){
		  		$("#myModal").find(".form-control").val("");
		  		$("#textarea").empty().prop("placeholder","");
		  		delete ModelObj["obj"];
		  		delete ModelObj["logis"];
	  })
	  //点击邮寄按钮触发
	  $(document).on("click",".icon_youji",function(){
		  let obj= $(this).parent()[0].dataset;
		  mainCode(obj,2);  
	  })
	
	  
	  
	  //点击原件回收触发
	  $(document).on("click",".icon_yuanFlag",function(){
		  let obj= $(this).parent()[0].dataset;
		  mainCode(obj,1);  
	  })
	  
	  
	  //点击提交按钮
	  $('#myModal').find(".modal-footer>.btn-primary")
	   .click(function(){
		   let logisticsComp= $.trim($("#sel").val());
		    let logisticsNo= $.trim($("#mail").val());
		    if(!logisticsComp){$("#sel").focus();return false;}
		    if(!logisticsNo){$("#mail").focus();return false;}
		    let logis= ModelObj["logis"]
		    let{aid:aId,uid:uId,sid:sId,acccode:accCode,atime,sname,dname}= ModelObj["obj"];
		    let url="";
		    let{logisticsId}=logis?logis:{};
		    $.post(`${logis?"/sta/updateLogistics":"/sta/addLogistics"}`,{logisticsId:logisticsId||null,aId,uId,logisticsType:2,logisticsNo,logisticsComp})
		     .then(function(data) {
		     	 if(data["resultCode"]==200){
		     		 alert("提交成功");
		     		$('#myModal').modal('hide');
		     	 }
		     })
	  })
	  
	  /**
	   * 原件收回&证件邮寄使用同一个模板
	   */
	  function mainCode(obj,inx){
		  let{aid:aId,uid:uId,sid:sId,acccode:accCode,atime,sname,dname}=obj;
		  ModelObj["obj"]=obj;
		  atime= new Date(Number(atime)).Format()
		  let $express= $("#express");
		  let $mail= $("#mail");
		  let $dzOrsj=$("#dzOrsj");
		  inx==1?
		  ($express.prop("readonly",true),$mail.prop("readonly",true),$dzOrsj.prev().text("邮寄时间"),$("#myModalLabel").text("原件收回"))
		 :($express.prop("readonly",false),$mail.prop("readonly",false),$dzOrsj.prev().text("邮寄地址"),$("#myModalLabel").text("证照邮寄"))
		  $('#myModal').modal('show');
		  //查询业务对象信息和邮寄信息
		  $('#myModal').one('shown.bs.modal',function(){
			  	$.post("/sta/viewObjAndLogis",{aId,logisticsType:inx})
			  	 .then(function(data){
			  		  let{view,logis}=data["data"];
			  		  let{aId,address="暂无数据",cardno,mobile,sex,uname}=view;
			  		  let{logisticsId,logisticsType,logisticsComp,logisticsNo,logisticsFpath,logisticsTime}=logis?logis:{};
			  		  let footbut= $('#myModal').find(".modal-footer>.btn-primary");
				  	  //生成下拉框start
			  		  let str=``;
		  			  $.each(getmail(),function(index,obj){
		  					str+=`<option value='${obj.mailCode}' ${logisticsComp==obj.mailCode?'selected':''}>${obj.mailName}</option>`
		  			  })
			  		  $('#sel').empty().append(str);
		  			  //生成下拉框end
			  		  if(!logis){
			  			ModelObj["logis"]=false;
			  			footbut.prop("disabled",false).text("提交")
			  		  }else{
			  			ModelObj["logis"]=logis;
			  			if(inx==1){
			  				footbut.prop("disabled",true).text("提交");
			  				address="";
			  				$("#sel").prop("disabled", true);
			  				youjixinx(aId,1);
			  			}else{
			  				footbut.prop("disabled",false).text("修改")
			  				$("#sel").prop("disabled", false);
			  				youjixinx(aId,2);
			  			}
			  		  }
			  		  inx==1?
			  		  $("#dzOrsj").val(new Date(logisticsTime).Format()||"暂无数据"):$("#dzOrsj").val(address||"暂无数据");
			  		  $("#mobile").val(mobile||"暂无数据");
			  		  $("#uName").val(uname||"暂无数据");
			  		  $("#aTime").val(atime||"暂无数据");
			  		  $("#sName").val(sname||"暂无数据");
			  		  $("#dName").val(dname||"暂无数据");
			  		  $("#express").val(logisticsComp||"");
			  		  $("#mail").val(logisticsNo||"");
			  	})
		  })

     }	  
	  /**
	   * 调取邮寄的接口
	   */
	  function youjixinx(aId,logisticsType){
		  $.post("/sta/wlcx",{aId,logisticsType},function(data){
			  console.log(data); 
			  let{reason,success,traces}=data["data"]["obj"];
			   let str=``;
			   if(success){
				   traces= traces.reverse();
				   $.each(traces,function(i,o){
					   str+=`${o["acceptTime"]}\n`
					   str+=`${o["acceptStation"]}\n`
				   })
				   traces.length<=0?str+=`${reason}`:"";
			   }else{
				   str+=`${reason}`
			   }
			   $("#textarea").empty().prop("placeholder",str);
		  })
		  
	  }
	  
  }      
        
 function getCurrentMonth(){
	 var date=new Date();
	 date.setDate(1);
	 let da1=date.Format("yyyy-MM-dd")
	 let da2= new Date().Format("yyyy-MM-dd");
	 $("#start").val(da1);
	 $("#end").val(da2);
  }
        
;(function(){
    Date.prototype.Format = function (fmt) { 
    	           if(fmt==undefined||fmt==null||fmt.length<=0)
    	           fmt="yyyy-MM-dd hh:mm";
  			    var o = {
  			        "M+": this.getMonth() + 1,
  			        "d+": this.getDate(),
  			        "h+": this.getHours(), 
  			        "m+": this.getMinutes(), 
  			        "s+": this.getSeconds(), 
  			        "q+": Math.floor((this.getMonth() + 3) / 3), 
  			        "S": this.getMilliseconds()
  			    };
  			    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  			    for (var k in o)
  			    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
  			    return fmt;
  	}
  })();