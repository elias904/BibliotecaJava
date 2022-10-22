package persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Fabrica.Fabrica;
import entidade.EmprestimoEntidade;
import entidade.Entidade;
import visao.Visao;

public class EmprestimoPersistencia extends Persistencia{
	static java.io.File diretorio = null;
	static java.io.File arquivo;
	private static FileWriter texto = null;
	private static PrintWriter escrito = null;
	//Lista de Emprestimo
	private static List<Entidade> emprestimos = new ArrayList<Entidade>();
	//Declaração da classe como singleton
	private static EmprestimoPersistencia uniqueInstance;
	
	private EmprestimoPersistencia() {
	}
	public static synchronized EmprestimoPersistencia getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new EmprestimoPersistencia();
			diretorio = new java.io.File("/home/eliasmnds/Desktop/UFSJ 2022.2/EngSoftware");
			arquivo = new java.io.File(diretorio, "emprestimos.txt");
		return uniqueInstance;
	}
	//------------------------------------
	//Criar metodo para salvar o array no arquivo
	//Criar metodo para ler o arquivo e salvar no arrays
	@Override
	public void inserir(Entidade emprestimo) throws IOException {
		// TODO Auto-generated method stub
		emprestimo.setId(emprestimos.size() + 1);
		emprestimos.add(emprestimo);
	}
	private void escreverArquivo() throws IOException {
		// TODO Auto-generated method stub
		for(Entidade e: emprestimos) 
		{
			texto = new FileWriter(arquivo, true);
			escrito = new PrintWriter(texto);
			escrito.println("\nEmprestimo:");
			escrito.println("\tId: " + e.getId() + " ");
			escrito.println("\tNome do Livro: " + e.getNomeLivro() + " ");
			escrito.println("\tMatricula Aluno: " + e.getMatriculaAluno() + " ");
			escrito.flush();
			escrito.close();
		}
	}
	//O objetivo é poder verficiar a existência do emprestimo para poder renová-lo
	@Override
	public void alterar(Entidade emprestimoAntigo, Entidade emprestimoNovo) {
		// TODO Auto-generated method stub
		for(Entidade e: emprestimos) 
		{
			if(e.getMatriculaAluno().equals(emprestimoAntigo.getMatriculaAluno())  && e.getNomeLivro().equals(emprestimoAntigo.getNomeLivro())){
				EmprestimoEntidade novoEmprestimo = (EmprestimoEntidade) e;
				novoEmprestimo.setMatriculaAluno(emprestimoNovo.getMatriculaAluno());
				novoEmprestimo.setNomeLivro(emprestimoNovo.getNomeLivro());
				return;
			}
		}
		
	}
	@Override
	public void excluir(Entidade emprestimo) {
		// TODO Auto-generated method stub
		for(Entidade e: emprestimos) 
		{
			if(e.getMatriculaAluno().equals(emprestimo.getMatriculaAluno())  && e.getNomeLivro().equals(emprestimo.getNomeLivro())) {
				emprestimos.remove(e);
				break;
			}
		}
		
	}
	@Override
	public void buscaPorId(int id) {
		// TODO Auto-generated method stub
		for(Entidade e: emprestimos) 
		{
			if(e.getId().equals(id)) {
				Visao visao;
				Fabrica fabrica;
				fabrica = Fabrica.getFactory("Emprestimo");
				visao = fabrica.createVisao();
				visao.viewBusca(e);
				break;
			}
		}
	}
	@Override
	public void buscaPorString(Entidade entidade) {
		// TODO Auto-generated method stub
		
	}
	public void arquivoToArray() {
		
	}
	@Override
	public void visualizar() {
		// TODO Auto-generated method stub
		Visao visao;
		Fabrica fabrica;
		fabrica = Fabrica.getFactory("Emprestimo");
		visao = fabrica.createVisao();
		visao.view(emprestimos);
	}
}
