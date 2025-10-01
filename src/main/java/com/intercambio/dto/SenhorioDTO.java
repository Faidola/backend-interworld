package com.intercambio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SenhorioDTO {
    
    private Integer id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    private String nome;
    
    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 400, message = "Descrição deve ter no máximo 400 caracteres")
    private String descricao;
    
    @NotBlank(message = "País é obrigatório")
    @Size(max = 50, message = "País deve ter no máximo 50 caracteres")
    private String pais;
    
    @NotBlank(message = "Local é obrigatório")
    @Size(max = 100, message = "Local deve ter no máximo 100 caracteres")
    private String localSenhorio;
    
    @NotBlank(message = "Telefone é obrigatório")
    @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres")
    private String telefone;
    
    private Integer usuarioId;
    private String statusSenhorio;
    
    // Constructors
    public SenhorioDTO() {}
    
    public SenhorioDTO(String nome, String descricao, String pais, String localSenhorio, String telefone) {
        this.nome = nome;
        this.descricao = descricao;
        this.pais = pais;
        this.localSenhorio = localSenhorio;
        this.telefone = telefone;
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
    
    public Integer getUsuarioId() {
        return usuarioId;
    }
    
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public String getStatusSenhorio() {
        return statusSenhorio;
    }
    
    public void setStatusSenhorio(String statusSenhorio) {
        this.statusSenhorio = statusSenhorio;
    }
} 