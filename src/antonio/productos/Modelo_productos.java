package antonio.productos;

import java.util.ArrayList;

import javax.sql.DataSource;

import java.sql.*;

public class Modelo_productos {
	private DataSource conexion_pool;
	
	public Modelo_productos(DataSource conexion_pool){
		this.conexion_pool=conexion_pool;
		
	}
	
	public ArrayList<Productos> getProductos() throws Exception{
		
		ArrayList <Productos> productos=new ArrayList<Productos>();
		
		//----------VARIABLES DE CONEXION-------------------------//
		
		Connection mi_conexion=null;
		Statement mi_estado=null;
		ResultSet mi_resultado=null;
		
		//-----------ESTABLECEMO CONECION CON EL POOL--------------------//
		mi_conexion=conexion_pool.getConnection();
		
		//-------------CREAMOS SENTENCIA SQL------------------------------//
		String mi_sql="SELECT * FROM productos";
		//-------------CREAMOS STATMENT---------------------------//
		mi_estado=mi_conexion.createStatement();
		
		//------------EJECUTAMOS CONSULTA CON EL RESULTSET-----------------//
		mi_resultado=mi_estado.executeQuery(mi_sql);
		
		//---------RECORRIDO DEL RESULTSET-----------------------------------//
		
		while(mi_resultado.next()){
			
			String codigo_articulo=mi_resultado.getString("CÓDIGOARTÍCULO");
			String seccion=mi_resultado.getString("SECCIÓN");
			String nombre_articulo=mi_resultado.getString("NOMBREARTÍCULO");
			double precio=mi_resultado.getDouble("PRECIO");
			String fecha=mi_resultado.getString("FECHA");
			String importado=mi_resultado.getString("IMPORTADO");
			String pais=mi_resultado.getString("PAÍSDEORIGEN");
			
			Productos temporales=new Productos(codigo_articulo,seccion,nombre_articulo,precio,fecha,importado,pais);
			
			productos.add(temporales);
			
		}
		return productos;
		
	}
//---------------------------------------------------------------------------------------
	public void agregar_producto(Productos insertar) {
		// TODO Auto-generated method stub
		Connection mi_Conexion=null;
		PreparedStatement mi_Statemente=null;
		//OBTENER CONEXION
		try{
			
			mi_Conexion=conexion_pool.getConnection();
			
		
		
		//CREAR LA INSTRUCCION SQL
		
		String consulta="INSERT INTO productos(CÓDIGOARTÍCULO,SECCIÓN,NOMBREARTÍCULO,PRECIO,FECHA,IMPORTADO,PAÍSDEORIGEN)VALUES(?,?,?,?,?,?,?)";
		mi_Statemente=mi_Conexion.prepareStatement(consulta);
		
		//ESTABLECER LOS PARAMETROS
		mi_Statemente.setString(1, insertar.getCodigo_articulo());
		mi_Statemente.setString(2, insertar.getSeccion());
		mi_Statemente.setString(3, insertar.getNombre_articulo());
		mi_Statemente.setDouble(4, insertar.getPrecio());
		mi_Statemente.setString(5, insertar.getFecha());
		mi_Statemente.setString(6, insertar.getImportado());
		mi_Statemente.setString(7, insertar.getPais());
		//EJECUTAR 
		mi_Statemente.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				
			mi_Conexion.close();
			mi_Statemente.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//--------------------------------------------------------------------------------------

	public Productos get_modelo(String codigo) {
		// TODO Auto-generated method stub
		Productos el_producto=null;
		Connection mi_conexion=null;
		PreparedStatement mi_estado=null;
		ResultSet mi_resultado;
		String codigo1=codigo;
		
		//ESTABLESER LA CONEXION
		try {
			mi_conexion=conexion_pool.getConnection();
		
		//SENTENCIA SQL
			
		String consulta="SELECT * FROM productos WHERE CÓDIGOARTÍCULO=?";
		
		//CREAR LA CONSULTA PREPARADA
		
		mi_estado=mi_conexion.prepareStatement(consulta);
		
		//ESTABLECER LOS PARAMETROS 
		mi_estado.setString(1,codigo1);
		
		//EJECUTAR LA CONSULTA
		mi_resultado=mi_estado.executeQuery();
		
		//OBTENER LOS DATOS DE RESPUESTA
		if(mi_resultado.next()){
			
		    String codigo_art=mi_resultado.getString("CÓDIGOARTÍCULO");
			String seccion=mi_resultado.getString("SECCIÓN");
			String nombre_articulo=mi_resultado.getString("NOMBREARTÍCULO");
			double precio=mi_resultado.getDouble("PRECIO");
			String fecha=mi_resultado.getString("FECHA");
			String importado=mi_resultado.getString("IMPORTADO");
			String pais=mi_resultado.getString("PAÍSDEORIGEN");
			
			el_producto=new Productos(codigo_art,seccion,nombre_articulo,precio,fecha,importado,pais);
			
			
		}else{
			throw new Exception("no se ha encontrado articulo con codigo"+ codigo1);
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
			mi_estado.close();
			mi_conexion.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return el_producto;
	}
//-----------------------------------------------------------------------------------------------------
	public void actualizar_productos(Productos actualizar) {
		// TODO Auto-generated method stub
		Connection mi_conexion=null;
		PreparedStatement mi_estado=null;
		
		try {
			//CREAR CONEXION
			mi_conexion=conexion_pool.getConnection();
			
			//CREAR CONSULTA
			
			String consulta="UPDATE productos SET SECCIÓN=?,NOMBREARTÍCULO=?,PRECIO=?,FECHA=?,IMPORTADO=?,PAÍSDEORIGEN=? WHERE CÓDIGOARTÍCULO=?";
			
			//CREAR OBJETO STATEMENT
			mi_estado=mi_conexion.prepareStatement(consulta);
			
			//ESTABLECER PARAMETROS
			mi_estado.setString(1, actualizar.getSeccion());
			mi_estado.setString(2, actualizar.getNombre_articulo());
			mi_estado.setDouble(3, actualizar.getPrecio());
			mi_estado.setString(4, actualizar.getFecha());
			mi_estado.setString(5, actualizar.getImportado());
			mi_estado.setString(6, actualizar.getPais());
			mi_estado.setString(7, actualizar.getCodigo_articulo());
			
			//EJECUTAR CONSULTA
			mi_estado.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
			mi_estado.close();
			mi_conexion.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
//----------------------------------------------------------------------------------------------------------//
	public void eliminar_productos(String codigo) {
		// TODO Auto-generated method stub
		Connection mi_conexion=null;
		PreparedStatement mi_estado=null;
		//ESTABLECER LA CONEXION
		try {
			mi_conexion=conexion_pool.getConnection();
		
		//CREAR CONSULTA SQL
		
		String consulta="DELETE FROM productos WHERE CÓDIGOARTÍCULO=?";
		//CREAR PREPAREDSTATEMENT
		mi_estado=mi_conexion.prepareStatement(consulta);
		
		//ASIGNAR PARAMETROS
		
		mi_estado.setString(1,codigo);
		//EJECUTAR LA CONSULTA
		
		mi_estado.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
			mi_estado.close();
			mi_conexion.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
