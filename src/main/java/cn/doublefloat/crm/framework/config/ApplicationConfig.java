package cn.doublefloat.crm.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:33 上午
 */

@Configuration
@MapperScan("cn.doublefloat.crm.project.**.mapper")
public class ApplicationConfig {
}
