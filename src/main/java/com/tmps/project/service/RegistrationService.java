package com.tmps.project.service;

import com.tmps.project.model.AppUser;
import com.tmps.project.model.AppUserRole;
import com.tmps.project.model.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final AppUserService userService;

    public String register(RegistrationRequest request) {

        return userService.singUpUser(
                new AppUser(
                        request.getName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
