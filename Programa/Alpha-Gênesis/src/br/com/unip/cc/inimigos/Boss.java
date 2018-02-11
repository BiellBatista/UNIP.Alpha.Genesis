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
 * Esta classe representa o chefe e é uma subclade de ImageEntity
 * 
 * @version 0.1 29/Ago/2016
 * @author Gabriel Batista
 */

public class Boss extends ImageEntity {
	private static final int VELOCIDADE = 1;
	private static int vida = 0;

		/**
		 * ao instanciar o chefe, o cosntrutor busca todas as imagens localizadas na pasta res
		 * recebe trrês parametros, do qual dois instanceara o objeto em X e Y e um é a vida inicial
		 * 
		 * @param x
		 * @param y
		 * @param vida
		 */
	public Boss(int x, int y, int vida) {
		ImageIcon referencia;
		
		referencia = new ImageIcon("res\\Boss1.png");
		image = referencia.getImage();
		
		setX(x);
		setY(y);
		setVida(vida);
		setVisivel(true);
	}

	public void mexer() {
		if(getX() < -500)
			setX(LARGURA_TELA + 1003);

		else
			incX(-VELOCIDADE);
	}

	public static int getVida() {
		return vida;
	}

	public static void setVida(int vida) {
		Boss.vida = vida;
	}
	
	public static void dncVida(int vida) {
		Boss.vida -= vida;
	}
}