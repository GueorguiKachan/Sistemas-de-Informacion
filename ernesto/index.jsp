<%@ page import="es.unizar.sisinf.grp1.model.EquipoFacade" %>
<%@ page import="es.unizar.sisinf.grp1.model.EquipoVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi primera aplicación Web</title>
</head>
<body>
<h1>Hola, Mundo!!!</h1>
<ul>
<li><a href="signin">signin</a></li>
<li><a href="logged">logged</a></li>
<li><a href="test">test</a></li>
</ul>
<%
	EquipoFacade dao = new EquipoFacade();		
	EquipoVO miEquipo = dao.getTeam("El Gancho C.F.");
%>
<p><%=miEquipo.getTeamName()%></p>
<p><%=miEquipo.getNumJugadores()%></p>

<form action="busquedaEquipo" method="get">
  			<label for="equipo">Equipo: </label>
            <input type="text" id="equipo" name="equipo" value="El Gancho C.F." style="width: 8em;"></input>
            <input type="submit" value="submit">
</form>

</body>
</html>