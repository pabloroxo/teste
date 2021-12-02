import java.sql.ResultSet;
import java.util.ArrayList;

public class GatoRepositorio {
	private BD bd;

	public GatoRepositorio(BD bd) {
		this.bd = bd;
	}
	
	public void cadastrar(Gato gato) {
		String query = "INSERT INTO "
					 + "gato "
					 + "(nome, cor, raca) "
					 + "VALUES "
					 + "('" + gato.getNome() + "', "
					 + "'" + gato.getCor() + "', "
					 + "'" + gato.getRaca() + "');";
		this.bd.executeUpdate(query);
	}
	
	public Gato obter(int id) {
		String query = "SELECT * FROM gato WHERE id = " + id + ";";
		ResultSet dados = this.bd.executeQuery(query);
		Gato gato = new Gato();
		try {
			dados.next();
			gato.setId(dados.getInt("id"));
			gato.setNome(dados.getString("nome"));
			gato.setRaca(dados.getString("raca"));
			gato.setCor(dados.getString("cor"));
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return gato;
	}
	
	public ArrayList<Gato> listar() {
		String query = "SELECT * FROM gato;";
		ResultSet dados = this.bd.executeQuery(query);
		ArrayList<Gato> gatos = new ArrayList<>();
		try {
			while(dados.next()) {
				Gato gato = new Gato();
				gato.setId(dados.getInt("id"));
				gato.setNome(dados.getString("nome"));
				gato.setRaca(dados.getString("raca"));
				gato.setCor(dados.getString("cor"));
				gatos.add(gato);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return gatos;
	}

	public void excluir(int id) {
		String query = "DELETE FROM gato WHERE id = " + id + ";";
		this.bd.executeUpdate(query);
	}

	public void editar(Gato gato) {
		String query = "UPDATE gato SET "
				     + "nome = '" + gato.getNome() + "', "
				     + "raca = '" + gato.getRaca() + "', "
				     + "cor = '" + gato.getCor() + "' "
				     + "WHERE id = " + gato.getId() + ";";
		this.bd.executeUpdate(query);
	}
}
