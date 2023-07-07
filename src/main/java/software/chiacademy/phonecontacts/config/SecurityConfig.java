//package software.chiacademy.phonecontacts.config;
//
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authConfiguration
//    ) throws Exception {
//        return authConfiguration.getAuthenticationManager();
//    }
//
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) ->
//                        //authorize.anyRequest().authenticated()
//                        authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//                                .requestMatchers("/api/auth/**").permitAll()
//                                .anyRequest().authenticated()
//                );
//
//        return http.build();
//    }
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests((authorize) ->
//////                        //authorize.anyRequest().authenticated()
////                        authorize.requestMatchers(HttpMethod.GET,"/contacts").hasAnyAuthority("USER")
////                .requestMatchers("/new").hasAnyAuthority("USER")
////                .requestMatchers("/edit/**").hasAnyAuthority("USER")
////                .requestMatchers("/delete/**").hasAuthority("USER")
////                .anyRequest().authenticated()
////                                .
////                .and()
////                .formLogin().permitAll()
////                .and()
////                .logout().permitAll()
////                .and()
////                .exceptionHandling().accessDeniedPage("/403");
////
////        return http.build();
////    }
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.authorizeHttpRequests(request ->
////                request.requestMatchers("/login").permitAll()
////                        .requestMatchers(HttpMethod.GET,"/auth/**").permitAll()
////                        .anyRequest().authenticated())
////                .csrf().disable()
////                .formLogin(form -> form
////                        .loginPage("/login")
////                        .loginProcessingUrl("/login")
////                        .failureUrl("/login?error")
////                        .usernameParameter("name")
////                        .passwordParameter("password")
////                        .defaultSuccessUrl("/"));
////        return http.build();
////    }
//}
