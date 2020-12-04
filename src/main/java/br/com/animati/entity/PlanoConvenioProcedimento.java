package br.com.animati.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
//@Entity
public class PlanoConvenioProcedimento {

    @Id
    @GeneratedValue// (strategy = GenerationType.AUTO)
    private long id_plano_convenio_procedimento;

    private boolean ativo;
    private boolean autorizacao;
    private String codigo_terminologia;
    private Date data_atualizacao;
    private boolean material_obrigatorio;
    private String tabela_terminologia;
    private String termo_terminologia;
    private boolean utiliza_pcp_material;
    private boolean utiliza_terminologia_especifica;
    private long id_plano_convenio;
    private long id_procedimento;
    private long id_usuario;
    private boolean permitir_agendamento;

    public PlanoConvenioProcedimento(long id_plano_convenio_procedimento,
                                     boolean ativo,
                                     boolean autorizacao,
                                     String codigo_terminologia,
                                     Date data_atualizacao,
                                     boolean material_obrigatorio,
                                     String tabela_terminologia,
                                     String termo_terminologia,
                                     boolean utiliza_pcp_material,
                                     boolean utiliza_terminologia_especifica,
                                     long id_plano_convenio,
                                     long id_procedimento,
                                     long id_usuario,
                                     boolean permitir_agendamento) {

        this.setId_plano_convenio_procedimento(id_plano_convenio_procedimento);
        this.setAtivo(ativo);
        this.setAutorizacao(autorizacao);
        this.setCodigo_terminologia(codigo_terminologia);
        this.setData_atualizacao(data_atualizacao);
        this.setMaterial_obrigatorio(material_obrigatorio);
        this.setTabela_terminologia(tabela_terminologia);
        this.setTermo_terminologia(termo_terminologia);
        this.setUtiliza_pcp_material(utiliza_pcp_material);
        this.setUtiliza_terminologia_especifica(utiliza_terminologia_especifica);
        this.setId_plano_convenio(id_plano_convenio);
        this.setId_procedimento(id_procedimento);
        this.setId_usuario(id_usuario);
        this.setPermitir_agendamento(permitir_agendamento);

    }
}
