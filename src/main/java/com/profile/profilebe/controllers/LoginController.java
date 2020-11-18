package com.profile.profilebe.controllers;

import com.profile.profilebe.exceptions.PasswordDoesntMatchException;
import com.profile.profilebe.exceptions.EmptyFieldsException;
import com.profile.profilebe.exceptions.UsernameNotFoundException;
import com.profile.profilebe.pojo.Login;
import com.profile.profilebe.pojo.User;
import com.profile.profilebe.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private static final String ORIGIN_URL = "http://localhost:3000";
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) { this.loginService = loginService; }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    @ResponseBody
    @CrossOrigin(origins = ORIGIN_URL)
    public ResponseEntity<User> login(@RequestBody Login loginCredentials) {

        try {
            return ResponseEntity.status(HttpStatus.OK).
                    body(loginService.getUserByCredentials(loginCredentials));
        } catch (PasswordDoesntMatchException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
