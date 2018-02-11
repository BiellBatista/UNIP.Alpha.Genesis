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
package br.com.unip.cc.base;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

import br.com.unip.cc.armas.Bolha;
import br.com.unip.cc.armas.Gota;

/**
 * esta interface é usada para fazer uma conversao ampliada
 */

public interface Personagem {
	void mexer();
	List<Bolha> getBolhas();
	List<Gota> getGotas();
	void atira();
	void atira2();
	void keyPressed(KeyEvent tecla);
	void keyReleased(KeyEvent tecla);
	int getVida();
	void setVida(int vida);
	void incVida(int vida);
	void decVida(int vida);
	void setVisivel(boolean b);
	Rectangle getBounds();
}