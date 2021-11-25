package br.iftm.edu.orquestrademo.model;

public class Usuario {
    private Integer id_usuario;
    private String senha;
    private String nome_usuario;

    public Usuario() {
    }

    public Usuario(String nome_usuario, String senha) {
        id_usuario++;
        this.senha = senha;
        this.nome_usuario = nome_usuario;
    }

    public Integer getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome_usuario() {
        return this.nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

}
