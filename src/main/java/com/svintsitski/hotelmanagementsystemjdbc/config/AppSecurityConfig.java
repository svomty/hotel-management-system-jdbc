package com.svintsitski.hotelmanagementsystemjdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Аннотация @EnableWebSecurity в связке с WebSecurityConfigurerAdapter классом работает над обеспечением
     * аутентификации. По умолчанию в Spring Security встроены и активны HTTP аутентификация и аутентификация на базе
     * веб форм.
     * @author Артем Свинтицкий
     */

    @Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("user").roles("USER").build());
        manager.createUser(users.username("admin").password("admin").roles("USER", "ADMIN").build());
        manager.createUser(users.username("superadmin").password("superadmin").roles("SUPERADMIN", "ADMIN", "USER").build());
        return manager;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')")
                .and().formLogin().defaultSuccessUrl("/", false);

    }

    /**
     * здесь прописываем пользователей с их ролями, а затем указываем адреса ресурсов с ограниченным доступом,
     * ограничение задано по ролям. Имена и пароли пользователей, для простоты, указаны прямо в коде. Spring Security
     * позволяет с легкостью указать другой источник для данных о пользователях, например базу данных. Обратите внимание
     * что роли в месте где мы присваиваем их пользователю пишутся без префикса ROLE_, в то время как в указании в
     * методе access, в котором мы, с помощью языка выражений SPEL (Spring Expression Language), задаем выражения
     * проверки ресурса (в нашем случае выражение проверки роли пользователя hasRole(‘ROLE_имя роли’)), мы пишем роль
     * с префиксом ROLE_. Еще одна маленькая хитрость для аутентификации: defaultSuccessUrl("/", false), установка
     * второго параметра (alwaysUse) в false говорит Spring Security что в случае успешной авторизации можно
     * перенаправить пользователя на ту страничку, с которой он пришел на страницу аутентификации.
     */
}