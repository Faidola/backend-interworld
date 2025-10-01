package com.intercambio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Senhorio")
public class Senhorio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "descricao", nullable = false, length = 400)
    private String descricao;
    
    @Column(name = "pais", nullable = false, length = 50)
    private String pais;
    
    @Column(name = "localSenhorio", nullable = false, length = 100)
    private String localSenhorio;
    
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;
    
    @Column(name = "foto", columnDefinition = "VARBINARY(MAX)")
    private byte[] foto;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @Column(name = "statusSenhorio", nullable = false, length = 10)
    private String statusSenhorio; // ATIVO ou INATIVO
    
    // Constructors
    public Senhorio() {}
    
    public Senhorio(String nome, String descricao, String pais, String localSenhorio, String telefone, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.pais = pais;
        this.localSenhorio = localSenhorio;
        this.telefone = telefone;
        this.usuario = usuario;
        this.statusSenhorio = "ATIVO";
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
    
    public String getLocalSenhorio() {
        return localSenhorio;
    }
    
    public void setLocalSenhorio(String localSenhorio) {
        this.localSenhorio = localSenhorio;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public byte[] getFoto() {
        return foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getStatusSenhorio() {
        return statusSenhorio;
    }
    
    public void setStatusSenhorio(String statusSenhorio) {
        this.statusSenhorio = statusSenhorio;
    }
} 