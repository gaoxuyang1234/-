package com.yxysoft.roomservice.roomlist.pojo.Response;

import java.util.ArrayList;

import com.yxysoft.roomservice.roomlist.pojo.Room;

public class GetRoomListRsp extends BaseRsp {
    private ArrayList<Room> rooms;

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
