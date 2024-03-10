/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.work.service.custom;

import course.work.dto.RoomDto;
import course.work.service.SuperService;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface RoomService extends SuperService {

    List<RoomDto> getAll() throws Exception;

    String saveRoom(RoomDto roomDto) throws Exception;

    RoomDto getRoom(int id) throws Exception;

    String deleteRoom(Integer RoomNo) throws Exception;

    String updateRoom(RoomDto roomDto) throws Exception;

}
