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
import br.com.unip.cc.inimigos.Boss;
import br.com.unip.cc.personagem.PersonagemBlue;
import br.com.unip.cc.personagem.PersonagemRed;

/**
 * Esta classe manipula os eventos da fase05
 * 
 * @version 0.1 29/Ago/2016
 * @author Gabriel Batista
 */

public class Fase05 {
	private final ImageIcon REFERENCIA = new ImageIcon("res\\fundojogo5.png"); //pegando a imagem de fundo
	private List<Boss> boss = null; //uma lista de objetos do tipo Boss
	private Personagem personagem = null;
	private boolean ativa = false;
	private int[][] coordenadas = {{2520, 190}};

	public ImageIcon getReferencia() {
		return REFERENCIA;
	}

	public  Boss getInimigo(int i) {
		return this.boss.get(i);
	}

	public int sizeInimigo() {
		return this.boss.size();
	}

	public void deleteInimigo(int i) {
		this.boss.remove(i);
	}

	public void inicializaBoss() {
		this.boss = new ArrayList<Boss>(); //objeto que aponta para uma lista de inimigos

		for (int i = 0; i < 1; i++) //adicionando inimigos a lista
			this.boss.add(new Boss(this.coordenadas[i][0], this.coordenadas[i][1], 100));
		this.ativa = true;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
		this.boss = null;
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
				getInimigo(i).setVisivel(false);
				return true;
			}
		}

		for (int j = 0; j < bolhas.size() - 1; j++) 
			for (int k = 0; k < sizeInimigo(); k++) {
				if (bolhas.get(j).getBounds().intersects(getInimigo(k).getBounds())) {
					Boss.dncVida(1);
					getInimigo(k).setVisivel(false);
					bolhas.remove(j);
					Control.incPontos(1);
				}

				else if(bolhas.get(j).getX() > 960)
					bolhas.remove(j);
			}

		for (int k = 0; k < gotas.size() - 1; k++)
			for (int l = 0; l < sizeInimigo(); l++) {
				if (gotas.get(k).getBounds().intersects(getInimigo(l).getBounds())) {
					gotas.remove(k);
				}

				else if(gotas.get(k).getY() > 672)
					gotas.remove(k);

			}
		return false;
	}
}