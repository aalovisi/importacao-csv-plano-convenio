package br.com.animati.service;

import br.com.animati.entity.PlanoConvenioProcedimento;

import java.util.List;

public interface PlanoConvenioProcedimentoService {

    int save(PlanoConvenioProcedimento pcp);

    int update(PlanoConvenioProcedimento pcp);

    int deleteById(Long id);

    List<PlanoConvenioProcedimento> findAll();

    List<PlanoConvenioProcedimento> findByPlanoConvenioProcedimento(long id_plano_convenio_procedimento, long id_plano_convenio, long id_procedimento);

    String findById(long id_plano_convenio_procedimento);

}
