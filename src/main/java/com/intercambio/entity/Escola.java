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
    

    private String identificacaoEscola;
    private String codigoPostal;
    private String estado;
    private String cidade;
    private String enderecoCompleto; 
    
  
    
    public Escola(Usuario usuario) {
        this.usuario = usuario;
        this.statusEscola = "ATIVO";
    }



	public Escola(Integer id, String nome, String descricao, String pais, String regiao, String telefone,
			String website, byte[] foto, double avalicao, Usuario usuario, String statusEscola,
			String identificacaoEscola, String codigoPostal, String estado, String cidade, String enderecoCompleto) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.pais = pais;
		this.regiao = regiao;
		this.telefone = telefone;
		this.website = website;
		this.foto = foto;
		this.avalicao = avalicao;
		this.usuario = usuario;
		this.statusEscola = statusEscola;
		this.identificacaoEscola = identificacaoEscola;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
		this.cidade = cidade;
		this.enderecoCompleto = enderecoCompleto;
	}







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



	public String getIdentificacaoEscola() {
		return identificacaoEscola;
	}



	public void setIdentificacaoEscola(String identificacaoEscola) {
		this.identificacaoEscola = identificacaoEscola;
	}



	public String getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}



	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
  
    
    
} 