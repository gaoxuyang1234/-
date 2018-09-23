$(function(){
	
	funx();
	funA();
	login();
})

function funA(){
	 const objfil={};
	$("#fil").change(function(){
		let fil=$(this)[0].files[0];
		let{name:filName,type,size}=fil;
		$(this).val("");
		if(size>30000000){alert("上传文件不得大于30M");return false}
		let houzui= filName.split(".").pop();
		let files=new FileReader();
		$(".img_a[src$='1.gif']").prop("src","/accept/img/lod1.gif").prop("title","正在上传...");
		files.readAsDataURL(fil);
		files.onload=function(){
			let img= this.result;
			let bob= dataURLtoBlob(img);
			let {name,imgId,aId,state,dom,sId}=objfil;
			let fom=new FormData();
			fom.append("file",bob,name);
			fom.append("aId",aId);
			fom.append("houzui",filName.split(".").pop());
			fom.append("fId",imgId);
			fom.append("filName",filName);
			fom.append("state",state);
			$.ajax({
				url:"/usFile/updFile",
            	cache: false,
            	data:fom,
            	dataType:"JSON",
            	type:"POST",
            	processData: false,
    			contentType: false,
    			success(data){
    				jiazai(aId,sId)
    			}
			})
		}
	})
				
		$(document).on("click",".img_a[src$='/1.gif']",function(){
			objfil["imgId"]=$(this).attr("id");
		 	let {aid,name,state,sid}= $(this)[0].dataset;
			objfil["aId"]=aid;
			objfil["name"]=name;
			objfil["state"]=state;
			objfil["dom"]=$(this);
			objfil["sId"]=sid;
			$("#fil").click();
		})
		//点击进行下载		
//		$(document).on("click",".img_a:not([src$='1.gif'])",function(){
//			let src= $(this)[0].dataset["url"];
//			let title=$(this).prop("title");
//			window.location="/fileX/down_file?path="+src+"&title="+title;
//		})
	}
			
			
function funB(houzui,url){
	let imgArr= ["gif","png","jpg","jpeg"];
	houzui=="doc"?houzui=url+"/"+houzui+".gif":null;
	houzui=="excel"?houzui=url+"/"+houzui+".gif":null;
	houzui=="rar"?houzui=url+"/"+houzui+".gif":null;
	houzui=="txt"?houzui=url+"/"+houzui+".gif":null;
	houzui=="zip"?houzui=url+"/"+houzui+".gif":null;
	houzui=="docx"?houzui=url+"/"+houzui+".gif":null;
	houzui=="xlsx"?houzui=url+"/"+houzui+".gif":null;
	houzui=="pdf"?houzui=url+"/"+houzui+".gif":null;
	houzui=="sql"?houzui=url+"/"+houzui+".gif":null;
	if(houzui.indexOf(".gif")==-1){
		$.inArray(houzui,imgArr)==-1?houzui=url+"/tu.gif":houzui=null;
	}
	return houzui;
}
function funx(){
	//模板关闭时
	$("#myModal").on("hidden.bs.modal",()=>$('#myModal').find(".modal-body").empty());
	//查询信息
	$(document).on("click","#butCX",()=>login())
	//上传文件
	$(document).on("click",".ck",function(){
	           let {aid:aId,sname:sName,sid:sId}= $(this)[0].dataset;
	           $("#myModalLabel").html(sName+"<span style='color:red'>[上传文件最大不能超过30M]<span>");
	            jiazai(aId,sId);
       		   $('#myModal').modal('show');
	})
	
}

//打开模态框时,加载文件数据
function jiazai(aId,sId){
	 $.post("/usFile/fileList",{aId,sId},data=>{
		     let str=``;
		     str=fileRead(data,aId)
             $('#myModal').find(".modal-body").empty().append(str||'<h4>暂无需求文件</h4>');
      })	
}

