package com.tugulbayraktar.springboot.mongodb.repository;

import com.tugulbayraktar.springboot.mongodb.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {


}
