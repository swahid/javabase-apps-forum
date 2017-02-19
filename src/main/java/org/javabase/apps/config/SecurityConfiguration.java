/**
 * 
 */
package org.javabase.apps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
        @Autowired
        UserDetailsService userDetailsService;
        
        @Autowired
        public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }
         
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            
            http.authorizeRequests()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/thread/view/**").permitAll()
            .antMatchers("/thread/create/**").authenticated()
            .antMatchers("/**").permitAll()
            .and().formLogin().loginPage("/login")
            .usernameParameter("username").passwordParameter("password")
            .failureUrl("/login?error=true")
            .and().csrf() //csrf enable so you need to send csrf parameter
            .and().logout().logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .and().exceptionHandling().accessDeniedPage("/404");
        }
        
        
}
