package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    /*public PasswordEncoder passwordEncoder() {  
    	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder;  
    }*/
	
	public DaoAuthenticationProvider authenticationProvider() {  
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();  
        authenticationProvider.setUserDetailsService(userDetailsService);  
        authenticationProvider.setPasswordEncoder(passwordEncoder);  
        return authenticationProvider; 
    }
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
		//PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//auth.inMemoryAuthentication().withUser("u").password(passwordEncoder.encode("p")).roles("USER");
		//auth.inMemoryAuthentication().withUser("a").password(passwordEncoder.encode("a")).roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				//.antMatchers("/login").permitAll()//对于登录路径不进行拦截
				//.antMatchers("/").hasAnyRole("USER", "ADMIN")
				//.antMatchers("/user/**").hasRole("ADMIN")
				//.anyRequest().authenticated()
				.anyRequest().permitAll()
			.and()
				.formLogin()//配置登录页面
				.loginPage("/login")//登录页面的访问路径
				.usernameParameter("usr").passwordParameter("pwd")
				//.defaultSuccessUrl("/user/list")//登录成功后默认跳转的路径
				//.failureUrl("/login?error")//登录失败后跳转的路径
			.and()
				.logout()
				//.logoutUrl("/logout")//用户退出所访问的路径，需要使用Post方式
				//.permitAll()
				//.logoutSuccessUrl("/login?logout")
			.and()
			//.csrf()
				//.and()
				//.disable()
				.httpBasic();
	}

}