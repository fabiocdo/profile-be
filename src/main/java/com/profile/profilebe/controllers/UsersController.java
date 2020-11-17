package com.profile.profilebe.controllers;

import com.profile.profilebe.exceptions.EmptyFieldsException;
import com.profile.profilebe.exceptions.UsernameAlreadyExistsException;
import com.profile.profilebe.pojo.User;
import com.profile.profilebe.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
    private static final String ORIGIN_URL = "http://localhost:3000";
    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    @ResponseBody
    @CrossOrigin(origins = ORIGIN_URL)
    public ResponseEntity<String> signup(@RequestBody User user){

        try {
            usersService.createUser(user);
        }catch (UsernameAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Este e-mail já está cadastrado.");
        }catch (EmptyFieldsException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Todos os campos obrigatórios devem ser preenchidos");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuário cadastrado com sucesso.");
    }

}
