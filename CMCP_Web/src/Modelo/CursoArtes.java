package Modelo;
import DAO.CursoArtesDAO;
import TO.CursoArtesTO;

public class CursoArtes extends Curso {
	private int idCursoArtes;
	private String materiais;
	private String livros;

	public int getIdCursoArtes() {
		return idCursoArtes;
	}

	public void setIdCursoArtes(int idCursoArtes) {
		this.idCursoArtes = idCursoArtes;
	}

	public String getMateriais() {
		return materiais;
	}

	public void setMateriais(String materiais) {
		this.materiais = materiais;
	}

	public String getLivros() {
		return livros;
	}

	public void setLivros(String livros) {
		this.livros = livros;
	}
	
	
	public CursoArtesTO getCursoArtesTO() {
		CursoArtesTO to = new CursoArtesTO();
		
		to.setIdCurso(getIdCurso());
		to.setIdCursoArtes(getIdCursoArtes());
		to.setMateriais(getMateriais());
		to.setLivros(getLivros());
		
		return to;
	}
	
	@Override
	public void incluir() {
		super.incluir();
		
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = getCursoArtesTO();
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
		
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = getCursoArtesTO();
		try {
			dao.atualizar(to);
		} finally {
			dao = null;
			to = null;
		}
	}
	
	@Override
	public void excluir() {
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = getCursoArtesTO();
		try {
			dao.atualizar(to);
			super.excluir();
		} finally {
			dao = null;
			to = null;
		}
	}

	@Override
	public void carregar() {
		super.carregar();
		
		CursoArtesDAO dao = new CursoArtesDAO();
		CursoArtesTO to = dao.carregar( getIdCurso() );
		
		try {
			setIdCursoArtes(to.getIdCursoArtes());
			setMateriais(to.getMateriais());
			setLivros(to.getMateriais());
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
		CursoArtes other = (CursoArtes) obj;
		if (getIdCursoArtes() != other.getIdCursoArtes())		  
			return false;
		return super.equals(obj);
	}
	

}
