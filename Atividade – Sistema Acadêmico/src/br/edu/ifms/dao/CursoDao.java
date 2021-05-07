package br.edu.ifms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifms.exception.CursoDaoEX;
import br.edu.ifms.model.Cursos;

public class CursoDao implements ICursoDao {

	@Override
	public void cadastrar(Cursos curso) {
		// TODO Auto-generated method stub
		
		if (curso != null && curso.isValid() && curso.getCodigo() == 0) {
			
			String sql = " insert into cursos (codigo, nivel, nome, cargaHoraria, situacao) values (?,?,?,?,?)";
					
			try (Connection conexao = ConnectionFactory.getConnection();
					PreparedStatement statement = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
				
				statement.setInt(1, curso.getCodigo());
				statement.setInt(2, curso.getNivel());
				statement.setString(3, curso.getNome());
				statement.setInt(4, curso.getCargaHoraria());
				statement.setBoolean(5, curso.Situacao());
				
				statement.executeUpdate();
				
				try (ResultSet result = statement.getGeneratedKeys()){
					
					if(result.next()){
						curso.setCodigo(result.getInt(1));
					}
				}
				
			}catch(Exception e) {
				throw new CursoDaoEX(e.getMessage());
			}
		}
	}

	@Override
	public void editar(Cursos curso) {
		// TODO Auto-generated method stub
		
		if(curso != null && curso.isValid() && curso.getCodigo() > 0) {
			
			String sqlUpdate = "update Cursos set curso=?, nivel=? where codigo =?";
			
			try(Connection conexao = ConnectionFactory.getConnection();
					PreparedStatement statement = conexao.prepareStatement(sqlUpdate)){
				
				statement.setInt(1, curso.getCodigo());
				statement.setInt(2, curso.getNivel());
				statement.setString(3, curso.getNome());
				
			}catch(Exception e) {
				throw new CursoDaoEX(e.getMessage());
			}
		}
		
	}

	@Override
	public void excluir(int codigo) {
		// TODO Auto-generated method stub
		
		String sqlUpdate = "delete from cursos where Codigo = ?";
		
		if(codigo > 0) {

			try (Connection conexao = ConnectionFactory.getConnection();
					PreparedStatement statement = conexao.prepareStatement(sqlUpdate)){
				
				statement.setInt(1, codigo);
				
				if(statement.executeUpdate() == 0) {
					throw new CursoDaoEX("CURSO NÃO INDIPONÍVEL");
				}
			}catch(Exception e) {
				throw new CursoDaoEX(e.getMessage());
			}
		}
		
		
	}

	@Override
	public void excluir(Cursos curso) {
		// TODO Auto-generated method stub
		
		if(curso != null && curso.getCodigo()>0) {
			this.excluir(curso.getCodigo());
			
		}
	}

	@Override
	public List<Cursos> buscarTodos() throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from cursos";
		
		try(Connection conexao = ConnectionFactory.getConnection();
				PreparedStatement statement = conexao.prepareStatement(sql)){
			
			try(ResultSet result = statement.executeQuery()){
				
				List<Cursos> cursos = new ArrayList<Cursos>();
				
				while (result.next()) {
					
					Cursos curso = new Cursos();
					
					curso.setCodigo(result.getInt("CÓDIGO"));
					curso.setNivel(result.getInt("NÌVEL"));
					curso.setNome(result.getString("NOME"));
					curso.add(curso);
					
				}
				
				return cursos;
				
			}catch(Exception e) {
				throw new CursoDaoEX(e.getMessage());
			}
		}
	}

	@Override
	public Cursos buscar(int codigo) {
		// TODO Auto-generated method stub
		
		if (codigo > 0) {
			
			String sql = "select * from Cursos where codigo = ?";
			try(Connection conexao = ConnectionFactory.getConnection();
					PreparedStatement statement = conexao.prepareStatement(sql)){
				
				statement.setInt(1, codigo);
				
				try(ResultSet result = statement.executeQuery()){
					
					if (result.next()) {
						
						Cursos cursos = new Cursos();
						cursos.setCodigo(result.getInt("NOME"));
						cursos.setNome(result.getString("NOME"));
						cursos.setNivel(result.getInt("NÍVEL"));
						return cursos;
					}
					
				}
			}catch(Exception e) {
				throw new CursoDaoEX(e.getMessage());
			}
		}else {
			throw new CursoDaoEX("CÓDIGO INVÁLIDO");
		}
		
		return null;
	}

	
}
