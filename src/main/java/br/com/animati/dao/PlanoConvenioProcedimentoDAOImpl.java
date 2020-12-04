package br.com.animati.dao;

import br.com.animati.entity.PlanoConvenioProcedimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PlanoConvenioProcedimentoDAOImpl implements PlanoConvenioProcedimentoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(PlanoConvenioProcedimento pcp) {

        String sql = "insert into netris.plano_convenio_procedimento (id_plano_convenio_procedimento, ativo," +
                " autorizacao, codigo_terminologia," +
                " data_atualizacao, material_obrigatorio," +
                " tabela_terminologia, termo_terminologia," +
                " utiliza_pcp_material, utiliza_terminologia_especifica, id_plano_convenio," +
                " id_procedimento, id_usuario, permitir_agendamento) values (nextval('netris.plano_convenio_procedimento_sequence'),?,?,?,?,?,?,?,?,?,?,?,?,?)";


        List<Object[]> parametros = new ArrayList<>();
        Object[] parametro = new Object[13];
        parametro[0] = pcp.isAtivo();
        parametro[1] = pcp.isAutorizacao();
        parametro[2] = pcp.getCodigo_terminologia();
        parametro[3] = pcp.getData_atualizacao();
        parametro[4] = pcp.isMaterial_obrigatorio();
        parametro[5] = pcp.getTermo_terminologia();
        parametro[6] = pcp.getTermo_terminologia();
        parametro[7] = pcp.isUtiliza_pcp_material();
        parametro[8] = pcp.isUtiliza_terminologia_especifica();
        parametro[9] = pcp.getId_plano_convenio();
        parametro[10] = pcp.getId_procedimento();
        parametro[11] = pcp.getId_usuario();
        parametro[12] = pcp.isPermitir_agendamento();
        parametros.add(parametro);
        jdbcTemplate.batchUpdate(sql, parametros);
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
