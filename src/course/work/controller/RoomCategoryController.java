/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.work.controller;

import course.work.dto.RoomCategoryDto;
import course.work.dto.RoomDto;
import course.work.service.ServiceFactory;
import course.work.service.custom.RoomCategoryService;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class RoomCategoryController {

    RoomCategoryService roomCategoryService = (RoomCategoryService) ServiceFactory.getInstance()
            .getService(ServiceFactory.ServiceType.ROOMCATEGORY);

    public List<RoomCategoryDto> getAll() throws Exception {
        return roomCategoryService.getAll();
    }

    public String saveCategory(RoomCategoryDto roomCategoryDto) throws Exception {
        return roomCategoryService.saveCategory(roomCategoryDto);
    }

    public RoomCategoryDto getCategory(String id) throws Exception {
        return roomCategoryService.getCategory(id);
    }

    public String updateCategory(RoomCategoryDto dto) throws Exception {
        return roomCategoryService.updateCategory(dto);
    }

    public String deleteCategory(String id) throws Exception {
        return roomCategoryService.deleteCategory(id);
    }

}
