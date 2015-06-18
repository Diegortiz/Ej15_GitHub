package es.curso.dispatchers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.curso.controllers.ActualizarClienteController;
import es.curso.controllers.BuscarPorIdController;
import es.curso.controllers.LoginController;
import es.curso.controllers.ejb.ActualizarClienteControllerEjb;
import es.curso.controllers.ejb.BuscarPorIdControllerEjb;
import es.curso.controllers.ejb.BuscarPorNombreControllerEjb;
import es.curso.controllers.ejb.DarAltaClienteControllerEjb;
import es.curso.controllers.ejb.EncontrarPorIdControllerEjb;
import es.curso.controllers.ejb.ListarTodosControllerEjb;
import es.curso.controllers.ejb.LoginControllerejb;
import es.curso.model.entity.Cliente;
import es.curso.model.entity.Usuario;

/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet("/Tienda/*")//Anotaciones
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TiendaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getPathInfo().substring(1);
	request.setCharacterEncoding("UTF-8");
	String titulo = "Sin título";
	
	RequestDispatcher rd ;//Dispatcher que redirecciona a otra página
	HttpSession miSession = request.getSession();
	
	//Preguntar si la petición es login
	if(action.equals("login")){
		
		//Invalidar la sesión.
		miSession.invalidate();
		
		//Redirigir a login
		rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request,response);
	}
	else{
				//Hago las otras opciones.
				//Preguntar si la sesión está activa.
				//Hacer el switch.
		if(miSession.getAttribute("userName")!=null){
			switch(action){
				case"altaCliente"://Se debe redirigir al formulario altaCliente.
					rd = request.getRequestDispatcher("/jsp/altaCliente.jsp");
					rd.forward(request, response);
					break;
						
				case "listarTodos": //Se invocará al controlador adecuado
								//que obtendrá todos los clientes.
					ListarTodosControllerEjb todos = new ListarTodosControllerEjb();
					ArrayList<Cliente> clientes = todos.listarTodos();
					request.setAttribute("clientes", clientes);//En el objeto request viajan los datos de todo el ArrayList
					todos.listarTodos();
					titulo="Listado general de clientes";
					request.setAttribute("titulo", titulo);
					rd = request.getRequestDispatcher("/jsp/listarTodos.jsp");//Se redirecciona a listar todos
					rd.forward(request,  response);
					break;	
					
			case "buscarPorNombre":
					
					//Esta petición redirige a otra página.
					//Se redirigirá hacia el formulario buscar por nombre.
					
					rd = request.getRequestDispatcher("/jsp/buscarPorNombre.jsp");
					rd.forward(request,  response);
					break;
					
			case "BuscarPorId":
				
					rd = request.getRequestDispatcher("/jsp/BuscarPorId.jsp");
					rd.forward(request, response);
					break;
					
			case "EncontrarPorId":
				
					rd = request.getRequestDispatcher("/jsp/EncontrarPorId.jsp");
					rd.forward(request, response);
					break;
					
					
			case "ActualizarCliente":
				
					rd = request.getRequestDispatcher("/jsp/ActualizarCliente.jsp");
					rd.forward(request, response);
					break;
					
			
				
				
			case "logout":  
				
				miSession.invalidate();
				rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request,response);
				break;
				
			}
			
		}//Cierre del if que verifica la sesión.
		else{
			response.sendRedirect("login");
		}
	}
				
}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		
		if(request.getSession().getAttribute("userName")!=null){
		switch(action){
		case "altaCliente" :
			//Recuperar los datos tecleados en el formulario
				String nombres = request.getParameter("nombres");
				String apellidos = request.getParameter("apellidos");
				String dni = request.getParameter("dni");
				Cliente cliente = new Cliente(0, nombres, apellidos, dni);
			//Invocará al controlador adecuado.
			
				DarAltaClienteControllerEjb controlador = new DarAltaClienteControllerEjb();
				
				controlador.agregar(cliente);
				
				rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request,  response);
			break;
		case "buscarPorNombre":
			
			//Recuperar la cadena tecleada en el formulario.
				String cadenaNombre = request.getParameter("nombre");
			
			 //Llamar al controlador adecuado.
				BuscarPorNombreControllerEjb controladorBusqueda = new BuscarPorNombreControllerEjb();
				ArrayList<Cliente>resultado = controladorBusqueda.buscarPorNombre(cadenaNombre);
			
			//Meter en el request el ArrayList de respuestea.
				request.setAttribute("clientes", resultado);
			
			//mandarle un título diferente
				request.setAttribute("titulo", "Búsqueda por " + cadenaNombre);
			
			//y redirigir hacia el jsp ListarTodos
				rd = request.getRequestDispatcher("/jsp/listarTodos.jsp");
				rd.forward(request, response);
				
			break;
			
		case "BuscarPorId":
			
			//Recuperar el id tecleado en el form
			int id = Integer.parseInt(request.getParameter("Id"));
			
			//Llamar al controlador
			BuscarPorIdControllerEjb buscarEjb = new BuscarPorIdControllerEjb();
			buscarEjb.borrar(id);
			
			//y redirigir hacia el jsp BuscarPorId
			
			response.sendRedirect("/Ej15_GitHub/Tienda/listarTodos");
			
			break;
			
		case "EncontrarPorId":
			
			int Id = Integer.parseInt(request.getParameter("Id"));
			
			EncontrarPorIdControllerEjb EncontrarEjb = new EncontrarPorIdControllerEjb();
			EncontrarEjb.encontrar(Id);
			
			response.sendRedirect("/Ej15_GitHub/Tienda/listarTodos");
			break;
			
		case "ActualizarCliente"://Recuperar los datos que vienen del formulario.
			
			int idCliente = Integer.parseInt(request.getParameter("Id"));
			String nombresCliente = request.getParameter("nombres");
			String apellidosCliente = request.getParameter("apellidos");
			String dniCliente = request.getParameter("dni");
			Cliente clienteModif = new Cliente(idCliente, nombresCliente, apellidosCliente, dniCliente);
			
			ActualizarClienteController actualizarEjb = new ActualizarClienteControllerEjb();
			actualizarEjb.actualizar(clienteModif);
			
			response.sendRedirect("/Ej15_GitHub/Tienda/listarTodos");
			break;
			
		
			
			
	
			
			}//Fin del switch
		
		}//Fin del if
	
		else{
			if(action.equals("login")){
				//recuperar los datos del formulario
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				//invocar al controlador
				LoginController loginController = new LoginControllerejb();
				Usuario usuario = loginController.login(userName, password);
				
				if(usuario!=null){
					//si el usuario existe...meter los datos de ese usuario en la sesión.
					HttpSession session = request.getSession(false);
					session.invalidate();
					session = request.getSession(true);
					session.setMaxInactiveInterval(30);
					
					//Aquí tengo que rellenar los datos del usuario
					String nombreCompleto = usuario.getNombre() + ""+ usuario.getApellido();
					session.setAttribute("nombreCompleto", nombreCompleto );  
					session.setAttribute("userName", usuario.getUserName());
					rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
					
					
				}else
				{
					//si no existe redirigir hacia login otra vez.
					response.sendRedirect("login");
				}
				
			}
			
		}
		
	}
	
}			
			
			
