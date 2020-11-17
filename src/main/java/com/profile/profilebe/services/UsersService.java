package com.profile.profilebe.services;

import com.profile.profilebe.exceptions.EmptyFieldsException;
import com.profile.profilebe.exceptions.UsernameAlreadyExistsException;
import com.profile.profilebe.pojo.User;
import com.profile.profilebe.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void createUser(User user) throws UsernameAlreadyExistsException, EmptyFieldsException {

        if(checkEmptyFields(user)){
            throw new EmptyFieldsException("Existem campos vazios.");
        }

        if(!checkEmailExists(user.getEmail())) {
            usersRepository.createUser(user);
        }else{
            throw new UsernameAlreadyExistsException("Este email já existe");
        }
    }

    public boolean checkEmailExists(String email) {

        if(usersRepository.checkEmailExists(email)){
            return true;
        }
        return false;
    }

    public boolean checkEmptyFields(User user){

        if(user.getNome().isEmpty() || user.getSobrenome().isEmpty() || user.getEmail().isEmpty() ||
                user.getSexo().isEmpty() || user.getCep().isEmpty() || user.getLogradouro().isEmpty() ||
                user.getNumero().isEmpty() || user.getBairro().isEmpty() || user.getCidade().isEmpty() ||
                user.getUf().isEmpty() || user.getSenha().isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}