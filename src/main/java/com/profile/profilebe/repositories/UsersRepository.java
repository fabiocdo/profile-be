package com.profile.profilebe.repositories;

import com.profile.profilebe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class UsersRepository {

    private MongoOperations mongoOperations;

    @Autowired
    public UsersRepository(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }

    public void createUser(User user){
        mongoOperations.insert(user);
    }
}
