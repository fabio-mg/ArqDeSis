package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Geral.ConnectionFactory;
import TO.CursoInformaticaTO;

public class CursoInformaticaDAO {
	
	public void incluir(CursoInformaticaTO to) {		
		String sqlStr = " Insert into TabCurso_Infor (TabCurso_IdTabCurso, Num_Laboratorio, Softwares) " + 
						" Values (?, ?, ?) ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, to.getIdCurso());
			stm.setInt(2, to.getNumeroLaboratorio());
			stm.setString(3, to.getSoftwares());
			
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(CursoInformaticaTO to) {		
		String sqlStr = " Update TabCurso_Infor set Num_Laboratorio = ?, Softwares = ? " + 
						" Where IdTabCurso_Infor = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, to.getNumeroLaboratorio());
			stm.setString(2, to.getSoftwares());
			stm.setInt(3, to.getIdCursoInformatica());
			
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(CursoInformaticaTO to) {
		String sqlStr = " Delete From TabCurso_Infor " + 
						" Where IdTabCurso_Infor = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, to.getIdCursoInformatica() );
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CursoInformaticaTO carregar(int id) {
		CursoInformaticaTO to = new CursoInformaticaTO(); 
		
		String sqlStr = " Select * From TabCurso_Infor " +
						" Where IDTabCurso_Infor = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {

				if (rs.next()) {
					to.setIdCursoInformatica( rs.getInt("IdTabCurso_Infor") );
					to.setNumeroLaboratorio( rs.getInt("Num_Laboratorio") );
					to.setSoftwares( rs.getString("Softwares") );
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
