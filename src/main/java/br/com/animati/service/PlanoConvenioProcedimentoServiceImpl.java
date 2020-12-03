package br.com.animati.service;

import br.com.animati.dao.PlanoConvenioProcedimentoDAO;
import br.com.animati.entity.PlanoConvenioProcedimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoConvenioProcedimentoServiceImpl implements PlanoConvenioProcedimentoService{

    @Autowired
    private PlanoConvenioProcedimentoDAO planoConvenioProcedimentoDAO;

    @Override
    public int save(PlanoConvenioProcedimento pcp) {
        return planoConvenioProcedimentoDAO.save(pcp);
    }

    @Override
    public int update(PlanoConvenioProcedimento pcp) {
        return planoConvenioProcedimentoDAO.update(pcp);
    }

    @Override
    public int deleteById(Long id) {
        return planoConvenioProcedimentoDAO.deleteById(id);
    }

    @Override
    public List<PlanoConvenioProcedimento> findAll() {
        return planoConvenioProcedimentoDAO.findAll();
    }

    @Override
    public List<PlanoConvenioProcedimento> findByPlanoConvenioProcedimento(long id_plano_convenio_procedimento, long id_plano_convenio, long id_procedimento) {
        return planoConvenioProcedimentoDAO.findByPlanoConvenioProcedimento(id_plano_convenio_procedimento, id_plano_convenio, id_procedimento);
    }

    @Override
    public String findById(long id_plano_convenio_procedimento) {
        return planoConvenioProcedimentoDAO.findById(id_plano_convenio_procedimento);
    }
}
