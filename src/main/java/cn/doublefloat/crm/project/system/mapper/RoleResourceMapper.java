package cn.doublefloat.crm.project.system.mapper;

import cn.doublefloat.crm.project.system.domain.RoleResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 8:18 下午
 */
@Repository
public interface RoleResourceMapper {

    /**
     * 删除角色对应资源
     *
     * @param roleId 角色ID
     * @return 结果
     */
    int delete(Long roleId);

    /**
     * 添加角色-资源映射
     *
     * @param roleResource 关系
     * @return 结果
     */
    int add(RoleResource roleResource);

    /**
     * 根据多个角色ID获取资源ID
     *
     * @param list 角色ID
     * @return 资源ID
     */
    List<Long> batchFindResourceId(List<Long> list);
}
