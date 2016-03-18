package Geral;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Modelo.Aluno;
import Modelo.CursoArtes;
import Modelo.CursoInformatica;

public class MainTest {
	public static void main (String args[]) throws ParseException {
		
		//teste de inclusão de aluno
		Aluno aluno = new Aluno();
		aluno.setNome("Fabio Miranda Goncalves");
		aluno.setEndereco("Rua Humberto Benemeritti, 240");
		aluno.setTelefone("58424834");
		aluno.setEmail("fabio.mir.gon@hotmail.com");
		aluno.setRG("491490343");
		aluno.setCPF("41009788809");
		aluno.setLogin("fabiomg");
		aluno.setSenha("teste");
		aluno.incluir();
		aluno.setIdAluno(10);
		
		aluno.carregar();
		
		
		CursoArtes cursoArtes = new CursoArtes();
		cursoArtes.setNome("Nome do Curso de Artes");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = format.parse("05/03/2016");
		Calendar calDtIni = Calendar.getInstance();
		calDtIni.setTime(data);
		cursoArtes.setDataInicio( calDtIni );
		Calendar calDtFin = Calendar.getInstance();
		calDtFin.setTime(data);
		cursoArtes.setDataTermino( calDtFin );
		cursoArtes.setNumeroVagas(1800);
		cursoArtes.setValor( new BigDecimal(1820.00) );
		cursoArtes.setHorario("10:40");
		cursoArtes.setLivros("Livros gerais");
		cursoArtes.setMateriais("Lapis e caneta");
		cursoArtes.incluir();
		
		
		CursoInformatica cursoInformatica = new CursoInformatica();
		cursoInformatica.setNome("Nome do Curso de Informatia");
		SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
		Date data2 = format2.parse("05/03/2016");
		Calendar calDtIni2 = Calendar.getInstance();
		calDtIni2.setTime(data2);
		cursoInformatica.setDataInicio( calDtIni2 );
		Calendar calDtFin2 = Calendar.getInstance();
		calDtFin2.setTime(data2);
		cursoInformatica.setDataTermino( calDtFin2 );
		cursoInformatica.setNumeroVagas(1800);
		cursoInformatica.setValor( new BigDecimal(1820.00) );
		cursoInformatica.setHorario("10:40");
		cursoInformatica.setNumeroLaboratorio(777);
		cursoInformatica.setSoftwares("Microsoft Office");
		cursoInformatica.incluir();		
	}
}
