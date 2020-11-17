package com.profile.profilebe.services;

import com.profile.profilebe.exceptions.PasswordDoesntMatchException;
import com.profile.profilebe.exceptions.EmptyFieldsException;
import com.profile.profilebe.pojo.Login;
import com.profile.profilebe.pojo.User;
import com.profile.profilebe.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public User getUserByCredentials(Login loginCredentials) throws PasswordDoesntMatchException, EmptyFieldsException {

        Login fetchedLogin = loginRepository.findLoginByEmail(loginCredentials.getEmail());

        if(fetchedLogin == null){
            throw new EmptyFieldsException("Usuário não encontrado");
        }

        if(!loginCredentials.getSenha().equals(fetchedLogin.getSenha())) {
            throw new PasswordDoesntMatchException("Senha incorreta.");
        }

        return loginRepository.findUserByEmail(loginCredentials.getEmail());
    }
}