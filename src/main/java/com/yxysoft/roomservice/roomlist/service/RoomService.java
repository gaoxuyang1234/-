package com.yxysoft.roomservice.roomlist.service;

import com.yxysoft.roomservice.roomlist.pojo.Request.CreateRoomReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.DeleteRoomReq;
import com.yxysoft.roomservice.roomlist.pojo.Request.EnterRoomReq;
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

public interface RoomService {
    GetLoginInfoRsp getLoginInfo(String userID);
    CreateRoomRsp createRoom(CreateRoomReq req);
    EnterRoomRsp enterRoom(EnterRoomReq req);
    BaseRsp quitRoom(QuitRoomReq req);
    BaseRsp heartbeat(HeartBeatReq req);
    GetRoomListRsp getRoomList(GetRoomListReq req);
    GetRoomMembersRsp getRoomMembers(GetRoomMembersReq roomID);

    BaseRsp deleteRoom(DeleteRoomReq req);
}