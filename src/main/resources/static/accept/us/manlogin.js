$(function(){
	
	funclick();
	 $(document).keydown(function(){
	        event.keyCode == "13"?$("#dengLog").click():"";
	    })
})

function funclick(){
	$("#dengLog").click(function(){
		let cardNo=$.trim($("#zhanghu").val());
		let pwd= $.trim($("#pwd").val());
		if(!zhanghu||!pwd){
			alert("请输入账号和密码");
			return false;
		}
		pwd=md5(pwd)
		console.log("=====>"+pwd);
		$.post("/usFile/login",{pwd,cardNo},function(data){
			   if(data["resultCode"]==200){
				 window.location="/usFile/usfile";  
			   }else{
				 alert("用户名或密码错误,请核实")
			   }
		},"JSON");
	})
	
	
}