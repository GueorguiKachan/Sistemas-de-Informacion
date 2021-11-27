<!DOCTYPE html>
<html lang="en">
<head>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Document</title>
  
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
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
        
      <!--<a href="#" class="btn btn-info btn-lg" style="margin:auto;color:#34495E">
          <span style="color:white" class="glyphicon glyphicon-log-out"></span> 
        </a>-->
<div class="modal-box" style="margin:auto;">
        	<button type="button" class="btn btn-primary btn-lg show-modal" style="background-color:#34495E; color:white; margin:auto;"data-toggle="modal" data-target="#login">Salir</button>
        
        	<div id="login"  class="modal fade" tabindex="-1" role="dialog"  >
    			<div class="modal-dialog" role="document">
        			<div class="modal-content clearfix" style="margin:auto">
                           <div class="modal-body">
                            <button data-dismiss="modal" class="close">&times;</button>
                           <div class="row" style="margin:auto">
                           <div class="col-12">
                           <h4>�Esta seguro de que quiere salir?</h4>
                          </div>
         				</div>
                        <div class="row">
                        <div  class="col-12">
                        <form name="salir" action="salir" method="get" >
                          <button type="submit" style="background-color:#AC1A10;color:white" class="btn btn-primary">Salir</button>
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
 	<form name="buscar" action="procesarForm.do" method="get" style="margin:auto;display:flex;max-width:210px">
	  		<input type="text" name="buscar"  placeholder="Introduzca un grupo" size="17">
	 		<button type="submit"><i class="fa fa-angle-double-right"></i></button>
	</form>
	<form name="buscar" action="procesarForm.do" method="get" style="margin:auto;display:flex;max-width:210px">
	  		<input type="text" name="buscar"  placeholder="Introduzca un equipo" size="17">
	 		<button type="submit"><i class="fa fa-angle-double-right"></i></button>
	</form>
	<form name="buscar" action="procesarForm.do"  method="get" style="margin:auto;display:flex;max-width:210px">
	  		<input type="text" name="buscar"  placeholder="Introduzca un jugador" size="17">
	 		<button type="submit"><i class="fa fa-angle-double-right"></i></button>
	</form>
	</div>
 </div>
 
</div>
<body>
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html> 
