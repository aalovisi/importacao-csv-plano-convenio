package br.com.animati.importacao;

import br.com.animati.entity.PlanoConvenioProcedimento;
import br.com.animati.service.PlanoConvenioProcedimentoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ImportacaoCsvPlanoConvenioApplicationTests {

	@Autowired
	private PlanoConvenioProcedimentoService planoConvenioProcedimentoService;

	@Test
	void findAllPlanoConvenioProcedimento() {
		List<PlanoConvenioProcedimento> planoConvenioProcedimentos = planoConvenioProcedimentoService.findAll();
		Assertions.assertTrue(!planoConvenioProcedimentos.isEmpty());
	}

}
