package com.catalyst.funds.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
    @Autowired
    private UserDetailsService userDetailsService;  
    @Autowired
    private DataSource dataSource;
	
    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }   
    
	@Bean
    public PasswordEncoder getPassword() {
        return new BCryptPasswordEncoder();
    }
	   
	   @Bean
       public DaoAuthenticationProvider authenticationProvider() {
           DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
           authProvider.setUserDetailsService(userDetailsService);
           authProvider.setPasswordEncoder(getPassword());
            
           return authProvider;
       }
	       
	   @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }

	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	            http

                .csrf().disable()
	            .authorizeRequests()
//	            .antMatchers("/mapping").authenticated()   use this to require login for user for each mapping
	            
	            .antMatchers("/createteam").authenticated() 
	            .antMatchers("/addtoteam").authenticated() 
	            .antMatchers("/admin").authenticated() 
	            .antMatchers("/modifyteam").authenticated() 
	            
	                .antMatchers("/resources/**","/userdata").permitAll() 
	                   .antMatchers("/static/**").permitAll() 
	                .antMatchers("/js/**").permitAll()
	                .antMatchers("/webjars/**").permitAll()
	                   .antMatchers("/templates/**").permitAll()
	                .antMatchers("/css/**").permitAll()
	                .antMatchers("/signup/**").permitAll()
	                .anyRequest().permitAll()
	                .and()
	            .formLogin()
	            .loginPage("/login")
	                .permitAll()
	                .and()
	                .logout().logoutSuccessUrl("/").permitAll();
	        }
	    
	   
	       
	            public void addResourceHandlers(ResourceHandlerRegistry registry) {
	                registry.addResourceHandler("/resources/**")
	                  .addResourceLocations("/resources/"); 
	            }
	        
          public void configure2(WebSecurity web) throws Exception {
          web.ignoring().antMatchers("/resources/**");
          web.ignoring().antMatchers("/static/**");
          web.ignoring().antMatchers("/js/**");
          web.ignoring().antMatchers("/css/**");
          web.ignoring().antMatchers("/signup/**");
          web.ignoring().antMatchers("/userdata");
          
          }
            

}


