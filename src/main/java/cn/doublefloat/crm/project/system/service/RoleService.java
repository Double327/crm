package cn.doublefloat.crm.project.system.service;

import cn.doublefloat.crm.project.system.domain.Role;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:37 下午
 */

public interface RoleService {

    /**
     * 查询角色列表
     *
     * @param role 角色
     * @return 结果
     */
    List<Role> findRoleList(Role role);

    /**
     * 保存角色
     *
     * @param role 角色
     * @return 结果
     */
    int saveRole(Role role);

    /**
     * 根据ID查找角色
     *
     * @param id ID
     * @return 结果
     */
    Role findById(Long id);

    /**
     * 根据ID删除角色
     *
     * @param id 角色ID
     * @return 结果
     */
    int delete(Long id);

    /**
     * 获取所有角色
     *
     * @param role 角色
     * @return 结果
     */
    List<Role> getAll(Role role);

    /**
     * 保存角色对应资源
     *
     * @param ids    资源ID
     * @param roleId 角色ID
     * @return 结果
     */
    int saveRightList(Long[] ids, Long roleId);
}
