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

package br.com.unip.cc.inimigos;

import javax.swing.ImageIcon;

import br.com.unip.cc.base.ImageEntity;

/**
 * Esta classe representa o inimigo 2 e é uma subclade de ImageEntity
 * 
 * @version 0.1 29/Ago/2016
 * @author Gabriel Batista
 */

public class Inimigo4 extends ImageEntity {
	private static final int VELOCIDADE = 4;

	/**
	 * ao instanciar o inimigo 4, o cosntrutor busca todas as imagens localizadas na pasta res
	 * recebe dois parametros, do qual instanceara o objeto em X e Y
	 * 
	 * @param x
	 * @param y
	 */
	public Inimigo4(int x, int y) {
		ImageIcon referencia;

		setX(x);
		setY(y);
		
		referencia = new ImageIcon("res\\inimigo4.png");

		image = referencia.getImage();
		setVisivel(true);
	}

	public void mexer() {
		if(getX() < 0)
			setX(LARGURA_TELA + 3);

		else
			incX(-VELOCIDADE);
	}
}