package com.example.PaymentService.security;
import org.springframework.context.annotation.Bean; 
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
import org.springframework.security.crypto.password.NoOpPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;
  
@SuppressWarnings("deprecation")
@EnableWebSecurity 
public class PaymentConfiguration extends WebSecurityConfigurerAdapter 
{
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception  { 
	  auth.inMemoryAuthentication()
	  		.withUser("anuska").password("sharma").roles("USER"); 
  }
  
  @Override 
  protected void configure(HttpSecurity http) throws Exception  {
	  
	  http.httpBasic()
	  .and().authorizeRequests()
//	  	  .antMatchers("/pay/add").hasRole("USER")
	  	  .antMatchers("/pay/all","/pay/add").permitAll()
	  	  .and().csrf().disable().headers().frameOptions().disable();
	 }
  
  @Bean
  public PasswordEncoder getPasswordEncoder() 
  { 
	  return NoOpPasswordEncoder.getInstance(); 
  } 
}
 