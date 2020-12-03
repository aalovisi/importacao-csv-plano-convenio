package br.com.animati;

import br.com.animati.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ImportacaoCsvPlanoConvenioApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApplicationConfig.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}

//	public static void main(String[] args) {
//		SpringApplication.run(ImportacaoCsvPlanoConvenioApplication.class, args);
//
//		try {
//			ExecutaPrj.Executa("d:/procedimento_plano_convenio.csv");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
