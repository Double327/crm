package cn.doublefloat.crm.project.system.mapper;

import cn.doublefloat.crm.project.system.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 7:52 下午
 */
@Repository
public interface RoleMapper {

    /**
     * 获取所有角色信息
     *
     * @param role 查询条件
     * @return 结果
     */
    List<Role> findAll(Role role);

    /**
     * 添加角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    int addRole(Role role);

    /**
     * 更新角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    int updateRole(Role role);

    /**
     * 根据ID查找角色信息
     *
     * @param id 角色ID
     * @return 结果
     */
    Role findById(@Param("id") Long id);

    /**
     * 删除角色信息
     *
     * @param id 角色ID
     * @return 结果
     */
    int deleteRole(@Param("id") Long id);
}
