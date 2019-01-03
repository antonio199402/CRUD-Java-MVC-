<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <th>ACTUALIZAR REGISTROS</th>
   
   <form action="Controlador_productos" method="get">
   <input type="hidden" name="instruccion" value="actualizarBBDD">
   <input type="hidden" name="codigo" value="${producto_actualizar.codigo_articulo}">
    <table>
    
    
    <tr>
    <td>Seccion</td><td><input type="text" name="seccion" value="${producto_actualizar.seccion}"></td>
    </tr>
    
    <tr>
    <td>Nombre Articulo</td><td><input type="text" name="nombre_art" value="${producto_actualizar.nombre_articulo}"></td>
    </tr>
    
     <tr>
    <td>Fecha</td><td><input type="text" name="fecha" value="${producto_actualizar.fecha}"></td>
    </tr>
    
     <tr>
    <td>Precio</td><td><input type="text" name="precio" value="${producto_actualizar.precio}"></td>
    </tr>
    
     <tr>
    <td>Importado</td><td><input type="text" name="importado" value="${producto_actualizar.importado}"></td>
    </tr>
    
     <tr>
    <td>Pais de Origen</td><td><input type="text" name="pais" value="${producto_actualizar.pais}"></td>
    </tr>
    
     <tr>
   <td> <input type="submit" value="Actualizar" name=""></td> <td> <input type="submit" value="Restablecer" name=""></td>
    </tr>
    
     
    </table>
    </form> 
</body>
</html>