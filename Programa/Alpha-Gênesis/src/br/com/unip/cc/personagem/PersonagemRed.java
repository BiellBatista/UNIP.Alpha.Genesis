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

package br.com.unip.cc.personagem;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import br.com.unip.cc.armas.Bolha;
import br.com.unip.cc.armas.Gota;
import br.com.unip.cc.base.ImageEntity;
import br.com.unip.cc.base.Personagem;
import br.com.unip.cc.music.TocarSom;

/**
 * Esta classe representa o personagem segundario
 * 
 * @version 0.1 02/Set/2016
 * @author Gabriel Batista
 */

public class PersonagemRed extends ImageEntity implements Personagem{
	private ImageIcon cima = null;
	private ImageIcon ref = null;
	private ImageIcon baixo = null;
	private ImageIcon esquerda = null;
	private ImageIcon direita = null;
	private ImageIcon anim_L = null;
	private ImageIcon anim_R = null;
	private ImageIcon anim_U = null;
	private ImageIcon anim_D = null;
	private List<Bolha> bolhas = null;
	private List<Gota> gotas = null;
	private boolean batalha = false;
	private int dx = 0, dy = 0; //direcao de x e y
	private int vida = 0;

	/**
	 * ao instanciar o personagem, ele ja inicia com os seus atributos preenchidos
	 */
	public PersonagemRed(boolean batalha) {
		baixo = new ImageIcon("res\\geleiaB1.png");
		esquerda = new ImageIcon("res\\geleiaE1.png");
		direita = new ImageIcon("res\\geleiaD1.png");
		cima = new ImageIcon("res\\geleiaC1.png");
		anim_L = new ImageIcon("res\\geleiaE.gif");
		anim_R = new ImageIcon("res\\geleiaD.gif");
		anim_U = new ImageIcon("res\\geleiaC.gif");
		anim_D = new ImageIcon("res\\geleiaB.gif");
		ref = new ImageIcon("res\\ref_V.png");
		image = ref.getImage();
		bolhas = new ArrayList<Bolha>();
		gotas = new ArrayList<Gota>();
		setBatalha(batalha);

		if(isBatalha()) {
			setVida(100);
			setX(900);
			setY(550);
		}

		else {
			setVida(3);
			setX(50);
			setY(50);
		}
	}

	public void mexer() {
		incX(dx);
		incY(dy);

		if(getX() < 1)
			setX(1);

		else if(getX() > 930)
			setX(930);

		else if(getY() < 1)
			setY(1);

		else if(getY() > 580)
			setY(580);
	}

	public List<Bolha> getBolhas() {
		return bolhas;
	}

	public List<Gota> getGotas() {
		return gotas;
	}

	public void atira() {
		this.bolhas.add(new Bolha((int)getX() + getWidth(), (int)getY() + getHeight()/2));
	}

	public void atira2() {
		if(this.gotas.size() < 5) {
			this.gotas.add(new Gota((int)getX() + getWidth(), (int)getY() + getHeight()/2));
			TocarSom.som("Gota");
		}
	}

	//Quando o jogador pressionar alguma tecla
	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();

		if(isBatalha())
			switch(codigo) {
			case KeyEvent.VK_UP:
				dy = -1;
				image = anim_U.getImage();;
				break;

			case KeyEvent.VK_DOWN:
				dy = 1;
				image = anim_D.getImage();
				break;

			case KeyEvent.VK_LEFT:
				dx = -1;
				image = anim_L.getImage();
				break;

			case KeyEvent.VK_RIGHT:
				dx = 1;
				image = anim_R.getImage();
				break;
			}

		else {
			if((codigo == KeyEvent.VK_UP) || (codigo == KeyEvent.VK_W)) {
				dy = -1;
				image = anim_U.getImage();
			}

			else if((codigo == KeyEvent.VK_DOWN) || (codigo == KeyEvent.VK_S)) {
				dy = 1;
				image = anim_D.getImage();
			}

			else if((codigo == KeyEvent.VK_LEFT) || (codigo == KeyEvent.VK_A)) {
				dx = -1;
				image = anim_L.getImage();
			}

			else if((codigo == KeyEvent.VK_RIGHT) || (codigo == KeyEvent.VK_D)){
				dx = 1;
				image = anim_R.getImage();
			}
		}
	}

	//Quando o jogador soltar alguma tecla
	public void keyReleased(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();

		if(isBatalha())
			switch(codigo) {
			case KeyEvent.VK_CONTROL:
				if(bolhas.size() < 20) {
					atira();
					TocarSom.som("Bolha");
				}
				break;

			case KeyEvent.VK_SHIFT:
				atira2();
				break;

			case KeyEvent.VK_UP:
				dy = 0;
				image = cima.getImage();
				break;

			case KeyEvent.VK_DOWN:
				dy = 0;
				image = baixo.getImage();
				break;

			case KeyEvent.VK_LEFT:
				dx = 0;
				image = esquerda.getImage();
				break;

			case KeyEvent.VK_RIGHT:
				dx = 0;
				image = direita.getImage();
				break;
			}

		else {
			if(codigo == KeyEvent.VK_J){
				if(bolhas.size() < 20) {
					atira();
					TocarSom.som("Bolha");
				}
			}

			else if(codigo == KeyEvent.VK_K){
				atira2();
			}

			else if((codigo == KeyEvent.VK_UP) || (codigo == KeyEvent.VK_W)) {
				dy = 0;
				image = cima.getImage();
			}

			else if((codigo == KeyEvent.VK_DOWN) || (codigo == KeyEvent.VK_S)) {
				dy = 0;
				image = baixo.getImage();
			}

			else if((codigo == KeyEvent.VK_LEFT) || (codigo == KeyEvent.VK_A)) {
				dx = 0;
				image = esquerda.getImage();
			}

			else if((codigo == KeyEvent.VK_RIGHT) || (codigo == KeyEvent.VK_D)) {
				dx = 0;
				image = direita.getImage();
			}
		}
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void incVida(int vida) {
		this.vida += vida;
	}

	public void decVida(int vida) {
		this.vida -= vida;
	}

	public boolean isBatalha() {
		return batalha;
	}

	public void setBatalha(boolean batalha) {
		this.batalha = batalha;
	}
}