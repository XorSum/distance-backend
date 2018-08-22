package com.example.distance.login.repository;


import com.example.distance.login.model.ProveNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveNumberRepository extends CrudRepository<ProveNumber,Integer> {

    ProveNumber findByPhonenumberAndProvenum(String phonenumber, String provenum);       //通过手机号和随机数查找
    ProveNumber findByPhonenumber(String phonenumber);
    ProveNumber findByProvenum(String provenum);
}
