package com.intercambio.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ProgramaIntercambio")
public class ProgramaIntercambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idioma_id", nullable = false)
    private Idioma idioma;

    @Column(nullable = false, length = 50)
    private String pais;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false)
    private Integer vagasDisponiveis;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "escola_id", nullable = false)
    private Escola escola;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Column(length = 200)
    private String acomodacao;

    @Column(length = 200)
    private String acomodacaoPreco;

    @Column(length = 200)
    private String infoEstagio;

    @Column(nullable = false, length = 20)
    private String statusPrograma = "ATIVO";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(Integer vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getAcomodacao() {
		return acomodacao;
	}

	public void setAcomodacao(String acomodacao) {
		this.acomodacao = acomodacao;
	}

	public String getAcomodacaoPreco() {
		return acomodacaoPreco;
	}

	public void setAcomodacaoPreco(String acomodacaoPreco) {
		this.acomodacaoPreco = acomodacaoPreco;
	}

	public String getInfoEstagio() {
		return infoEstagio;
	}

	public void setInfoEstagio(String infoEstagio) {
		this.infoEstagio = infoEstagio;
	}

	public String getStatusPrograma() {
		return statusPrograma;
	}

	public void setStatusPrograma(String statusPrograma) {
		this.statusPrograma = statusPrograma;
	}

}
