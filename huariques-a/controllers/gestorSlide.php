<?php

class Slide{

	public function seleccionarSlideController(){

		$respuesta = SlideModels::seleccionarSlideModel("slide");

		foreach ($respuesta as $row => $item){

			echo '

			   	<li style="background-image: url(backend/'.substr($item["ruta"], 6).');">
			   		<div class="overlay"></div>
			   		<div class="container-fluid">
			   			<div class="row">
				   			<div class="col-md-6 col-md-offset-3 col-md-push-3 col-sm-12 col-xs-12 slider-text">
				   				<div class="slider-text-inner">
				   					<div class="desc">
					   					<br>
					   					<br>
					   					<h2 class="head-2">'.$item["titulo"].'</h2>
					   					<h2 class="head-3">'.$item["descripcion"].'</h2>
					   					<br>
					   					<br>
				   					</div>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>';

		}

	}
}