function login(){
	$.post("/usFile/list",{mas:funmas()},function(data){
		console.log(data);
		let{list}=data["data"];
		console.log(list);
		let str=``;
		$.each(list,function(index,obj){
			let{aId,aTime,state,sId,mail,yuanFlag,zhengFlag,sName,dId,dName,uId,uName,isOnline}=obj;
			str+=`<tr class="${index%2==0?'success':''}">
       			<td>${new Date(aTime).Format()}</td>
       			<td>${dName}</td>
       			<td>${sName}</td>
       			<td>${uName}</td>
       			<td>${getState(state)}</td>
       			<td ><a class='ck icon_view' href="javascript:void(0);" data-aId=${aId} data-sName=${sName} data-sId=${sId}>上传文件</a></td>
       		     </tr>`
		})
		$("#tbs").empty().append(str||"<tr><td colspan=6>暂无数据</td></tr>");
		
	},"JSON")
}


     function getState(state){
       	state==0?state="已办结":
				state==1?state="未排队":
				state==2?state="待受理":
				state==3?state="受理中":
				state==4?state="已受理":
				state==5?state="待补正":     //受理驳回
				state==6?state="审批通过":
				state==7?state="审批驳回":null;	     	
        return state;		     
       }
       	//渲染文件数据和路径	
       function fileName(arr,appName,appPath){
           let zhi=``;
           $.each(arr,function(index,obj){
               let houzui= obj[appName].split(".").pop();
       		  zhi+=`<a href=${obj[appPath]}  target=_blak><img  class="img_a img-thumbnail" src="${funB(houzui,"/accept/img/")||obj[appPath]}" data-url=${obj[appPath]} title="${obj[appName]}" alt="图片"></a>`    
           })
           return zhi;    
	   }
       //渲染文件		 
       function fileRead(data,aId){
    	   let{data:{obj:objs,appfil,appcer,nodes,qqList,certs,files,appFile,appCert}}=data;
    	   let str=``;
    	   $.each(certs,(index,item)=>{
    		   let {cId,cName,sId}=item;
    		   let arr=appCert.filter((item,index)=>item["cId"]==cId);
    		   str+=`${index!=0?'<hr>':""}<h4>${cName||"暂无数据"}[证件]</h4>
			       <div class="div_a">
			       <div class="div_b" id="div_imgs">
			       ${fileName(arr,"appCName","appCPath")}
				   <img id="${cId}" data-sId=${sId} data-aId=${aId} data-state=0 data-Name=${cName} class="img_a img-thumbnail" src="/accept/img/1.gif" alt="" title="请添加文件">
			       </div>
		           </div>`
    	    })
    	     $.each(files,(index,item)=>{
    		   let {fId,fName,sId}=item;
    		   let arr=appFile.filter((item,index)=>item["fId"]==fId);
    		   str+=`${index!=0?'<hr>':""}<h4>${fName||"暂无数据"}[文件]</h4>
			       <div class="div_a">
			       <div class="div_b" id="div_imgs">
			       ${fileName(arr,"appFName","appFPath")}
				   <img id="${fId}" data-aId=${aId} data-state=0 data-Name=${fName} class="img_a img-thumbnail" src="/accept/img/1.gif" alt="" title="请添加文件">
			       </div>
		           </div>`
    	      })
    	   return str; 
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
           return new Blob([u8arr], { type: mime });
         }
	 
	 
       //参数索取
       function funmas(sta=2,uId=306){
           maps={};
           let didOrDname=$.trim($("#didOrDname").val())
           let sidOrSname=$.trim($("#sidOrSname").val()) 
           let befDate=$.trim($("#start").val());
           let aftDate=$.trim($("#end").val());
           let state=sta;
           if(didOrDname)
           maps["didOrDname"]=didOrDname;
           if(sidOrSname)
           maps["sidOrSname"]=sidOrSname;
           if(befDate){
           maps["befDate"]=befDate;
           maps["aftDate"]=aftDate||(function(){
        	   let date= new Date().Format("yyyy-MM-dd");
        	   $("#end").val(date);return date;
           })();
           }
           maps["state"]=state;
           maps["uId"]=uId;
           return maps;
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