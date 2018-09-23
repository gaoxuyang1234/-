$(function(){
	
	funLogin();
	funclick();
	setInterval(function() {
		funLogin();
	},30000)  //30秒
//	console.log(objmas);
})

//var objmas={};
//  if(sessionStorage.getItem('ITEM')){
//  		objmas = JSON.parse(sessionStorage.getItem('ITEM'));
//  }else{
//   objmas={length:0};
//  } 
function funLogin(){
	
 $.post("/sta/depcount",{},function(data){
	let{data:{list}}=data;
    let str1="";let len=1;
	let str2="";let len2=1;
	$.each(list,function(i,obj){
	  if(obj["pdId"]==3){
		  len==1?str1+=`<ul class="clearfix">`:"";
		  str1+=funStr1(obj);
		  len==4?(str1+=`</ul>`,len=1):"";
		  len++;
	  }
	  if(obj["pdId"]==2){
		  len2==1?str2+=` <ul class="clearfix" style="margin-bottom: 0;">`:"";
		  str2+=funStr2(obj);
		  len2==6?(str2+=`</ul>`,len2=1):"";
		  len2++;
	  }
	 })
	 $("#tab1").empty().append(str1);
	 $("#tab2").empty().append(str2);
//	 sessionStorage.setItem('ITEM', JSON.stringify(objmas))
	},"JSON")
	
}

function funclick(){
	$(document).on("click",".tdbead",function(){
		  let obj= $(this)[0].dataset;
		  let{did:dId,dname:dName,pdid:pdId}=obj;
		  console.log(obj);
		  window.open(`/accept/goindex?dId=${dId}&dName=${dName}&pdId=${pdId}`); 
	})
	
}


function funStr1({countNum=0,dId,dName,pdId}){
	//修改逻辑,不判断是否后续新增,只要有待处理即可
//	let bool="";  
//	dId in objmas?(function(){
//	    let zhi= parseInt(objmas[dId+""]);
//	    let zhi2=countNum-zhi
//	    zhi2>0?bool=zhi2:bool="";
//	})():objmas[dId+""]=countNum;
	let str=""; 
	str+=`<li class="col-sm-12 col-md-3 col-xs-12 tdbead" data-dId=${dId} data-dName=${dName} data-pdId=${pdId}>
            <a href="javascript:;" class="clearfix">
                <div class="icon-bg bg-color_03 f-l">
                    <span class="iconfont">${dName.substr(0,1)}</span>
                </div>
                <div class="right-text-con">
                    <p class="name">${dName.substr(1,dName.length)}</p>
                    <p><span class="font_color font-color_03">${countNum}</span>待办</p>
                </div>
                ${countNum>0?(function(){
                	$("#audiok")[0].play();
                	return '<div class="tu_gif"><img  class="tu_gif" src="/audio/tu.gif" /></div>'
                    }()):""
                  }
            </a>
    	</li>`
    	 
     return str;
}

function funStr2({countNum=0,dId,dName,pdId}){
	//修改逻辑,不判断是否后续新增,只要有待处理即可
//	let bool="";
//	dId in objmas?(function(){
//	    let zhi= parseInt(objmas[dId+""]);
//	    let zhi2=countNum-zhi
//	    zhi2>0?(bool=zhi2,objmas[dId+""]=countNum):bool="";
//	})():objmas[dId+""]=countNum;
	let str=""; 
	str+=`<li class="col-sm-12 col-md-2 col-xs-12 li_padding tdbead" data-dId=${dId} data-dName=${dName} data-pdId=${pdId}>
                                        <a href="javascript:;" class="clearfix">
                                            <div class="icon-bg_01 bg-color_00 f-l">
                                                <span class="iconfont_01">${dName.substr(0,1)}</span>
                                            </div>
                                            <div class="right-text-con_01">
                                                <p class="name_01">${dName.substr(1,dName.length)}</p>
                                            
                                                <span class="font_color font-color_00">${countNum}</span>待办                                           
                                            </div>
                                                ${countNum>0?(function(){
                                                	$("#audiok")[0].play();
                                                	return '<div class="tu_gif"><img  class="tu_gif" src="/audio/tu.gif" /></div>'
                                                    }()):""
                                                  }
                                        </a>
                                  </li>`
//          <i class="fa fa-envelope fa_i" style=""></i>
//          <i class="fa_i_num" style="">${bool||0}</i>                        
     return str;
}

