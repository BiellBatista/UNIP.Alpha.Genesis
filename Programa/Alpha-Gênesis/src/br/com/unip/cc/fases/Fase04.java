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

package br.com.unip.cc.fases;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import br.com.unip.cc.armas.Bolha;
import br.com.unip.cc.armas.Gota;
import br.com.unip.cc.base.Personagem;
import br.com.unip.cc.control.Control;
import br.com.unip.cc.inimigos.Inimigo4;
import br.com.unip.cc.personagem.PersonagemBlue;
import br.com.unip.cc.personagem.PersonagemRed;

/**
 * Esta classe manipula os eventos da fase04
 * 
 * @version 0.1 29/Ago/2016
 * @author Gabriel Batista
 */

public class Fase04 {
	private final ImageIcon REFERENCIA = new ImageIcon("res\\fundojogo4.png"); //pegando a imagem de fundo
	private List<Inimigo4> inimigo = null; //uma lista de objetos do tipo Inimigo4
	private Personagem personagem = null;
	private boolean ativa = false;
	private int[][] coordenadas = {
			{2510, 050}, {3221, 150}, {5110, 200}, {4759, 250},
			{3000, 350}, {6785, 450}, {9958, 530}, {3584, 130},
			{2651, 330}, {5547, 430}, {9994, 500}, {6871, 400},
			{2121, 050}, {3581, 150}, {10258, 060}, {8447, 290},
			{7710, 200}, {6791, 250}, {13013, 450}, {12240, 450},
			{6411, 230}, {2997, 290}, {20910, 070}, {10840, 040},
			{4451, 500}, {2820, 400}, {7611, 530}, {6714,  90},
			};
	
	public ImageIcon getReferencia() {
		return REFERENCIA;
	}

	public  Inimigo4 getInimigo(int i) {
		return this.inimigo.get(i);
	}

	public int sizeInimigo() {
		return this.inimigo.size();
	}

	public void deleteInimigo(int i) {
		this.inimigo.remove(i);
	}

	public void inicializaInimigo4() {
		this.inimigo = new ArrayList<Inimigo4>(); //objeto que aponta para uma lista de inimigos

		for (int i = 0; i < this.coordenadas.length; i++) //adicionando inimigos a lista
			this.inimigo.add(new Inimigo4(this.coordenadas[i][0], this.coordenadas[i][1]));
		this.ativa = true;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
		this.inimigo = null;
	}
	
	public boolean isAtiva() {
		return this.ativa;
	}

	public boolean isColisao(Personagem tipo, List<Bolha> bolhas, List<Gota> gotas) {
		if(tipo instanceof PersonagemBlue) {
			this.personagem = (PersonagemBlue) tipo;
		}
		
		else if(tipo instanceof PersonagemRed){
			this.personagem = (PersonagemRed) tipo;
		}
		
		bolhas = this.personagem.getBolhas();
		gotas = this.personagem.getGotas();

		for (int i = 0; i < sizeInimigo(); i++) {
			if (this.personagem.getBounds().intersects(getInimigo(i).getBounds())) {
				this.personagem.setVisivel(false);
				deleteInimigo(i);
				this.personagem.decVida(1);
				
				if(this.personagem.getVida() == 0)
					return true;
			}
		}

		for (int j = 0; j < bolhas.size() - 1; j++) 
			for (int k = 0; k < sizeInimigo(); k++) {
				if (bolhas.get(j).getBounds().intersects(getInimigo(k).getBounds())) {
					deleteInimigo(k);;
					bolhas.remove(j);
					Control.incPontos(1);
				}
				
				else if(bolhas.get(j).getX() > 960)
					bolhas.remove(j);
			}

		for (int k = 0; k < gotas.size() - 1; k++) 
			for (int l = 0; l < sizeInimigo(); l++) {
				if (gotas.get(k).getBounds().intersects(getInimigo(l).getBounds())) {
					deleteInimigo(l);
					gotas.remove(k);
					Control.incPontos(1);
				}
				
				else if(gotas.get(k).getY() > 672)
					gotas.remove(k);
			}
		
		return false;
	}
}