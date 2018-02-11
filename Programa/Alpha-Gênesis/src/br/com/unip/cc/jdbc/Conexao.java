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

package br.com.unip.cc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Esta classe cuida da conexao com o SGBD Oracle 11g
 * 
 * @version 0.1 09/Set/2016
 * @author Gabriel Batista
 */

public class Conexao {
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; //url do banco local
	private static String login = "hr"; //usuario do banco
	private static String senha = "hr"; //senha do usuario
	private static Connection con = null; //objeto que aponta para a conexao
	
	public static Connection getConexao() {
		if(con == null){// caso nao exista uma conexao
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver"); //recuperando o driver do oracle
				con = DriverManager.getConnection(url, login, senha); //conectando ao banco
			} catch(ClassNotFoundException e) {//caso nao encontre o driver
				JOptionPane.showMessageDialog(null, "Classe do Driver de conex�o com Oracle n�o encontrada!", e.getMessage(), JOptionPane.ERROR_MESSAGE);
			} catch(SQLException e) { //caso a url ou o login ou a senha esteja incorreto
				JOptionPane.showMessageDialog(null, "Problemas com Par�metros da conex�o!", e.getMessage(), JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return con;
	}
	
	public static void closeConexao() {
		try{
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Erro:N�o foi poss�vel fechar a conex�o com BD!");
		}
	}
}