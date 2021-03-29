package cn.doublefloat.crm.project.system.mapper;

import cn.doublefloat.crm.project.system.domain.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void findAll() {
        Role role = new Role();
        List<Role> roles = roleMapper.findAll(role);
        for (Role r : roles) {
            System.out.println(r);
        }
    }

    @Test
    void addRole() {
    }

    @Test
    void updateRole() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteRole() {
    }
}