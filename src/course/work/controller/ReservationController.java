/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.work.controller;

import course.work.dto.CustomerDto;
import course.work.dto.ReservationDto;
import course.work.service.ServiceFactory;
import course.work.service.custom.ReservationService;

/**
 *
 * @author ASUS
 */
public class ReservationController {

    ReservationService reservationService = (ReservationService) ServiceFactory.getInstance()
            .getService(ServiceFactory.ServiceType.RESERVATION);

    public String reservation(ReservationDto dto) throws Exception {
        return reservationService.reservation(dto);
    }

}
