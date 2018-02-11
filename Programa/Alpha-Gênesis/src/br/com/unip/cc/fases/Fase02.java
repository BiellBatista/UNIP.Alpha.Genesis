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
import br.com.unip.cc.inimigos.Inimigo2;
import br.com.unip.cc.personagem.PersonagemBlue;
import br.com.unip.cc.personagem.PersonagemRed;

/**
 * Esta classe manipula os eventos da fase02
 * 
 * @version 0.1 29/Ago/2016
 * @author Gabriel Batista
 */

public class Fase02 {
	private final ImageIcon REFERENCIA = new ImageIcon("res\\fundojogo2.png"); //pegando a imagem de fundo
	private List<Inimigo2> inimigo = null; //uma lista de objetos do tipo Inimigo2
	private Personagem personagem = null;
	private boolean ativa = false;
	private int[][] coordenadas = {
			{2200, 050}, {2752, 150}, {3057, 200}, {4856, 250},
			{13333, 350}, {9546, 450}, {7854, 530}, {4688, 130}, 
			{5113, 060}, {9754, 290}, {21333, 050}, {9785, 150},
			{2198, 330}, {3511, 430}, {4669, 500}, {3020, 400}, 
			{7888, 200}, {8455, 250}, {6643, 450}, {5555, 450}, 
			{2222, 530}, {6464,  90}, {2256, 500}, {3333, 400},
			{12664, 230}, {20000, 290}, {4587,  70}, {12120,  40}
			};
	
	public ImageIcon getReferencia() {
		return this.REFERENCIA;
	}

	public  Inimigo2 getInimigo(int i) {
		return this.inimigo.get(i);
	}

	public int sizeInimigo() {
		return this.inimigo.size();
	}

	public void deleteInimigo(int i) {
		this.inimigo.remove(i);
	}

	public void inicializaInimigo2() {
		this.inimigo = new ArrayList<Inimigo2>();//objeto que aponta para uma lista de inimigos

		for (int i = 0; i < this.coordenadas.length; i++) //adicionando inimigos a lista
			this.inimigo.add(new Inimigo2(this.coordenadas[i][0], this.coordenadas[i][1]));
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