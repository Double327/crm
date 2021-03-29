package cn.doublefloat.crm.project.system.service.impl;

import cn.doublefloat.crm.project.system.domain.Organization;
import cn.doublefloat.crm.project.system.domain.Password;
import cn.doublefloat.crm.project.system.domain.User;
import cn.doublefloat.crm.project.system.domain.UserRole;
import cn.doublefloat.crm.project.system.domain.vo.UserVo;
import cn.doublefloat.crm.project.system.mapper.OrganizationMapper;
import cn.doublefloat.crm.project.system.mapper.UserMapper;
import cn.doublefloat.crm.project.system.mapper.UserRoleMapper;
import cn.doublefloat.crm.project.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:51 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public List<UserVo> findAll(User user) {
        List<User> list = userMapper.findAll(user);
        List<UserVo> userVoList = new ArrayList<>();
        for (User u : list) {
            userVoList.add(getUserVo(u));
        }
        return userVoList;
    }

    @Override
    public Integer countAll(User user) {
        return userMapper.countAll(user);
    }

    @Override
    public int saveUser(UserVo user) {
        if (user.getId() == null) {
            User u = new User(user);
            int saveUserRes = userMapper.saveUser(u);
            user.setId(u.getId());
            saveUserRole(user);
            return saveUserRes;
        } else {
            User u = new User(user);
            int editRes = userMapper.editUser(u);

            userRoleMapper.deleteByUserId(u.getId());
            saveUserRole(user);
            return editRes;
        }
    }

    private void saveUserRole(UserVo userVo) {
        List<Long> roleIds = userVo.getRoleIds();
        if (roleIds.size() > 0) {
            for (Long roleId : roleIds) {
                int saveUserRoleRes = userRoleMapper.saveUserRole(new UserRole(userVo.getId(), roleId));
            }
        }
    }

    @Override
    public int delete(Long id) {
        int removeUser = userMapper.remove(id);
        int removeRole = userRoleMapper.deleteByUserId(id);
        return removeUser;
    }

    @Override
    public UserVo findById(Long id) {
        return getUserVo(userMapper.findById(id));
    }

    @Override
    public UserVo findByLoginName(String loginName) {
        return new UserVo(userMapper.findByLoginName(loginName));
    }

    @Override
    public List<Map<Long, Object>> findSalesAll() {
        return findSalesAll();
    }

    @Override
    public List<Map<Long, Object>> findAllManager() {
        return userMapper.findAllManager();
    }

    @Override
    public int setPassword(Password pwd) {
        User user = userMapper.findById(pwd.getId());
        return 0;
    }

    private UserVo getUserVo(User user) {
        UserVo userVo = new UserVo(user);
        List<Map<Long, Object>> userRoles = userRoleMapper.findById(user.getId());
        userVo.setRoleIds(parseRoleIds(userRoles));
        //一个用户只能一个部门
        Organization org = organizationMapper.findById(user.getOrganizationId());
        if (org != null) {
            userVo.setOrganizationName(org.getName());
        }
        return userVo;
    }

    private List<Long> parseRoleIds(List<Map<Long, Object>> userRoles) {
        List<Long> ids = new ArrayList<>();
        if (userRoles.size() > 0) {
            for (Map<Long, Object> role : userRoles) {
                ids.add((Long) role.get("role_id"));
            }
        }
        return ids;
    }
}
