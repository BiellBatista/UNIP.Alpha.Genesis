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
		
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.com.unip.cc.armas.Bolha;
import br.com.unip.cc.armas.Gota;
import br.com.unip.cc.personagem.PersonagemBlue;
import br.com.unip.cc.personagem.PersonagemRed;

/**
 * Esta classe controla os eventos da batalha
 * 
 * @version 0.1 09/Set/2016
 * @author Gabriel Batista
 */

@SuppressWarnings("serial")
public class Batalha extends JPanel implements ActionListener{
	private final ImageIcon REFERENCIA = new ImageIcon("res\\fundojogo0.jpg");
	private final Image fundo = REFERENCIA.getImage();
	private Timer timer = null;
	private PersonagemBlue personagemBlue = null;
	private PersonagemRed personagemRed = null;
	private List<Bolha> bolhasBlue = null;
	private List<Gota> gotasBlue = null;
	private List<Bolha> bolhasRed = null;
	private List<Gota> gotasRed = null;

	public Batalha() {
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());
		
		personagemRed = new PersonagemRed(true);
		personagemBlue = new PersonagemBlue(true);
		timer = new Timer(1, this);
		
		setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Batalha");
		internalFrame.setBounds(0, 0, 450, 300);
		add(internalFrame);
		internalFrame.setVisible(true);
		timer.start();
	}

	//Método que serve para desenhar no JPanel
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(personagemBlue.getImage(), (int) personagemBlue.getX(), (int) personagemBlue.getY(), this);
		graficos.drawImage(personagemRed.getImage(), (int) personagemRed.getX(), (int) personagemRed.getY(), this);
		
		bolhasBlue = personagemBlue.getBolhas();
		gotasBlue = personagemBlue.getGotas();
		bolhasRed = personagemRed.getBolhas();
		gotasRed = personagemRed.getGotas();
		
		for (int i = 0; i < gotasBlue.size(); i++) {
			Gota n = (Gota) gotasBlue.get(i);
			graficos.drawImage(n.getImage(), (int) n.getX(), (int) n.getY(), this);
		}

		for (int i = 0; i < bolhasBlue.size(); i++) {
			Bolha m = (Bolha) bolhasBlue.get(i);
			graficos.drawImage(m.getImage(), (int) m.getX(), (int) m.getY(), this);
		}
		
		for (int i = 0; i < gotasRed.size(); i++) {
			Gota n = (Gota) gotasRed.get(i);
			graficos.drawImage(n.getImage(), (int) n.getX(), (int) n.getY(), this);
		}

		for (int i = 0; i < bolhasRed.size(); i++) {
			Bolha m = (Bolha) bolhasRed.get(i);
			graficos.drawImage(m.getImage(), (int) m.getX(), (int) m.getY(), this);
		}
		
		if (personagemBlue.getVida() == 0) {	
			ImageIcon fimJogo = new ImageIcon("res\\Amoeba_Venceu.png");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
		}
		
		if (personagemRed.getVida() == 0) {	
			ImageIcon fimJogo = new ImageIcon("res\\Ameba_Venceu.png");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);
		}
	}

	//verifica e executa todas as ações que ocorrem dentro do JPanel
	public void actionPerformed(ActionEvent arg0) {
		bolhasBlue = personagemBlue.getBolhas();
		gotasBlue = personagemBlue.getGotas();
		bolhasRed = personagemRed.getBolhas();
		gotasRed = personagemRed.getGotas();

		for (int i = 0; i < bolhasBlue.size(); i++) {
			Bolha b = (Bolha) bolhasBlue.get(i);

			if (b.isVsivel()) {
				b.mexer();
				if(personagemBlue.getX() >= 465)
					bolhasBlue.get(i).setVelocidade(-2);
			}

			else
				bolhasBlue.remove(i);
			
			if(bolhasBlue.get(i).getX() > 960 || bolhasBlue.get(i).getX() < 2)
				bolhasBlue.remove(i);
		}
		
		for (int i = 0; i < gotasBlue.size(); i++) {
			Gota g = (Gota) gotasBlue.get(i);

			if (g.isVsivel()){
				g.mexer();
				if(personagemBlue.getX() >= 465)
					gotasBlue.get(i).incX(-2);
			}
			
			else
				gotasBlue.remove(i);
			
			if(gotasBlue.get(i).getY() > 672)
				gotasBlue.remove(i);
		}

		for (int i = 0; i < bolhasRed.size(); i++) {
			Bolha b = (Bolha) bolhasRed.get(i);

			if (b.isVsivel()) {
				b.mexer();
				if(personagemRed.getX() <= 465)
					bolhasRed.get(i).setVelocidade(2);
				
				else
					bolhasRed.get(i).setVelocidade(-2);
			}

			else
				bolhasRed.remove(i);
			
			if(bolhasRed.get(i).getX() > 960 || bolhasRed.get(i).getX() < 2)
				bolhasRed.remove(i);
		}

		for (int i = 0; i < gotasRed.size(); i++) {
			Gota g = (Gota) gotasRed.get(i);

			if (g.isVsivel()) {
				g.mexer();
				if(personagemRed.getX() >= 465)
					gotasRed.get(i).incX(-2);
			}

			else
				gotasRed.remove(i);
			
			if(gotasRed.get(i).getY() > 672 || gotasRed.get(i).getY() == 0)
				gotasRed.remove(i);
		}
		
		colisao();
		personagemBlue.mexer();
		personagemRed.mexer();
		repaint();
	}
	
	public void colisao() {
		bolhasBlue = personagemBlue.getBolhas();
		gotasBlue = personagemBlue.getGotas();
		bolhasRed = personagemRed.getBolhas();
		gotasRed = personagemRed.getGotas();
		
		for (int i = 0; i < bolhasBlue.size(); i++)
			if (personagemRed.getBounds().intersects(bolhasBlue.get(i).getBounds())) {
				bolhasBlue.remove(i);
				personagemRed.decVida(1);
			}
		
		for (int i = 0; i < gotasBlue.size(); i++)
			if (personagemRed.getBounds().intersects(gotasBlue.get(i).getBounds())) {
				gotasBlue.remove(i);
				personagemRed.decVida(1);
			}
		
		for (int i = 0; i < bolhasRed.size(); i++)
			if (personagemBlue.getBounds().intersects(bolhasRed.get(i).getBounds())) {
				bolhasRed.remove(i);
				personagemBlue.decVida(1);
			}
		
		for (int i = 0; i < gotasRed.size(); i++)
			if (personagemBlue.getBounds().intersects(gotasRed.get(i).getBounds())) {
				gotasRed.remove(i);
				personagemBlue.decVida(1);
			}
	}

	//Caso o usuário aperte enter no menu inicial
	private class TecladoAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			personagemBlue.keyPressed(e);
			personagemRed.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			personagemBlue.keyReleased(e);
			personagemRed.keyReleased(e);
		}
	}
}