<?php

require_once "backend/models/conexion.php";

class TodoModels{

	public function seleccionarTodoModel($tabla){

		$stmt = Conexion::conectar()->prepare("SELECT titulo, descripcion, contenido, imagen, precio, categoria, id FROM $tabla");

		$stmt->execute();

		return $stmt->fetchAll();

		$stmt->close();

	}

}