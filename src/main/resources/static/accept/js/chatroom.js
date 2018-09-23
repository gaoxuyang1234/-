var ws = null;  
var url = null;  
var transports = [];  
const interval = null;
setInterval(function () {
	if($("#aId").val()!=null&&$("#aId").val()!=''){		
      $.ajax({
    	  	url:"/chat/queryChats",
    	  	dataType:"JSON",
    	  	type:"POST",
    	  	data:{fromUser:$("#toUser").val(),toUser:$("#accId").val(),aId:$("#aId").val(),isRead: 1},
    	  	success:function(data){
		        if(data["resultCode"]=='200'){
	    	  		console.log(data);
		          	var list=data["data"];
	    	  		console.log(list);
			        $.each(list,function(i,o){
			        	console.log(o["chatContent"]);
			        	setContent1 (o["chatContent"]);
			       	})
		         }          	
         	}
        })

  	}
    //循环执行代码  
  }, 1000) //循环时间 这里是1秒    
 
function setContent1 (msg) {  
		var type1 = msg;
		var spanorimg = "";
		if(type1.indexOf(".jpg")>0){
			spanorimg =  "<a href=\""+msg+"\" target=\"_blank\"><img class=\"inlindimg\" src=\""+msg+"\"></img></a>";
		}else{
			spanorimg =  "<span>"+msg+"</span>";
		}
		var str = "<li class=\"Chat_content_body_news_li_receive\">"+
                            "<img src=\"images/applicant.png\"/>"+
                            spanorimg+
                        "+</li>";
	   $("#chatContent").append(str);
	   $(window).scroll(function(){
		 　　var scrollTop = $(this).scrollTop();
		 　　var scrollHeight = $(document).height();
		 　　var windowHeight = $(this).height();
		 　　if(scrollTop + windowHeight == scrollHeight){
		 　　　//　alert("已经到最底部了！");
		 　　}
		 });
//	    var data = JSON.parse(event.data);
//	    alert(data.fromUser);
	//log('Received: ' + event.data);  
	}; 
function echo() {   
    	var toUser = $("#toUser").val();
    	if(toUser!=null&&toUser!=''){
            var message = document.getElementById('messageInput').value;  
    		//log('Sent: ' + message);  

            var str = "<li class=\"Chat_content_body_news_li_send\">"+
                "<span>"+message+"</span>"+
                "<img src=\"images/dealer.png\"/>"+
            "</li>";
        	   $("#chatContent").append(str);
        	   var msg  = "{\"fromUser\":\"accept"+$("#accId").val()+"\",\"toUser\":\"apply"+toUser+"\",\"ChataId\":"+$("#aId").val()+",\"ChataccnodeId\":"+$("#accnodeId").val()+",\"me\":\"我是业务员\",\"msg\": \""+message+"\"}";

               var data = {
                 fromUser: $("#accId").val(),
                 toUser: toUser,
                 aId: $("#aId").val(),
                 accnodeId: $("#accnodeId").val(),
                 chatDesc: "我是业务员",
                 userType: 1,
                 chatType: 1,
                 chatContent: message
               }
               $.ajax({
           	  	url:"/chat/insert",
           	  	dataType:"JSON",
           	  	type:"POST",
           	  	data:data,
           	  	success:function(data){
   	    	  		console.log(data);        	
                }
               })
       		//ws.send(msg);  
    	}else{
    		alert('请选择一项业务申请！'); 
    	}
    $("#messageInput").val("");
} 
$(function () {
    /**
     * 键盘enter事件，用来发送消息
     */
    $("#messageInput").bind("keyup", function (event) {
        if (event.keyCode == 13){
        	echo();
        }
    });

    /**
     * 清除聊天窗口的所有内容
     */
    $("#clearBtn").click(function () {
        $("#historyMsg").empty();
        $("#messageInput").focus();
    });

    /**
     * 上传图片发送
     */
    $("#sendImage").bind("change", function () {
        if (this.files.length != 0){
            $.ajax({
                url: $("#uploadUrl").val(),
                type: 'POST',
                cache: false,
                data: new FormData($('#sendImageForm')[0]),
                processData: false,
                contentType: false
            }).done(function(res) {
                console.log(res);
            }).fail(function(res) {
                console.log(res);
            });
        }
    })
    //initEmoji();
    $("#sendImageBtn").click(function () {
        $("#sendImage").trigger("click");
    })

});

/**
 * 预加载emoji图片
 */
function initEmoji() {
    var emojiContainer = $("#emojiWrapper");
    var documentFragment = document.createDocumentFragment();
    for (var i = 69; i > 0; i--){
        var emojiItem = document.createElement("img");
        emojiItem.src = $("#emojiBaseUri").val().trim() + i + ".gif";
        emojiItem.title = i;
        documentFragment.appendChild(emojiItem);
    }
    emojiContainer.append(documentFragment);

    $("#emoji").click(function (event) {
        emojiContainer.css("display", "block");
        event.stopPropagation(); //阻止事件的传递，防止body监听到
    });

    $("body").click(function (event) {
        if (event.target != emojiContainer){
            emojiContainer.css("display", "none");
        }
    });
    
    $("#emojiWrapper").click(function (event) {
        var target = event.target;
        if (target.nodeName.toLowerCase() == "img"){
            var messageInput = $("#messageInput");
            messageInput.val(messageInput.val() + "[EMOJI:" + target.title + "]");
            messageInput.focus();
        }
    })
    
}

/**
 * 格式化时间，参数为null显示当前客户端时间
 * @param dateTime
 * @returns {string}
 */
function formatDate(dateTime) {
    var date = dateTime == null ? new Date() : new Date(dateTime);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    hour = hour < 10  ? '0'+""+hour : hour;
    var minute = date.getMinutes();
    minute = minute < 10 ? '0'+""+minute : minute;
    var second = date.getSeconds();
    second = second < 10 ? '0'+""+second : second;
    return year + "-" + month + "-" + day +" " + hour + ":" + minute + ":" + second;
}

