package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨.
public class SecurityConfig {
		 
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			return http
				.csrf(AbstractHttpConfigurer::disable)

			// 특정 URL에 대한 권한 설정.
            .authorizeHttpRequests((authorizeRequests) -> {
                authorizeRequests.requestMatchers("/").authenticated();

                authorizeRequests.requestMatchers("/manager/**")
                        .hasAnyRole("ADMIN", "MANAGER");

                authorizeRequests.requestMatchers("/admin/**")
                        .hasRole("ADMIN");
                        
                authorizeRequests.anyRequest().permitAll();
            })
            
            .formLogin((formLogin) ->
				formLogin
					.usernameParameter("email")
					.passwordParameter("password")
					.loginPage("/login/login")
					.failureUrl("/login/login?failed")
					.loginProcessingUrl("/")
			)
					/*
					 * .logout(log -> log .logoutUrl("/logout") .logoutSuccessUrl("/login")
					 * .deleteCookies("JSESSIONID", "remember-me") // 로그아웃 후 쿠키 삭제
					 * .addLogoutHandler(logoutHandler()) // 로그아웃 핸들러
					 * .logoutSuccessHandler(logoutSuccessHandler()) )
					 */ 	// 로그아웃 성공 후 핸들러
            .build();
	}
}