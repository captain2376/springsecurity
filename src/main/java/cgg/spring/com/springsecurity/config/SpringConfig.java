package cgg.spring.com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringConfig {
    
    /* Form Based in memory authorization
    @Bean
    UserDetailsService userDetailsService(){
        
        UserDetails adminUser = User.withUsername("Sindhu").password("1234").roles("ADMIN").build();
        UserDetails noramlUser = User.withUsername("abc").password("abc").roles("NORMAL").build();
    
        return new InMemoryUserDetailsManager(adminUser,noramlUser);
    }

    @Bean
    PasswordEncoder  passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }--using no password encoder*/

    //now HTTP BASED -- Basis Auth -- we get js alert instead of form which will prompt us to enter credentials

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(authz->authz.anyRequest().authenticated()).httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        
        UserDetails adminUser = User.withUsername("Sindhu").password(this.passwordEncoder().encode("1234")).roles("ADMIN").build();
        UserDetails noramlUser = User.withUsername("abc").password(this.passwordEncoder().encode("abc")).roles("NORMAL").build();
    
        return new InMemoryUserDetailsManager(adminUser,noramlUser);
    }

    @Bean
    PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
