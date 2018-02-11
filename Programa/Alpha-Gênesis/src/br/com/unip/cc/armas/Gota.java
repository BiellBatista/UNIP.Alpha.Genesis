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

public class Gota extends ImageEntity {
	private int velocidade = 1;
	private int randomNum = 0;

	/**
	 * ao instanciar uma gota, o cosntrutor busca todas as imagens localizadas na pasta res
	 * recebe dois parametros, do qual instanceara o objeto em X e Y
	 * cria uma sequencia de números aleatórios, para que varie as imagens da gota
	 * 
	 * @param x
	 * @param y
	 */
	public Gota(int x, int y) {
		Random rand = new Random();
		ImageIcon referencia1 = new ImageIcon("res\\gota.png");
		ImageIcon referencia2 = new ImageIcon("res\\gota2.png");
		ImageIcon referencia3 = new ImageIcon("res\\gota3.png");

		setX(x);
		setY(y);

		randomNum = rand.nextInt(2);
		
		if(randomNum == 0)
			setImage(referencia1.getImage());

		else if(randomNum == 1)
			setImage(referencia2.getImage());

		else if(randomNum == 2)
			setImage(referencia3.getImage());
		
		setVisivel(true);
	}
	
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public void mexer() {
		incX(velocidade);
		incY(velocidade);

		if(getX() > LARGURA_TELA)
			setVisivel(true);

		if(getY() > LARGURA_TELA)
			setVisivel(true);
	}
}