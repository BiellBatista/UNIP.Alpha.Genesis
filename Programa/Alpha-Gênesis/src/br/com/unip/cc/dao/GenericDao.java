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