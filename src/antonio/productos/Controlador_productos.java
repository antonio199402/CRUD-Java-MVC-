package antonio.productos;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/Controlador_productos")
public class Controlador_productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Modelo_productos modelo;
    
   @Resource(name="jdbc/productos")
	
	private DataSource mi_pool;
   
   
	

	
	@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
	
	try{
	modelo=new Modelo_productos(mi_pool);
	
	}catch(Exception e){
		e.printStackTrace();
	}
}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//LEER PARAMETRO DEL FORMULARIO
		
		String parametro_formulario=request.getParameter("instruccion");
		
		//SI NO SE ENVIA PARAMETRO, LISTAR PRODUCTOS
		
		if(parametro_formulario==null){
			parametro_formulario="listar";
		}
		
		//REDIRIGIR EL FLUJO AL METODO ADECUADO
		
		switch(parametro_formulario){
		
		case "listar":
			
			obtener_productos(request, response);
			
			break;
			
		case "insertarBBDD":
			
			agregar_productos(request, response);
			
			break;
		case "cargar":
		     
		    try {
				cargar_productos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		   break;
		   
		case "actualizarBBDD":
			  try {
				actualizar_productos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "eliminar":
			try {
				eliminar_producto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			default:
				obtener_productos(request, response);
				
		
		}
		
	}

//------------------INICIO DE METODOS---------------------------------------------------------------------//
	
//-----------------METODO ELIMINAR PRODUCTOS--------------------------------------------------------------//
	
private void eliminar_producto(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
	//LEER EL CODIGO ARTICULO
	String codigo=request.getParameter("c_articulo");
	
	//BORRAR PRODUCTO DE LA BBDD
	modelo.eliminar_productos(codigo);
	
	//VOLVER A LA LISTA DE PRODUCTOS
	obtener_productos( request, response);
		
	}

//-----------------METODO ACTUALIZAR PRODUCTOS---------------------------------------------//

private void actualizar_productos(HttpServletRequest request,
			HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
	//LEER INFORMACION DEL FORMULARIO
	
	String codigo=request.getParameter("codigo");
	String seccion=request.getParameter("seccion");
	String nombre_art=request.getParameter("nombre_art");
	String fecha=request.getParameter("fecha");
	double precio=Double.parseDouble(request.getParameter("precio"));
	String importado=request.getParameter("importado");
	String pais=request.getParameter("pais");
	
	//CREAR UN OBJETO DE TIPO PRODUCTO CON LA INFORMACION DEL FORMULARIO
	
	Productos actualizar=new Productos(codigo,seccion,nombre_art,precio,fecha,importado,pais);
	
	//ACTUALIZAR LA BBDD
	
	modelo.actualizar_productos(actualizar);
	
	//VOLVER AL LISTADO
	obtener_productos( request, response);
	
		
	}

  //--------------------------METODO CARGAR PRODUCTOS------------------------------------------------//
	


private void cargar_productos(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
	//LEER EL CODIGO AERTICULO
	String codigo=request.getParameter("c_articulo");
	
	//ENAVIAR EL CODIGO AL MODELO
	Productos el_producto=modelo.get_modelo(codigo);
	
	//COLOCAR ATRIBUTO AL CODIGO ARTICULO
	request.setAttribute("producto_actualizar",el_producto);
	
	//ENVIAR PRODUCTO AL FORMULARIO
	 RequestDispatcher conexion_formulario=request.getRequestDispatcher("/actualizar.jsp");
	 
	 conexion_formulario.forward(request, response);
		
	}



	//----------------------------METODO AGREGAR PRODUCTOS------------------------------------------------//
	private void agregar_productos(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//LEER LA INFORMACION DEL FORMULARIO
		String codigo=request.getParameter("codigo");
		String seccion=request.getParameter("seccion");
		String nombre_art=request.getParameter("nombre_art");
		String fecha=request.getParameter("fecha");
		double precio=Double.parseDouble(request.getParameter("precio"));
		String importado=request.getParameter("importado");
		String pais=request.getParameter("pais");
		
		
		//CREAR UN OBJETO DE TIPO PRODUCTO
		
		Productos insertar=new Productos(codigo,seccion,nombre_art,precio,fecha,importado,pais);
		//ENVIAR OBJETO AL MODELO
		
		modelo.agregar_producto(insertar);
		
		
		//VOLVER AL LISTADO DE OBJETOS
		obtener_productos(request, response);
	}

//----------------------METODO OBTENER PRODUCTOS--------------------------------------------------------------//

	private void obtener_productos(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//-----------------OBTENER LISTA DEL MODELO--------------------------//
		ArrayList <Productos> lista_productos;
		
		try{
		 lista_productos=modelo.getProductos();
		 
		 
		//-----------------AGREGAR ESA LISTA AL REQUEST------------------------//
		
		 request.setAttribute("lista", lista_productos);
		//----------------ENVIAR EL REQUEST AL JSP-------------------------------//
		 
		 RequestDispatcher conexion_jsp=request.getRequestDispatcher("/ListaProductos.jsp");
		 
		 conexion_jsp.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
