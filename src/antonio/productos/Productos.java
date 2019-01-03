package antonio.productos;

public class Productos {
	
	
	
	public Productos(String codigo_articulo, String seccion,String nombre_articulo, double prcio, String fecha,
			String importado, String pais) {
		
		this.codigo_articulo = codigo_articulo;
		this.seccion = seccion;
		this.nombre_articulo = nombre_articulo;
		this.precio = prcio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais = pais;
	}
	
	
	public Productos(String seccion, String nombre_articulo, double prcio,String fecha, String importado, String pais){
		
		this.seccion = seccion;
		this.nombre_articulo = nombre_articulo;
		this.precio = prcio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais = pais;
	}
	
	


	public String getCodigo_articulo() {
		return codigo_articulo;
	}


	public void setCodigo_articulo(String codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}


	public String getSeccion() {
		return seccion;
	}


	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}


	public String getNombre_articulo() {
		return nombre_articulo;
	}


	public void setNombre_articulo(String nombre_articulo) {
		this.nombre_articulo = nombre_articulo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double prcio) {
		this.precio = prcio;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getImportado() {
		return importado;
	}


	public void setImportado(String importado) {
		this.importado = importado;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}



	public String toString() {
		return "Productos [codigo_articulo=" + codigo_articulo + ", seccion="
				+ seccion + ", nombre_articulo=" + nombre_articulo + ", prcio="
				+ precio + ", fecha=" + fecha + ", importado=" + importado
				+ ", pais=" + pais + "]";
	}




	private String codigo_articulo;
	private String seccion;
	private String nombre_articulo;
	private double precio;
	private String fecha;
	private String importado;
	private String pais;

}
