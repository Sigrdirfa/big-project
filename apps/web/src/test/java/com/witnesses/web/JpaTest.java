package com.witnesses.web;

import com.witnesses.web.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testJpaSave() {
        userRepository.findByEmail("sigrdirfa@163.com").ifPresent(user -> {
            user.setEnabled(true);
            userRepository.save(user);
        });

        System.out.println(userRepository.findByEmail("sigrdirfa@163.com"));
    }

    @Test
    public void testJpaFindByUUID() {
//        userRepository.findById()
    }
}
