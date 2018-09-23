$(function(){
	$("#gosId").val()?$("#sidOrSname").val($("#gosId").val()):getCurrentMonth();
//	summLogin("",function(){
//		$("#pagination_4").empty().append(pagStr());
//	});
	summLogin("");
	paramevent();
	funclick();
	funModal();
	fundAcc();
	fundAdd();
	(function(){
		/*$.post("/sta/getdep").then(function(data){
			   let{dName,pDId}=data["data"];
			   dName&&pDId>2?$("#didOrDname").prop("disabled","true").prop("placeholder",dName):"";
		})*/
	})();
})

const OBJ={};
const ARRAY=[5,10,15,20,30];
const ModelObj={};

function summLogin(dataObj,fn){
	
	dataObj=dataObj||{currentPage:1,size:10,mas:funmas()};
	$.ajax({
		url:"/AccountAdminister/query",data:dataObj,async:false,dataType:"JSON",type:"POST",
		success:function(data){
		    let {data:{list,pageNum,pageSize,size,pages}}= data;
		    let str=funstr(list);
			$("#tbs").empty().append(str||"<tr><td colspan=9>暂无数据</td></tr>");
			OBJ["size"]=pageSize;
			OBJ["pages"]=pages;
			OBJ["pageSize"]=pageSize;
			OBJ["pageNum"]=pageNum;
			OBJ["currentPage"]=pageNum;
			fn?fn():$("#pagination_4").empty().append(pagStr());
		}

	})

}


//拼接核心字符串
function funstr(list){
	let str=""
	$.each(list,function(i,obj){
		let{accId,accCode,accName,roleName,dName,cTime,state}=obj;
		state==0?state="有效":state==1?state="无效":"";
		//state==0?state="<span style='color:blue'>满意<span>":state==1?state="<span style='color:red'>不满意<span>":"";
		str+=`<tr ><td width="10%">${new Date(cTime).Format("yyyy-MM-dd")}</td>
			<td width="10%">${accCode||"暂无数据"}</td>
			<td width="15%">${accName||"暂无数据"}</td>
			<td width="15%">${dName||"暂无数据"}</td>
	        <td width="20%">${roleName||"暂无数据"}</td>
	        <td width="15%">${state||"--"}</td>
	        <td width="15%" data-accId=${accId} data-accCode=${accCode}
	      	 data-accName=${accName} data-roleName=${roleName} data-dName=${dName}
	      	 data-cTime=${cTime} data-state=${state} >
	        	<a class="icon_view icon_acc" title="删除" id=${accId}>删除</a>
	            <a class="icon_view icon_youji" title="编辑" id=${accId}>编辑</a>
	        </td>
      </tr>`;
	})
	return str;
}

//点击删除触发
function fundAcc(){
	$(document).on("click",".icon_acc",function(){
		let code= this.id
		if(confirm('确定删除么')){
			$.ajax({
		        url:"/AccountAdminister/remove",
		        data:{accId:code},
		        type:"POST",
		        dataType:"text",
		        success:function(data){
			        data =JSON.parse(data)
			        if(data.resultCode == 200){
			        	alert("删除成功"); 
			        	window.location.reload();
			        }else{
			            alert("删除失败");    
			        }
		        }
		    });
		}
	});
}


