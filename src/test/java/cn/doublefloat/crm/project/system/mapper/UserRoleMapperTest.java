package cn.doublefloat.crm.project.system.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRoleMapperTest {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Test
    void findById() {
        List<Map<Long, Object>> roles = userRoleMapper.findById(1L);
        for (Map<Long, Object> role : roles) {
            System.out.println(role);
        }

    }

    @Test
    void saveUserRole() {
    }

    @Test
    void deleteByUserId() {
    }

    @Test
    void testFindById() {
    }

    @Test
    void testSaveUserRole() {
    }

    @Test
    void testDeleteByUserId() {
        int i = userRoleMapper.deleteByUserId(8L);
        System.out.println(i);
    }
}