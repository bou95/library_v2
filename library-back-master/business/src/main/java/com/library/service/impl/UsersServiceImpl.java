package com.library.service.impl;

import com.library.consumer.repository.UsersRepo;
import com.library.model.entities.Users;
import com.library.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    public synchronized boolean insert(Users user) {
        Users user1=usersRepo.findUsersByEmail(user.getEmail());
        if (user1 != null) {
            return false;
        } else {
            usersRepo.save(user);
            return true;
        }
    }

    @Override
    public void update(Users user) {
        usersRepo.save(user);
    }

    @Override
    public List<Users> getAllUser() {
        return usersRepo.findAll();
    }

    @Override
    public Users getById(Long id) {
         return usersRepo.findOne(id);
    }


    @Override
    public void delete(Long id) {
        usersRepo.delete(id);
    }

	@Override
	public Users login(String email, String password) {
		return usersRepo.findUsersByEmailAndPassword(email, password);
	}

}
