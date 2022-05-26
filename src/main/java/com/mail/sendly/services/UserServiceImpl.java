package com.mail.sendly.services;

import com.mail.sendly.data.model.MailBox;
import com.mail.sendly.data.model.User;
import com.mail.sendly.data.repository.MailboxesRepository;
import com.mail.sendly.data.repository.UserRepository;
import com.mail.sendly.dtos.requests.CreateMailboxes;
import com.mail.sendly.dtos.requests.RegisterUserRequest;
import com.mail.sendly.dtos.responses.FindUserResponse;
import com.mail.sendly.dtos.responses.RegisterUserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    ModelMapper mapper = new ModelMapper();
    RegisterUserResponse response = new RegisterUserResponse();


    @Override
    public RegisterUserResponse saveUser(RegisterUserRequest request) {
           User user = new User();

           MailboxesService mailboxesService= new MailboxesServiceImpl();

        MailBox mailBox = new MailBox();
        CreateMailboxes createMailboxes = new CreateMailboxes(request.getEmail(), Collections.singletonList(mailBox));
        createMailboxes.setEmail(request.getEmail());
//        createMailboxes.setMailbox(Collections.singletonList(mailBox));
        mailboxesService.saveMailboxes(createMailboxes);


           user.setFirstName(request.getFirstName());
           user.setLastName(request.getLastName());
           user.setEmail(request.getEmail());
           user.setPassword(request.getPassword());
           User userDetails = userRepository.save(user);

            mapper.map(userDetails, response);
//            mapper.map(request, CreateMailboxes.class);
//

            return response;
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
