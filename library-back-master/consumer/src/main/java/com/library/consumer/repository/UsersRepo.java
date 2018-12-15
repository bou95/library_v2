package com.library.consumer.repository;


import com.library.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long>{
    Users findUsersByEmail(String email);
    Users findUsersByEmailAndPassword(String email, String password);

}
