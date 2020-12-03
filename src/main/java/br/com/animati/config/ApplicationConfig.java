package br.com.animati.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "br.com.animati.dao",
        "br.com.animati.service"
})

public class ApplicationConfig {


}
