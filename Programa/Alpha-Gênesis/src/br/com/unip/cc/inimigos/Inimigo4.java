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
 * Esta classe representa o inimigo 2 e � uma subclade de ImageEntity
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