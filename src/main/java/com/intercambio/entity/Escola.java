package com.intercambio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Escola")
public class Escola {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "descricao", nullable = false, length = 400)
    private String descricao;
    
    @Column(name = "pais", nullable = false, length = 50)
    private String pais;
    
    @Column(name = "regiao", nullable = false, length = 50)
    private String regiao;
    
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;
    
    @Column(name = "website", nullable = false, length = 100)
    private String website;
    
    @Column(name = "foto", columnDefinition = "VARBINARY(MAX)")
    private byte[] foto;
    
    @Column(name = "avalicao")
    private double avalicao;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @Column(name = "statusEscola", nullable = false, length = 10)
    private String statusEscola; // ATIVO ou INATIVO
    
    // Constructors
    public Escola() {}
    
    public Escola(String nome, String descricao, String pais, String regiao, String telefone, String website, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.pais = pais;
        this.regiao = regiao;
        this.telefone = telefone;
        this.website = website;
        this.usuario = usuario;
        this.statusEscola = "ATIVO";
    }
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getPais() {
        return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String getRegiao() {
        return regiao;
    }
    
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
    public byte[] getFoto() {
        return foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    public double getAvalicao() {
        return avalicao;
    }
    
    public void setAvalicao(double avalicao) {
        this.avalicao = avalicao;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getStatusEscola() {
        return statusEscola;
    }
    
    public void setStatusEscola(String statusEscola) {
        this.statusEscola = statusEscola;
    }
} 