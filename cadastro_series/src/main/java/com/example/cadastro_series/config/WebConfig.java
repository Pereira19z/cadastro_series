package com.example.cadastro_series.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS para todos os endpoints
                .allowedOrigins("*") // Permite requisições de qualquer origem (substituir por origens específicas em produção)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .exposedHeaders("Authorization", "Link") // Cabeçalhos que serão expostos
                .allowCredentials(false); // Defina como `true` se usar cookies/sessões em CORS
    }
}
