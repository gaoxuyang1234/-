$(function(){
	$(".dates").text(new Date().Format("yyyy-MM-dd"));
	getCurrentMonth()();
	adminiLongin();
	adminiStatis();
	funClik();
})


function adminiLongin(obj){
	$.post("/sta/count",obj,function(data){
			let {data:{coubus,couobj,cousid,couuser}}=data;
			if(coubus&&cousid){
			//cousid= (Number(cousid)/Number(coubus)).toFixed(2)*100+" %";
			  cousid= ((Number(cousid)/Number(coubus))*100).toFixed(2)+" %";
			}else{cousid="暂无数据"};
			coubus==0||coubus?coubus+=" 个":coubus="暂无数据";
			couuser==0||couuser?couuser+=" 个":couuser="暂无数据";
			couobj==0||couobj?couobj+=" 个":coubus="暂无数据";
			$("#coubus").text(coubus);
			$("#couuser").text(couuser);
			$("#couobj").text(couobj);
			$("#cousid").text(cousid);
	},"JSON")
}

function adminiStatis(dataObj){
	 let befDate= $.trim($("#start").val());
	 let aftDate= $.trim($("#end").val());
	dataObj=dataObj||{mas:{befDate:befDate,aftDate:aftDate}};
	$.post("/sta/deps",dataObj,function(data){
		   let {data:{depList,depRates,streetRates}}=data;
		   let {countDep,countStreet}=depList[0];
		   let tbs1="";
		   let tbs2="";
		   //计数:测试
		   let tbs1zhi=0;
		   let tbs2zhi=0;
		   //
		   $.each(depList,function(i,obj){
			 let {pdId} =obj
			 if(pdId&&(pdId==2||pdId==3)){
				 pdId==3?tbs1+=funStr(obj):tbs2+=funStr(obj);
				 pdId==3?tbs1zhi+=obj["countNum"]:tbs2zhi+=obj["countNum"];
			 }
			 
		   })
		   let depRatesList=depRates.concat(streetRates);
		   let tbs3="";let tbs4="";
		   $.each(depRatesList, function(i,obj) {
		   			let {pDId}=obj
		   			pDId==3?tbs3+=funStr1(obj):tbs4+=funStr1(obj);
		   })
		   $("#tbs1").empty().append(tbs1||"<tr><td colspan=3>暂无数据</td></tr>");
		   $("#tbs2").empty().append(tbs2||"<tr><td colspan=3>暂无数据</td></tr>");
		   $("#tbs3").empty().append(tbs3||"<tr><td colspan=3>暂无数据</td></tr>");
		   $("#tbs4").empty().append(tbs4||"<tr><td colspan=3>暂无数据</td></tr>");
		   $(".tbs1len").empty().append(countStreet+"个街道的统计")
		   $(".tbs2len").empty().append(countDep+"个部门的统计")
	},"JSON");	
}


function funStr(obj){
	let str=`<tr class="tr_30" data-did=${obj["dId"]} data-pdid=${obj["pdId"]}  align="center">
		<td class="td_01">${$.trim($("#start").val())+"-"+$.trim($("#end").val())}</td>
		<td class="td_02 td_maidid" ><a href="javascript:void(0);">${obj["dName"]}</a></td>
        <td class="td_03">${obj["countNum"]}</td>
        </tr>`;
    return str;
}

function funStr1(obj){
	let {rate}=obj;
	//let num= (obj["rate"].toFixed(2)*100+"").split(".")[0];//解决js处理浮点乘法BUG问题
	let num=(function(){
		rate==0?rate="0.00":rate=(rate*100).toFixed(2);
		return rate;
	})();
	let str=`<tr class="tr_30"   align="center">
		<td class="td_02 td_maidid" ><a href="javascript:void(0);">${obj["dName"]}</a></td>
        <td class="td_03">${num+"%"}</td>
        </tr>`
     return str;
}

 function getCurrentMonth(){
	 var date=new Date();
	 date.setDate(1);
	 let da1=date.Format("yyyy-MM-dd")
	 let da2= new Date().Format("yyyy-MM-dd");
	 $("#start").val(da1);
	 $("#end").val(da2);
	 return function(){
		 let prevDate=new Date(new Date().getTime() - 24*60*60*1000).Format("yyyy-MM-dd")
		 $("#start").val(prevDate);
		 $("#end").val(prevDate);
	 }
  }

function funClik(){
	$("#butCX").click(function(){
		let befDate= $.trim($("#start").val());
		let aftDate= $.trim($("#end").val());
		
		if(befDate){
		    if(!aftDate){
			   $("#end").val(new Date().Format("yyyy-MM-dd"))
			}
			let obj={mas:{befDate,aftDate:aftDate||new Date().Format("yyyy-MM-dd")}};
			adminiStatis(obj);
		}
		
	})
	
//	$(document).on("click",".td_maidid",function(){
//        	let obj= $(this).parent()[0].dataset;
//        	if(obj&&obj.did){
//        		window.location="/accept/detailed_inquiry?dId="+obj["did"];
//        	}
//        
//	})
	//点击总办理量
	$("#parcouobj").click(function(){
		parent.c1("/accept/summary_statistics");
//		parent.c2("/accept/business_statistics");
	})
	//点击事项发生率
	$("#parcousid").click(function(){
//		parent.c1("/accept/summary_statistics");
		parent.c2("/accept/business_statistics");
	})
	
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