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
			lblModo.setBounds(0, 0, 997, 672); //posi��o da imagem
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