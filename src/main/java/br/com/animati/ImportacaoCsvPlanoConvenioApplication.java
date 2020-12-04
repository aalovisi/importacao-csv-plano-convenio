package br.com.animati;

import br.com.animati.config.ApplicationConfig;
import br.com.animati.service.ExecutarImprtacaoCsvServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Arrays;

@SpringBootApplication
public class ImportacaoCsvPlanoConvenioApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApplicationConfig.class);
	}

	public static void main(String[] args) {
		try {
			if(!Arrays.asList(args).isEmpty()){
				ExecutarImprtacaoCsvServiceImpl.STATIC_PATH_FILE_CSV = args[0];
				SpringApplication.run(ApplicationConfig.class, args);
			} else {
				throw new Exception("Obrigatóio informar o path do arquivo csv.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
