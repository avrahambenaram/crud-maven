/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.da.crudmaven.model;
 
import java.util.Date;
 
/**
*
* @author alunocmc
*/
public class Falecido {
 
    public Falecido() {
        super();
    }
    private int id;
    private String nome;
    private String cpf;
    private Date nascimento;
    private Date morte;
    private String nacionalidade;
    private float peso;
    private float altura;
    private String convenio;
    private String salaVelorio;
    private Boolean doacaoOrgaos;
    private Boolean cremacao;
    
    public Falecido(int id, String nome, String cpf, Date nascimento, Date morte, String nacionalidade, float peso, float altura, String convenio, String salaVelorio, Boolean doacaoOrgaos, Boolean cremacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.morte = morte;
        this.nacionalidade = nacionalidade;
        this.peso = peso;
        this.altura = altura;
        this.convenio = convenio;
        this.salaVelorio = salaVelorio;
        this.doacaoOrgaos = doacaoOrgaos;
        this.cremacao = cremacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Date getMorte() {
        return morte;
    }

    public void setMorte(Date morte) {
        this.morte = morte;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getSalaVelorio() {
        return salaVelorio;
    }

    public void setSalaVelorio(String salaVelorio) {
        this.salaVelorio = salaVelorio;
    }

    public Boolean getDoacaoOrgaos() {
        return doacaoOrgaos;
    }

    public void setDoacaoOrgaos(Boolean doacaoOrgaos) {
        this.doacaoOrgaos = doacaoOrgaos;
    }

    public Boolean getCremacao() {
        return cremacao;
    }

    public void setCremacao(Boolean cremacao) {
        this.cremacao = cremacao;
    }
    
    
}