package cn.doublefloat.crm.framework.security;

import cn.doublefloat.crm.project.system.service.impl.UserDetailService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
        System.out.println(authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String authToken = authHeader.substring("Bearer ".length());


            String username = Jwts.parser()
                    .setSigningKey("RedReins")
                    .parseClaimsJws(authToken)
                    .getBody().getSubject();//从token中获取用户信息，jwtUtils自定义的token加解密方式
            System.out.println("token中的username" + username);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailService.loadUserByUsername(username);//根据用户名获取用户对象

                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    //设置为已登录
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        chain.doFilter(request, response);
    }
}
