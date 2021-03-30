package cn.doublefloat.crm.framework.security;

import cn.doublefloat.crm.project.system.service.impl.UserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author RedReins
 * @version 1.0
 * @description: 验证token
 * @date 2021/3/22 9:10
 */

@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {


    @Autowired
    private UserDetailService userDetailService; //用户信息service

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader("token");//获取header中的验证信息

        if(authHeader!=null){
            Claims claims;
            try {
                claims = Jwts.parser().setSigningKey("RedReins").parseClaimsJws(authHeader.replace("Bearer",""))
                .getBody();
            } catch (ExpiredJwtException e) {
                claims = e.getClaims();
            }
        String username = claims.getSubject();//获取当前登录用户名
            LinkedHashMap authorities1 = (LinkedHashMap) claims.get("authorities");
            String json = new JSONObject().toJSONString(authorities1);
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(json);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(token);
        }
        chain.doFilter(request, response);
    }
}
