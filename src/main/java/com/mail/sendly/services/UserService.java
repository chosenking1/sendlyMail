package com.mail.sendly.services;

import com.mail.sendly.data.repository.UserRepository;
import com.mail.sendly.dtos.requests.RegisterUserRequest;
import com.mail.sendly.dtos.responses.FindUserResponse;
import com.mail.sendly.dtos.responses.RegisterUserResponse;

import java.util.List;

public interface UserService {
    RegisterUserResponse saveUser(RegisterUserRequest request);

    UserRepository getRepository();


    List<FindUserResponse> findUserByEmail(String userEmail);

    void deleteUserByEmail(String email);
}
