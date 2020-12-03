package br.com.animati.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
//@Entity
public class PlanoConvenioProcedimento {

    @Id
    @GeneratedValue// (strategy = GenerationType.AUTO)
    private long id_plano_convenio_rocedimento;

    private String ativo;
    private String autorizacao;
    private String codigo_terminologia;
    private String data_atualizacao;
    private String material_obrigatorio;
    private String tabela_terminologia;
    private String termo_terminologia;
    private String utiliza_pcp_material;
    private String utiliza_terminologia_especifica;
    private String id_plano_convenio;
    private String id_procedimento;
    private String id_usuario;
    private String permitir_agendamento;

    public PlanoConvenioProcedimento(long id_plano_convenio_procedimento, String ativo) {
    }
}
