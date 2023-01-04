package com.example.basic;

import com.example.basic.entity.User;
import com.example.basic.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaBasicApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save_user() {
        User user = User.builder()
                .name("Nguyễn Văn A")
                .email("a@gmail.com")
                .age(30)
                .build();

        userRepository.save(user);
    }

    @Test
    void save_mutilple_user() {
        User user = User.builder()
                .name("Nguyễn Văn B")
                .email("b@gmail.com")
                .age(36)
                .build();

        User user1 = User.builder()
                .name("Trần Thị C")
                .email("c@gmail.com")
                .age(16)
                .build();

        User user2 = User.builder()
                .name("Ngô Văn D")
                .email("d@gmail.com")
                .age(24)
                .build();

        userRepository.saveAll(List.of(user, user1, user2));
    }

    @Test
    void update_user() {
        Optional<User> userOptional =  userRepository.findById(1);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName("Nguyễn Văn A Update");
            user.setAge(33);

            userRepository.save(user);
        }
    }

    @Test
    void delete_user() {
        userRepository.deleteById(1);
    }

    @Test
    void findByName_test() {
        List<User> users = userRepository.findByName("Nguyễn Văn B");
        users.forEach(System.out::println);

        List<User> users1 = userRepository.findByNameJPQL("Nguyễn Văn B");
        users1.forEach(System.out::println);

        List<User> users2 = userRepository.findByNameNative("Nguyễn Văn B");
        users2.forEach(System.out::println);
    }

    @Test
    void findByNameContainingIgnoreCase_test() {
        List<User> users = userRepository.findByNameContainingIgnoreCase("Văn");
        users.forEach(System.out::println);
    }

    @Test
    void countByAgeBetween_test() {
        long total = userRepository.countByAgeBetween(18, 28);
        System.out.println(total);
    }

    @Test
    void existsByEmail_test() {
        System.out.println(userRepository.existsByEmail("b@gmail.com"));
        System.out.println(userRepository.existsByEmail("a@gmail.com"));
    }

    @Test
    void updateNameUser_test() {
        userRepository.updateNameUser(2, "Nguyễn Văn B update");
    }

    @Test
    void findByAgeJPQL_test() {
        List<User> users = userRepository.findByAgeJPQL(16);
        users.forEach(System.out::println);
    }
}
