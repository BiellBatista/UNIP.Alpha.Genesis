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

package br.com.unip.cc.armas;

import java.util.Random;

import javax.swing.ImageIcon;

import br.com.unip.cc.base.ImageEntity;

/**
 * Esta classe representa a municao gota do personagem e é uma subclasse da ImageEntity
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
	 * cria uma sequencia de números aleatórios, para que varie as imagens da bolha
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

	//Método responsável por movimentar a bolha na tela
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