package com.example.distance.sign.repository;


import com.example.distance.sign.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
     User findByPhonenumber(String phonenumber);
     User findByPhonenumberAndPassword(String phonenumber, String password);
     User findOneById(Integer Id);
}
