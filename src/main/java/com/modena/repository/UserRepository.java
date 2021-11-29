package com.modena.repository;
import com.modena.model.UserDao;

import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}