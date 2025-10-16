package com.intercambio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {
    
    private Integer id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    private String nome;
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    private String email;
    
    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    private String senha;
    
    private String nivelAcesso;
    private String statusUsuario;
    
    // Constructors
    public UsuarioDTO() {}
    
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
    
    public String getStatusUsuario() {
        return statusUsuario;
    }
    
    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

	@Override
	public String toString() {
		return "UsuarioDTO [nome=" + nome + ", email=" + email + ", senha=" + senha + ", nivelAcesso="
				+ nivelAcesso + ", statusUsuario=" + statusUsuario + "]";
	}
    
    
} 