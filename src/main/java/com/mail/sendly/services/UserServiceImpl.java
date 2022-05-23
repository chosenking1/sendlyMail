package com.mail.sendly.services;

import com.mail.sendly.data.model.User;
import com.mail.sendly.data.repository.UserRepository;
import com.mail.sendly.dtos.requests.RegisterUserRequest;
import com.mail.sendly.dtos.responses.FindUserResponse;
import com.mail.sendly.dtos.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse saveUser(RegisterUserRequest request) {
           User user = new User();
           user.setFirstName(request.getFirstName());
           user.setLastName(request.getLastName());
           user.setEmail(request.getEmail());
           user.setPassword(request.getPassword());
           User userDetails = userRepository.save(user);

        return null;
    }

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public List<FindUserResponse> findUserByEmail(String userEmail) {
        return null;
    }

    @Override
    public void deleteUserByEmail(String email) {

    }
}
