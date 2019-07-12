<?php

require_once "conexion.php";

class VentasModel{

	#MOSTRAR 
	#------------------------------------------------------------
	public function mostrarVentasModel($tabla){

		$stmt = Conexion::conectar()->prepare("SELECT V.id, U.usuario, V.producto, V.imagen, V.costo, V.fecha FROM $tabla V INNER JOIN usuarios U ON V.usuario = U.id order by V.fecha");

		$stmt -> execute();

		return $stmt -> fetchAll();

		$stmt -> close();

	}

		#SUMAR
	#------------------------------------------------------------
	public function sumarVentasModel($tabla){

		$stmt = Conexion::conectar()->prepare("SELECT SUM(costo) AS total_suma FROM $tabla");

		$stmt -> execute();

		return $stmt -> fetchAll();

		$stmt -> close();

	}

	#BORRAR
	#-----------------------------------------------------
	public function borrarVentasModel($datosModel, $tabla){

		$stmt = Conexion::conectar()->prepare("DELETE FROM $tabla WHERE id = :id");

		$stmt->bindParam(":id", $datosModel, PDO::PARAM_INT);

		if($stmt->execute()){

			return "ok";

		}

		else{

			return "error";

		}

		$stmt->close();

	}

	#SELECCIONAR
	#------------------------------------------------------------
	public function ventasSinRevisarModel($tabla){
	
		$stmt = Conexion::conectar()->prepare("SELECT revision FROM $tabla");

		$stmt -> execute();

		return $stmt -> fetchAll();

		$stmt -> close();

	}

	# REVISADOS
	#------------------------------------------------------------
	public function ventasRevisadosModel($datosModel, $tabla){

		$stmt = Conexion::conectar()->prepare("UPDATE $tabla SET revision = :revision");

		$stmt->bindParam(":revision", $datosModel, PDO::PARAM_INT);

		if($stmt->execute()){

			return "ok";

		}

		else{

			return "error";

		}

		$stmt->close();

	}

}


