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
import br.com.unip.cc.inimigos.Inimigo1;
import br.com.unip.cc.personagem.PersonagemBlue;
import br.com.unip.cc.personagem.PersonagemRed;

/**
 * Esta classe manipula os eventos da fase01
 * 
 * @version 0.1 29/Ago/2016
 * @author Gabriel Batista
 */

public class Fase01 {
	private final ImageIcon REFERENCIA = new ImageIcon("res\\fundojogo1.png"); //pegando a imagem de fundo
	private List<Inimigo1> inimigo = null; //uma lista de objetos do tipo Inimigo1
	private Personagem personagem = null;
	public boolean ativa = false;
	private int[][] coordenadas = {
			{2374, 250}, {2655, 150}, {6445, 200}, {4537, 363},
			{8999, 550}, {4444, 300}, {3671, 450}, {5447, 300}, {7500, 200},
			{6784, 450}, {3576, 210}, {7782, 420}, {6674, 490}, {9788, 150},
			{10011, 500}, {11787, 320}, {9990, 145}, {8889, 200}, {3010, 490},
			{2788, 530}, {5555, 490}, {2580, 550}, {8874, 050}, {15783, 100},
			{4457, 160}, {7777, 050}, {6666, 020}, {2545, 045}, {6119, 065},
			{9957, 460}, {2222, 250}, {2420, 390}, {8952, 430}, {7991, 410},
			{3005, 420}, {2209, 490}, {7030, 350}, {3020, 300}, {11547, 320},
			{20500, 345}, {18777, 300}, {15789, 490}, {11111, 530}, {13547, 490},
			{3578, 550}, {9991,  80}, {6557, 190}, {2333, 360}, {3190, 040},
			{10002, 050}, {9898, 445}, {3211, 025}, {2358, 160}, {9124, 350},
			{2998, 390}, {3858, 330}, {21111, 210}, {5578, 420}, {9135, 490},
			{10123, 150}, {2786, 500}, {6547, 320}, {7778, 145}, {2587, 200},
			{21589, 490}, {9805, 530}, {11190, 490}, {7055, 550}, {13559, 050}
			};
	
	public ImageIcon getReferencia() {
		return this.REFERENCIA;
	}

	public Inimigo1 getInimigo(int i) {
		return this.inimigo.get(i);
	}

	public int sizeInimigo() {
		return this.inimigo.size();
	}

	public void deleteInimigo(int i) {
		this.inimigo.remove(i);
	}

	public void inicializaInimigo1() {
		this.inimigo = new ArrayList<Inimigo1>(); //objeto que aponta para uma lista de inimigos

		for (int i = 0; i < this.coordenadas.length; i++) //adicionando inimigos a lista
			this.inimigo.add(new Inimigo1(this.coordenadas[i][0], this.coordenadas[i][1]));
		this.ativa = true;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
		this.inimigo = null;
	}
	
	public boolean isAtiva() {
		return this.ativa;
	}

	//método que cuida das colisões da fase 01
	public boolean isColisao(Personagem tipo, List<Bolha> bolhas, List<Gota> gotas) {
		if(tipo instanceof PersonagemBlue) {
			this.personagem = (PersonagemBlue) tipo;
		}
		
		else if(tipo instanceof PersonagemRed){
			this.personagem = (PersonagemRed) tipo;
		}
		
		bolhas = this.personagem.getBolhas();
		gotas = this.personagem.getGotas();
		
		for (int i = 0; i < sizeInimigo(); i++)
			if (this.personagem.getBounds().intersects(getInimigo(i).getBounds())) {
				this.personagem.setVisivel(false);
				deleteInimigo(i);
				this.personagem.decVida(1);
				
				if(this.personagem.getVida() == 0)
					return true;
			}

		for (int j = 0; j < bolhas.size() - 1; j++)
			for (int k = 0; k < sizeInimigo(); k++) {
				if (bolhas.get(j).getBounds().intersects(getInimigo(k).getBounds())) {
					deleteInimigo(k);
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