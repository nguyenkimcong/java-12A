package com.example.blogbackend;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.Category;
import com.example.blogbackend.entity.User;
import com.example.blogbackend.repository.BlogRepository;
import com.example.blogbackend.repository.CategoryRepository;
import com.example.blogbackend.repository.UserRepository;
import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InitDataTests {

    @Autowired
    private Faker faker;

    @Autowired
    private Slugify slugify;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Test
    @Rollback(value = false)
    void save_user() {
        for (int i = 0; i < 5; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password("111")
                    .build();

            userRepository.save(user);
        }
    }

    @Test
    @Rollback(value = false)
    void save_category() {
        for (int i = 0; i < 5; i++) {
            Category category = Category.builder()
                    .name(faker.leagueOfLegends().champion())
                    .build();

            categoryRepository.save(category);
        }
    }

    @Test
    @Rollback(value = false)
    void save_blog() {
        Random rd = new Random();

        List<User> users = userRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        for (int i = 0; i < 20; i++) {
            // Random 1 user
            User rdUser = users.get(rd.nextInt(users.size()));

            // Random 1 ds category
            Set<Category> rdCategories = new LinkedHashSet<>();
            for (int j = 0; j < 3; j++) {
                Category rdCategory = categories.get(rd.nextInt(categories.size()));
                rdCategories.add(rdCategory);
            }

            String title = faker.lorem().sentence(10);
            Blog blog = Blog.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().sentence(20))
                    .content(faker.lorem().sentence(100))
                    .status(rd.nextInt(2) == 1)
                    .user(rdUser)
                    .categories(rdCategories)
                    .build();

            blogRepository.save(blog);
        }
    }
}