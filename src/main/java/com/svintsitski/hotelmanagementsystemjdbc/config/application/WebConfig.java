package com.svintsitski.hotelmanagementsystemjdbc.config.application;

import com.svintsitski.hotelmanagementsystemjdbc.config.AppSecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration //конфигурационный класс
@EnableWebMvc
@ComponentScan({"com.svintsitski.hotelmanagementsystemjdbc.config",
        "com.svintsitski.hotelmanagementsystemjdbc.controller"})
//указываем фреймворку Spring, что компоненты надо искать внутри пакетов ...
@Import({AppSecurityConfig.class})//Импортируем класс с настройками безопасности
//мб автоматически найден (без импорта)
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");//Указываем что вьюшки будут лежать в директории
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }
}
