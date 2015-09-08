

package tutorial_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection createConnection() { 
		String stringDeConexao = "jdbc:mysql://localhost:3306/manuscritos"; //url do driver jdbc
		String usuario = "root"; //seu usuario do banco de dados
		String senha = "root"; //sua senha do banco de dados
		Connection conexao = null;
		
		try{
			conexao = DriverManager.getConnection(stringDeConexao, usuario, senha); //cria uma conexão
		} catch(Exception e ){
			e.printStackTrace();
		}
		return conexao; //retorna a conexão
	}
}