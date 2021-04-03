package com.jungwoo.book.springboot.domain.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.jungwoo.book.springboot.domain.user.Role.USER;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositorySupport userRepositorySupport;

    @After
    public void down() throws Exception {
        userRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_기본_기능_확인() {
        //given
        String name = "jungwoo";
        String address = "jungwoo@gmail.com";
        String picture = "???";
        Role role = USER;

        userRepository.save(User.builder()
                                .name(name)
                                .email(address)
                                .picture(picture)
                                .role(role)
                                .build());

        //when
        List<User> result = userRepositorySupport.findByName(name);

        //then
//        assertThat(result.size(), `is`(1));
        assertThat(result.get(0).getEmail().equals(address));
//        assertThat(result.get(0).getAddress(), is(address));
    }
}
