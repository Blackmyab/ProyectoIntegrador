<?php

require_once "backend/models/conexion.php";

class CateModels{

	public function seleccionarCateModel($tabla, $id){

		$stmt = Conexion::conectar()->prepare("SELECT id, titulo, imagen, descripcion, contenido, precio, calificacion, categoria FROM $tabla WHERE categoria = '$id'");

		$stmt->execute();

		return $stmt->fetchAll();

		$stmt->close();

	}

}