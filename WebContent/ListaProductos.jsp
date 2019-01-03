<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.cabecera{
    color:FFFFFF;
    background-color:#00BFFF;
  }
  
.filas{
    background-color:#A9F5F2;
    text-align:center;
  }
  
table{
  float:left;
  }
  
#contenedor{
  margin-left:860px;
}

</style>
<body>

   <table>
   
   <tr>
   
   <th class="cabecera">CODIGO ARTICULO</th>
   <th class="cabecera">SECCION</th>
   <th class="cabecera">NOMBRE ARTICULO</th>
   <th class="cabecera">PRECIO</th>
   <th class="cabecera">FECHA</th>
   <th class="cabecera">IMPORTADO</th>
   <th class="cabecera">PAIS DE ORIGENS</th>
   <th class="cabecera">ACCION</th>
    
    </tr>
    
    <c:forEach var="p" items="${lista}">
    
    <!-- link para actualizar cada producto -->
    
    <c:url var="link" value="Controlador_productos">
    
    <c:param name="instruccion" value="cargar"> </c:param>
    <c:param name="c_articulo" value="${p.codigo_articulo}"></c:param>
 
    
    </c:url>
    
     <!-- link para eliminar cada producto -->
    
    <c:url var="link_borrar" value="Controlador_productos">
    
    <c:param name="instruccion" value="eliminar"> </c:param>
    <c:param name="c_articulo" value="${p.codigo_articulo}"></c:param>
 
    
    </c:url>
    	<tr>
    	
    	<td class="filas">${p.codigo_articulo}</td>
    	<td class="filas">${p.seccion}</td>
    	<td class="filas">${p.nombre_articulo}</td>
    	<td class="filas">${p.precio}</td>
    	<td class="filas">${p.fecha}</td>
    	<td class="filas">${p.importado}</td>
    	<td class="filas">${p.pais}</td>
    	<td class="filas"><a href="${link}">Actualizar</a>&nbsp;&nbsp;<a href="${link_borrar}">Eliminar</a></td>
    	
    	
    	
    	</tr>
 
   </c:forEach>
   </table>
   
   <div id=contenedor>
   
   <input type="submit" value="INSERTAR" onclick="window.location.href='inserta_producto.jsp'"/>
   
   </div>
   
   

</body>
</html>