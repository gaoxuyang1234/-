$(function(){
	$("#dates").text(new Date().Format("yyyy-MM-dd"));
	getCurrentMonth()();
	detaLogin();
	detaStatis({mas:getDOMDates()});
	detaclick();
})

function detaLogin(){
	let befDate= $.trim($("#start").val());
	let aftDate= $.trim($("#end").val());
	let obj={mas:{dId:$("#mandId").val()||0,befDate:befDate,aftDate:aftDate}}
	$.post("/sta/count",obj,function(data){
		console.log(data);
		let {data:{coubus,counow,couobj,cousid,depOrStreet}}=data
		let [{allCount,rate}=depobj]=depOrStreet
		counow==0||counow?counow+=" 个":counow="暂无数据";
		couobj==0||couobj?couobj+=" 个":coubus="暂无数据";
		allCount==0||allCount?allCount+=" 个":allCount="暂无数据";
		cousid=(function(){
			rate==0?rate="0.00":rate=(rate*100).toFixed(2);
			return rate;
		})();
		$("#counow").text(counow);  //待办事项
		$("#couobj").text(couobj);  //总办理量
		$("#coubus").text(allCount);  //不见面事项
		$("#cousid").text(cousid+"%");  //事项发生率？
	},"JSON");
  }

function detaStatis(objdata){
	$.post("/sta/countList",objdata,function(data){
			let{data:{buss,uss,mons,pers}}=data
			let monsstr=funStr(mons)("aTime","aTimeNum");
			let ussstr=funStr(uss)("uName","countNum");
			let bussstr=funStr(buss)("sName","countNum");
			let persstr=funStr(pers)("acccode","acccodenNum");
			$("#mons").empty().append(monsstr||"<li>暂无数据</li>");
			$("#uss").empty().append(ussstr||"<li>暂无数据</li>");
			$("#buss").empty().append(bussstr||"<li>暂无数据</li>");
			$("#pers").empty().append(persstr||"<li>暂无数据</li>");
	},"JSON");
}

function detaclick(){
	$("#buts").click(function(){
	   let befDate= $.trim($("#start").val());
	   let aftDate= $.trim($("#end").val());
	   if(!befDate){alert("请选择起始日期");return false};
	   if(!aftDate){aftDate=$.trim($("#end").val(new Date().Format("yyyy-MM-dd")))}
	   detaStatis({mas:{befDate:befDate,aftDate:aftDate}});
	})
	
	$("#counowck").click(function(){
		let roles=$("#roles").val();
		if(roles&&(roles.includes("R1")||roles.includes("R3"))){
			window.open("/accept/index");
		}
	})

	
		//点击总办理量
	$("#parcouobj").click(function(){
		parent.c1("/accept/summary_statistics");
	})
	//点击事项发生率
	$("#parcousid").click(function(){
		parent.c2("/accept/business_statistics");
	})
}


function funStr(...arr){
	let obj=arr[0];
	return function(...arr1){
		let str="";
		let zhi=0;
		$.each(obj,function(i,o){
			zhi+=o[arr1[1]];
			str+=`<li>${o[arr1[0]]}<span class="statistical_list_date_number">${o[arr1[1]]}</span></li>`
		})
	
		return str;
	}
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