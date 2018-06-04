package mat.web.service;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

public class UsuarioDAO {
	
	public boolean inserirUsuario(Usuario usuario){
		
		try {
			Connection conn = ConexaoMysql.obtemConexao();
			
			String queryInserir = "INSERT INTO usuario VALUES(null,?,?);";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setString(1, usuario.getNome());
			ppStm.setInt(2, usuario.getIdade());
			
			ppStm.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	 public boolean atualizarUsuario(Usuario usuario){
		
		try {
			Connection conn = ConexaoMysql.obtemConexao();
			
			String queryAtualizar = "UPDATE usuario SET nome = ?, idade = ? WHERE id = ?;";
			
			PreparedStatement ppStm = conn.prepareStatement(queryAtualizar);
			
			ppStm.setString(1, usuario.getNome());
			ppStm.setInt(2, usuario.getIdade());
			ppStm.setInt(3, usuario.getId());
			
			ppStm.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
		
	public boolean excluirUsuario(Usuario usuario){
		try {
			Connection conn = ConexaoMysql.obtemConexao();
			
			String queryExcluir = "DELETE FROM usuario WHERE id = ?;";
			
			PreparedStatement ppStm = conn.prepareStatement(queryExcluir);

			ppStm.setInt(1, usuario.getId());
			
			ppStm.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;		
	}
	
	public ArrayList<Usuario> buscarTodosUsuarios(){
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			Connection conn = ConexaoMysql.obtemConexao();
			
			String queryBuscarTodos = "SELECT * FROM usuario";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarTodos);

			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Usuario usr = new Usuario();
				
				usr.setId(rSet.getInt(1));
				usr.setNome(rSet.getString(2));
				usr.setIdade(rSet.getInt(3));
				
				lista.add(usr);
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return lista;
	}
	
	public Usuario buscarUsuarioPorID(int id){
		
		Usuario usr = null;
		
		try {
			Connection conn = ConexaoMysql.obtemConexao();
			
			String queryBuscarPorID = "SELECT * FROM usuario WHERE id = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryBuscarPorID);

			ppStm.setInt(1, id);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if(rSet.next()){
				usr = new Usuario();
				
				usr.setId(rSet.getInt(1));
				usr.setNome(rSet.getString(2));
				usr.setIdade(rSet.getInt(3));
			}else{
				return usr;
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return usr;
	}
	
	public boolean excluirUsuario(int id){
		
		return excluirUsuario(new Usuario(id, "",0));
	}
	
}

