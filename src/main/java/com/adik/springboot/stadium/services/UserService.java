package com.adik.springboot.stadium.services;

import com.adik.springboot.stadium.model.User;
import com.adik.springboot.stadium.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
