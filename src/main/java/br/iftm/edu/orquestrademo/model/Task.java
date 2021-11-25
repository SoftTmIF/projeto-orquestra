package br.iftm.edu.orquestrademo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Task {
    private Integer id; //AUTO_INCREMENT
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date dataExecucao;
    private Double totalHoras; //transformar a entrada do usuário de horas para minutos para inserir no banco
    private String tipoNatureza; //criar enum
    private String descricao;
    private Integer idUsuario; //buscar do objeto de login
    private Integer idProjeto;

    public Task() {
    }

    public Task(Integer id, Date dataExecucao, Double totalHoras, String tipoNatureza, String descricao, Integer idUsuario, Integer idProjeto) {
        this.id = id;
        this.dataExecucao = dataExecucao;
        this.totalHoras = totalHoras;
        this.tipoNatureza = tipoNatureza;
        this.descricao = descricao;
        this.idUsuario = idUsuario;
        this.idProjeto = idProjeto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Double getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(Double totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getTipoNatureza() {
        return tipoNatureza;
    }

    public void setTipoNatureza(String tipoNatureza) {
        this.tipoNatureza = tipoNatureza;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }
}
