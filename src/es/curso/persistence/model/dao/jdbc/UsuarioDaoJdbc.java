package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import es.curso.model.entity.Usuario;
import es.curso.persistence.model.dao.usuarioDao;

public class UsuarioDaoJdbc implements usuarioDao {

	private Connection cx;

	@Override
	public Usuario searchForUserNamePassword(String userName, String password) {
		
		Usuario usuario = null;
		try {
			//Abrir la conexión.
			abrirConexion();
			//Preparar la sentencia
			PreparedStatement ps = 
					cx.prepareStatement
					("SELECT * FROM USUARIO WHERE userName=? AND password=?");
			//2.1Rellenar los ?
			ps.setString(1, userName);
			ps.setString(2, password);
			//3.Ejecutar la sentencia 
			ResultSet consulta = ps.executeQuery();
			
			if(consulta.next()){
				//Traspasar los datos de resulset al usuario
				usuario = new Usuario();
				usuario.setId(consulta.getInt("id"));
				usuario.setNombre(consulta.getString("nombre"));
				usuario.setApellido(consulta.getString("apellido"));
				usuario.setUserName(consulta.getString("userName"));
				usuario.setPassWord(consulta.getString("password"));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		cerrarConexion();
	}
	return usuario;
}
		 private void abrirConexion(){
				try {
					//1.Determinar y validar si tengo el driver o conector (de mysql)
					Class.forName("com.mysql.jdbc.Driver");
					//2.Establecer la conexión...
					cx = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Tienda",
							"rootTienda",
							"rootTienda");
					//3.Iniciar el autoComit en false para gestionar transacciones.
					cx.setAutoCommit(false);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
			private void cerrarConexion(){
				try {
					if(cx != null)
					cx.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
				
			}

	}
		 
		 
		 
		 
		 


