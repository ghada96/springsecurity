package com.springsecurity.controller;

import com.springsecurity.db.UserRepository;
import com.springsecurity.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value="/all", method= RequestMethod.GET)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @RequestMapping(value="/create" , method= RequestMethod.POST)
    public List<User> create(@RequestBody User user ){
        userRepository.save(user);
        return userRepository.findAll();
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public  List<User> remove(@PathVariable Long id){
        userRepository.deleteById(id);
        return userRepository.findAll();
    }
    @RequestMapping(value = "/update/{id}" ,method = RequestMethod.POST)
    public List<User> update(@PathVariable Long id, User user){
        userRepository.save(user);
        return userRepository.findAll();
    }
}
