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

package br.com.unip.cc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Classe que facilita a comunicacao entre as camadas de negocios
 * 
 * @version 0.1 16/Out/2016
 * @author Gabriel Batista
 */

public abstract class GenericDao<T> {

	protected EntityManager em;
	Class<T> clazz;
	
	public GenericDao(EntityManager em, Class<T> clazz) {
		this.em = em;
		this.clazz = clazz; 
	}

	public void save(T entity) {
		EntityTransaction trans = em.getTransaction();

		trans.begin();
		try {
			em.persist(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}

	}

	public void delete(T entity) {
		EntityTransaction trans = em.getTransaction();

		trans.begin();
		try {
			em.remove(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
	}

	public T findById(Long id) {
		return em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

}