package com.profile.profilebe.services;

import com.profile.profilebe.pojo.User;
import com.profile.profilebe.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public void createUser(User user){
        usersRepository.createUser(user);
    }
}
