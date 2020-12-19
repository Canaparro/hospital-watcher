package com.example.demo.bedreport.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Document(indexName = "leito_ocupacao")
@Data
public class BedReport {

    public static final String STATE = "estado";
    public static final String CITY = "municipio";
    public static final String HOSPITAL = "nomeCnes";
    public static final String LAST_MODIFICATION_DATE = "dataNotificacaoOcupacao";

    @Id
    private String id;

    @Field(STATE)
    private String state;

    @Field("estadoSigla")
    private String stateAcronym;

    @Field(CITY)
    private String city;

    @Field("cnes")
    private String hospitalNationalId;

    @Field(HOSPITAL)
    private String hospitalName;

    @Field(value = LAST_MODIFICATION_DATE, type = FieldType.Date, format = DateFormat.date_time)
    private LocalDateTime lastModificationDate;

    @Field("ofertaRespiradores")
    private int respirators;

    @Field("ofertaHospCli")
    private int clinicalBeds;

    @Field("ofertaHospUti")
    private int icuBeds;

    @Field("ofertaSRAGCli")
    private int clinicalSARSBeds;

    @Field("ofertaSRAGUti")
    private int icuSARSBeds;

    @Field("ocupHospCli")
    private int occupiedClinicalBeds;

    @Field("ocupHospUti")
    private int occupiedIcuBeds;

    @Field("ocupSRAGCli")
    private int occupiedClinicalSARSBeds;

    @Field("ocupSRAGUti")
    private int occupiedIcuSARSBeds;

    @Field("altas")
    private int discharges;

    @Field("obitos")
    private int deaths;

}
