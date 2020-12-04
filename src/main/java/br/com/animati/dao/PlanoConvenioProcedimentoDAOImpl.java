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
                "insert into netris.plano_convenio_procedimento (id_plano_convenio_procedimento, ativo," +
                        " autorizacao, codigo_terminologia," +
                        " data_atualizacao, material_obrigatorio," +
                        " tabela_terminologia, termo_terminologia," +
                        " utiliza_pcp_material, utiliza_terminologia_especifica, id_plano_convenio," +
                        " id_procedimento, id_usuario, permitir_agendamento) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                pcp.getId_plano_convenio_procedimento(), pcp.isAtivo(),
        pcp.isAutorizacao(), pcp.getCodigo_terminologia(),
                pcp.getData_atualizacao(), pcp.isMaterial_obrigatorio(),
                pcp.getTermo_terminologia(), pcp.getTermo_terminologia(),
                pcp.isUtiliza_pcp_material(), pcp.isUtiliza_terminologia_especifica(), pcp.getId_plano_convenio(),
                pcp.getId_procedimento(), pcp.getId_usuario(), pcp.isPermitir_agendamento());
    }

    @Override
    public int update(PlanoConvenioProcedimento pcp) {
        return jdbcTemplate.update(
                "update netris.plano_convenio_procedimento set ativo = ? where id_plano_convenio_procedimento = ?",
                pcp.isAtivo(), pcp.getId_plano_convenio_procedimento());
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
                                rs.getBoolean("ativo"),
                                rs.getBoolean("autorizacao"),
                                rs.getString("codigo_terminologia"),
                                rs.getDate("data_atualizacao"),
                                rs.getBoolean("material_obrigatorio"),
                                rs.getString("tabela_terminologia"),
                                rs.getString("termo_terminologia"),
                                rs.getBoolean("utiliza_pcp_material"),
                                rs.getBoolean("utiliza_terminologia_especifica"),
                                rs.getLong("id_plano_convenio"),
                                rs.getLong("id_procedimento"),
                                rs.getLong("id_usuario"),
                                rs.getBoolean("permitir_agendamento")
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
                                rs.getBoolean("ativo"),
                                rs.getBoolean("autorizacao"),
                                rs.getString("codigo_terminologia"),
                                rs.getDate("data_atualizacao"),
                                rs.getBoolean("material_obrigatorio"),
                                rs.getString("tabela_terminologia"),
                                rs.getString("termo_terminologia"),
                                rs.getBoolean("utiliza_pcp_material"),
                                rs.getBoolean("utiliza_terminologia_especifica"),
                                rs.getLong("id_plano_convenio"),
                                rs.getLong("id_procedimento"),
                                rs.getLong("id_usuario"),
                                rs.getBoolean("permitir_agendamento")
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
