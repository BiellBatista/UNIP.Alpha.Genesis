/* %W% %E% Gabriel Batista
 *
 * Copyright (c) 2000-2012 Razão Social Ltda. Todos os direitos reservados.
 *
 * Esse software é informação confidencial e proprietária da Razão
 * Social Ltda. ("Informação Confidencial"). Você não deve divulgar
 * tal Informação Confidencial e deve usá-la apenas em concordância
 * com os termos de acordo de licença que você entrou com a Laranja Games Ltda.
 *
 * 
 * LARANJA GAMES LTDA NÃO FAZ REPRESENTAÇÃO OU DÁ GARANTIAS SOBRE A
 * ADEQUAÇÃO DO SOFTWARE, SEJA EXPRESSA OU IMPLICADA, INCLUINDO MAS
 * NÃO LIMITANDO AS GARANTIAS DE COMERCIALIZAÇÃO, ADEQUAÇÃO PARA UM
 * DETERMINADO FIM PARTICULAR OU NÃO-VIOLAÇÃO. LARANJA GAMES LTDA NÃO
 * SERÁ RESPONSÁVEL POR QUALQUER DANO SOFRIDO PELO LICENCIADO EM
 * DECORRÊNCIA DO USO, MODIFICAÇÃO OU DISTRIBUIÇÃO DESSE SOFTWARE OU
 * SEUS DERIVADOS.
 */

package br.com.unip.cc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que representa a tabela jogadores do banco
 * 
 * @version 0.1 16/Out/2016
 * @author Gabriel Batista
 */

@Entity //indica para o Hibernate que a classe Jogadores deve ser armazenada em uma tablea
@Table(name = "jogadores") //Passa o nome da tabela para o Hibernate configurar

public class Jogadores {
	
	@Id //Configura um atributo como sendo a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INC_JOG") //definição de como será tratada a PK
	@SequenceGenerator(name = "INC_JOG", sequenceName = "INC_JOG", allocationSize = 1, initialValue = 0)
	@Column(name = "jog_codigo", nullable = false)
	private int jog_codigo;
	
	@Column(name = "jog_nome", length = 30, nullable = false) //Indica uma coluna de tamanho 30 e não nulas
	private String jog_nome;
	
	@Column(name = "jog_apelido", length = 04, nullable = false)
	private String jog_apelido;
	
	@Temporal(TemporalType.DATE) //Indica um dado do tipo data
	@Column(name = "jog_dt_criacao", nullable = false)
	private Date jog_dt_criacao;
	
	public Jogadores() {
	}

	public int getJog_codigo() {
		return jog_codigo;
	}

	public void setJog_codigo(int jog_codigo) {
		this.jog_codigo = jog_codigo;
	}

	public String getJog_nome() {
		return jog_nome;
	}

	public void setJog_nome(String jog_nome) {
		this.jog_nome = jog_nome;
	}

	public String getJog_apelido() {
		return jog_apelido;
	}

	public void setJog_apelido(String jog_apelido) {
		this.jog_apelido = jog_apelido;
	}

	public Date getJog_dt_criacao() {
		return jog_dt_criacao;
	}

	public void setJog_dt_criacao(Date jog_dt_criacao) {
		this.jog_dt_criacao = jog_dt_criacao;
	}
}