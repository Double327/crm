package cn.doublefloat.crm.framework.config;

import cn.doublefloat.crm.framework.security.AuthenticationTokenFilter;
import cn.doublefloat.crm.framework.security.LoginFilter;
import cn.doublefloat.crm.framework.web.domain.JsonResult;
import cn.doublefloat.crm.project.system.domain.vo.UserDetail;
import cn.doublefloat.crm.project.system.service.impl.UserDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * security配置
 *
 * @author 赵潭
 * @version 1.0
 * @date 2021/3/28 2:12 下午
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailService userDetailService;
    @Autowired
    AuthenticationTokenFilter authenticationTokenFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SessionRegistryImpl sessionRegistry() {
        return new SessionRegistryImpl();
    }

    /*
     * 登录信息验证
     * */
    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                UserDetail userDetail = (UserDetail) authentication.getPrincipal();
                String jwt = Jwts.builder()
                        .claim("authorities", userDetail)//配置用户角色
                        .setSubject(userDetail.getUsername())
//                        10分钟有效时间
                        .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .signWith(SignatureAlgorithm.HS512, "RedReins")
                        .compact();
//                userDetail.setToken(jwt);
                userDetail.setPassword(null);
                JsonResult ok = JsonResult.success("登录成功!", jwt);
                String s = new ObjectMapper().writeValueAsString(ok);
                out.write(s);
                out.flush();
                out.close();
            }
        });
        loginFilter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                JsonResult respBean = JsonResult.error(exception.getMessage());
                if (exception instanceof LockedException) {
                    JsonResult.error("账户被锁定，请联系管理员!");
                } else if (exception instanceof CredentialsExpiredException) {
                    JsonResult.error("密码过期，请联系管理员!");
                } else if (exception instanceof AccountExpiredException) {
                    JsonResult.error("账户过期，请联系管理员!");
                } else if (exception instanceof DisabledException) {
                    JsonResult.error("账户被禁用，请联系管理员!");
                } else if (exception instanceof BadCredentialsException) {
                    JsonResult.error("用户名或者密码输入错误，请重新输入!");
                }
                out.write(new ObjectMapper().writeValueAsString(respBean));
                out.flush();
                out.close();
            }
        });
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/doLogin");
        return loginFilter;
    }

    //    身份管理
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                验证码
                .antMatchers("/verifyCode").permitAll()
//                注册
                .antMatchers("/doRegister").permitAll()
//                注销
                .antMatchers("/loginOut").permitAll()
//                登录
                .antMatchers(HttpMethod.POST, "/doLogin").permitAll()
                //设置访问已经上传的文件访问允许匿名
                .antMatchers("/file/**").anonymous()
                .antMatchers("/swagger-ui.html").anonymous()
                .antMatchers("/swagger-resources/**").anonymous()
                .antMatchers("/webjars/**").anonymous()
                .antMatchers("/*/api-docs").anonymous()
                .antMatchers("/druid/**").anonymous()
                .anyRequest()
                .authenticated()
                .and()
                /* 在接受到请求之后 触发security之前 先进行jwt验证 如果请求头中由header值 那么放行拦截*/
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf()
                .disable();
    }
}
