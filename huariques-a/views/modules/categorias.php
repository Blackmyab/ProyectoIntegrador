		<nav class="colorlib-nav" role="navigation">
			<div class="top-menu">
				<div class="container">
					<div class="row">
						<div class="col-xs-2">
							<div id="colorlib-logo"><a href="./">HUARIQUES</a></div>
						</div>
						<div class="col-xs-10 text-right menu-1">
							<ul>
				<?php
				$categoria = new Categoria();
				$categoria -> seleccionarCategoriaController();
				?>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</nav>