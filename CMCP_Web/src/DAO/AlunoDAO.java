package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Geral.ConnectionFactory;
import TO.AlunoTO;

public class AlunoDAO {
	public void incluir(AlunoTO to) {
		String sqlStr = " Insert into TabAluno (Nome, Endereco, Tel_Num, email, rg, cpf, login, senha) "
				+ " Values (?, ?, ?, ?, ?, ?, ?, ?) ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setString(1, to.getNome());
			stm.setString(2, to.getEndereco()); 
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getRG());
			stm.setString(6, to.getCPF());
			stm.setString(7, to.getLogin());
			stm.setString(8, to.getSenha());
			stm.execute();
			
			to.setIdAluno(getLastID(conn));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(AlunoTO to) {
		String sqlStr = " Update TabAluno Set " + " Nome = ? " + ",Endereco = ? " + ",Tel_Num = ?" + ",Email = ?"
				+ ",RG = ?" + ",CPF = ?" + ",Login = ?" + ",Senha = ? " + " Where IDTabAluno = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setString(1, to.getNome());
			stm.setString(2, to.getEndereco());
			stm.setString(3, to.getTelefone());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getRG());
			stm.setString(6, to.getCPF());
			stm.setString(7, to.getLogin());
			stm.setString(8, to.getSenha());
			stm.setInt(9, to.getIdAluno());

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(AlunoTO to) {
		String sqlStr = " Delete From TabAluno " + 
						" Where IDTabAluno = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, to.getIdAluno());
			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public AlunoTO carregar(int id) {
		AlunoTO to = new AlunoTO();
		String sqlStr = " Select * From TabAluno " +
					 " Where IDTabAluno = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {

				if (rs.next()) {
					to.setIdAluno(rs.getInt("IdTabAluno"));
					to.setNome(rs.getString("Nome"));
					to.setEndereco(rs.getString("Endereco"));
					to.setTelefone(rs.getString("Tel_Num"));
					to.setEmail(rs.getString("Email")); 
					to.setRG(rs.getString("RG"));
					to.setCPF(rs.getString("CPF"));
					to.setLogin(rs.getString("Login"));
					to.setSenha(rs.getString("Senha"));
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}				
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return to;
	}
	
	
	private int getLastID(Connection conn) {
		String sqlStr = " SELECT LAST_INSERT_ID() AS LastID ";
		
		int lastId = -1;
		
		try (PreparedStatement stm = conn.prepareStatement(sqlStr);) {
			
			
			try (ResultSet rs = stm.executeQuery();) {

				if (rs.next()) {
					lastId = rs.getInt("LastID");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return lastId;
	}	

}
