package br.com.oficina.infra.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val customAuthenticationSuccessHandler: CustomAuthenticationSuccessHandler,
    private val filter: SecurityFilter
) {

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http.authorizeHttpRequests {
            it.requestMatchers("/", "/servicos", "/login", "/logout", "/usuario/cadastro", "/error")
                .permitAll()
                .anyRequest()
                .authenticated()
        }
            .formLogin {
                it.loginPage("/login")
                    .usernameParameter("email")
                    .passwordParameter("senha")
                    .successHandler(customAuthenticationSuccessHandler)
                    .failureUrl("/login?loginError=true")
            }
            .logout {
                it.logoutRequestMatcher(AntPathRequestMatcher("/logout", "GET"))
                    .logoutSuccessUrl("/login?logoutSuccess=true")
                    .deleteCookies("usuario_id")
                    .invalidateHttpSession(true)
            }
            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.ignoring()
                .requestMatchers("/css/**", "/js/**", "/fonts/**", "/images/**", "/*.png", "/*.ico", "/*.jpg", "/error")
        }
    }

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(configuration: AuthenticationConfiguration): AuthenticationManager {
        return configuration.authenticationManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}