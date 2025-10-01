package com.intercambio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Estudante")
public class Estudante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @Column(name = "dataNascimento", length = 10)
    private String dataNascimento;
    
    @Column(name = "cpf", length = 14)
    private String cpf;
    
    @Column(name = "rg", length = 12)
    private String rg;
    
    @Column(name = "telefone", length = 20)
    private String telefone;
    
    @Column(name = "endereco", length = 200)
    private String endereco;
    
    @Column(name = "cidade", length = 100)
    private String cidade;
    
    @Column(name = "estado", length = 2)
    private String estado;
    
    @Column(name = "cep", length = 9)
    private String cep;
    
    @Column(name = "statusEstudante", length = 10)
    private String statusEstudante; // ATIVO ou INATIVO
    
    // Constructors
    public Estudante() {}
    
    public Estudante(Usuario usuario) {
        this.usuario = usuario;
        this.statusEstudante = "ATIVO";
    }
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getRg() {
        return rg;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getStatusEstudante() {
        return statusEstudante;
    }
    
    public void setStatusEstudante(String statusEstudante) {
        this.statusEstudante = statusEstudante;
    }
} 