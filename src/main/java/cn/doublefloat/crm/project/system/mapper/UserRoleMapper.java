package cn.doublefloat.crm.project.system.mapper;

import cn.doublefloat.crm.project.system.domain.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:57 下午
 */

public interface UserRoleMapper {
    List<Map<Long, Object>> findById(@Param("id") Long id);

    int saveUserRole(UserRole userRole);

    int deleteByUserId(Long id);
}
