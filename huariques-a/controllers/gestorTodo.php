<?php

class Todo{

	public function seleccionarTodoController(){

		$respuesta = TodoModels::seleccionarTodoModel("productos");

		foreach ($respuesta as $row => $item){

			echo '

					<div class="col-md-3 text-center">
						<div class="product-entry">
							<div class="product-img" style="background-image: url(backend/'.$item["imagen"].');">

							</div>
							<div class="desc">
								<h3><a href="producto.php?owl='.$item["id"].'">'.utf8_encode($item["titulo"]).'</a></h3>
								<p class="price"><span>$'.$item["precio"].'</span></p>
							</div>
						</div>
					</div>
				';

		}

	}
}