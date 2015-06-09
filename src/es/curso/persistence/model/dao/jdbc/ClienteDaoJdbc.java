package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;

public  class ClienteDaoJdbc implements ClienteDao{
	
	private Connection cx;
	
	public ClienteDaoJdbc() {
		super();
		
	}

	@Override
	public void create(Cliente cliente) {
		try {
			//Van las instrucciones para
			//1. Conectar con la base de datos.
			abrirConexion();
			//2. Preparar la sentencia -sql- para agregar.
			try {
				PreparedStatement ps = 
						cx.prepareStatement("INSERT INTO CLIENTE VALUES(?,?,?,?)");
				//2.1 Insertar los datos del cliente en los: ?
				
				ps.setInt(1, 0);
				ps.setString(2, cliente.getNombres());
				ps.setString(3, cliente.getApellidos());
				ps.setString(4, cliente.getDni());
				
				//3. Ejecutar la sentencia -sql-
				
				ps.executeUpdate();//= que dar al play en Heidi
				//nota: se usa executeUpdate() para las instruciones sql
				//como: insert, delete, update.
				//Esta instrucción devuelve como resultado el número de
				//registros (o filas) afectadas.
				
				//3.1Hacer el commit...
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//4.Cerrar la conexión.
		
		finally{
			cerrarConexion();
		}
		
	}

	@Override
	public ArrayList<Cliente> findAll() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			try {
				//1.Abrir la conexión
					abrirConexion();
				//2.Preparar las sentencias
					PreparedStatement ps = cx.prepareStatement("SELECT * FROM CLIENTE");
				//3.Ejecutar las sentencias...
					ResultSet consulta = ps.executeQuery();
					
					//3.1 Traspasar los datos de la respuesta al arrayList.
					while (consulta.next()){
						Cliente clienteTemporal = new Cliente();
						//Código para traspasar de la consulta (ResultSet)
						//hacia clienteTemporal
						clienteTemporal.setId(consulta.getInt("id"));//Lo entrecomillado corresponde
																	//al nombre del atributo en la base 
																	//de datos.(A veces no).
						clienteTemporal.setNombres(consulta.getString("nombres"));
						clienteTemporal.setApellidos(consulta.getString("apellidos"));
						clienteTemporal.setDni(consulta.getString("dni"));
						
						clientes.add(clienteTemporal);//Esta instrucción los adiciona al ArrayList.
						
					}				
					
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			//4.Cerrar la conexión
			finally{
				cerrarConexion();
			}
	return clientes;
	
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
			//3.Iniciar el autoComit en false
			//cx.setAutoCommit(false);
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

	@Override
	public ArrayList<Cliente> searchByName(String name) {
		ArrayList<Cliente> clientes= new ArrayList<Cliente>();//Crear ArrayList.
		try {
			
			// 1.-Establecer la conexión con la bbdd
				abrirConexion();
				
			//2.-Preparar la sentencia sql parametrizada (son las que tienen ?)
				PreparedStatement ps = cx
					.prepareStatement("SELECT * FROM CLIENTE WHERE NOMBRES LIKE ?");
				
			//2.1-Especificar lo que va en la ?
				ps.setString(1, "%"+ name + "%");
				
			//3.-Ejecutar la query.
				ResultSet resultado = ps.executeQuery();
				
			//3.1-Pasar los datos que vienen de la bbdd (ResultSet) hacia el ArrayList<Cliente>
				while(resultado.next()){
					Cliente c = new Cliente();
					c.setId(resultado.getInt("id"));
					c.setNombres(resultado.getString("nombres"));
					c.setApellidos(resultado.getString("apellidos"));
					c.setDni(resultado.getNString("dni"));
				clientes.add(c);
				}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			//4.-Cerrar la conexión (en el finally).
			cerrarConexion();
		
		}
		return clientes;//Devolver ArrayList.
	}
	
	@Override
	public void update(Cliente cliente) {
		try {
			
			// 1.Establecer la conexión
				abrirConexion();
				
			//2.Preparar la sentencia
				PreparedStatement ps = cx.prepareStatement(
						"UPDATE CLIENTE SET NOMBRES = ?, APELLIDOS = ?, DNI = ? WHERE ID = ?");
				
			//2.1 Rellenar los ?
				ps.setString(1, cliente.getNombres());
				ps.setString(2, cliente.getApellidos());
				ps.setString(3, cliente.getDni());
				ps.setInt(4, cliente.getId());
				
			//3. Ejecutar la sentencia.
				ps.executeUpdate();
			
		
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
				//4. Cerrar conexión.
				cerrarConexion();
		}
		
	}
	
	@Override
	public void delete(Integer id) {
		try {
			// Establecer conexión.
			abrirConexion();
			//2.Preparar las sentencias.
			PreparedStatement ps = cx.prepareStatement("DELETE FROM CLIENTE WHERE ID = ?");
			//2.1Especificar lo que va en ?
			ps.setInt(1, id);
			//3.Ejecutar la sentencia.
			ps.executeUpdate();//Este método devuelve un entero.
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			//4 Cerrar la conexión.
			cerrarConexion();
			
		}
		
	}

	@Override
	public void read(Object id) {
		// TODO Auto-generated method stub
		
	}
	
}
		
				
				
				
	
	
