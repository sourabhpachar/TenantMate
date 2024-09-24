package com.TenantMate.service.impl;

import com.TenantMate.entity.Room;
import com.TenantMate.repository.RoomRepository;
import com.TenantMate.service.RoomService;

public class RoomServiceImpl implements RoomService {
    RoomRepository roomRepository;
    @Override
    public Room CreateRoom(Room room) {

        return roomRepository.save(room);
    }
}
