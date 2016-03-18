package Modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import DAO.CursoDAO;
import TO.CursoTO;

public class Curso {
	private int idCurso;
	private String nome;
	private Calendar dataInicio;
	private Calendar dataTermino;
	private String horario;
	private int numeroVagas;
	private BigDecimal valor;

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	public CursoTO getCursoTO() {
		CursoTO to = new CursoTO();
		
		to.setIdCurso(getIdCurso());
		to.setNome(getNome());
		to.setDataInicio(getDataInicio());
		to.setDataTermino(getDataTermino());
		to.setHorario(getHorario());
		to.setNumeroVagas(getNumeroVagas());
		to.setValor(getValor());
		
		return to;
	}
	
	
	public void incluir() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = getCursoTO();
		try {
			dao.incluir(to);
			setIdCurso(to.getIdCurso());
		} finally {
			dao = null;
			to = null;
		}
	}
	
	
	public void atualizar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = getCursoTO();
		try {
			dao.atualizar(to);
		} finally {
			dao = null;
			to = null;
		}
	}
	
	
	public void excluir() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = getCursoTO();
		try {
			dao.atualizar(to);
		} finally {
			dao = null;
			to = null;
		}
	}

	
	public void carregar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = dao.carregar( getIdCurso() );
		
		try {

			setIdCurso(to.getIdCurso());
			setNome(to.getNome());
			setDataInicio(to.getDataInicio());
			setDataTermino(to.getDataTermino());
			setHorario(to.getHorario());
			setNumeroVagas(to.getNumeroVagas());
			setValor(to.getValor());
		
		} finally {
			dao = null;
			to = null;
		}
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if ( getIdCurso() != other.getIdCurso())		  
			return false;
		return true;
	}
	
}
