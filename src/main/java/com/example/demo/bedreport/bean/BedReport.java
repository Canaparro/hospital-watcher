package com.example.demo.bedreport.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Document(indexName = "leito_ocupacao")
@Data
public class BedReport {

    @Id
    private String id;
    private String estado;
    private String estadoSigla;
    private String municipio;
    private String cnes;
    private String nomeCnes;
    private String dataNotificacaoOcupacao;
    private int ofertaRespiradores;
    private int ofertaHospCli;
    private int ofertaHospUti;
    private int ofertaSRAGCli;
    private int ofertaSRAGUti;
    private int ocupHospCli;
    private int ocupHospUti;
    private int ocupSRAGCli;
    private int ocupSRAGUti;
    private int altas;
    private int obitos;
    private boolean ocupacaoInformada;
    private boolean algumaOcupacaoInformada;

}
