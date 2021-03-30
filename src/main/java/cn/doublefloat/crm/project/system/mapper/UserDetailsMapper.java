package cn.doublefloat.crm.project.system.mapper;

import cn.doublefloat.crm.project.system.domain.Role;
import cn.doublefloat.crm.project.system.domain.vo.UserDetail;
import cn.doublefloat.crm.project.system.domain.vo.UserLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author RedReins
 * @version 1.0
 * @description: TODO
 * @date 2021/3/28 22:11
 */
@Repository
public interface UserDetailsMapper {
    UserDetail selectUserByName(String loginName);

    List<Role> queryRolesByUid(Long id);

    /*
    * 添加用户日志
    * */
    int addUserLog(UserLog userLog);

    List<UserLog> findAllLogs();

}
