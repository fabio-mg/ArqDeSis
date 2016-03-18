package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Geral.ConnectionFactory;
import TO.CursoArtesTO;

public class CursoArtesDAO {
	public void incluir(CursoArtesTO to) {		
		String sqlStr = " Insert into TabCurso_Artes (TabCurso_IdTabCurso, Desc_Material, Nome_Livro) " + 
						" Values (?, ?, ?) ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, to.getIdCurso());
			stm.setString(2, to.getMateriais());
			stm.setString(3, to.getLivros());
			
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(CursoArtesTO to) {		
		String sqlStr = " Update TabCurso_Artes set Desc_Material = ?, Nome_Livro = ? " + 
						" Where IdTabCurso_Artes = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setString(1, to.getMateriais());
			stm.setString(2, to.getLivros());
			stm.setInt(3, to.getIdCursoArtes());
			
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(CursoArtesTO to) {
		String sqlStr = " Delete From TabCurso_Artes " + 
						" Where IdTabCurso_Artes = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, to.getIdCursoArtes() );
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public CursoArtesTO carregar(int id) {
		CursoArtesTO to = new CursoArtesTO(); 
		
		String sqlStr = " Select * From TabCurso_Artes " +
						" Where TabCurso_IDTabCurso = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {

				if (rs.next()) {
					to.setIdCursoArtes( rs.getInt("IdTabCursoArtes") );
					to.setMateriais( rs.getString("Desc_Material") );
					to.setLivros( rs.getString("Nome_Livro") );
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}				
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return to;
	}
}
