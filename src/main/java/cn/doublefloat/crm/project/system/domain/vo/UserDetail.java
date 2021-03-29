package cn.doublefloat.crm.project.system.domain.vo;

import cn.doublefloat.crm.project.system.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author RedReins
 * @version 1.0
 * @description: TODO
 * @date 2021/3/28 22:00
 */

public class UserDetail extends UserVo implements UserDetails {
    List<Role> roles;

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for(Role role : roles){
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorityList;
    }

    @Override
    public String getUsername() {
        return getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
