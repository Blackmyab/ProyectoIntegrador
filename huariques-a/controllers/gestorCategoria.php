<?php

class Categoria{

	public function seleccionarCategoriaController(){

		$respuesta = CategoriaModels::seleccionarCategoriaModel("categorias");

		foreach ($respuesta as $row => $item){

			echo '
					<li><a href="categorias.php?wsite='.$item["id"].'">'.utf8_encode($item["titulo"]).'</a></li>
				';

		}

	}
}