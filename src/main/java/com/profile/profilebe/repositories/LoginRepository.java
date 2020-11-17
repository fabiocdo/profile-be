package com.profile.profilebe.repositories;

import com.profile.profilebe.pojo.Login;
import com.profile.profilebe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class LoginRepository {

    private MongoOperations mongoOperations;

    @Autowired
    public LoginRepository(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }

    public Login findLoginByEmail(String email) {

        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        return mongoOperations.findOne(query, Login.class);
    }

    public User findUserByEmail(String email) {

        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        return mongoOperations.findOne(query, User.class);
    }
}
