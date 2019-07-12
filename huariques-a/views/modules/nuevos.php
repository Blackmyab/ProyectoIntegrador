		<div class="colorlib-shop">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center colorlib-heading">
						<h2><span>últimos productos</span></h2>
					</div>
				</div>
				<div class="row">
				<?php
				$nuevos= new Nuevos();
				$nuevos -> seleccionarNuevosController();
				?>
				</div>
			</div>
		</div>