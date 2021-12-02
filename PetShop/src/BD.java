import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class BD {
	private final String servidor = "jdbc:mariadb://localhost:3306/petshop",
						 usuario = "root",
						 senha = "",
						 driver = "org.mariadb.jdbc.Driver";
	private Connection conexao;
	private Statement statement;
	
	public void conectar() {
		try {
			Class.forName(this.driver);
			this.conexao = DriverManager.getConnection(this.servidor, this.usuario, this.senha);
			this.statement = this.conexao.createStatement();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ResultSet executeQuery(String query) {
		ResultSet resultado = null;
		try {
			resultado = this.statement.executeQuery(query);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}
	
	public void executeUpdate(String query) {
		try {
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
