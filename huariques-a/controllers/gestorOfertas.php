<?php

class Ofertas{

	public function seleccionarOfertasController(){

		$respuesta = OfertasModels::seleccionarOfertasModel("productos");

		foreach ($respuesta as $row => $item){

			echo '

							<div class="col-md-4">
								<a href="producto.php?owl='.$item["id"].'" class="f-product-2" style="background-image: url(backend/'.$item["imagen"].');">
									<div class="desc">
										<h2>'.$item["titulo"].'<br>$'.$item["precio"].'</h2>
									</div>
								</a>
							</div>
				';

		}

	}
}