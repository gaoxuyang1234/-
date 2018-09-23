package com.yxysoft.roomservice.roomlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxysoft.roomservice.roomlist.pojo.Request.CreateRoomReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.DeleteRoomReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.EnterRoomReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.GetLoginInfoReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.GetRoomListReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.GetRoomMembersReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.QuitRoomReq;
import com.yxysoft.roomservice.roomlist.pojo.Response.BaseRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.CreateRoomRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.EnterRoomRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.GetLoginInfoRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.GetRoomListRsp;
import com.yxysoft.roomservice.roomlist.pojo.Response.GetRoomMembersRsp;
import com.yxysoft.roomservice.roomlist.service.RoomService;

/**
 * webexe房间接口
 */
@Controller
@ResponseBody
@RequestMapping("/weapp/webexe_room")
public class WebExeRoom {
    @Autowired
    RoomService roomService;

    @ResponseBody
    @RequestMapping("get_login_info")
    public GetLoginInfoRsp get_login_info(@ModelAttribute GetLoginInfoReq req){
        return roomService.getLoginInfo(req.getUserID());
    }

    @ResponseBody
    @RequestMapping("create_room")
    public CreateRoomRsp create_room(@RequestBody CreateRoomReq req){
        return roomService.createRoom(req);
    }

    @ResponseBody
    @RequestMapping("delete_room")
    public BaseRsp delete_room(@RequestBody DeleteRoomReq req){
        return roomService.deleteRoom(req);
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
