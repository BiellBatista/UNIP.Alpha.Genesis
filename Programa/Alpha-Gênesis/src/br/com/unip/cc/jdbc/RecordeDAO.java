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