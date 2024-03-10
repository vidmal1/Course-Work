/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.work.service.custom;

import course.work.dto.ReservationDto;
import course.work.service.SuperService;

/**
 *
 * @author ASUS
 */
public interface ReservationService extends SuperService {

    String reservation(ReservationDto dto) throws Exception;

}
