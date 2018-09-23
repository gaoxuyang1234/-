package com.yxysoft.roomservice.roomlist.service.impl;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yxysoft.roomservice.roomlist.common.Config;
import com.yxysoft.roomservice.roomlist.logic.IMMgr;
import com.yxysoft.roomservice.roomlist.logic.RoomMgr;
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
import com.yxysoft.roomservice.roomlist.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
    @Resource
    RoomMgr roomMgr;

    @Resource
    IMMgr imMgr;

    @Override
    public GetLoginInfoRsp getLoginInfo(String userID) {
        return imMgr.getLoginInfo(userID);
    }

    @Override
    public CreateRoomRsp createRoom(CreateRoomReq req) {
        CreateRoomRsp rsp = new CreateRoomRsp();
        String userID = req.getUserID();
        String nickName = req.getNickName();
        String roomInfo = req.getRoomInfo();
        String roomType = req.getRoomType();
        boolean needHeartBeat = req.isNeedHeartBeat();

        if (userID == null || userID.length() == 0 || roomInfo == null || roomInfo.length() == 0) {
            rsp.setCode(2);
            rsp.setMessage("请求失败，缺少参数");
            return rsp;
        }

        String pattern = "^[a-zA-Z][a-zA-Z0-9_]{3,23}$";
        if (!Pattern.matches(pattern, userID)) {
            rsp.setCode(7);
            rsp.setMessage("请求失败，userID含有非法字符或者不符合规范");
            return rsp;
        }

        if (roomInfo.length() > 1024) {
            rsp.setCode(11);
            rsp.setMessage("roomInfo 字符串长度不能超过1024字节");
            return rsp;
        }

        String roomID = req.getRoomID();
        if (roomID == null || roomID.length() == 0) {
            roomID = String.valueOf(Math.abs((int) (System.currentTimeMillis())));
        }
        // 获取一个可用的roomid
        while (roomMgr.isRoomExist(roomID)) {
            roomID = String.valueOf(Math.abs((int)(System.currentTimeMillis())));
        }

        //先获取权限位
        String privateMapKey = imMgr.getPrivMapEncrypt(userID, roomID);

        if (privateMapKey.length() == 0) {
            rsp.setCode(3);
            rsp.setMessage("请求失败，权限位生成失败");
            return rsp;
        }

        // 再创建房间
        roomMgr.creatRoom(roomID, userID, nickName, roomInfo, roomType, needHeartBeat);
        rsp.setUserID(userID);
        rsp.setRoomID(roomID);
        rsp.setRoomInfo(roomInfo);
        rsp.setPrivateMapKey(privateMapKey);
        return rsp;
    }

    @Override
    public EnterRoomRsp enterRoom(EnterRoomReq req) {
        EnterRoomRsp rsp = new EnterRoomRsp();
        String userID = req.getUserID();
        String nickName = req.getNickName();
        String roomID = req.getRoomID();
        int status = req.getStatus();

        if (userID == null || userID.length() == 0 || roomID == null || roomID.length() == 0) {
            rsp.setCode(2);
            rsp.setMessage("请求失败，缺少参数");
            return rsp;
        }

        String pattern = "^[a-zA-Z][a-zA-Z0-9_]{3,23}$";
        if (!Pattern.matches(pattern, userID)) {
            rsp.setCode(7);
            rsp.setMessage("请求失败，userID含有非法字符或者不符合规范");
            return rsp;
        }

        // 房间不存在
        if (!roomMgr.isRoomExist(roomID)) {
            rsp.setCode(3);
            rsp.setMessage("请求失败，房间不存在");
            return rsp;
        }

        if (roomMgr.getMemberCnt(roomID) >= Config.Room.maxMembers) {
            rsp.setCode(5001);
            rsp.setMessage("超出房间人数上限");
            return rsp;
        }

        //获取权限位
        String privateMapKey = imMgr.getPrivMapEncrypt(userID, roomID);

        if (privateMapKey.length() == 0) {
            rsp.setCode(3);
            rsp.setMessage("请求失败，权限位生成失败");
            return rsp;
        }

        roomMgr.addMember(roomID, userID, nickName, status);

        rsp.setUserID(userID);
        rsp.setRoomID(roomID);
        rsp.setPrivateMapKey(privateMapKey);
        return rsp;
    }

    @Override
    public BaseRsp quitRoom(QuitRoomReq req) {
        BaseRsp rsp = new BaseRsp();
        String userID = req.getUserID();
        String roomID = req.getRoomID();

        if (userID == null || userID.length() == 0 || roomID == null || roomID.length() == 0) {
            rsp.setCode(2);
            rsp.setMessage("请求失败，缺少参数");
            return rsp;
        }

        // 房间不存在
        if (!roomMgr.isRoomExist(roomID)) {
            rsp.setCode(3);
            rsp.setMessage("请求失败，房间不存在");
            return rsp;
        }

        // 删除成员
        roomMgr.delMember(roomID, userID);
        return rsp;
    }

    @Override
    public BaseRsp heartbeat(HeartBeatReq req) {
        BaseRsp rsp = new BaseRsp();
        String userID = req.getUserID();
        String roomID = req.getRoomID();

        if (userID == null || userID.length() == 0 || roomID == null || roomID.length() == 0) {
            rsp.setCode(2);
            rsp.setMessage("请求失败，缺少参数");
            return rsp;
        }

        // 房间不存在
        if (!roomMgr.isRoomExist(roomID)) {
            rsp.setCode(3);
            rsp.setMessage("请求失败，房间不存在");
            return rsp;
        }

        // 更新时间戳
        roomMgr.updateTimeStamp(roomID, userID);
        return rsp;
    }

    @Override
    public GetRoomListRsp getRoomList(GetRoomListReq req) {
        GetRoomListRsp rsp = new GetRoomListRsp();
        rsp.setRooms(roomMgr.getList(req.getCount(), req.getIndex(), req.getRoomType()));
        return rsp;
    }

    @Override
    public GetRoomMembersRsp getRoomMembers(GetRoomMembersReq req) {
        GetRoomMembersRsp rsp= new GetRoomMembersRsp();
        String roomID = req.getRoomID();

        if (roomID == null || roomID.length() == 0) {
            rsp.setCode(2);
            rsp.setMessage("请求失败，缺少参数");
            return rsp;
        }

        // 房间不存在
        if (!roomMgr.isRoomExist(roomID)) {
            rsp.setCode(3);
            rsp.setMessage("请求失败，房间不存在");
            return rsp;
        }

        rsp.setMembers(roomMgr.getMembers(roomID));

        return rsp;
    }

    @Override
    public BaseRsp deleteRoom(DeleteRoomReq req) {
        BaseRsp rsp = new BaseRsp();
        String roomID = req.getRoomID();

        if (roomID == null || roomID.length() == 0) {
            rsp.setCode(2);
            rsp.setMessage("请求失败，缺少参数");
            return rsp;
        }

        roomMgr.deleteRoom(roomID);

        return rsp;
    }

}