//点击新增触发
function fundAdd(){
	$("#butTJ").click(function(){
		  document.getElementById("text").innerHTML='';
		  $("#dName").prop("readonly",false);
		  $(".pd").prop("readonly",false);
		  $("#uName").prop("readonly",false);
		  $(".pd").prev().text("登录密码");
		  $(".pd").prop('type','password');
		  $("#myModalLabel").text("新增账户信息");
		  $("#roleradio").hide();
		  $("#zt").hide();
		  $('#myModal').modal('show');
		  $('#myModal').one('shown.bs.modal',function(){
			  $.post("/AccountAdminister/queryDepartment")
			   .then(function(data){
			  	    let {data:list}= data;
			  		let footbut= $('#myModal').find(".modal-footer>.btn-primary");
			  		let a=0;
				  	 //生成下拉框start
			  		 let str=``;
			  		 $.each(list,function(index,obj){
	  				     str+=`<option value='${obj.dId}' ${dName==obj.dName?'selected':''}>${obj.dName}</option>`
	  			     })
			  		 $('#sel').empty().append(str);
		  			 //生成下拉框end
			  		footbut.prop("disabled",false).text("提交");
			  		$("#rolecheck").empty();
				  	$.post("/AccountAdminister/queryRole")
				  	 .then(function(data){
				  		let {data:list}= data;
				  		for(var i=0 ;i<list.length;i++){
			                $("#rolecheck").append("<label class='checkbox-inline'><input  type='checkbox' id='"+list[i].roleCode+"' value='"+list[i].roleCode+"' name='header'/>"+list[i].roleName)+"</label>";
				  		}
				  	});
			  	})
			})
	})
}
        
