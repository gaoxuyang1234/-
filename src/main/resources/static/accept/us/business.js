$(function(){
	$("#gosId").val()?$("#sidOrSname").val($("#gosId").val()):getCurrentMonth();
	detailLogin(undefined,function(){
		$("#pagination_4").empty().append(pagStr());
	});
	paramevent();
	funclick();
	(function(){
		$.post("/sta/getdep").then(function(data){
			   let{dName,pDId}=data["data"];
			   dName&&pDId>2?$("#didOrDname").prop("disabled","true").prop("placeholder",dName):"";
		})
	})();
})


const OBJ={
	
}
const ARRAY=[5,10,15,20,30]

function detailLogin(obj,fnbak){
	 obj=obj||{size:10,mas:funmas()};
	$.ajax({url:"/sta/buss",type:"post",dataType:"JSON",data:obj,
		success:function(data){
			console.log(data);
			let {data:{list,page,dIdkey}}=data;
			let{count,currentPage,pageCount,size}=page;
			OBJ["count"]=count;
			OBJ["currentPage"]=currentPage;
			OBJ["pageCount"]=pageCount;
			OBJ["size"]=size;
			let str="";
			$.each(list,function(index,obj){
				let {sId,sName,aTime,countNum,dId,dName}=obj;
				str+=`<tr>
                    <td width="10%">${sId||"暂无数据"}</td>
                    <td width="45%">${sName||"暂无数据"}</td>
                    <td width="30%">${dName||"暂无数据"}</td>
                    <td width="10%">${countNum||"暂无数据"}</td>
                    <td width="15%"><a class="icon_view" title="详情" id="icon_view" 
                    	data-did=${dId}
                    	data-sid=${sId}>详情</a></td>
					</tr>`
			})
			  $("#tbs").empty().append(str||"<tr><td colspan=6>暂无数据</td></tr>");
			    fnbak=fnbak&&fnbak();
		}
	})	
}

function paramevent(){
	 let timer=0;
       //点击详情触发
      $(document).on("click",".icon_view",function(){
       		let obj= $(this)[0].dataset;
       		let {sid:sId,did:dId}=obj;
       		obj={sId,dId};
       		console.log(obj);
       	    //window.location="/accept/gosummaey?sId="+obj["sId"];
       		var url ="/accept/gosummaey?sId="+obj["sId"];
    		//该变量指的是包含当前分割窗口的父窗口。如果在一个窗口内有分割窗口，而在其中一个分割窗口中又包含着分割窗口，则第2层的分割窗口可以用parent变量引用包含它的父分割窗口
       		parent.c1(url);
      })
      
      $("#butCX").click(function(){
    	  funObj({});
    	  detailLogin(OBJ,function(){
      			$("#pagination_4").empty().append(pagStr());
      		});
      })
      
        $("#didOrDname")[0].oninput=function(){
    	   if(!timer){
    		   timer=setTimeout(function() {
    			   funObj({});
    			   detailLogin(OBJ,function(){
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
    			   detailLogin(OBJ,function(){
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
 	  detailLogin(OBJ,function(){
			$("#pagination_4").empty().append(pagStr(undefined,index));
		});
    })
     $(document).on("click",".shouye",function(){ 	  
       funObj({});	
       detailLogin(OBJ,function(){
			$("#pagination_4").empty().append(pagStr(undefined,1));
		});
    })  
    
     $(document).on("click",".prevye",function(){
       funObj({currentPage:OBJ["currentPage"]});	
 	   if(OBJ["currentPage"]&&OBJ["currentPage"]>1){OBJ["currentPage"]--}
 	  detailLogin(OBJ,function(){
			$("#pagination_4").empty().append(pagStr(undefined,OBJ["currentPage"]));
		});
    })
        
      $(document).on("click",".nextye",function(){
    	  funObj({currentPage:OBJ["currentPage"],pageCount:OBJ["pageCount"]});funObj({currentPage:OBJ["currentPage"],pageCount:OBJ["pageCount"]});
    	  if(OBJ["currentPage"]&&OBJ["currentPage"]<OBJ["pageCount"]){OBJ["currentPage"]++}
	 	  detailLogin(OBJ,function(){
				$("#pagination_4").empty().append(pagStr(undefined,OBJ["currentPage"]));
			});
      })
 
    $(document).on("click",".tailye",function(){
       funObj({currentPage:OBJ["currentPage"],pageCount:OBJ["pageCount"]});
 	   if(OBJ["currentPage"]&&OBJ["currentPage"]<OBJ["pageCount"]){OBJ["currentPage"]=OBJ["pageCount"]}
 	  detailLogin(OBJ,function(){
			$("#pagination_4").empty().append(pagStr(undefined,OBJ["currentPage"]));
		});
 	   
    })
    
    $(document).on("change",".selectid",function(){
    	funObj({size:$(this).val()});
 	   detailLogin(OBJ,function(){
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
 		   detailLogin(OBJ,function(){
 	   			$("#pagination_4").empty().append(pagStr(undefined,num,num));
 	   		});
 	   }
 	   
    })
    
    $(document).on("click","#refre",function(){
     	$("#sidOrSname").val("");
     	$("#didOrDname").val("");
     	getCurrentMonth();
     	funObj({});
     	detailLogin(OBJ,function(){
 	   			$("#pagination_4").empty().append(pagStr(undefined,1));
 	   		});
    
    })
	
	
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

//参数索取
function funmas(){
   let maps={}
   let didOrDname=$.trim($("#didOrDname").val())
   let sidOrSname=$.trim($("#sidOrSname").val()) 
   let befDate=$.trim($("#start").val());
   let aftDate=$.trim($("#end").val());
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

function getCurrentMonth(){
	 var date=new Date();
	 date.setDate(1);
	 let da1=date.Format("yyyy-MM-dd")
	 let da2= new Date().Format("yyyy-MM-dd");
	 $("#start").val(da1);
	 $("#end").val(da2);
}

function getDOMDates(){
	let befDate= $.trim($("#start").val());
	let aftDate= $.trim($("#end").val());
	if(befDate){
		return {
			befDate:befDate,
			aftDate:aftDate||new Date().Format("yyyy-MM-dd")
		}
	}
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