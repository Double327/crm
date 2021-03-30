package cn.doublefloat.crm.project.system.service.impl;

import cn.doublefloat.crm.project.system.domain.Role;
import cn.doublefloat.crm.project.system.domain.vo.UserDetail;
import cn.doublefloat.crm.project.system.domain.vo.UserVo;
import cn.doublefloat.crm.project.system.mapper.UserDetailsMapper;
import cn.doublefloat.crm.project.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RedReins
 * @version 1.0
 * @description: 给用户设置角色
 * @date 2021/3/28 22:03
 */
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetail userDetails = userDetailsMapper.selectUserByName(s);
        if(userDetails == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        userDetails.setRoles(userDetailsMapper.queryRolesByUid(userDetails.getId()));
        return userDetails;
    }

    public UserVo findByLoginName(String loginName) {
        return new UserVo(userMapper.findByLoginName(loginName));
    }
}
