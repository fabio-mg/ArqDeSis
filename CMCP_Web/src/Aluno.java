public class Aluno {
	private int idAluno;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String RG;
	private String CPF;
	private String login;
	private String senha;

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	private AlunoTO getAlunoTO() {
		AlunoTO to = new AlunoTO();
		
		to.setIdAluno(idAluno);
		to.setNome(nome);
		to.setEndereco(endereco);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setRG(RG);
		to.setCPF(CPF);
		to.setLogin(login);
		to.setSenha(senha);
		
		return to;
	}
	
	public void incluir () {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getAlunoTO();
		try {
			dao.incluir(to);
		} finally {
			dao = null;
			to = null;
		}
	}
	
	public void atualizar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getAlunoTO();
		try {
			dao.atualizar(to);
		} finally {
			dao = null;
			to = null;
		}
	}
	
	
	public void excluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getAlunoTO();
		try {
			dao.excluir(to);
		} finally {
			dao = null;
			to = null;
		}
	}
	
	public void carregar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.carregar( getIdAluno() );
		try {
			
			setNome(to.getNome());
			setEndereco(to.getEndereco());
			setTelefone(to.getTelefone());
			setEmail(to.getEmail());
			setRG(to.getRG());
			setCPF(to.getCPF());
			setLogin(to.getLogin());
			setSenha(to.getSenha());
		
		} finally {
			dao = null;
			to = null;
		}
	}

}
