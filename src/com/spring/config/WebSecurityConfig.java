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
				//.antMatchers("/login").permitAll()//���ڵ�¼·������������
				//.antMatchers("/").hasAnyRole("USER", "ADMIN")
				//.antMatchers("/user/**").hasRole("ADMIN")
				//.anyRequest().authenticated()
				.anyRequest().permitAll()
			.and()
				.formLogin()//���õ�¼ҳ��
				.loginPage("/login")//��¼ҳ��ķ���·��
				.usernameParameter("usr").passwordParameter("pwd")
				//.defaultSuccessUrl("/user/list")//��¼�ɹ���Ĭ����ת��·��
				//.failureUrl("/login?error")//��¼ʧ�ܺ���ת��·��
			.and()
				.logout()
				//.logoutUrl("/logout")//�û��˳������ʵ�·������Ҫʹ��Post��ʽ
				//.permitAll()
				//.logoutSuccessUrl("/login?logout")
			.and()
			//.csrf()
				//.and()
				//.disable()
				.httpBasic();
	}

}