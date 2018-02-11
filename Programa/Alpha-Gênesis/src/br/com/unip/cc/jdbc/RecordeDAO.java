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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Esta classe cuida de inserir e recuperar jogadores no banco
 * 
 * @version 0.1 07/Nov/2016
 * @author Gabriel Batista
 */

public class RecordeDAO {
	private Connection con = null;
	private PreparedStatement stmt = null;
	private String sql = null;
	/**
	 * metodo que insere um novo jogador na tabela
	 * @param player
	 * @return
	 */
	
	public String inserirRecorde(Jogador player){
		con = Conexao.getConexao();
		sql = "INSERT INTO RECORDES VALUES(?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "INC_REC.NEXTVAL");
			stmt.setString(2, "INC_JOG1.NEXTVAL");
			stmt.setString(3, player.getData().get(Calendar.DAY_OF_MONTH) + "/" + player.getData().get(Calendar.MONTH) + "/" + player.getData().get(Calendar.YEAR));
			stmt.setInt(4, player.getRecord());
			stmt.execute();
			
			return "Inserido com sucesso!";
		} catch(SQLException e) {
			return e.getMessage();
		}
	}
}