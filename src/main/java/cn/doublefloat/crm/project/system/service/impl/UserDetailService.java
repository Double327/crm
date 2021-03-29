package cn.doublefloat.crm.project.system.service.impl;

import cn.doublefloat.crm.project.system.domain.vo.UserDetail;
import cn.doublefloat.crm.project.system.mapper.UserDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author RedReins
 * @version 1.0
 * @description: TODO
 * @date 2021/3/28 22:03
 */
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetail userDetails = userDetailsMapper.selectUserByName(s);
        if(userDetails == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        userDetails.setRoles(userDetailsMapper.queryRolesByUid(userDetails.getId()));
        return userDetails;
    }
}
