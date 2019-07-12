<?php

class Producto{

	public function seleccionarProductoController($id){

		$respuesta = ProductoModels::seleccionarProductoModel("productos", $id);

		foreach ($respuesta as $row => $item){

			echo '


					<div class="col-md-10 col-md-offset-1">
							<div class="row">
								<div class="col-md-5">
									<div class="product-entry">
										<div class="product-img" style="background-image: url(backend/'.$item["imagen"].');">
										</div>
									</div>
								</div>
								<div class="col-md-7">
									<div class="desc">
										<h3>'.utf8_encode($item["titulo"]).'</h3>
										<p class="price">
											<span>$'.$item["precio"].'</span> 
										</p>
										<p>'.utf8_encode($item["descripcion"]).'</p>

									</div>
								</div>
							<div class="col-md-7 tabulation">
								<ul class="nav nav-tabs">
								<hr>
									<li class="active"><a data-toggle="tab" href="#description">Información</a></li>
								</ul>
								<div class="tab-content">
									<div id="description" class="tab-pane fade in active">
										<p style="white-space: pre-wrap;">'.utf8_encode($item["contenido"]).'</p>

						         </div>
					         </div>
				         </div>
							</div>
					</div>
				';

		}

	}
}