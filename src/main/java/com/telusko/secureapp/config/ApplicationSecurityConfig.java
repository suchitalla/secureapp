package com.telusko.secureapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.*;
@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	/* FOR INMEMORY PASSWD
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * 
	 * List<UserDetails> usr = new ArrayList<>();
	 * usr.add(User.withDefaultPasswordEncoder().username("navin").password("1234").
	 * roles("USER").build());
	 * usr.add(User.withDefaultPasswordEncoder().username("suchi").password("abcd").
	 * roles("USER").build()); return new InMemoryUserDetailsManager(usr); }
	 */
	//FORM LOGIN
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-success").permitAll();
	}
	/* FOR DB ACCESS PASSWD
	 * @Autowired private UserDetailsService userDetailsService;
	 * 
	 * @Bean public AuthenticationProvider authProvider() {
	 * DaoAuthenticationProvider prov = new DaoAuthenticationProvider();
	 * prov.setUserDetailsService(userDetailsService);
	 * //prov.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	 * prov.setPasswordEncoder(new BCryptPasswordEncoder()); return prov; }
	 */
	
}
