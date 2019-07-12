<?php

/**
 * 
 */
class Conexion
{
	
	public function conectar(){

		$localhost = "localhost";
		$database = "tienda_MENU";
		$user = "root";
		$password = "";

		$link = new PDO("mysql:host=$localhost;dbname=$database",$user,$password);

		return $link;
	}
}

?>