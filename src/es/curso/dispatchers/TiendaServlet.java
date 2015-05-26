package es.curso.dispatchers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.controllers.ejb.DarAltaClienteControllerEjb;
import es.curso.model.entity.Cliente;

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
	switch(action){
	case "listarTodos": //Se invocará al controlador adecuado
						//que obtendrá todos los clientes.
		break;			//Esta petición redirige a otra página.
	case "buscarPorNombre"://Se invocará al controlador que haga la consulta por nombre,
						//que obtendrá solo los clientes que coincidan con el nombre.
							//Esta petición redirige a otra página.
		break;
	}
	//Tengo que redirigir hacia una vista jsp para mostrar los clientes
	
	RequestDispatcher rd;
	//De alguna manera hay que enviarle a la vista el resultado de la consulta a la base de datos...
	
	rd = request.getRequestDispatcher("listarTodos.jsp");
	rd.forward(request,  response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
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
			break;
			
		}
		
	}

}
