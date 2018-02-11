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

package br.com.unip.cc.janelas;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta classe representa a escolha de modo de jogo
 * 
 * @version 0.1 11/Set/2016
 * @author Gabriel Batista
 */

public class JFModo extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lblModo = null;
	private JButton btnHistoria = null;
	private JButton btnBatalha = null;
	
	public JFModo() {
		super();
		initialize();
	}
	
	public void initialize() {
		this.setSize(997,672);
		this.setContentPane(getJContentPane());
		this.setTitle("Modo de Jogo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(150, 150, 997,672);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblModo = new JLabel("");
			lblModo.setBounds(0, 0, 997, 672); //posição da imagem
			lblModo.setIcon(new ImageIcon("res//tela_princpal2.png")); //imagem de fundo
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblModo, null);
			jContentPane.add(getBtnHistoria(), null);
			jContentPane.add(getBtnRecordes(), null);
		}
		
		return jContentPane;
	}
	
	private JButton getBtnHistoria() {
		if(btnHistoria == null) {
			btnHistoria = new JButton();
			btnHistoria.setBounds(new Rectangle(320, 180, 362, 72));
			btnHistoria.setText("");
			btnHistoria.setIcon(new ImageIcon("res//Hist.png"));
			btnHistoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					@SuppressWarnings("unused")
					JFase fases = new JFase();
				}
			});
		}
		
		 return btnHistoria;
	}
	
	private JButton getBtnRecordes() {
		if(btnBatalha == null) {
			btnBatalha = new JButton();
			btnBatalha.setBounds(320, 300, 362, 72);
			btnBatalha.setIcon(new ImageIcon("res//P1VP2.png"));
			btnBatalha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					@SuppressWarnings("unused")
					JFBatalha batalha = new JFBatalha();
				}
			});
			
		}
		return btnBatalha;
	}
}