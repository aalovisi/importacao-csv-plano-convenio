package br.com.animati.config;

import br.com.animati.service.ExecutaImprtacaoCsvServiceImpl;
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
    private ExecutaImprtacaoCsvServiceImpl executaImportacaoCsvService;

    @PostConstruct
    public void processarCsv(){
        try {
            executaImportacaoCsvService.processar("d:/procedimento_plano_convenio.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
