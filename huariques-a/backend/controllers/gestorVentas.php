<?php

class VentasController{

	#------------------------------------------------------------
	public function mostrarVentasController(){

		$respuesta = VentasModel::mostrarVentasModel("ventas");

		foreach ($respuesta as $row => $item){

			echo '<tr>
			        <td>'.$item["usuario"].'</td>
			        <td>'.$item["producto"].'</td>
			        <td>'.$item["costo"].'</td>
			        <td>'.$item["fecha"].'</td>
			        <td>
			        	<a href="index.php?action=ventas&idBorrar='.$item["id"].'"><span class="btn btn-danger fa fa-times quitarVenta"></span></a>
			        </td>
			        <td>
			        </td>
			      </tr>';

		}

	}

		public function sumarVentasController(){

		$respuesta = VentasModel::sumarVentasModel("ventas");

		foreach ($respuesta as $row => $item){

			echo '
	<h2><span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
        '.$item["total_suma"].'
    </h2>';

		}

	}

	#------------------------------------------------------------

	public function borrarVentasController(){

		if(isset($_GET["idBorrar"])){

			$datosController = $_GET["idBorrar"];

			$respuesta = VentasModel::borrarVentasModel($datosController, "ventas");

			if($respuesta == "ok"){

					echo'<script>

							swal({
								  title: "¡OK!",
								  text: "¡El suscrito se ha borrado correctamente!",
								  type: "success",
								  confirmButtonText: "Cerrar",
								  closeOnConfirm: false
							},

							function(isConfirm){
									 if (isConfirm) {	   
									    window.location = "ventas";
									  } 
							});


						</script>';

			}

		}

	}

	#------------------------------------------------------------

	public function impresionVentasController($datos){

		$datosController = $datos;

		$respuesta = VentasModel::mostrarVentasModel($datosController);
	
		return $respuesta;

	}

	#------------------------------------------------------------
	public function ventasSinRevisarController(){

		$respuesta = VentasModel::ventasSinRevisarModel("ventas");

		$sumaRevision = 0;

		foreach ($respuesta as $row => $item) {
			
			if($item["revision"] == 0){

				++$sumaRevision;

				echo '<span>'.$sumaRevision.'</span>';

			}					
		
		}

	}

	#------------------------------------------------------------
	public function ventasRevisadosController($datos){

		$datosController = $datos;

		$respuesta = VentasModel::ventasRevisadosModel($datosController, "ventas");

		echo $respuesta;

	}

}