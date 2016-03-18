package Modelo;
import DAO.CursoInformaticaDAO;
import TO.CursoInformaticaTO;

public class CursoInformatica extends Curso {
	private int idCursoInformatica;
	private int numeroLaboratorio;
	private String softwares;

	public int getIdCursoInformatica() {
		return idCursoInformatica;
	}

	public void setIdCursoInformatica(int idCursoInformatica) {
		this.idCursoInformatica = idCursoInformatica;
	}

	public int getNumeroLaboratorio() {
		return numeroLaboratorio;
	}

	public void setNumeroLaboratorio(int numeroLaboratorio) {
		this.numeroLaboratorio = numeroLaboratorio;
	}

	public String getSoftwares() {
		return softwares;
	}

	public void setSoftwares(String softwares) {
		this.softwares = softwares;
	}
	
	
	public CursoInformaticaTO getCursoInformaticaTO() {
		CursoInformaticaTO to = new CursoInformaticaTO();
		
		to.setIdCurso(getIdCurso());
		to.setIdCursoInformatica(getIdCursoInformatica());
		to.setNumeroLaboratorio(getNumeroLaboratorio());
		to.setSoftwares(getSoftwares());
		
		return to;
	}
	
	@Override
	public void incluir() {
		super.incluir();
		
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = getCursoInformaticaTO();
		try {
			dao.incluir(to);
		} finally {
			dao = null;
			to = null;
		}
	}
	
	@Override
	public void atualizar() {
		super.atualizar();
		
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = getCursoInformaticaTO();
		try {
			dao.atualizar(to);
		} finally {
			dao = null;
			to = null;
		}
	}
	
	
	public void excluir() {
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = getCursoInformaticaTO();
		try {
			dao.excluir(to);
			super.excluir();
		} finally {
			dao = null;
			to = null;
		}
	}

	
	public void carregar() {
		super.carregar();
		
		CursoInformaticaDAO dao = new CursoInformaticaDAO();
		CursoInformaticaTO to = dao.carregar( getIdCursoInformatica() );
		try {
			setIdCursoInformatica(to.getIdCursoInformatica());
			setNumeroLaboratorio(to.getNumeroLaboratorio());
			setSoftwares(to.getSoftwares());
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
		CursoInformatica other = (CursoInformatica) obj;
		if (getIdCursoInformatica() != other.getIdCursoInformatica())		  
			return false;
		return super.equals(obj);
	}
}
