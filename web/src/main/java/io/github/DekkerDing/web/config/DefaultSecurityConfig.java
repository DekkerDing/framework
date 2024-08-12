package io.github.DekkerDing.web.config;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class DefaultSecurityConfig {

    //@formatter:off
    @Bean
    SecurityWebFilterChain defaultSecurityFilterChain(ServerHttpSecurity http) throws Exception {

//        http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
//            .oidc(Customizer.withDefaults());    // Enable OpenID Connect 1.0

//        http
//            // Redirect to the login page when not authenticated from the
//            // authorization endpoint
//            .exceptionHandling((exceptions) -> exceptions
//                .authenticationEntryPoint(
//                    new LoginUrlAuthenticationEntryPoint("/login"))
//            )
//            // Accept access tokens for User Info and/or Client Registration
//            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        http.authorizeExchange(authorize->{
            authorize.matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
        });

        http.csrf(csrf -> {
            csrf.disable();
        });

        http
            .authorizeExchange((authorize) -> authorize
                .anyExchange().authenticated()
            )
            // Form login handles the redirect to the login page from the
            // authorization server filter chain
            .formLogin(Customizer.withDefaults());

        http
                .authorizeExchange(authorizeRequests -> authorizeRequests
                        .pathMatchers("/password/*").permitAll()
                        .anyExchange().authenticated()
                )
                .formLogin(Customizer.withDefaults());

//        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);

        return http.build();
    }


    // @formatter:off
    @Bean
    UserDetailsService users() {
        UserDetails user = User.builder()
                .username("lengleng")
                .password("{noop}123456")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
