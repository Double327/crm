package cn.doublefloat.crm.project.system.service.impl;

import cn.doublefloat.crm.project.system.domain.vo.ResourceVo;
import cn.doublefloat.crm.project.system.domain.vo.UserVo;
import cn.doublefloat.crm.project.system.service.ResourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceServiceImplTest {

    @Autowired
    private ResourceService resourceService;
    @Test
    void findResource() {
        UserVo userVo = new UserVo();
        List<Long> ids = new ArrayList<>();
        ids.add(7L);
        userVo.setRoleIds(ids);
        userVo.setAdmin(false);
        List<ResourceVo> resource = resourceService.findResource(userVo);
        for (ResourceVo resourceVo : resource) {
            System.out.println(resourceVo);
        }
    }

    @Test
    void findResourceList() {
    }

    @Test
    void addResource() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteResource() {
    }

    @Test
    void findRightList() {
    }
}