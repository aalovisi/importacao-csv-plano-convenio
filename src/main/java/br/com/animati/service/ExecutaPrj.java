package br.com.animati.service;

import br.com.animati.dao.PlanoConvenioProcedimentoDAOImpl;
import br.com.animati.dao.PlanoConvenioProcedimentoDAO;
import br.com.animati.entity.CoberturaPlanoCsv;
import br.com.animati.entity.PlanoConvenioProcedimento;
import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ExecutaPrj {

    public static void Executa(String sArqPatch) throws IOException {

        if (!sArqPatch.substring(sArqPatch.lastIndexOf(".") + 1).toUpperCase().equals("CSV")) {
            JOptionPane.showMessageDialog(null, "Arquivo Inválido: " + sArqPatch);
            return;
        }

        Reader in = new FileReader(sArqPatch);

        Iterable<CSVRecord> records = CSVFormat.EXCEL.withDelimiter(';').parse(in);

        Boolean bHead = true;

        StringBuilder json = new StringBuilder();

        json.append("{ planoConvenioProcedimentos : [");

        for (CSVRecord record : records) {

            if (bHead) {
                bHead = false;
                continue;
            }

            json.append("{");

            String ativo = record.get(1);
            json.append("'ativo':'" + ativo + "',");

            String autorizacao = record.get(2);
            json.append("'autorizacao':'" + autorizacao + "',");

            String codigo_terminologia = record.get(3);
            json.append("'codigo_terminologia':'" + codigo_terminologia + "',");

            String data_atualizacao = record.get(4);
            json.append("'data_atualizacao':'" + data_atualizacao + "',");

            String material_obrigatorio = record.get(5);
            json.append("'material_obrigatorio':'" + material_obrigatorio + "',");

            String tabela_terminologia = record.get(6);
            json.append("'tabela_terminologia':'" + tabela_terminologia + "',");

            String termo_terminologia = record.get(7);
            json.append("'termo_terminologia':'" + termo_terminologia + "',");

            String utiliza_pcp_material = record.get(8);
            json.append("'utiliza_pcp_material':'" + utiliza_pcp_material + "',");

            String utiliza_terminologia_especifica = record.get(9);
            json.append("'utiliza_terminologia_especifica':'" + utiliza_terminologia_especifica + "',");

            String id_plano_convenio = record.get(10);
            json.append("'id_plano_convenio':'" + id_plano_convenio + "',");

            String id_procedimento = record.get(11);
            json.append("'id_procedimento':'" + id_procedimento + "',");

            String id_usuario = record.get(12);
            json.append("'id_usuario':'" + id_usuario + "',");

            String permitir_agendamento = record.get(13);
            json.append("'permitir_agendamento':'" + permitir_agendamento + "'");

            json.append("},");

        }
        String strJson = json.toString();

        strJson = strJson.substring(0, json.length() - 1);
        strJson = strJson + "]}";

        System.out.println(strJson);

        Gson gson = new Gson();
        CoberturaPlanoCsv objPL = gson.fromJson(strJson, CoberturaPlanoCsv.class);


        for (PlanoConvenioProcedimento lPlanoConv : objPL.getPlanoConvenioProcedimentos()){

        }

        PlanoConvenioProcedimentoDAO ps = new PlanoConvenioProcedimentoDAOImpl();

         ps.findAll();


    }

}