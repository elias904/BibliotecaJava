package controlador;

import java.io.IOException;

import entidade.EmprestimoEntidade;
import entidade.Entidade;

public abstract class Controlador {

	public abstract void insereArray(Entidade entidade, int opcao) throws IOException;

	public abstract void alterarEmprestimo(Entidade entidadeAntiga, Entidade entidadeNova);

	public abstract void excluir(Entidade entidade);

	public abstract void visualizar();
	
}
