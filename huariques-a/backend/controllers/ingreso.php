<?php

class Ingreso{

	public function ingresoController(){

		if(isset($_POST["usuarioIngreso"])){

			if(preg_match('/^[a-zA-Z0-9]+$/', $_POST["usuarioIngreso"])&&
			   preg_match('/^[a-zA-Z0-9]+$/', $_POST["passwordIngreso"])){


				$datosController = array("usuario"=>$_POST["usuarioIngreso"],
				                     "password"=>$_POST["passwordIngreso"]);

				$respuesta = IngresoModels::ingresoModel($datosController, "usuarios");

				$usuarioActual = $_POST["usuarioIngreso"];



						session_start();

						$_SESSION["validar"] = true;
						$_SESSION["usuario"] = $respuesta["usuario"];
						$_SESSION["id"] = $respuesta["id"];
						$_SESSION["password"] = $respuesta["password"];
						$_SESSION["role"] = $respuesta["role"];

if ($_SESSION["role"] == "administrador") {

						header("location:productos");

}
				


			}

		}
	}

}