package course.work.service.custom.impl;

import course.work.dto.RoomDto;
import course.work.entity.RoomCategoryEntity;
import course.work.entity.RoomEntity;
import course.work.service.custom.RoomService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of RoomService using Hibernate with improved clarity and error
 * handling.
 *
 * @author Bard
 */
public class RoomServiceImpl implements RoomService {

    private final SessionFactoryConfiguration sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance();

    @Override
    public List<RoomDto> getAll() throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            List<RoomEntity> roomEntities = session
                    .createQuery("from RoomEntity", RoomEntity.class).list();
            List<RoomDto> roomDtos = new ArrayList<>();
            for (RoomEntity entity : roomEntities) {
                roomDtos.add(new RoomDto(entity.getCustName(), entity.getRoomNo(), entity.getRoomType(),
                        entity.getRoomPackage(), entity.getStatus()));
            }
            return roomDtos;
        } finally {
            session.close();
        }
    }

    @Override
    public RoomDto getRoom(int roomNo) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            RoomEntity entity = session.get(RoomEntity.class, roomNo);
            if (entity != null) {
                return new RoomDto(entity.getCustName(), entity.getRoomNo(), entity.getRoomType(),
                        entity.getRoomPackage(), entity.getStatus());
            }
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public String saveRoom(RoomDto dto) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {

            RoomEntity exitingentity = session.get(RoomEntity.class, dto.getRoomNo());
            if (exitingentity != null) {
                return "Already saved Room";
            }

            RoomEntity entity = new RoomEntity(dto.getRoomNo(), dto.getCustName(), dto.getRoomType(), dto.getRoomPackage(),
                    dto.getStatus());
            session.save(entity);
            session.beginTransaction().commit();
            return "Successfully Saved";
        } finally {
            session.close();
        }
    }

    @Override
    public String deleteRoom(Integer roomNo) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            RoomEntity entity = session.get(RoomEntity.class, roomNo);
            if (entity != null) {
                session.delete(entity);
                session.beginTransaction().commit();
                return "Room successfully deleted.";
            }
            return "Failed";
        } finally {
            session.close();
        }
    }

    @Override
    public String updateRoom(RoomDto dto) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            RoomEntity entity = session.get(RoomEntity.class, dto.getRoomNo());
            if (entity != null) {
                entity.setCustName(dto.getCustName());
                entity.setRoomType(dto.getRoomType());
                entity.setRoomPackage(dto.getRoomPackage());
                entity.setStatus(dto.getStatus());
                session.update(entity);
                session.beginTransaction().commit();
                return "Successfully Updated";
            }
            return "User not found";
        } finally {
            session.close();
        }
    }
}
