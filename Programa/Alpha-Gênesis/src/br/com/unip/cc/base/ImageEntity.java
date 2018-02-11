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

package br.com.unip.cc.base;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * Esta classe possibilita a utiliza��o de uma imagem para os objetos no game
 *
 * @version 0.20 31/Jul/2016
 * @author Gabriel Batista
 */

public class ImageEntity extends BaseGameEntity {
	protected Image image = null;//Objeto que ir� armazenar a imagem
	private Graphics2D g2d = null;//Objeto que controla a geometria, transforma��es de coordenadas, gerenciamento de cores e layout de texto
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

	//M�todo que ir� desenhar a imagem na tela
	public void draw(int x, int y) {
		g2d.drawImage(getImage(), x, y, null);
	}

	//M�todo que cuida da m�scara de cada imagem
	public Rectangle getBounds() {
		return new Rectangle((int)getX(), (int)getY(), getWidth(), getHeight());
	}
}