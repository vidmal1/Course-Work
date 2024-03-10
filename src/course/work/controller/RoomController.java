/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.work.controller;

import course.work.dto.RoomDto;
import course.work.service.ServiceFactory;
import course.work.service.custom.RoomService;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class RoomController {

    RoomService roomService = (RoomService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOM);

    public List<RoomDto> getAll() throws Exception {
        return roomService.getAll();
    }

    public String saveRoom(RoomDto roomDto) throws Exception {
        return roomService.saveRoom(roomDto);
    }

    public RoomDto getRoom(int id) throws Exception {
        return roomService.getRoom(id);
    }

    public String deleteRoom(Integer roomNo) throws Exception {
        return roomService.deleteRoom(roomNo);
    }

    public String updateRoom(RoomDto dto) throws Exception {
        return roomService.updateRoom(dto);
    }
}
