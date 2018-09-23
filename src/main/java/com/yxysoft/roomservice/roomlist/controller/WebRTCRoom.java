package com.yxysoft.roomservice.roomlist.controller;

import com.yxysoft.basic.model.QxzwBusApplysChats;
import com.yxysoft.basic.service.QxzwChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxysoft.roomservice.roomlist.pojo.Request.CreateRoomReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.EnterRoomReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.GetLoginInfoReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.GetRoomListReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.GetRoomMembersReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.HeartBeatReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.QuitRoomReq;
import com.yxysoft.roomservice.roomlist.pojo.Response.BaseRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.CreateRoomRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.EnterRoomRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.GetLoginInfoRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.GetRoomListRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.GetRoomMembersRsp;
import com.yxysoft.roomservice.roomlist.service.RoomService;

/**
 * webrtc房间接口
 */
@Controller
@ResponseBody
@RequestMapping("/weapp/webrtc_room")
public class WebRTCRoom {
    @Autowired
    RoomService roomService;

    @Autowired
    QxzwChatService qxzwChatService;

    @ResponseBody
    @RequestMapping("get_login_info")
    public GetLoginInfoRsp get_login_info(@RequestBody GetLoginInfoReq req){
        return roomService.getLoginInfo(req.getUserID());
    }

    @ResponseBody
    @RequestMapping("create_room")
    public CreateRoomRsp create_room(@RequestBody CreateRoomReq req){
        CreateRoomRsp createRoomRsp = roomService.createRoom(req);
        //插入消息表记录
        QxzwBusApplysChats qxzwBusApplysChats = new QxzwBusApplysChats();
        qxzwBusApplysChats.setaId(Integer.valueOf(req.getaId()));
        qxzwBusApplysChats.setToUser(Integer.valueOf(req.getToUser()));
        qxzwBusApplysChats.setAccnodeId(Integer.valueOf(req.getAccnodeId()));
        qxzwBusApplysChats.setFromUser(Integer.valueOf(req.getAccId()));
        qxzwBusApplysChats.setUserType(1);
        qxzwBusApplysChats.setChatType(4);
        qxzwBusApplysChats.setChatContent(createRoomRsp.getRoomID()+","+createRoomRsp.getRoomInfo()+","+createRoomRsp.getUserID());
        qxzwChatService.insertQxzwBusApplysChats(qxzwBusApplysChats);
        return createRoomRsp;
    }

    @ResponseBody
    @RequestMapping("enter_room")
    public EnterRoomRsp enter_room(@RequestBody EnterRoomReq req){
        return roomService.enterRoom(req);
    }

    @ResponseBody
    @RequestMapping("quit_room")
    public BaseRsp quit_room(@RequestBody QuitRoomReq req){
        return roomService.quitRoom(req);
    }

    @ResponseBody
    @RequestMapping("heartbeat")
    public BaseRsp heartbeat(@RequestBody HeartBeatReq req) {
        return roomService.heartbeat(req);
    }

    @ResponseBody
    @RequestMapping("get_room_list")
    public GetRoomListRsp get_room_list(@RequestBody GetRoomListReq req) {
        return roomService.getRoomList(req);
    }

    @ResponseBody
    @RequestMapping("get_room_members")
    public GetRoomMembersRsp get_room_members(@RequestBody GetRoomMembersReq req){
        return roomService.getRoomMembers(req);
    }
}