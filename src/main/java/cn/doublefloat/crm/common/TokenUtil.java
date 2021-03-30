package cn.doublefloat.crm.common;

import cn.doublefloat.crm.project.system.domain.vo.UserVo;
import cn.doublefloat.crm.project.system.service.impl.UserDetailService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


/**
 * @author RedReins
 * @version 1.0
 * @description: token工具类
 * @date 2021/3/29 23:51
 */
public class TokenUtil {
    // 返回token中的载体
    Claims claims;
    public Claims getToken(String token){
        try {
            claims = Jwts.parser().setSigningKey("RedReins").parseClaimsJws(token.replace("Bearer",""))
                    .getBody();
        } catch (
                ExpiredJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }
//    public UserVo getUserVo(String token){
//        try {
//            claims = Jwts.parser().setSigningKey("RedReins").parseClaimsJws(token.replace("Bearer",""))
//                    .getBody();
//        } catch (
//                ExpiredJwtException e) {
//            claims = e.getClaims();
//        }
//        System.out.println("claims.getSubject()"+claims.getSubject());
//        userDetailService = (UserDetailService) ApplicationContextProvider.getBean("userDetailsService");
//        UserDetails userDetails = userDetailService.selectUserByName("admin");
//        System.out.println("userDetails"+userDetails);
//        return (UserVo) userDetails;
//    }
}
