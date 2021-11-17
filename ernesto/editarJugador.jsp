<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.cabecera{padding:20px;}
	table,th,td{border:1px solid black;padding:15px 0;}
	table{width:100%;border-collapse:collapse;}
</style>
</head>
<body>

	<div class="container">
	<div class="row">
		<table class="table-striped">
            <form action="/action_page.php" method="get">
            <tr>
            	<th>
                <div class="row">
                <div class="col-6">Campo a cambiar: Goles</div>
               
                <div class="col-4">Nuevo valor:8</div>
                </div>
                </th>
                <th>
                <a href="/action_page.php"><img src="" alt="cancelar" style="float:right;"></img></a>
                </th>
            </tr>
            <tr>
            	<td>
                <div class="row">
            <div class="col-6"><label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="nombre" value="Ramon Calvo"  readonly></input></div>
  			<div class="col-4"><label for="equipo">Equipo: </label>
            <input type="text" id="equipo" name="equipo" value="tardienta" style="width: 7em;" ></input></div>
            </td>
            <td>
           <input type=image src="" alt="guardar" style="float:right;"></input>
            </td>
            </tr>
            </table>
            
            <div class="container">
            
            
            
            <div class="row">
             <div class="col-6">
             <label for="nacido">Nacido: </label>
            <input type="text" id="nacido" name="nacido" value="1998" style="width: 8em;"></input>
            </div>
            <div class="col-6">
             <p>Años: 23</p>
            </div>
            </div>
            <div class="row">
            	 <div class="col-6">
             <p>Partidos:</p>
            </div>
            <div class="col-6">
             <p>Tarjetas:</p>
            </div>
            </div>
            <div class="row">
            <div class="col-1"></div>
            	 <div class="col-5">
             <label for="jugados">Jugados: </label>
            <input type="text" id="jugados" name="jugados" value="3" style="width: 2em;"></input>
            </div>
            <div class="col-1"></div>
            <div class="col-5">
              <label for="amarillas">Amarillas: </label>
            <input type="text" id="amarillas" name="amarillas" value="0" style="width: 2em;"></input>
            </div>
            </div>
            
            <div class="row">
            <div class="col-1"></div>
            	 <div class="col-5">
             <label for="titular">Titular: </label>
            <input type="text" id="titular" name="titular" value="0" style="width: 2em;"></input>
            </div>
            <div class="col-1"></div>
            <div class="col-5">
              <label for="rojas">Rojas: </label>
            <input type="text" id="rojas" name="rojas" value="0" style="width: 2em;"></input>
            </div>
            </div>
            
            <div class="row">
            <div class="col-12">
            <label for="goles">Goles: </label>
            <input type="text" id="goles" name="goles" value="0" style="width: 2em;"></input>
            </div>
            	
           
            
		</table>
	</div>
</body>
</html>
