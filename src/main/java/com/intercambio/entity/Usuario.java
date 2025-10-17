package com.intercambio.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "Usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "senha", nullable = false, length = 100)
    private String senha;
    
    @Column(name = "nivelAcesso", length = 10)
    private String nivelAcesso; // ADMIN, INTERCAMBISTA, ESCOLA, SENHORIO
    
    @Column(name = "foto", columnDefinition = "VARBINARY(MAX)")
    private byte[] foto;
    
    @Column(name = "dataCadastro", nullable = false)
    private LocalDateTime dataCadastro;
    
    @Column(name = "statusUsuario", nullable = false, length = 20)
    private String statusUsuario; // ATIVO, INATIVO, TROCAR_SENHA
    
    // Constructors
    public Usuario() {}
    
    public Usuario(String nome, String email, String senha, String nivelAcesso) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.dataCadastro = LocalDateTime.now();
        this.statusUsuario = "ATIVO";
    }
    
    
    @Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", nivelAcesso="
				+ nivelAcesso + ", foto=" + Arrays.toString(foto) + ", dataCadastro=" + dataCadastro
				+ ", statusUsuario=" + statusUsuario + "]";
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNivelAcesso() {
        return nivelAcesso;
    }
    
    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
    public byte[] getFoto() {
        return foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public String getStatusUsuario() {
        return statusUsuario;
    }
    
    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }
} 