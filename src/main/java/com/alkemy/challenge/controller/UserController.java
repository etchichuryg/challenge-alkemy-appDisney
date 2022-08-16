package com.alkemy.challenge.controller;


import org.springframework.web.bind.annotation.*;


import com.alkemy.challenge.repository.UserRepository;


@RestController
@RequestMapping(path = "auth")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	UserRepository userRepository;



}
