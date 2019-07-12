<?php

require_once "backend/models/conexion.php";

class OfertasModels{

	public function seleccionarOfertasModel($tabla){

		$stmt = Conexion::conectar()->prepare("SELECT id, titulo, imagen, descripcion, contenido, precio, calificacion, categoria FROM $tabla WHERE precio < 300 LIMIT 6");

		$stmt->execute();

		return $stmt->fetchAll();

		$stmt->close();

	}

}