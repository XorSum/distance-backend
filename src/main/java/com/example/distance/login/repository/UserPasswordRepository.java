package com.example.distance.login.repository;


import com.example.distance.login.model.UserPassword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPasswordRepository extends CrudRepository<UserPassword,Integer> {
     UserPassword findByPhonenumber(String phonenumber);
     UserPassword findByPhonenumberAndPassword(String phonenumber, String password);

}
