<?php

class Nuevos{

	public function seleccionarNuevosController(){

		$respuesta = NuevosModels::seleccionarNuevosModel("productos");

		foreach ($respuesta as $row => $item){

			echo '
					<div class="col-md-3 text-center">
						<div class="product-entry">
							<div class="product-img" style="background-image: url(backend/'.$item["imagen"].');">
								<p class="tag"><span class="new">Nuevo</span></p>
							</div>
							<div class="desc">
								<h3><a href="producto.php?owl='.$item["id"].'">'.$item["titulo"].'</a></h3>
								<p class="price"><span>$'.$item["precio"].'</span></p>
							</div>
						</div>
					</div>
				';

		}

	}
}