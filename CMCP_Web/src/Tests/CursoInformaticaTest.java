package Tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Modelo.CursoInformatica;

public class CursoInformaticaTest {

	CursoInformatica cursoInformatica;
	
	@Before
	public void setUp() throws ParseException {
		cursoInformatica = new CursoInformatica();
		cursoInformatica.setNome("Teste JUnit");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = format.parse("05/03/2016");
		Calendar calDtIni = Calendar.getInstance();
		calDtIni.setTime(data);
		cursoInformatica.setDataInicio( calDtIni );
		Calendar calDtFin = Calendar.getInstance();
		calDtFin.setTime(data);
		cursoInformatica.setDataTermino( calDtFin );
		cursoInformatica.setHorario("10:00");
		cursoInformatica.setNumeroVagas(10);
		cursoInformatica.setValor( new BigDecimal(1820.00) );
		cursoInformatica.setNumeroLaboratorio(500);
		cursoInformatica.setSoftwares("Softwares teste");
	}

	@Test
	public void testaInclusao() {
		cursoInformatica.incluir();
		CursoInformatica cursoInformaticaTest;
		cursoInformaticaTest = new CursoInformatica();
		cursoInformaticaTest.setIdCurso(cursoInformatica.getIdCurso());
		cursoInformaticaTest.carregar();
		
		assertEquals(cursoInformatica, cursoInformaticaTest);
	}
	
	
	@Test
	public void testaAlteracao() {
		cursoInformatica.incluir();
		cursoInformatica.setNome("Alterando inclusao");
		cursoInformatica.atualizar();
		
		CursoInformatica cursoInformaticaTest;
		cursoInformaticaTest = new CursoInformatica();
		cursoInformaticaTest.setIdCurso(cursoInformatica.getIdCurso());
		cursoInformaticaTest.carregar();
			
		assertEquals(cursoInformatica.getNome(), cursoInformaticaTest.getNome());
	}
	
	
	@Test
	public void testaExclusao() {
		cursoInformatica.excluir();
			
		CursoInformatica cursoInformaticaTest;
		cursoInformaticaTest = new CursoInformatica();
		cursoInformaticaTest.setIdCurso(cursoInformatica.getIdCurso());
		cursoInformaticaTest.carregar();
		
		assertEquals(cursoInformaticaTest, new CursoInformatica());
	}


}
