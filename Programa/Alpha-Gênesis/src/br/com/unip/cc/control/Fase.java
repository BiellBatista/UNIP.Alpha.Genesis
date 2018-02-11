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

package br.com.unip.cc.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.unip.cc.armas.Bolha;
import br.com.unip.cc.armas.Gota;
import br.com.unip.cc.dao.JogadorDAO;
import br.com.unip.cc.dao.RecordeDAO;
import br.com.unip.cc.domain.Jogadores;
import br.com.unip.cc.domain.Recordes;
import br.com.unip.cc.fases.Fase01;
import br.com.unip.cc.fases.Fase02;
import br.com.unip.cc.fases.Fase03;
import br.com.unip.cc.fases.Fase04;
import br.com.unip.cc.fases.Fase05;
import br.com.unip.cc.inimigos.Boss;
//import br.com.unip.cc.jdbc.Jogador;
//import br.com.unip.cc.jdbc.JogadorDAO;
//import br.com.unip.cc.jdbc.RecordeDAO;
import br.com.unip.cc.persistence.EntityManagerProvider;
import br.com.unip.cc.personagem.PersonagemBlue;

/**
 * Esta classe representa o controle das fases. Ela verifica se o jogador pode continuar
 * se é fim de jogo, invoca os métodos de cada fase para verificar a colisão, iniciar
 * os inimigos e etc..
 * É uma subclasse de JPanel com a implementação da ActionListener
 * 
 * @version 0.1 02/Set/2016
 * @author Gabriel Batista
 */

