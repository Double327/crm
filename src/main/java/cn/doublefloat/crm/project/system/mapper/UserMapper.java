package cn.doublefloat.crm.project.system.mapper;

import cn.doublefloat.crm.project.system.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:56 下午
 */
@Repository
public interface UserMapper {

    User findUser(User user);

    List<User> findAll(User user);

    Integer countAll(User user);

    int saveUser(User user);

    int remove(Long id);

    User findById(Long id);

    User findByLoginName(String loginName);

    int editUser(User u);

    List<Map<Long, Object>> findSalesAll();

    List<Map<Long, Object>> findAllManager();

    int changeStatus(User user);
}
