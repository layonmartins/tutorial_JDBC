package tutorial_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class InsereManuscrito {

	public static void main(String[] args) {
		try {
			//abrindo uma conexão
			Connection conexao = ConnectionFactory.createConnection();
			JOptionPane.showMessageDialog(null, "Conexão aberta com sucesso!"); //exibe uma janela de mensagem
			
			//vamos salvar em variaveis os dados que serão inseridos no banco
			String titulo = JOptionPane.showInputDialog("Digite o titulo do manuscrito:");
			String autor = JOptionPane.showInputDialog("Digite o autor do manuscrito:");
			
			//criar o SQL para inserir dados no banco
			String sql = "insert into manuscrito(titulo, autor) values (?,?)";
			
			//criando um comando para passar o sql
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, titulo); //Passando os parametros do sql
			cmd.setString(2, autor); //Obs: caso fosse do tipo inteiro seria cmd.setInt()
			
			//executa o comando
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!"); //exibe uma janela de mensagem
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
