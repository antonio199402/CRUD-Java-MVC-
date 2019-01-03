package antonio.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/servlet_pruebas")
public class servlet_pruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
     //------------ESTABLECER EL DATDA SOURCE----------------------//
	@Resource(name="jdbc/productos")
	
	private DataSource mi_pool;
	
    
    public servlet_pruebas() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //------------CREA EL OBJETO PRINWRITER---------------------//
		
		PrintWriter salida=response.getWriter();
		
		response.setContentType("text/plain");
		
		//--------------CREAE CONEXION CON BASES DE DATOS----------------------//
		
		Connection conexion=null;
		Statement estado=null;
		ResultSet resultado=null;
		
		try{
			
			conexion=mi_pool.getConnection();
			String misql="SELECT * FROM productos";
			estado=conexion.createStatement();
			resultado=estado.executeQuery(misql);
			
			while(resultado.next()){
				String nombre=resultado.getString(3);
				salida.println(nombre);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
