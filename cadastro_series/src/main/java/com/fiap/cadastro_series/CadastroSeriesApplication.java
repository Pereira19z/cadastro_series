package com.fiap.cadastro_series;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.cadastro_series")  // Explicitamente escaneia o pacote base
public class CadastroSeriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadastroSeriesApplication.class, args);
    }
}
