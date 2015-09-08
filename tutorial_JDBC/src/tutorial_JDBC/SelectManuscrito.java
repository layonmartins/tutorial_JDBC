package tutorial_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectManuscrito {

	public static void main(String[] args) {
		try {
			//abrindo uma conexão
			Connection conexao = ConnectionFactory.createConnection();
			JOptionPane.showMessageDialog(null, "Conexão aberta com sucesso!"); //exibe uma janela de mensagem
			
			//criar o SQL para extrai dados do banco
			String sql = "select * from manuscrito";
			//criando comando...
			PreparedStatement cmd = conexao.prepareStatement(sql);
			//executando o comando...
			ResultSet resultado = cmd.executeQuery(); //resultado recebe o os dados da consulta
			
			String manuscritos; //variavel para receber os dados 
			manuscritos = "<< Manuscritos encontrados >>\n";
			while(resultado.next()){ //percorre todos os dados do retorno da consulta
				 manuscritos += "ID -> " + resultado.getInt("id") //add cada item na string manuscritos
						 + " - Titulo -> " + resultado.getString("titulo")
						 + " - Autor -> " + resultado.getString("autor")
						 + "\n";
			}
			JOptionPane.showMessageDialog(null, manuscritos); //exibe os manuscritos
			conexao.close(); //fecha a conexão
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
