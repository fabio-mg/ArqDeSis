package Tests;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import Modelo.Curso;

public class CursoTest {

	private Curso curso;
	
	@Before
	public void setUp() throws ParseException {
		curso = new Curso();
		curso.setNome("Teste JUnit");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = format.parse("05/03/2016");
		Calendar calDtIni = Calendar.getInstance();
		calDtIni.setTime(data);
		curso.setDataInicio( calDtIni );
		Calendar calDtFin = Calendar.getInstance();
		calDtFin.setTime(data);
		curso.setDataTermino( calDtFin );
		curso.setHorario("10:00");
		curso.setNumeroVagas(10);
		curso.setValor( new BigDecimal(1820.00) );		
	}

	@Test
	public void testaInclusao() {
		curso.incluir();
		Curso cursoTest;
		cursoTest = new Curso();
		cursoTest.setIdCurso(curso.getIdCurso());
		cursoTest.carregar();
		
		assertEquals(curso, cursoTest);
	}
	
	
	@Test
	public void testaAlteracao() {
		curso.incluir();
		curso.setNome("Alterando inclusao");
		curso.atualizar();
		
		Curso cursoTest;
		cursoTest = new Curso();
		cursoTest.setIdCurso(curso.getIdCurso());
		cursoTest.carregar();
			
		assertEquals(curso.getNome(), cursoTest.getNome());
	}
	
	
	@Test
	public void testaExclusao() {
		curso.excluir();
			
		Curso cursoTest;
		cursoTest = new Curso();
		cursoTest.setIdCurso(curso.getIdCurso());
		cursoTest.carregar();
		
		assertEquals(cursoTest, new Curso());
	}

}
