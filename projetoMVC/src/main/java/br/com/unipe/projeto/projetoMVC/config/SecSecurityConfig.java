package br.com.unipe.projeto.projetoMVC.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("user1").password("user1Pass").roles("USER")
			.and()
			.withUser("user2").password("user2Pass").roles("USER")
			.and()
			.withUser("admin").password("adminPass").roles("ADMIN");
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception{
		http
			.csrf().disable()
		    .authorizeRequests()
		    .antMatchers("/login*").permitAll()
		    .antMatchers("/contas").hasRole("ADMIN")
		    .antMatchers("/criar-conta").hasRole("USER")
		    .antMatchers("/criar-pessoa").permitAll()
		    .anyRequest().authenticated()
		    .and()
		    .formLogin()
		    .loginProcessingUrl("/login")
		    .defaultSuccessUrl("/")
		    .and()
		    .logout()
		    .logoutUrl("/logout")
		    .deleteCookies("JSESSIONID");
	}

}