function paramevent(){
	 let timer=0;
        //点击详情触发
       /*$(document).on("click",".icon_xiangqing",function(){
        		let obj= $(this).parent()[0].dataset;
        		let {aid:aId,uid:uId,sid:sId,acccode:accCode}=obj
        		obj={aId,uId,sId,accCode};
        		window.open(`/accept/goindex_x?aId=${aId}`);
       })*/
       
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
	    	   funObj({currentPage:OBJ["currentPage"],pages:OBJ["pages"]});
	    	 	   if(OBJ["currentPage"]&&OBJ["currentPage"]<OBJ["pages"]){OBJ["currentPage"]++}
	    	 	   summLogin(OBJ,function(){
	    				$("#pagination_4").empty().append(pagStr(undefined,OBJ["currentPage"]));
	    			});
	    	    	 $(document).on('click',".nextye",FX);
	    	},200)
	     }

	
	
	 $(document).on("click",".tailye",function(){
		 let {currentPage,pages}=OBJ;
	       funObj({currentPage,pages});
	 	   if(currentPage&&currentPage<pages){OBJ["currentPage"]=OBJ["pages"]}
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
	    	if(num>OBJ["pages"])
	    	$("#inptval").val(OBJ["pages"]);
	    }else{
	    	$("#inptval").val(1);
//	    	alert("请输入整数数字!!");
	    	return false;
	    }
 	   
    })
    $(document).on("click","#querens",function(){
 	   let num= parseInt($.trim($("#inptval").val()));
 	   if(num<=OBJ["pages"]&&num>=1){
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
   
 function funObj({mas=funmas(),count=0,pages=0,currentPage=1,size=OBJ["size"]}){
		OBJ["mas"]=mas;
		OBJ["count"]=count;
		OBJ["pages"]=pages;
		OBJ["currentPage"]=currentPage;
		OBJ["size"]=size;
}
 
 function pagStr(pagetotl=5,current=1,page=""){
	 let {pages,count,size,currentPage}=OBJ;
	 let str=`<div class="whj_jqueryPaginationCss-1">
	          <div class="whj_border whj_padding whj_bgc ${currentPage==1?"whj_hoverDisable":"whj_hover"} shouye" name="whj_firstPage">首页</div>
	          <div class="whj_border whj_padding whj_bgc ${currentPage==1?"whj_hoverDisable":"whj_hover"} prevye" name="whj_previousPage">上一页</div> 
	          {0}
	          <div class="whj_border whj_padding whj_bgc ${currentPage==pages?"whj_hoverDisable":"whj_hover"} nextye" name="whj_nextPage">下一页</div>
	          <div class="whj_border whj_padding whj_bgc ${currentPage==pages?"whj_hoverDisable":"whj_hover"} tailye" name="whj_lastPage">尾页</div>
	          <select class="whj_border whj_bgc  selectid" name="whj_pageSize" >
	 		   {1}
	          </select>
	          <div class="whj_padding whj_color">跳至</div>
	          <input type="text" id=inptval class="whj_border whj_color " style="backage-color:red" name="whj_toPage" value="${page}">
	          <div class="whj_border whj_padding whj_bgc whj_hover" name="whj_confirm" id="querens">确认</div>
	          <div class="whj_border whj_padding whj_bgc whj_hover" name="whj_refresh" id="refre">刷新</div>
	          <div class="whj_padding whj_color">共${OBJ["pages"]||0}页</div></div>`
			   str=str.replace("{0}",(function(){
			    	let sub="";
			    	if(pages&&pages>0){
			    		let current2=1
			    		if(current>=3){current2=current,current2=current2-2}
			    		if(pages<pagetotl){pagetotl=pages};
			    		if(current==pages){pagetotl=3}
			    		if(pages-current<5){
			    			let zhi= pages-current2+1;
			    				zhi>5?pagetotl=pagetotl:pagetotl=zhi;
			    		}
			    		
			    		for(i=1;i<=pagetotl;i++){
			    		 sub+=`<div style="width:40px" class="whj_border whj_padding whj_bgc ${current&&current==current2?"whj_checked":"whj_hover"} pagx" name="whj_page" data-page="${current2}">${current2}</div>`
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
   
	  
  function funCli(){
		 $('input[name="header"]').click(function(){
			document.getElementById("text").innerHTML='';
			let role_array = new Array();;  
		    $('input[name="header"]:checked').each(function(){  
		    	role_array.push($(this).val());
		    });  
		    let roles = role_array.join(',');
		    if(!roles){
		    	document.getElementById("text").innerHTML='请至少选择一个角色权限';
		    	document.getElementById("text").style.fontSize='15px';
		    	document.getElementById("text").style.color='red';
		    }
		});
 }
 
 /**
  * 处理模态框事件与其数据
  */
 function funModal(){
	  $("#myModal").on("hidden.bs.modal",function(){
		  		$("#myModal").find(".form-control").val("");
		  		//$("#textarea").empty().prop("placeholder","");
		  		delete ModelObj["obj"];
		  		//delete ModelObj["logis"];
	  })
	  //点击修改触发
	  $(document).on("click",".icon_youji",function(){
		  let obj= $(this).parent()[0].dataset;
		  mainCode(obj,2);  
	  })
	  
	  //点击提交按钮
	  $('#myModal').find(".modal-footer>.btn-primary")
	   .click(function(){
		    let dId = $.trim($("#sel").val());
		    let state = $('input[name="state"]:checked').val();
		    let role_array = new Array();;  
		    $('input[name="header"]:checked').each(function(){  
		    	role_array.push($(this).val());
		    });  
		    let roles = role_array.join(',');
		    let s = document.getElementById("a").innerHTML;
		    if(s=="登录密码"){
		    	let accName = document.getElementById("uName").value;
		    	let pwd = $('.form-control.pd').val()
				let accCode = document.getElementById("dName").value;
				if(!accName){
					$("#uName").focus();
			    	return false;
			    }
				if(!pwd){
			    	$(".pd").focus();
			    	return false;
			    }
				if(!accCode){
			    	$("#dName").focus();
			    	return false;
			    }else{
			    	$.post("/AccountAdminister/queryPersonal")
				     .then(function(data) {
				    	 let {data:list}= data;
					  	 for(var i=0 ;i<list.length;i++){
					    	 if(accCode == list[i].accCode){
					     		//alert(accCode+"工号已存在");
					     		document.getElementById("text").innerHTML='工号已存在';
					     		document.getElementById("dName").value='';
					     		$("#dName").focus();
					     		return false;
					     	 }
					  	 }
				     });
			    }
				if(!dId){
			    	$("#sel").focus();
			    	return false;
			    }
				funCli();
				if(!roles){
			    	document.getElementById("text").innerHTML='请至少选择一个角色权限';
			    	document.getElementById("text").style.fontSize='15px';
			    	document.getElementById("text").style.color='red';
			    	return false;
			    }
				$.post("/AccountAdminister/save",{accCode,pwd,accName,dId,roles})
			     .then(function(data) {
			    	 if(data["resultCode"]==200){
			     		alert("提交成功");
			     		$('#myModal').modal('hide');
			     		window.location.reload();
			     	 }
			     })
		    }else{
		    	funCli();
		    	if(!roles){
			    	document.getElementById("text").innerHTML='请至少选择一个角色权限';
			    	document.getElementById("text").style.fontSize='15px';
			    	document.getElementById("text").style.color='red';
			    	return false;
			    }
		    	let{accid:accId,acccode:accCode,accname:accName}= ModelObj["obj"];
		    	$.post("/AccountAdminister/update",{accId,dId,state,roles})
			     .then(function(data) {
			    	 if(data["resultCode"]==200){
			     		 alert("修改成功");
			     		$('#myModal').modal('hide');
			     		window.location.reload();
			     	 }
			     })
		    }
	  })
	  
	  /**
	   * 修改&添加使用同一个模板
	   */
	  function mainCode(obj,inx){
		  let {accid:accId,acccode:accCode,accname:accName,rolename:roleName,dname:dName,ctime:cTime,state:state}=obj
		  ModelObj["obj"]=obj;
		  OBJ["roleName"] = roleName;
		  document.getElementById("text").innerHTML='';
		  let ctime= new Date(Number(cTime)).Format()
		  let $express= $("#dName");
		  let $mail= $(".pd");
		  let $dzOrsj=$("#uName");
		  let $sName=$("#sName");
		  inx==1?
		  ($express.prop("readonly",false),$mail.prop("readonly",false),$dzOrsj.prop("readonly",false),$("#myModalLabel").text("新增账户信息"))
		 :($express.prop("readonly",true),$mail.prop("readonly",true),$dzOrsj.prop("readonly",true),$sName.prop("readonly",false),$mail.attr('type','text'),$mail.prev().text("创建时间"),$("#roleradio").show(),$("#zt").show(),$("#myModalLabel").text("编辑账户信息"))
		  $('#myModal').modal('show');
		  //查询业务对象信息和邮寄信息
		  $('#myModal').one('shown.bs.modal',function(){
			  $.post("/AccountAdminister/queryDepartment")
			   .then(function(data){
			  	    let {data:list}= data;
			  		let footbut= $('#myModal').find(".modal-footer>.btn-primary");
				  	 //生成下拉框start
			  		 let str=``;
			  		 $.each(list,function(index,obj){
	  				     str+=`<option value='${obj.dId}' ${dName==obj.dName?'selected':''}>${obj.dName}</option>`
	  			     })
			  		 $('#sel').empty().append(str);
		  			 //生成下拉框end
		  			 if(inx==1){
		  				 footbut.prop("disabled",true).text("提交");
		  				 $("#sel").prop("disabled", true);
		  			 }else{
		  				 footbut.prop("disabled",false).text("修改")
		  				 $("#sel").prop("disabled", false);
		  			 }
			  	})
			  	$("#rolecheck").empty();
			  	$.post("/AccountAdminister/queryRole")
			  	 .then(function(data){
			  		let {data:list}= data;
			  		for(var i=0 ;i<list.length;i++){
		                $("#rolecheck").append("<label class='checkbox-inline'><input  type='checkbox' id='"+list[i].roleCode+"' value='"+list[i].roleCode+"' name='header'/>"+list[i].roleName)+"</label>";
		                var roame = OBJ["roleName"].split(",");
		                if(roame.length>0){
		                	for(var j=0;j<roame.length;j++){
		                		if (list[i].roleName == roame[j]) {
		                			$("#"+list[i].roleCode).attr("checked",true)
		                		}
		                	}
		                }
			  		}
			  	});
			  	if(state=="有效"){
			  		$("#inlineRadio1").prop("checked","checked");
			  	}else{
			  		$("#inlineRadio2").prop("checked","checked");
			  	}
			  	
  			    $("#uName").val(accName||"暂无数据");
	  		    $(".pd").val(ctime||"暂无数据");
	  		    $("#dName").val(accCode||"暂无数据");
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