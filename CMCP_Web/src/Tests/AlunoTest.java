package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Modelo.Aluno;

public class AlunoTest {
	private Aluno aluno;
	
	@Before
	public void setUp() {
		aluno = new Aluno();
		aluno.setNome("Teste JUnit");
		aluno.setEndereco("Endereco Teste JUnit");
		aluno.setRG("999999999");
		aluno.setCPF("99999999999");
		aluno.setEmail("email_junit_teste");
		aluno.setLogin("login_junit");
		aluno.setSenha("senha_junit");
		aluno.setTelefone("99999999");		
	}

	@Test
	public void testaInclusao() {
		aluno.incluir();
		Aluno alunoTest;
		alunoTest = new Aluno();
		alunoTest.setIdAluno(aluno.getIdAluno());
		alunoTest.carregar();
		assertEquals(aluno, alunoTest);
	}
	
	
	@Test
	public void testaAlteracao() {
		aluno.incluir();
		aluno.setNome("Alterando inclusao");
		aluno.atualizar();
		
		Aluno alunoTest;
		alunoTest = new Aluno();
		alunoTest.setIdAluno(aluno.getIdAluno());
		alunoTest.carregar();
			
		assertEquals(aluno.getNome(), alunoTest.getNome());
	}
	
	
	@Test
	public void testaExclusao() {
		aluno.excluir();
			
		Aluno alunoTest;
		alunoTest = new Aluno();
		alunoTest.setIdAluno(aluno.getIdAluno());
		alunoTest.carregar();
		
		assertEquals(alunoTest, new Aluno());
	}
	
}
