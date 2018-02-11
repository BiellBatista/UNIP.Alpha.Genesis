/* %W% %E% Gabriel Batista
 *
 * Copyright (c) 2000-2012 Raz�o Social Ltda. Todos os direitos reservados.
 *
 * Esse software � informa��o confidencial e propriet�ria da Raz�o
 * Social Ltda. ("Informa��o Confidencial"). Voc� n�o deve divulgar
 * tal Informa��o Confidencial e deve us�-la apenas em concord�ncia
 * com os termos de acordo de licen�a que voc� entrou com a Laranja Games Ltda.
 *
 * 
 * LARANJA GAMES LTDA N�O FAZ REPRESENTA��O OU D� GARANTIAS SOBRE A
 * ADEQUA��O DO SOFTWARE, SEJA EXPRESSA OU IMPLICADA, INCLUINDO MAS
 * N�O LIMITANDO AS GARANTIAS DE COMERCIALIZA��O, ADEQUA��O PARA UM
 * DETERMINADO FIM PARTICULAR OU N�O-VIOLA��O. LARANJA GAMES LTDA N�O
 * SER� RESPONS�VEL POR QUALQUER DANO SOFRIDO PELO LICENCIADO EM
 * DECORR�NCIA DO USO, MODIFICA��O OU DISTRIBUI��O DESSE SOFTWARE OU
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
 * Classe que representa a tabela recordes do banco
 * 
 * @version 0.1 16/Out/2016
 * @author Gabriel Batista
 */

@Entity //indica para o Hibernate que a classe Jogadores deve ser armazenada em uma tablea
@Table(name = "recordes") //Passa o nome da tabela para o Hibernate configurar

public class Recordes {
	
	@Id //Configura um atributo como sendo a chave prim�ria da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INC_REC") //defini��o de como ser� tratada a PK
	@SequenceGenerator(name = "INC_REC", sequenceName = "INC_REC", allocationSize = 1, initialValue = 0)
	@Column(name = "rec_codigo", nullable = false)
	private int rec_codigo;
	
	@Column(name = "rec_quantidade", nullable = false) //Indica uma coluna
	private int rec_quantidade;
	
	@Temporal(TemporalType.DATE) //Indica um dado do tipo data
	@Column(name = "rec_dt_criacao", nullable = false)
	private Date rec_dt_criacao;
	
	public Recordes() {
	}

	public int getRec_codigo() {
		return rec_codigo;
	}

	public void setRec_codigo(int rec_codigo) {
		this.rec_codigo = rec_codigo;
	}

	public int getRec_quantidade() {
		return rec_quantidade;
	}

	public void setRec_quantidade(int rec_quantidade) {
		this.rec_quantidade = rec_quantidade;
	}

	public Date getRec_dt_criacao() {
		return rec_dt_criacao;
	}

	public void setRec_dt_criacao(Date rec_dt_criacao) {
		this.rec_dt_criacao = rec_dt_criacao;
	}
}