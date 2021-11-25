package br.com.opet.gestime;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/js/**", "/css/**", "/imagem/**")
				.permitAll()
				.anyRequest().authenticated()
			.and()
			.oauth2Login(oauth2 -> oauth2
					.loginPage("/login/oauth2")
					.defaultSuccessUrl("/home", true)
					.permitAll()
			.authorizationEndpoint(authorization -> authorization
		            .baseUri("/login/oauth2/authorization"))
					.permitAll()
					)
			.logout(logout -> {
				logout.logoutUrl("/logout") 
					.logoutSuccessUrl("/home"); 
			});
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.dataSource(dataSource);
	}

}
