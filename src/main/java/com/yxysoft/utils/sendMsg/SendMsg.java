package com.yxysoft.utils.sendMsg;
import java.io.IOException;

import com.linkage.netmsg.NetMsgclient;
import com.linkage.netmsg.server.ReceiveMsg;
import com.linkage.netmsg.server.AnswerBean;
import com.linkage.netmsg.server.ReturnMsgBean;
import com.linkage.netmsg.server.UpMsgBean;



class ReceiveDemo extends ReceiveMsg {

	/*获取下行短信返回状态和短信ID的方法*/
	public void getAnswer(AnswerBean answerBean) {
		super.getAnswer(answerBean);
		System.out.println("SeqID:"+answerBean.getSeqId()); 
		System.out.println("Status:"+String.valueOf(answerBean.status));
		System.out.println("MsgID :"+String.valueOf(answerBean.msgId));
	}

	/*接收上行短信的方法*/
	public void getUpMsg(UpMsgBean upMsgBean) {
		super.getUpMsg(upMsgBean);

		String sequenceId = upMsgBean.getSequenceId();
		/* 发送号码 */
		String sendNum = upMsgBean.getSendNum();
		/* 接收号码 */
		String receiveNum = upMsgBean.getReceiveNum();
		/* 上行短信到达时间 */
		String msgRecTime = upMsgBean.getMsgRecTime();
		/* 短信内容 */
		String msgContent = upMsgBean.getMsgContent();

		//此处加入接收上行短信的处理代码
		System.out.println("***********上行短信:*********");
		System.out.println("时序ID（收信状态）: " + sequenceId);
		System.out.println("发送号码（收信状态）: " + sendNum);
		System.out.println("接收号码（收信状态）: " + receiveNum);
		System.out.println("接收时间（收信状态）: " + msgRecTime);
		System.out.println("接收内容（收信状态）: " + msgContent);
		//upMsgBean.
	}

	/* 获取下行短信回执的方法 */
	public void getReturnMsg(ReturnMsgBean returnMsgBean) {
		super.getReturnMsg(returnMsgBean);
		
		String sequenceId = returnMsgBean.getSequenceId();
		/* 短信的msgId */
		String msgId = returnMsgBean.getMsgId();
		/* 发送号码 */
		String sendNum = returnMsgBean.getSendNum();
		/* 接收号码 */
		String receiveNum = returnMsgBean.getReceiveNum();
		/* 短信提交时间 */
		String submitTime = returnMsgBean.getSubmitTime();
		/* 短信下发时间 */
		String sendTime = returnMsgBean.getSendTime();
		/* 短信状态 */
		String msgStatus = returnMsgBean.getMsgStatus();
		/* 短信错误代码 */
		int msgErrStatus = returnMsgBean.getMsgErrStatus();

		//此处加入接收短信回执的处理代码
		System.out.println("***********下行短信回执:*********"); 
		System.out.println("ReturnMsgBean sequenceId: " + sequenceId);
		System.out.println("ReturnMsgBean msgId: " + msgId);
		System.out.println("ReturnMsgBean sendNum: " + sendNum);
		System.out.println("ReturnMsgBean receiveNum: " + receiveNum);
		System.out.println("ReturnMsgBean submitTime: " + submitTime);
		System.out.println("ReturnMsgBean sendTime: " + sendTime);
		System.out.println("ReturnMsgBean msgStatus: " + msgStatus);
		System.out.println("ReturnMsgBean msgErrStatus: " + msgErrStatus);
		

	}

}


public class SendMsg {
	public static NetMsgclient client   = null;
	public static  boolean isLogin = false;
	public static NetMsgclient GetClient(){
		if(client==null){
	        ReceiveMsg receiveMsg = new ReceiveDemo();
			client   = new NetMsgclient();
			client = client.initParameters("202.102.41.101", 9005, "025C00358893", "570440", receiveMsg);
			try {
				isLogin = client.anthenMsg(client);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	
	public static void SendMsg(String mobile ,String content){
		// TODO Auto-generated method stub
		 NetMsgclient c   = GetClient();
	        /*ReceiveMsgImpl为ReceiveMsg类的子类，构造时，构造自己继承的子类就行*/
	        //ReceiveMsg receiveMsg = new ReceiveDemo();
	        /*初始化参数*/
	       // client.initParameters(ipAddress, port, username, password, receiveMsg)
	        //client = client.initParameters("202.102.41.101", 9005, "025C00358893", "570440", receiveMsg);
	        try {
	            /*登录认证*/
	            //boolean isLogin = client.anthenMsg(client);
	            if(isLogin) {
	            	//client.send 
	            	System.out.println("login sucess");
	            	
		            /*发送下行短信*/
		          	System.out.println(c.sendMsg(client, 0, mobile, "【栖霞不见面审批】"+content, 1));
		          	//c.finalClose();
		          	//System.out.println(client.sendMsgWithSrcNum(client, 0, "96106","15335162626", "【栖霞96106】Hello，发送短信测试！", 1));
	            
	            } 
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	}

	public static void main(String[] args) {
		for(int i =0;i<5;i++){
			SendMsg("18118827018","测试短信发送"+i);
			
		}
	}

}
