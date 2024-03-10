/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.work.service.custom;

import course.work.dto.RoomCategoryDto;
import course.work.entity.RoomCategoryEntity;
import course.work.service.SuperService;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface RoomCategoryService extends SuperService {

    String saveCategory(RoomCategoryDto roomCategoryDto) throws Exception;

    List<RoomCategoryDto> getAll() throws Exception;

    RoomCategoryDto getCategory(String id) throws Exception;

    String updateCategory(RoomCategoryDto dto) throws Exception;

    String deleteCategory(String id) throws Exception;

}
