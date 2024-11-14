package top.xym.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import top.xym.handler.JsonLogoutSuccessHandler;
import top.xym.handler.MyLogoutHandler;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // 配置所有的Http请求必须认证
        http.authorizeHttpRequests()
                .requestMatchers("/login.html", "/demo.html").permitAll()
                .anyRequest().authenticated();

        // 开启表单登录
        http.formLogin();
//                .loginPage("/login.html")
//                .loginProcessingUrl("/login");

        //自定义注销登录请求处理路径
        http.logout()
                // 自定义清理项
                .clearAuthentication(true)
                .deleteCookies("xxx", "yyy")
                .invalidateHttpSession(true)
                .logoutUrl("/custom/logout")
                //注销成功后跳转的页面
                .logoutSuccessUrl("/demo.html")
                .addLogoutHandler(new MyLogoutHandler())
                .logoutSuccessHandler(new JsonLogoutSuccessHandler());
        // 开启Basic认证
        http.httpBasic();
        // 关闭CSRF
        http.csrf().disable();
        return http.build();
    }

}