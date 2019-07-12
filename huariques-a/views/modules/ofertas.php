		<div id="colorlib-featured-product">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center colorlib-heading">
						<h2><span>OFERTAS</span></h2>
					</div>
				</div>
				<div class="row">

					<div class="col-md-12">
						<div class="row">
				<?php
				$ofertas = new Ofertas();
				$ofertas -> seleccionarOfertasController();
				?>
						</div>
					</div>
				</div>
			</div>
		</div>