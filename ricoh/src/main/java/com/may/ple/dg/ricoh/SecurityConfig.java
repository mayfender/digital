/*package com.may.ple.dg.ricoh;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication().dataSource(dataSource)
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("select username, password, enabled from user where username = ?")
			.authoritiesByUsernameQuery("select username, authority from role where username = ?");
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and()
		.csrf().disable()
		.authorizeRequests()
			.antMatchers("/app/js/**", "/app/lib/**", "/user",
					     "/app/scripts/**", "/app/styles/**", 
						 "/app/views/pages/login.html", "/app/index.html").permitAll()
			.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/app/index.html#/login")
//			.defaultSuccessUrl("/app/index.html", true)
//			.failureUrl("/index.html?error=1")
			.permitAll()
		.and()
		.logout().logoutUrl("/logout");
	}

}
*/