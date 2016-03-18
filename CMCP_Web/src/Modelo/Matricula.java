package Modelo;
import java.util.Calendar;
import java.util.Currency;

public class Matricula {
	private int idMatricula;
	private Calendar data;
	private String status;
	private Currency valor;
	private String statusPagto;
	private int idCurso;
	private int idAluno;

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Currency getValor() {
		return valor;
	}

	public void setValor(Currency valor) {
		this.valor = valor;
	}

	public String getStatusPagto() {
		return statusPagto;
	}

	public void setStatusPagto(String statusPagto) {
		this.statusPagto = statusPagto;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
}
