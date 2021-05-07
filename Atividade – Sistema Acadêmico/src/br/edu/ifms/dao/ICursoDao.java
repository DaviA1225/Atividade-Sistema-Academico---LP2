package br.edu.ifms.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifms.model.Cursos;

public interface ICursoDao {

	void cadastrar (Cursos curso);
	void editar(Cursos curso);
	void excluir(int codigo);
	void excluir(Cursos curso);
	List<Cursos> buscarTodos() throws SQLException;
	Cursos buscar(int codigo);
}
