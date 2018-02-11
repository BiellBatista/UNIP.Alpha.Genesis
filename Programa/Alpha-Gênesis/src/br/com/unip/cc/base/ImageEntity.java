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

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * Esta classe possibilita a utilização de uma imagem para os objetos no game
 *
 * @version 0.20 31/Jul/2016
 * @author Gabriel Batista
 */

public class ImageEntity extends BaseGameEntity {
	protected Image image = null;//Objeto que irá armazenar a imagem
	private Graphics2D g2d = null;//Objeto que controla a geometria, transformações de coordenadas, gerenciamento de cores e layout de texto
	protected boolean visivel = false;
	protected static final int LARGURA_TELA = 997;

	public ImageEntity() {
		setImage(null);
		setAlive(true);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setGraphics(Graphics2D g) {
		g2d = g;
	}

	public boolean isVsivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public int getWidth() {
		return image.getWidth(null);
	}

	public int getHeight() {
		return image.getHeight(null);
	}

	//Método que irá desenhar a imagem na tela
	public void draw(int x, int y) {
		g2d.drawImage(getImage(), x, y, null);
	}

	//Método que cuida da máscara de cada imagem
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), getWidth(), getHeight());
	}
}