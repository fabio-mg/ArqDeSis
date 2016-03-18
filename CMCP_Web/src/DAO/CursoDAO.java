package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import Geral.ConnectionFactory;
import TO.CursoTO;

public class CursoDAO {
	public void incluir(CursoTO to) {
		String sqlStr = " Insert into TabCurso (Nome, Data_Inicio, Data_Termino, Horario, Num_Vagas, Valor) "
					  + " Values (?, ?, ?, ?, ?, ?) ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setString(1, to.getNome());
			stm.setDate (2, new java.sql.Date(to.getDataInicio().getTimeInMillis()));
			stm.setDate (3, new java.sql.Date(to.getDataTermino().getTimeInMillis()));
			stm.setString(4, to.getHorario() );
			stm.setInt(5, to.getNumeroVagas());			
			stm.setBigDecimal(6, to.getValor());
			stm.execute();
			
						
			to.setIdCurso(getLastID(conn));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(CursoTO to) {
		String sqlStr = " Update TabCurso Set Nome = ?, Data_Inicio = ?, Data_Termino = ?, Horario = ?, Num_Vagas = ?, Valor = ?" + 
						" Where IdTabCurso = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setString(1, to.getNome());
			stm.setDate (2, new java.sql.Date(to.getDataInicio().getTimeInMillis()));
			stm.setDate (3, new java.sql.Date(to.getDataTermino().getTimeInMillis()));
			stm.setString(4, to.getHorario() );
			stm.setInt(5, to.getNumeroVagas());			
			stm.setBigDecimal(6, to.getValor());
			stm.setInt(7, to.getIdCurso());

			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(CursoTO to) {
		String sqlStr = " Delete From TabCurso " + 
						" Where IDTabCurso = ? ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, to.getIdCurso() );
			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CursoTO carregar(int id) {
		CursoTO to = new CursoTO();
		String sqlStr = " Select * From TabCurso " +
						" Where IDTabCurso = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlStr);) {

			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {

				if (rs.next()) {
					to.setIdCurso( rs.getInt("IdTabCurso") );
					to.setNome( rs.getString("Nome") );
					Calendar dataInicio = Calendar.getInstance();
					dataInicio.setTime(rs.getDate("Data_Inicio"));
					to.setDataInicio( dataInicio );	
					Calendar dataTermino = Calendar.getInstance();
					dataTermino.setTime(rs.getDate("Data_Termino"));
					to.setDataTermino(dataTermino);
					to.setHorario(rs.getString("Horario"));
					to.setNumeroVagas(rs.getInt("Num_Vagas"));
					to.setValor( rs.getBigDecimal("Valor") );
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
