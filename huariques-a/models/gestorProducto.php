<?php

require_once "backend/models/conexion.php";

class ProductoModels{

	public function seleccionarProductoModel($tabla, $id){

		$stmt = Conexion::conectar()->prepare("SELECT titulo, descripcion, contenido, imagen, precio, categoria, id FROM $tabla WHERE id = '$id'");

		$stmt->execute();

		return $stmt->fetchAll();

		$stmt->close();

	}

}