@SuppressWarnings("serial")
public class Fase extends JPanel implements ActionListener {
	private Image fundo = null;
	private Timer timer = null;
	private PersonagemBlue personagem = null;
	private Fase01 fase01 = null;
	private Fase02 fase02 = null;
	private Fase03 fase03 = null;
	private Fase04 fase04 = null;
	private Fase05 fase05 = null;
	private List<Bolha> bolhas = null;
	private List<Gota> gotas = null;
	private boolean emJogo = false, emJogo2 = false;
	private int cont = 0;
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());

		fase01 = new Fase01();
		fase02 = new Fase02();
		fase03 = new Fase03();
		fase04 = new Fase04();
		fase05 = new Fase05();
		personagem = new PersonagemBlue(false);
		timer = new Timer(1, this);

		emJogo2 = true;

		setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Fases");
		internalFrame.setBounds(0, 0, 450, 300);
		add(internalFrame);
		internalFrame.setVisible(true);
		timer.start();
	}

	//Método que serve para desenhar no JPanel
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);

		if (emJogo) {
			bolhas = personagem.getBolhas();
			gotas = personagem.getGotas();

			graficos.drawImage(personagem.getImage(), (int) personagem.getX(), (int) personagem.getY(), this);

			for (int i = 0; i < personagem.sizeGotas(); i++)
				graficos.drawImage(personagem.getGotas(i).getImage(), (int) personagem.getGotas(i).getX(), (int) personagem.getGotas(i).getY(), this);

			for (int i = 0; i < personagem.sizeBolhas(); i++)
				graficos.drawImage(personagem.getBolhas(i).getImage(), (int) personagem.getBolhas(i).getX(), (int) personagem.getBolhas(i).getY(), this);

			if(fase01.isAtiva())
				for (int i = 0; i < fase01.sizeInimigo(); i++)
					graficos.drawImage(fase01.getInimigo(i).getImage(), (int) fase01.getInimigo(i).getX(), (int) fase01.getInimigo(i).getY(), this);

			if(fase02.isAtiva())
				for (int i = 0; i < fase02.sizeInimigo(); i++)
					graficos.drawImage(fase02.getInimigo(i).getImage(), (int) fase02.getInimigo(i).getX(), (int) fase02.getInimigo(i).getY(), this);

			if(fase03.isAtiva())
				for (int i = 0; i < fase03.sizeInimigo(); i++)
					graficos.drawImage(fase03.getInimigo(i).getImage(), (int) fase03.getInimigo(i).getX(), (int) fase03.getInimigo(i).getY(), this);

			if(fase04.isAtiva())
				for (int i = 0; i < fase04.sizeInimigo(); i++)
					graficos.drawImage(fase04.getInimigo(i).getImage(), (int) fase04.getInimigo(i).getX(), (int) fase04.getInimigo(i).getY(), this);

			if(fase05.isAtiva())
				for (int i = 0; i < fase05.sizeInimigo(); i++)
					graficos.drawImage(fase05.getInimigo(i).getImage(), (int) fase05.getInimigo(i).getX(), (int) fase05.getInimigo(i).getY(), this);

			if (this.cont == 4) {
				Font font = new Font("Serif", Font.PLAIN, 20);
				graficos.setFont(font);
				graficos.setColor(Color.white);
				graficos.drawString("Vida do Boss: " + Boss.getVida(), 445, 35);
			}

			if(fase05.isAtiva())
				if (fase05.sizeInimigo() == 0) {
					ImageIcon fimJogo = new ImageIcon("res\\fim_jogo.png");
					graficos.drawImage(fimJogo.getImage(), 0, 0, null);
					g.dispose();
				}
		}

		if (emJogo2 == true) {
			ImageIcon fimJogo = new ImageIcon("res\\tuto1.png");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
			g.dispose();
		}



		else if (emJogo == false) {	
			ImageIcon fimJogo = new ImageIcon("res\\game_over.png");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
		}
	}

	//verifica e executa todas as ações que ocorrem dentro do JPanel
	public void actionPerformed(ActionEvent arg0) {
		bolhas = personagem.getBolhas();
		gotas = personagem.getGotas();

		if(emJogo) {
			for (int i = 0; i < bolhas.size(); i++) {
				if (bolhas.get(i).isVsivel()) {
					bolhas.get(i).mexer();

					if(personagem.getX() >= 465)
						bolhas.get(i).setVelocidade(-2);
				}

				else
					bolhas.remove(i);

				if(bolhas.get(i).getX() > 960 || bolhas.get(i).getX() < 2)
					bolhas.remove(i);
			}

			for (int i = 0; i < gotas.size(); i++) {
				if (gotas.get(i).isVsivel()) {
					gotas.get(i).mexer();

					if(personagem.getX() >= 465)
						gotas.get(i).incX(-2);
				}

				else
					gotas.remove(i);

				if(gotas.get(i).getY() > 672)
					gotas.remove(i);
			}

			if(fase01.isAtiva()) {
				for (int i = 0; i < fase01.sizeInimigo(); i++) {
					if (fase01.getInimigo(i).isVsivel())
						fase01.getInimigo(i).mexer();
					else
						fase01.deleteInimigo(i);
				}

				if (fase01.sizeInimigo() == 0  && this.cont == 0) {
					this.cont++;
					fase01.setAtiva(false);
					fundo = fase02.getReferencia().getImage();
					fase02.inicializaInimigo2();
				}
			}

			if(fase02.isAtiva()){
				for (int e = 0; e < fase02.sizeInimigo(); e++) {
					if (fase02.getInimigo(e).isVsivel())
						fase02.getInimigo(e).mexer();
					else
						fase02.deleteInimigo(e);
				}

				if (fase02.sizeInimigo() == 0 && this.cont == 1) {
					this.cont++;
					fase02.setAtiva(false);
					fundo = fase03.getReferencia().getImage();
					fase03.inicializaInimigo3();
				}
			}

			if(fase03.isAtiva()) {
				for (int b = 0; b < fase03.sizeInimigo(); b++) {
					if (fase03.getInimigo(b).isVsivel())
						fase03.getInimigo(b).mexer();
					else
						fase03.deleteInimigo(b);
				}

				if (fase03.sizeInimigo() == 0 && this.cont == 2) {
					this.cont++;
					fase03.setAtiva(false);
					fundo = fase04.getReferencia().getImage();
					fase04.inicializaInimigo4();
				}
			}

			if(fase04.isAtiva()) {
				for (int c = 0; c < fase04.sizeInimigo(); c++) {
					if (fase04.getInimigo(c).isVsivel())
						fase04.getInimigo(c).mexer();
					else
						fase04.deleteInimigo(c);
				}

				if (fase04.sizeInimigo() == 0 && this.cont == 3) {
					this.cont++;
					fase04.setAtiva(false);
					fundo = fase05.getReferencia().getImage();
					fase05.inicializaBoss();
				}
			}

			if(fase05.isAtiva())
				for (int p = 0; p < fase05.sizeInimigo(); p++) {
					fase05.getInimigo(p).mexer();

					if (fase05.getInimigo(p).isVsivel()) {
						fase05.getInimigo(0);
						fase05.getInimigo(p).mexer();
					}

					else if (Boss.getVida() == 0)
						fase05.deleteInimigo(p);
				}
			personagem.mexer();
			colisao();
		}
		repaint();
	}

	//verificando as colisões
	public void colisao() {
		if(fase01.isAtiva())
			if(fase01.isColisao(personagem, bolhas, gotas)){
				if(personagem.getVida() == 0)
					cadastre();
				emJogo = false;
			}

		if(fase02.isAtiva())
			if(fase02.isColisao(personagem, bolhas, gotas)){
				if(personagem.getVida() == 0)
					cadastre();
				emJogo = false;
			}

		if(fase03.isAtiva())
			if(fase03.isColisao(personagem, bolhas, gotas)){
				if(personagem.getVida() == 0)
					cadastre();
				emJogo = false;
			}

		if(fase04.isAtiva())
			if(fase04.isColisao(personagem, bolhas, gotas)){
				if(personagem.getVida() == 0)
					cadastre();
				emJogo = false;
			}

		if(fase05.isAtiva())
			if(fase05.isColisao(personagem, bolhas, gotas)){
				if(personagem.getVida() == 0)
					cadastre();
				emJogo = false;
			}
	}

	public void cadastre() {
		/*Jogador player = new Jogador();
		JogadorDAO salve = new JogadorDAO();
		RecordeDAO record = new RecordeDAO();

		player.setNome(JOptionPane.showInputDialog(null, "Digite seu nome", "Nome", JOptionPane.PLAIN_MESSAGE));
		player.setNick(JOptionPane.showInputDialog(null, "Digite seu apleido", "Apelido", JOptionPane.PLAIN_MESSAGE));
		player.setRecord(Control.getPontos());
		record.inserirRecorde(player);
		JOptionPane.showMessageDialog(null, salve.inserirPlayer(player));*/

		String nome = JOptionPane.showInputDialog(null, "Digite seu nome", "Nome", JOptionPane.PLAIN_MESSAGE);

		if(nome != null) {
			Jogadores player = new Jogadores();

			player.setJog_nome(nome);
			
			nome = null;
			nome = JOptionPane.showInputDialog(null, "Digite seu apleido", "Apelido", JOptionPane.PLAIN_MESSAGE);
			
			if(nome != null) {
				Calendar data = GregorianCalendar.getInstance();
				EntityManager em = EntityManagerProvider.getEntityManagerInstance();
				
				JogadorDAO daoJogador = new JogadorDAO(em);
				
				Recordes pontos = new Recordes();
				RecordeDAO daoRecorde = new RecordeDAO(em);
				
				player.setJog_apelido(nome.substring(0, 4));
				player.setJog_dt_criacao(data.getTime());
				daoJogador.save(player);

				pontos.setRec_quantidade(Control.getPontos());
				pontos.setRec_dt_criacao(data.getTime());
				daoRecorde.save(pontos);
			}
		}
	}

	//Caso o usuário aperte enter no menu inicial
	private class TecladoAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {		
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				emJogo = true;
				emJogo2 = false;
				fundo = fase01.getReferencia().getImage();
				personagem = new PersonagemBlue(false);

				fase01.inicializaInimigo1();
				fase02.setAtiva(false);
				fase03.setAtiva(false);
				fase04.setAtiva(false);
				fase05.setAtiva(false);
				cont = 0;
			}

			personagem.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			personagem.keyReleased(e);
		}
	}
}