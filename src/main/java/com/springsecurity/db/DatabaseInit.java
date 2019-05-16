package com.springsecurity.db;

import com.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class DatabaseInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
@Autowired
    public DatabaseInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User dan = new User("dan",passwordEncoder.encode("dan123"),"USER");
        User ghada = new User("ghada",passwordEncoder.encode("ghada"),"USER");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN");

        List<User> users = Arrays.asList(dan,admin,ghada);

        // Save to db
        this.userRepository.saveAll(users);


    }
}
