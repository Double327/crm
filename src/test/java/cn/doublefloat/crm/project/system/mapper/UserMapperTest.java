package cn.doublefloat.crm.project.system.mapper;

import cn.doublefloat.crm.project.system.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void findUser() {
    }

    @Test
    void findAll() {
    }

    @Test
    void countAll() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void remove() {
    }

    @Test
    void findById() {
        User user = userMapper.findById(1L);
        System.out.println(user);
    }

    @Test
    void findByLoginName() {
    }

    @Test
    void editUser() {
    }

    @Test
    void findSalesAll() {
    }

    @Test
    void findAllManager() {
    }
}