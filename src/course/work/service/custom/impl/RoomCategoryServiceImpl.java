package course.work.service.custom.impl;

import course.work.dto.CustomerDto;
import course.work.dto.RoomCategoryDto;
import course.work.dto.RoomDto;
import course.work.entity.CustomerEntity;
import course.work.entity.RoomCategoryEntity;
import course.work.entity.RoomEntity;
import course.work.service.custom.RoomCategoryService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class RoomCategoryServiceImpl implements RoomCategoryService {

    private SessionFactoryConfiguration sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance();

    @Override
    public List<RoomCategoryDto> getAll() throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            List<RoomCategoryEntity> roomCategoryEntities = session
                    .createQuery("from RoomCategoryEntity", RoomCategoryEntity.class).list();
            List<RoomCategoryDto> roomCategoryDtos = new ArrayList<>();
            for (RoomCategoryEntity entity : roomCategoryEntities) {
                roomCategoryDtos.add(new RoomCategoryDto(entity.getCategoryId(), entity.getCategoryName(),
                        entity.getCategoryDescription(),
                        entity.getPrice()));
            }
            return roomCategoryDtos;
        } finally {
            session.close();
        }

    }

    @Override
    public RoomCategoryDto getCategory(String id) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            RoomCategoryEntity entity = session.get(RoomCategoryEntity.class, id);
            if (entity != null) {
                return new RoomCategoryDto(entity.getCategoryId(), entity.getCategoryName(),
                        entity.getCategoryDescription(),
                        entity.getPrice());
            }
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public String saveCategory(RoomCategoryDto dto) throws Exception {

        Session session = sessionFactoryConfiguration.getSession();
        try {

            RoomCategoryEntity existingEntity = session.get(RoomCategoryEntity.class, dto.getCategoryID());
            if (existingEntity != null) {
                return "Already exists. Cannot save duplicate entry.";
            }

            RoomCategoryEntity entity = new RoomCategoryEntity(dto.getCategoryID(), dto.getCategoryName(),
                    dto.getCategoryDescription(),
                    dto.getPrice());
            session.save(entity);
            session.beginTransaction().commit();
            return "Successfully Saved";
        } finally {
            session.close();
        }
    }

    @Override
    public String updateCategory(RoomCategoryDto dto) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            RoomCategoryEntity entity = session.get(RoomCategoryEntity.class, dto.getCategoryID());
            if (entity != null) {
                entity.setCategoryName(dto.getCategoryName());
                entity.setCategoryDescription(dto.getCategoryDescription());
                entity.setPrice(dto.getPrice());
                session.beginTransaction().commit();
                return "Successfully Updated";

            }
            return "User not found";
        } finally {
            session.close();
        }
    }

    @Override
    public String deleteCategory(String id) {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            RoomCategoryEntity entity = session.get(RoomCategoryEntity.class, id);
            if (entity != null) {
                session.delete(entity);
                session.beginTransaction().commit();
                return "Category Successfully Deleted";
            }
            return "Failed";
        } finally {
            session.close();
        }
    }
}