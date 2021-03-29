package cn.doublefloat.crm.project.system.service.impl;

import cn.doublefloat.crm.project.system.domain.Role;
import cn.doublefloat.crm.project.system.domain.RoleResource;
import cn.doublefloat.crm.project.system.mapper.RoleMapper;
import cn.doublefloat.crm.project.system.mapper.RoleResourceMapper;
import cn.doublefloat.crm.project.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:38 下午
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;


    @Override
    public List<Role> findRoleList(Role role) {
        return roleMapper.findAll(role);
    }

    @Override
    public int saveRole(Role role) {
        int i = 0;
        if (role.getId() == null) {
            //新增
            i = roleMapper.addRole(role);
        } else {
            //编辑
            i = roleMapper.updateRole(role);
        }
        return i;
    }

    @Override
    public Role findById(Long id) {
        return roleMapper.findById(id);
    }

    @Override
    public int delete(Long id) {
        return roleMapper.deleteRole(id);
    }

    @Override
    public List<Role> getAll(Role role) {
        return roleMapper.findAll(role);
    }

    @Override
    public int saveRightList(Long[] ids, Long roleId) {
        int i = 0;
        //先删除roleId的所有权限，再添加
        roleResourceMapper.delete(roleId);
        if (ids.length > 0) {
            for (int n = 0; n < ids.length; n++) {
                Long resourceId = ids[n];
                i += roleResourceMapper.add(new RoleResource(roleId, resourceId));
            }
        }
        return i;
    }
}
