package com.profile.profilebe.repositories;

import com.profile.profilebe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    
    public boolean checkEmailExists(String email){
        
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        return mongoOperations.exists(query, User.class);
    }
}
