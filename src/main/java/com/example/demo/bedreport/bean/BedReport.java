package com.example.demo.bedreport.bean;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "leito_ocupacao")
public class BedReport {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoSigla() {
        return estadoSigla;
    }

    public void setEstadoSigla(String estadoSigla) {
        this.estadoSigla = estadoSigla;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCnes() {
        return cnes;
    }

    public void setCnes(String cnes) {
        this.cnes = cnes;
    }

    public String getNomeCnes() {
        return nomeCnes;
    }

    public void setNomeCnes(String nomeCnes) {
        this.nomeCnes = nomeCnes;
    }

    public String getDataNotificacaoOcupacao() {
        return dataNotificacaoOcupacao;
    }

    public void setDataNotificacaoOcupacao(String dataNotificacaoOcupacao) {
        this.dataNotificacaoOcupacao = dataNotificacaoOcupacao;
    }

    public int getOfertaRespiradores() {
        return ofertaRespiradores;
    }

    public void setOfertaRespiradores(int ofertaRespiradores) {
        this.ofertaRespiradores = ofertaRespiradores;
    }

    public int getOfertaHospCli() {
        return ofertaHospCli;
    }

    public void setOfertaHospCli(int ofertaHospCli) {
        this.ofertaHospCli = ofertaHospCli;
    }

    public int getOfertaHospUti() {
        return ofertaHospUti;
    }

    public void setOfertaHospUti(int ofertaHospUti) {
        this.ofertaHospUti = ofertaHospUti;
    }

    public int getOfertaSRAGCli() {
        return ofertaSRAGCli;
    }

    public void setOfertaSRAGCli(int ofertaSRAGCli) {
        this.ofertaSRAGCli = ofertaSRAGCli;
    }

    public int getOfertaSRAGUti() {
        return ofertaSRAGUti;
    }

    public void setOfertaSRAGUti(int ofertaSRAGUti) {
        this.ofertaSRAGUti = ofertaSRAGUti;
    }

    public int getOcupHospCli() {
        return ocupHospCli;
    }

    public void setOcupHospCli(int ocupHospCli) {
        this.ocupHospCli = ocupHospCli;
    }

    public int getOcupHospUti() {
        return ocupHospUti;
    }

    public void setOcupHospUti(int ocupHospUti) {
        this.ocupHospUti = ocupHospUti;
    }

    public int getOcupSRAGCli() {
        return ocupSRAGCli;
    }

    public void setOcupSRAGCli(int ocupSRAGCli) {
        this.ocupSRAGCli = ocupSRAGCli;
    }

    public int getOcupSRAGUti() {
        return ocupSRAGUti;
    }

    public void setOcupSRAGUti(int ocupSRAGUti) {
        this.ocupSRAGUti = ocupSRAGUti;
    }

    public int getAltas() {
        return altas;
    }

    public void setAltas(int altas) {
        this.altas = altas;
    }

    public int getObitos() {
        return obitos;
    }

    public void setObitos(int obitos) {
        this.obitos = obitos;
    }

    public boolean isOcupacaoInformada() {
        return ocupacaoInformada;
    }

    public void setOcupacaoInformada(boolean ocupacaoInformada) {
        this.ocupacaoInformada = ocupacaoInformada;
    }

    public boolean isAlgumaOcupacaoInformada() {
        return algumaOcupacaoInformada;
    }

    public void setAlgumaOcupacaoInformada(boolean algumaOcupacaoInformada) {
        this.algumaOcupacaoInformada = algumaOcupacaoInformada;
    }
}
