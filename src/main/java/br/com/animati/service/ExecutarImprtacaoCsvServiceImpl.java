package br.com.animati.service;

import br.com.animati.entity.CoberturaPlanoCsv;
import br.com.animati.entity.PlanoConvenioProcedimento;
import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Component
public class ExecutarImprtacaoCsvServiceImpl implements ExecutarImprtacaoCsvService {

    public static String STATIC_PATH_FILE_CSV = StringUtils.EMPTY;

    @Autowired
    private PlanoConvenioProcedimentoService planoConvenioProcedimentoService;

    public void processar() throws IOException {

        if (StringUtils.isBlank(STATIC_PATH_FILE_CSV)){
            System.out.println(" Não foi encontrado o path do arquivo como parametro");
            return;
        }

        if (!STATIC_PATH_FILE_CSV.substring(STATIC_PATH_FILE_CSV.lastIndexOf(".") + 1).toUpperCase().equals("CSV")) {
            System.out.println(" Arquivo Inválido: "+STATIC_PATH_FILE_CSV);
            return;
        }

        Reader in = new FileReader(STATIC_PATH_FILE_CSV);

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

            String id_plano_convenio_procedimento = record.get(0);
            json.append("'id_plano_convenio_procedimento':'" + id_plano_convenio_procedimento + "',");

            String ativo = record.get(1);
            json.append("'ativo':'" + ativo + "',");

            String autorizacao = record.get(2);
            json.append("'autorizacao':'" + autorizacao + "',");

            String codigo_terminologia = record.get(3);
            json.append("'codigo_terminologia':'" + codigo_terminologia + "',");

            String data_atualizacao = record.get(4);
            json.append("'data_atualizacao':null,");

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
            if (id_usuario.isEmpty()) {
                json.append("'id_usuario':1,");
            } else {
                json.append("'id_usuario':'" + id_usuario + "',");
            }

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

        for (PlanoConvenioProcedimento oPCP : objPL.getPlanoConvenioProcedimentos()) {
            planoConvenioProcedimentoService.save(oPCP);
        }

    }

}