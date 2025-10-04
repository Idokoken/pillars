package com.ndgroups.pillars.Data;

import com.ndgroups.pillars.model.User;
import com.ndgroups.pillars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@Component
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event){
        Set<String> defaultRoles = Set.of("ADMIN", "USER");
        createDefaultUserIfNotExist();
        createDefaultAdminIfNotExist();
    }

    private void createDefaultUserIfNotExist() {

        for (int i = 1; i <= 2; i++) {
           String defaultEmail = "user" + i + "@gmail.com";
           if(userRepository.existsByEmail(defaultEmail)){
               continue;
           }
           User user  = new User();
           user.setUsername("User" + i);
           user.setEmail(defaultEmail);
           user.setPassword(passwordEncoder.encode("123456"));
           user.setRole("USER");
           userRepository.save(user);
            System.out.println("Default user " + i + " created successfully.");
        }
    }

    private void createDefaultAdminIfNotExist() {
        for (int i = 1; i <= 2; i++) {
            String defaultEmail = "admin" + i + "@gmail.com";
            if(userRepository.existsByEmail(defaultEmail)){
                continue;
            }
            User user  = new User();
            user.setUsername("Admin" + i);
            user.setEmail(defaultEmail);
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRole("ADMIN");
            userRepository.save(user);
            System.out.println("Default Admin user " + i + " created successfully.");
        }
    }

}
