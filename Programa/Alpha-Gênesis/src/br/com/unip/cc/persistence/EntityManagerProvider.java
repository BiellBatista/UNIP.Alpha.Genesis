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

package br.com.unip.cc.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe respons�vel pela manipula��o dos objetos que devem ser salvos e recuperados do banco de dados
 * 
 * @version 0.1 16/Out/2016
 * @author Gabriel Batista
 */

public class EntityManagerProvider {
	private static EntityManagerFactory emf = null;
	
	private EntityManagerProvider() {
	}

	public static EntityManager getEntityManagerInstance() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("conexao");
		
		return emf.createEntityManager();
	}
}