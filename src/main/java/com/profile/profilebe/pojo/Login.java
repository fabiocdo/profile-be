package com.profile.profilebe.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class Login {

    private String email;
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
