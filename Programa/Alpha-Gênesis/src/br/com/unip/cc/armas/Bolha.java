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

package br.com.unip.cc.armas;

import java.util.Random;

import javax.swing.ImageIcon;

import br.com.unip.cc.base.ImageEntity;

/**
 * Esta classe representa a municao gota do personagem e � uma subclasse da ImageEntity
 * 
 * @version 0.1 29/Ago/2016
 * @author Gabriel Batista
 */

public class Bolha extends ImageEntity {
	private int velocidade = 2;
	private int randomNum = 0;

	/**
	 * ao instanciar uma bolha, o cosntrutor busca todas as imagens localizadas na pasta res
	 * recebe dois parametros, do qual instanceara o objeto em X e Y
	 * cria uma sequencia de n�meros aleat�rios, para que varie as imagens da bolha
	 * 
	 * @param x
	 * @param y
	 */
	public Bolha(int x, int y) {
		Random rand = new Random();
		ImageIcon referencia1 = new ImageIcon("res\\bolha.png");
		ImageIcon referencia2 = new ImageIcon("res\\bolhas2.png");
		ImageIcon referencia3 = new ImageIcon("res\\bolhas3.png");
		ImageIcon referencia4 = new ImageIcon("res\\bolhas4.png");
		
		setX(x);
		setY(y);

		randomNum = rand.nextInt(3);

		if(randomNum == 0)
			setImage(referencia1.getImage());

		else if(randomNum == 1)
			setImage(referencia2.getImage());

		else if(randomNum == 2)
			setImage(referencia3.getImage());

		else if(randomNum == 3)
			setImage(referencia4.getImage());

		else if(randomNum == 4)
			setImage(referencia1.getImage());

		else if(randomNum == 5)
			setImage(referencia2.getImage());

		setVisivel(true);
	}
	
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	//M�todo respons�vel por movimentar a bolha na tela
	public void mexer() {
		incX(velocidade);

		if(getX() > LARGURA_TELA)
			setVisivel(true);

		else if(getX() < 1)
			setX(1);

		else if(getX() > 1000)
			setX(9000);
	}
}