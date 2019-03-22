package com.library.service;

import com.library.model.entities.Users;

import java.util.List;


public interface UsersService {
    boolean insert(Users user);

    void update(Users user);

    List<Users> getAllUser();

    Users getById(Long id);

    void delete(Long id);

    Users login(String email, String password);

    Users saveRemind(Users user);

    List<Users> findAllByReminder(boolean reminder);
}
