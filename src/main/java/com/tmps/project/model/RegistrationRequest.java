package com.tmps.project.model;

import lombok.Data;

@Data
public class RegistrationRequest {

    private final String name;
    private final String email;
    private final String password;

}
