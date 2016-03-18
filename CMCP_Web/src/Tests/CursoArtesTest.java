package Tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import Modelo.CursoArtes;

public class CursoArtesTest {
	CursoArtes cursoArtes;
	
	@Before
	public void setUp() throws ParseException {
		cursoArtes = new CursoArtes();
		cursoArtes.setNome("Teste JUnit");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = format.parse("05/03/2016");
		Calendar calDtIni = Calendar.getInstance();
		calDtIni.setTime(data);
		cursoArtes.setDataInicio( calDtIni );
		Calendar calDtFin = Calendar.getInstance();
		calDtFin.setTime(data);
		cursoArtes.setDataTermino( calDtFin );
		cursoArtes.setHorario("10:00");
		cursoArtes.setNumeroVagas(10);
		cursoArtes.setValor( new BigDecimal(1820.00) );
		cursoArtes.setMateriais("Materiais teste");
		cursoArtes.setLivros("Livros teste");
	}

	@Test
	public void testaInclusao() {
		cursoArtes.incluir();
		CursoArtes cursoArtesTest;
		cursoArtesTest = new CursoArtes();
		cursoArtesTest.setIdCurso(cursoArtes.getIdCurso());
		cursoArtesTest.carregar();
		
		assertEquals(cursoArtes, cursoArtesTest);
	}
	
	
	@Test
	public void testaAlteracao() {
		cursoArtes.incluir();
		cursoArtes.setNome("Alterando inclusao");
		cursoArtes.atualizar();
		
		CursoArtes cursoArtesTest;
		cursoArtesTest = new CursoArtes();
		cursoArtesTest.setIdCurso(cursoArtes.getIdCurso());
		cursoArtesTest.carregar();
			
		assertEquals(cursoArtes.getNome(), cursoArtesTest.getNome());
	}
	
	
	@Test
	public void testaExclusao() {
		cursoArtes.excluir();
			
		CursoArtes cursoArtesTest;
		cursoArtesTest = new CursoArtes();
		cursoArtesTest.setIdCurso(cursoArtes.getIdCurso());
		cursoArtesTest.carregar();
		
		assertEquals(cursoArtesTest, new CursoArtes());
	}

}
