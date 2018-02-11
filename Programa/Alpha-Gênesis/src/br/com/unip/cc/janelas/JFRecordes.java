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

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.com.unip.cc.jdbc.JogadorDAO;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

/**
 * Esta classe representa o painel de recordes
 * 
 * @version 0.1 09/Set/2016
 * @author Gabriel Batista
 */

public class JFRecordes extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JList listRecordes;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JFRecordes() {
		setTitle("Recordes");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 354, 223);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		listRecordes = new JList(listaJogador());

		scrollPane = new JScrollPane(listRecordes);
		scrollPane.setBounds(5, 35, 340, 150);
		contentPane.add(scrollPane);
		
		JLabel lblRecordes = new JLabel("Lista de Recordes");
		lblRecordes.setForeground(Color.RED);
		lblRecordes.setFont(new Font("Arial", Font.BOLD, 13));
		lblRecordes.setBounds(125, 11, 119, 14);
		contentPane.add(lblRecordes);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DefaultListModel listaJogador() {
		try {
			DefaultListModel lista = new DefaultListModel();
			JogadorDAO player = new JogadorDAO();
			ResultSet rs = player.pesquisar();

			for(int i = 0; i < 10; i++)
				if(rs.next())
					lista.addElement(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3));
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}