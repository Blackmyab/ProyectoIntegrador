<?php

class Cate{

	public function seleccionarCateController($id){

		$respuesta = CateModels::seleccionarCateModel("productos", $id);

		foreach ($respuesta as $row => $item){

			echo '


							<div class="col-md-4 text-center">
								<div class="product-entry">
									<div class="product-img" style="background-image: url(backend/'.$item["imagen"].');">
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