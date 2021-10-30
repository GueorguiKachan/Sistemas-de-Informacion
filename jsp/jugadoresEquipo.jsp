<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Transfermarkt Aragon</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-5.1.3-dist/css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">body{background-color:#34495E;}</style>
<style>
*{
    box-sizing: border-box;
}
form.buscar button{
    
  float: right;
  width: 20%;
  
  height:20px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}
  
  .cabecera{
    background-color: #CCD1D1;
    padding:10px 15px 15px 10px ;
}
</style>
</head>
<body>
<div class="cabecera">
  <div class="row">
      
        <img alt="Imagen" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2SeLFs7dKpRTLT5ljvM8vY0V0mte9-lHD_LQuJt5YcIWi9xI&s" style="dispaly:flex;margin:0px 0px 20px 20px;width:170px; heigth:80px;">
      
     
        <form name="jugador" action="procesarForm.do" method="get" style="display:flex;margin:auto;max-width:210px;height:60px">
            <input type="text" name="buscar" placeholder="Introduzca un jugador" size="20">
            <button type="submit"><i class="fa fa-angle-double-right"></i></button>
        </form>
        <button type="button" class="btn btn-primary btn-sm" style="background-color:#117A65; color:white; margin:auto;width:170px; height:60px">Iniciar sesion</button>
     
 </div>
 <div id="buscadores">
    <div class="row">
    <form name="buscar" action="listaEquipos" method="get" style="margin:auto;display:flex;max-width:210px">
            <input type="text" name="grupo"  placeholder="Introduzca un grupo" size="17">
            <button type="submit"><i class="fa fa-angle-double-right"></i></button>
    </form>
    <form name="buscar" action="jugadoresEquipo" method="get" style="margin:auto;display:flex;max-width:210px">
            <input type="text" name="equipo"  placeholder="Introduzca un equipo" size="17">
            <button type="submit"><i class="fa fa-angle-double-right"></i></button>
    </form>
    <form name="buscar" action="buscaJugador"  method="get" style="margin:auto;display:flex;max-width:210px">
            <input type="text" name="nombre"  placeholder="Introduzca un jugador" size="17">
            <button type="submit"><i class="fa fa-angle-double-right"></i></button>
    </form>
    </div>
 </div>
</div>

<div class="table-responsive-sm">
        <table class="table-striped" name="tablaJugadores">
            <tr>
            
                <th>Nombre<img src="" alt="ordenar" style="float:right;"></img></th>
                <th>Grupo<img src="" alt="ordenar" style="float:right;"></th>
                <th>Jugadores<img src="" alt="ordenar" style="float:right;"></th>
                <th>Pr.Entradas<img src="" alt="ordenar" style="float:right;"></th>
                <th>Estadio<img src="" alt="ordenar" style="float:right;"></th>
                <th>Capacidad<img src="" alt="ordenar" style="float:right;"></th>
                <th>Cesped<img src="" alt="ordenar" style="float:right;"></th>
                <!--<th><img src="goles.png" alt="Goles"></img><img src="" alt="ordenar" style="float:right;"></th>-->
                
                <th></th>
            </tr>
            <tbody>
            <c:forEach var="jugador" items="${jugadoresEquipo}">
                <tr>
        
                  <td><c:out value="${jugador.nombre}" /></td>
                    <td><c:out value="${jugador.nacido}" /></td>
                    <td><c:out value="${jugador.equipo}" /></td>
                    <td><c:out value="${jugador.p_jugados}" /></td>
                    <td><c:out value="${jugador.p_titular}" /></td>
                    <td><c:out value="${jugador.goles}" /></td>
                    <td><c:out value="${jugador.amarillas}" /></td>
                    <td><c:out value="${jugador.rojas}" /></td>
                
                   <!-- <td><img src="editar.png" alt="Editar"></img></td>-->
           		</tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html> 