package course.work.service.custom.impl;

import course.work.dto.CustomerDto;
import course.work.dto.ReservationDto;
import course.work.dto.RoomDto;
import course.work.entity.CustomerEntity;
import course.work.entity.ReservationEntity;
import course.work.entity.RoomCategoryEntity;
import course.work.entity.RoomEntity;
import course.work.service.custom.ReservationService;
import util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationServiceImpl implements ReservationService {

    private SessionFactoryConfiguration sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance();

    @Override
    public String reservation(ReservationDto dto) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            ReservationEntity reservationEntity = new ReservationEntity(dto.getId(), dto.getRoom(), dto.getDate(),
                    dto.getPrice());
            if (session.save(reservationEntity) != null) {

                boolean isCustomerSaved = true;

                for (CustomerDto customerDto : dto.getCustomerDtos()) {
                    CustomerEntity customerEntity = new CustomerEntity(
                            dto.getRoom(), customerDto.getName(), customerDto.getPhone(),
                            customerDto.getEmail(),
                            customerDto.getAddress(), customerDto.getCity(), customerDto.getNationality(),
                            customerDto.getIdNo(), customerDto.getCheckInDate(), customerDto.getCheckOutDate());

                    if (session.save(customerEntity) != null) {
                        isCustomerSaved = false;
                    }
                }

                if (isCustomerSaved) {
                    boolean isRoomSaved = true;
                    for (CustomerDto customerDto : dto.getCustomerDtos()) {
                        RoomEntity entity = session.get(RoomEntity.class, customerDto.getRoom());
                        if (entity != null) {
                            entity.setCustName(customerDto.getName());
                           // entity.setRoomPackage();
                            entity.setStatus("Booked");
                            if (session.save(entity) != null) {
                                isRoomSaved = false;
                            }
                        }
                    }

                    if (isRoomSaved) {
                        transaction.commit();
                        return "Successfully Saved";
                    } else {
                        transaction.rollback();
                        return "Room Save Error";
                    }
                } else {
                    transaction.rollback();
                    return "Customer Save Error";
                }
            } else {
                transaction.rollback();
                return "Reservation Save Error";
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }
}
