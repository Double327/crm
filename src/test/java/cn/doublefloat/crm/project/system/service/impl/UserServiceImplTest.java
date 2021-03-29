package cn.doublefloat.crm.project.system.service.impl;

import cn.doublefloat.crm.project.system.domain.vo.UserVo;
import cn.doublefloat.crm.project.system.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @BeforeEach
    void setUp() {
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
    void delete() {
    }

    @Test
    void findById() {
        UserVo user = userService.findById(1L);
        System.out.println(user);
    }

    @Test
    void findByLoginName() {
    }

    @Test
    void findSalesAll() {
    }

    @Test
    void findAllManager() {
    }

    @Test
    void setPassword() {
    }
}