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

import javax.swing.JFrame;

import br.com.unip.cc.control.Batalha;

/**
 * Esta classe representa o campo de batalha do jogo
 * 
 * @version 0.1 09/Set/2016
 * @author Gabriel Batista
 */

public class JFBatalha extends JFrame{
	private static final long serialVersionUID = 1L;
	private Batalha painel = null;
	
	public JFBatalha() {
		super();
		initialize();
		setVisible(true);
	}
	
	public void initialize() {
		painel = new Batalha();
		painel.setBounds(0, 0, 997, 672);
		this.setSize(997,672);
		this.setTitle("Batalha Gênesis");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(150, 150, 997,672);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(painel);
	}
}
