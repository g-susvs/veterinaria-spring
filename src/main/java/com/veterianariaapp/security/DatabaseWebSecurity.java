package com.veterianariaapp.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {

    @Bean
    public UserDetailsManager usersCustom(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select username, password, estatus from Usuarios where username=?");
        users.setAuthoritiesByUsernameQuery("select u.username, p.perfil from usuario_perfil up " +
                "inner join Usuarios u on u.id = up.id_usuario " +
                "inner join Perfiles p on p.id = up.id_perfil " + "where u.username = ?");
        return users;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // ===== permitir acceso al api ====
        http.csrf().disable();
        http.authorizeHttpRequests()

                // Los recursos estáticos no requieren autenticación
                .requestMatchers("/bootstrap/**", "/imgs/**", "/tinymce/**",
                        "/logos/**")
                .permitAll()

                // Las vistas públicas no requieren autenticación
                .requestMatchers("/", "/login", "/signup", "/search", "/bcrypt/**", "/about", "/vacantes/view/**")
                .permitAll()
                .requestMatchers("/api/veterinaria/actualizarimg/**", "/cloudinary").permitAll()

                // Asignar permisos a URLs por ROLES
                .requestMatchers("/form", "formimg/**").hasAnyAuthority("SUPERVISOR", "ADMINISTRADOR")

                // Todas las demás URLs de la Aplicación requieren autenticación
                .anyRequest().authenticated()

                // El formulario de Login no requiere autenticacion
                .and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();

        return http.build();
    }

    /**
     * Implementación de Spring Security que encripta passwords con el algoritmo
     * Bcrypt
     * 
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
