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

package br.com.unip.cc.inimigos;

import javax.swing.ImageIcon;

import br.com.unip.cc.base.ImageEntity;

/**
 * Esta classe representa o chefe e � uma subclade de ImageEntity
 * 
 * @version 0.1 29/Ago/2016
 * @author Gabriel Batista
 */

public class Boss extends ImageEntity {
	private static final int VELOCIDADE = 1;
	private static int vida = 0;

		/**
		 * ao instanciar o chefe, o cosntrutor busca todas as imagens localizadas na pasta res
		 * recebe trr�s parametros, do qual dois instanceara o objeto em X e Y e um � a vida inicial
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