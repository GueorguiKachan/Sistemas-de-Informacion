<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="es.unizar.sisinf.grp1.model.JugadorFacade" %>
<%@ page import="es.unizar.sisinf.grp1.model.JugadorVO" %>
<%@ page import="es.unizar.sisinf.grp1.model.EquipoFacade" %>
<%@ page import="es.unizar.sisinf.grp1.model.EquipoVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Document</title>
  
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
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
.show-modal{
    color: #fff;
    background: linear-gradient(to right, #33a3ff, #0675cf, #49a6fd);
    font-size: 18px;
    font-weight: 600;
    text-transform: capitalize;
    padding: 10px 15px;
    margin: 200px auto 0;
    border: none;
    outline: none;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    display: block;
    transition: all 0.3s ease 0s;
}
.show-modal:hover,
.show-modal:focus{
    color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
    outline: none;
}
.modal-dialog{
    width: 400px;
    margin: 70px auto 0;
}
.modal-dialog{ transform: scale(0.5); }
.modal-dialog{ transform: scale(1); }
.modal-dialog .modal-content{
    text-align: center;
    border: none;
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
         
        
	 	<div class="modal-box" style="margin:auto">
        	<button type="button" class="btn btn-primary btn-lg show-modal" style="background-color:#117A65; color:white; margin:auto"data-toggle="modal" data-target="#login">Iniciar sesion</button>
        
        	<div id="login"  class="modal fade" tabindex="-1" role="dialog"  >
    			<div class="modal-dialog" role="document" >
        			<div class="modal-content clearfix">
                            
            			<div class="modal-body" >
                        <button data-dismiss="modal" class="close">&times;</button>
                                <div class="row"  > 
                           
                                <h4 style="margin:auto">Login</h4>
                                <h4 style="margin:auto">Register</h4>
                                </div>
                                <div class="row" > 
                                <div class="col-6">
                                <form  name="login" action="login" method="post" style="margin:auto">
                                  <input type="text" name="username" class="username form-control" placeholder="Username"/>
                                  <input type="password" name="password" class="password form-control" placeholder="password"/>
                                 <button type="submit" class="btn btn-primary btn-sm" style="background-color:#117A65; color:white; margin:auto;">Login</button>
                                  </form>
                                  </div>
                                  <div class="col-6">
                                  <form  name="registro" action="registro" method="post" style="margin:auto">
                                   <input type="text" name="username" class="username form-control" placeholder="Username"/>
                                  <input type="password" name="password" class="password form-control" placeholder="password"/>
                                 <button type="button" class="btn btn-primary btn-sm" style="background-color:#117A65; color:white; margin:auto;">Register</button>
                                </form>
                                </div>
                                </div>
                                
            			</div>
            		</div>
        		</div>
			</div>
        
        	
        </div>
        
	 
 </div>
 <div id="buscadores">
 	<div class="row">
 	<form name="buscar" action="procesarGrupo" method="get" style="margin:auto;display:flex;max-width:210px">
	  		<input type="text" name="buscar"  placeholder="Introduzca un grupo" size="17">
	 		<button type="submit"><i class="fa fa-angle-double-right"></i></button>
	</form>
	<form name="buscar" action="procesarEquipo" method="get" style="margin:auto;display:flex;max-width:210px">
	  		<input type="text" name="buscar"  placeholder="Introduzca un equipo" size="17">
	 		<button type="submit"><i class="fa fa-angle-double-right"></i></button>
	</form>
	<form name="buscar" action="procesarJugador"  method="get" style="margin:auto;display:flex;max-width:210px">
	  		<input type="text" name="buscar"  placeholder="Introduzca un jugador" size="17">
	 		<button type="submit"><i class="fa fa-angle-double-right"></i></button>
	</form>
	</div>
 </div>
 
</div>


<div class="container-fluid">
		<div class="cabecera">Tabla de goleadores</div>
	</div>
	<div class="table-responsive-sm">
		<table class="table-striped">
			<tr>
				<th>Nombre<img src="" alt="" style="float:right;"></img></th>
				<th>Equipo<img src="" alt="" style="float:right;"></th>
				<th>Grupo<img src="" alt="" style="float:right;"></th>
				<th>P.Jugados<img src="" alt="" style="float:right;"></th>
				<th>P.Titular<img src="" alt="" style="float:right;"></th>
				<th><img src="goles.png" alt=""></img><img src="" alt="ordenar" style="float:right;"></th>
				<th></th>
			</tr>
			<tbody>
			<%
JugadorFacade dao = new JugadorFacade();		
List<JugadorVO> goleadores = new ArrayList<>();
goleadores = dao.goleadores();%>
			<!--<c:forEach var="jugador" items="${goleadores}">
                <tr>
                <td><c:out value="${jugador.nombre}" /></td>
                    <td><c:out value="${jugador.nacido}" /></td>
                    <td><c:out value="${jugador.equipo}" /></td>
                    <td><c:out value="${jugador.p_jugados}" /></td>
                    <td><c:out value="${jugador.p_titular}" /></td>
                    <td><c:out value="${jugador.goles}" /></td>
                    <td><c:out value="${jugador.amarillas}" /></td>
                    <td><c:out value="${jugador.rojas}" /></td>
           		</tr>
            </c:forEach>-->

			
			</tbody>
		</table>
	</div>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html> 
