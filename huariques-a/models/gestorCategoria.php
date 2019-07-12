<?php

require_once "backend/models/conexion.php";

class CategoriaModels{

	public function seleccionarCategoriaModel($tabla){

		$stmt = Conexion::conectar()->prepare("SELECT id, titulo FROM $tabla");

		$stmt->execute();

		return $stmt->fetchAll();

		$stmt->close();

	}

}