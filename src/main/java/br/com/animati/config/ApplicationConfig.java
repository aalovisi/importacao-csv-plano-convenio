package br.com.animati.config;

import br.com.animati.service.ExecutarImprtacaoCsvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.io.IOException;

@EnableAutoConfiguration
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = {
        "br.com.animati.dao",
        "br.com.animati.service"
})
public class ApplicationConfig {

    @Autowired
    private ExecutarImprtacaoCsvServiceImpl executaImportacaoCsvService;

    @PostConstruct
    public void processarCsv(){
        try {
            executaImportacaoCsvService.processar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
