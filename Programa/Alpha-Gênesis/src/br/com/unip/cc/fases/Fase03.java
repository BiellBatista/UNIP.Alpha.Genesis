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
import br.com.unip.cc.inimigos.Inimigo3;
import br.com.unip.cc.personagem.PersonagemBlue;
import br.com.unip.cc.personagem.PersonagemRed;

/**
 * Esta classe manipula os eventos da fase03
 * 
 * @version 0.1 29/Ago/2016
 * @author Gabriel Batista
 */

public class Fase03 {
	private final ImageIcon REFERENCIA = new ImageIcon("res\\fundojogo3.png"); //pegando a imagem de fundo
	private List<Inimigo3> inimigo = null; //uma lista de objetos do tipo Inimigo3
	private Personagem personagem = null;
	private boolean ativa = false;
	private int[][] coordenadas = {
			{13131, 050}, {10101, 150}, {5555, 200}, {2588, 250},
			{3555, 350}, {4878, 450}, {12590, 530}, {11250, 130}, 
			{3554, 060}, {3789, 290}, {2547, 050}, {8897, 150},
			{9877, 330}, {21085, 430}, {12254, 500}, {9991, 400}, 
			{7547, 200}, {5311, 250}, {12455, 450}, {2710, 450},
			{4778, 230}, {2155, 290}, {9157, 070}, {6478, 040}, 
			{8711, 500}, {21214, 400}, {12001, 530}, {8555,  90},
			};
	
	public ImageIcon getReferencia() {
		return REFERENCIA;
	}

	public  Inimigo3 getInimigo(int i) {
		return this.inimigo.get(i);
	}

	public int sizeInimigo() {
		return this.inimigo.size();
	}

	public void deleteInimigo(int i) {
		this.inimigo.remove(i);
	}

	public void inicializaInimigo3() {
		this.inimigo = new ArrayList<Inimigo3>();//objeto que aponta para uma lista de inimigos

		for (int i = 0; i < this.coordenadas.length; i++)//adicionando inimigos a lista
			this.inimigo.add(new Inimigo3(this.coordenadas[i][0], this.coordenadas[i][1]));
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