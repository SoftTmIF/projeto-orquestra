package br.iftm.edu.orquestrademo.model;

public class Projeto {

    private int id_projeto; //AUTO_INCREMENT
    private int item_task; //buscar id_task da tabela task 
    private int id_usuario; //buscar do objeto de login
    private String nome_projeto;
    
    public Projeto(int item_task, int id_usuario, String nome_projeto) {
        this.item_task = item_task;
        this.id_usuario = id_usuario;
        this.nome_projeto = nome_projeto;
    }

    public int getId_projeto() {
        return this.id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public int getItem_task() {
        return this.item_task;
    }

    public void setItem_task(int item_task) {
        this.item_task = item_task;
    }

    public int getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_projeto() {
        return this.nome_projeto;
    }

    public void setNome_projeto(String nome_projeto) {
        this.nome_projeto = nome_projeto;
    }

}
