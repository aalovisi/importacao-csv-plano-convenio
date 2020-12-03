package br.com.animati.dao;

import br.com.animati.entity.PlanoConvenioProcedimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanoConvenioProcedimentoDAOImpl implements PlanoConvenioProcedimentoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(PlanoConvenioProcedimento pcp) {
        return jdbcTemplate.update(
                "insert into netris.plano_convenio_procedimento (id_plano_convenio_procedimento, ativo) values(?,?)",
                pcp.getId_plano_convenio_rocedimento(), pcp.getAtivo());
    }

    @Override
    public int update(PlanoConvenioProcedimento pcp) {
        return jdbcTemplate.update(
                "update netris.plano_convenio_procedimento set ativo = ? where id_plano_convenio_procedimento = ?",
                pcp.getAtivo(), pcp.getId_plano_convenio_rocedimento());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete netris.plano_convenio_procedimento where id_plano_convenio_procedimento = ?",
                id);
    }

    @Override
    public List<PlanoConvenioProcedimento> findAll() {
        return jdbcTemplate.query(
                "select * from netris.plano_convenio_procedimento limit 10 ",
                (rs, rowNum) ->
                        new PlanoConvenioProcedimento(
                                rs.getLong("id_plano_convenio_procedimento"),
                                rs.getString("ativo")
                        )
        );
    }

    @Override
    public List<PlanoConvenioProcedimento> findByPlanoConvenioProcedimento(long id_plano_convenio_procedimento, long id_plano_convenio, long id_procedimento) {
        return jdbcTemplate.query(
                "select * from netris.plano_convenio_procedimento where id_plano_convenio_procedimento = ? " +
                        " and id_plano_convenio = ?, id_procedimento = ?  ",
                (rs, rowNum) ->
                        new PlanoConvenioProcedimento(
                                rs.getLong("id_plano_convenio_procedimento"),
                                rs.getString("ativo")
                        )
        );
    }

    @Override
    public String findById(long id_plano_convenio_procedimento) {
        return jdbcTemplate.queryForObject(
                "select name from netris.plano_convenio_procedimento where id_plano_convenio_procedimento = ?",
                new Object[]{id_plano_convenio_procedimento},
                String.class
        );
    }
}
