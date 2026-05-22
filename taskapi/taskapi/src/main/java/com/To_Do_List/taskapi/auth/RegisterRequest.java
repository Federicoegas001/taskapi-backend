package com.To_Do_List.taskapi.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String role;
}
