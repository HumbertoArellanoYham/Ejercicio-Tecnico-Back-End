package com.pruebatecnica.formularioarticulos.configurationscomponent;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSettings {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods(HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.DELETE.name(),
                                HttpMethod.PUT.name())
                        .allowedHeaders(HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.AUTHORIZATION, "*")
                        .allowCredentials(true);
            }
        };
    }
}
