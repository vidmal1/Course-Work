/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.work.service.custom.impl;

import course.work.dto.CustomerDto;
import course.work.dto.RoomCategoryDto;
import course.work.entity.CustomerEntity;
import course.work.entity.RoomCategoryEntity;
import course.work.service.custom.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

/**
 *
 * @author ASUS
 */
public class CustomerServiceImpl implements CustomerService {

    private SessionFactoryConfiguration sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance();

    @Override
    public String addCustomer(CustomerDto dto) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            CustomerEntity customerEntity = new CustomerEntity(dto.getRoom(),
                    dto.getName(), dto.getPhone(),
                    dto.getEmail(), dto.getAddress(), dto.getCity(), dto.getNationality(),
                    dto.getIdNo(), dto.getCheckInDate(), dto.getCheckOutDate());
            session.save(customerEntity);
            transaction.commit();
            return "Successfully Saved";
        } catch (Exception e) {
            transaction.rollback();
            throw e; // Rethrow the exception for proper handling
        } finally {
            session.close();
        }
    }

   
    @Override
    public String deleteCustomer(String id) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            // Assuming you have an `id` property in CustomerEntity:
            CustomerEntity customerEntity = session.get(CustomerEntity.class, id);
            if (customerEntity != null) {
                session.delete(customerEntity);
                transaction.commit();
                return "Customer deleted successfully";
            } else {
                return "Customer not found";
            }
        } catch (Exception e) {
            transaction.rollback();
            throw e; // Rethrow for proper error handling
        } finally {
            session.close();
        }
    }

    @Override
    public CustomerDto getCustomer(String id) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            CustomerEntity entity = session.get(CustomerEntity.class, id);
            if (entity != null) {
                return new CustomerDto(entity.getRoom(), entity.getName(), entity.getPhone(),
                        entity.getEmail(), entity.getAddress(), entity.getCity(),
                        entity.getNationality(), entity.getIdNo(), entity.getCheckInDate(), entity.getCheckOutDate());
            }
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<CustomerDto> getAll() throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            List<CustomerEntity> customerEntities = session
                    .createQuery("from CustomerEntity", CustomerEntity.class).list();
            List<CustomerDto> customerDtos = new ArrayList<>();
            for (CustomerEntity entity : customerEntities) {
                customerDtos.add(new CustomerDto(entity.getRoom(), entity.getName(), entity.getPhone(),
                        entity.getEmail(), entity.getAddress(), entity.getCity(),
                        entity.getNationality(), entity.getIdNo(), entity.getCheckInDate(), entity.getCheckOutDate()));
            }
            return customerDtos;
        } finally {
            session.close();
        }

    }

    @Override
    public String updateCustomer(CustomerDto dto) throws Exception {
        Session session = sessionFactoryConfiguration.getSession();
        try {
            CustomerEntity entity = session.get(CustomerEntity.class, dto.getRoom());
            if (entity != null) {
                entity.setName(dto.getName());
                entity.setPhone(dto.getPhone());
                entity.setEmail(dto.getEmail());
                entity.setAddress(dto.getAddress());
                entity.setCity(dto.getCity());
                entity.setNationality(dto.getNationality());
                session.beginTransaction().commit();
                return "Successfully Updated";
            }
            return "User Not Found";
        } finally {
            session.close();
        }
    }
}
