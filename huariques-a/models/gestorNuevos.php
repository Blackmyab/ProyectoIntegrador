<?php

require_once "backend/models/conexion.php";

class NuevosModels{

	public function seleccionarNuevosModel($tabla){

		$stmt = Conexion::conectar()->prepare("SELECT id, titulo, imagen, descripcion, contenido, precio, calificacion, categoria FROM $tabla ORDER BY id DESC LIMIT 4");

		$stmt->execute();

		return $stmt->fetchAll();

		$stmt->close();

	}

}