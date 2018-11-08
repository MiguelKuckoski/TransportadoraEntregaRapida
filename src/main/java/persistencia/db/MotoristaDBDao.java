package persistencia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entidade.Motorista;
import persistencia.idao.IMotoristaDao;

public class MotoristaDBDao implements IMotoristaDao {

	@Override
	public void inserir(Motorista motorista) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		String sql = "insert into motorista(nome, data_nasc, cnh_num, cnh_tipo, endereco, veiculo) values(?,?,?,?,?,?)";
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, motorista.getNome());
			statement.setString(2, motorista.getNascimento());
			statement.setString(3, motorista.getCnhNum());
			statement.setString(4, motorista.getCnhTipo());
			statement.setString(5, motorista.getEndereco());
			statement.setBoolean(6, motorista.getVinculadoCarro());
			
			statement.execute();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public Map<String, Motorista> listar() {
		Connection con = Conexao.getConnection();
		String sql = "select * from motorista";
		PreparedStatement statement = null; 
		ResultSet rs = null;
		Map<String, Motorista> motoristas = new HashMap<>();
		
		try {
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				Motorista motorista = new Motorista();
				motorista.setNome(rs.getString("nome"));
				motorista.setNascimento(rs.getString("data_nasc"));
				motorista.setCnhNum(rs.getString("cnh_num"));
				motorista.setCnhTipo(rs.getString("cnh_tipo"));
				motorista.setEndereco(rs.getString("endereco"));
				motorista.setVinculadoCarro(rs.getBoolean("veiculo"));
				motoristas.put(motorista.getCnhNum(), motorista);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return motoristas;
	}

	@Override
	public void atualizar(Motorista motorista, String cnhNum) {
		Connection con = Conexao.getConnection();
		String sql = "update motorista set nome = ?, data_nasc = ?, cnh_num =?, cnh_tipo =?, endereco = ?, veiculo = ? where cnh_num = ?";
		PreparedStatement statement = null; 
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, motorista.getNome());
			statement.setString(2, motorista.getNascimento());
			statement.setString(3, motorista.getCnhNum());
			statement.setString(4, motorista.getCnhTipo());
			statement.setString(5, motorista.getEndereco());
			statement.setBoolean(6, motorista.getVinculadoCarro());
			statement.setString(7, cnhNum);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void remover(Motorista motorista) {
		Connection con = Conexao.getConnection();
		String sql = "delete from motorista where cnh_num = ?";
		PreparedStatement statement = null; 
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, motorista.getCnhNum());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}