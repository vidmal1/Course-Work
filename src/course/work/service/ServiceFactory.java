/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.work.service;

import course.work.service.custom.RoomCategoryService;
import course.work.service.custom.impl.CustomerServiceImpl;
import course.work.service.custom.impl.ReservationServiceImpl;
import course.work.service.custom.impl.RoomCategoryServiceImpl;
import course.work.service.custom.impl.RoomServiceImpl;

/**
 *
 * @author ASUS
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }

        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type) {
            case RESERVATION:
                return new ReservationServiceImpl();
            case ROOM:
                return new RoomServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ROOMCATEGORY:
                return new RoomCategoryServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType {
        RESERVATION, ROOM, CUSTOMER, ROOMCATEGORY
    }
}
