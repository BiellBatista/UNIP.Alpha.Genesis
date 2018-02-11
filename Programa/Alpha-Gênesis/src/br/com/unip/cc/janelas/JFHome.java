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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.unip.cc.music.TocarSom;

/**
 * Esta classe representa o menu do jogo
 * 
 * @version 0.1 02/Set/2016
 * @author Gabriel Batista
 */

public class JFHome extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lblMenu = null;
	private JButton btnJogar = null;
	private JButton btnRecordes = null;
	private JButton btnSobre = null;
	private JButton btnSair = null;
	
	public JFHome() {
		super();
		initialize();
		TocarSom.som("Game_music");
	}
	
	public void initialize() {
		this.setSize(997,672);
		this.setContentPane(getJContentPane());
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(150, 150, 997,672);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblMenu = new JLabel("");
			lblMenu.setBounds(0, 0, 997, 672); //posi��o da imagem
			lblMenu.setIcon(new ImageIcon("res//tela_princpal2.png")); //imagem de fundo
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblMenu, null);
			jContentPane.add(getBtnJogar(), null);
			jContentPane.add(getBtnRecordes(), null);
			jContentPane.add(getBtnSobre(), null);
			jContentPane.add(getBtnSair(), null);
		}
		
		return jContentPane;
	}
	
	private JButton getBtnJogar() {
		if(btnJogar == null) {
			btnJogar = new JButton();
			btnJogar.setBounds(new Rectangle(320, 180, 362, 72));
			btnJogar.setText("");
			btnJogar.setIcon(new ImageIcon("res//iniciar.png"));
			btnJogar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					@SuppressWarnings("unused")
					JFModo modo = new JFModo();
				}
			});
		}
		
		 return btnJogar;
	}
	
	private JButton getBtnRecordes() {
		if(btnRecordes == null) {
			btnRecordes = new JButton();
			btnRecordes.setBounds(320, 300, 362, 72);
			btnRecordes.setIcon(new ImageIcon("res//Recordes.png"));
			btnRecordes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					@SuppressWarnings("unused")
					JFRecordes recordes = new JFRecordes();
				}
			});
			
		}
		return btnRecordes;
	}
	
	private JButton getBtnSobre() {
		if(btnSobre == null) {
			btnSobre = new JButton();
			btnSobre.setBounds(new Rectangle(320, 420, 362, 72));
			btnSobre.setText("");
			btnSobre.setIcon(new ImageIcon("res//sobre.png"));
			btnSobre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "- Gabriel de Almeida Batista\n- Felipe da Silva Borges Neves\n- Felipe Cunha Santos\n- Jos� Vitor Zanoni da Costa", "Equipe de Desenvolvimento", JOptionPane.PLAIN_MESSAGE);
				}
			});
		}
		return btnSobre;
	}
	
	private JButton getBtnSair() {
		if(btnSair == null) {
			btnSair = new JButton();
			btnSair.setBounds(new Rectangle(320, 540, 362, 72));
			btnSair.setText("");
			btnSair.setIcon(new ImageIcon("res//sair.png"));
			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btnSair;
	}
}