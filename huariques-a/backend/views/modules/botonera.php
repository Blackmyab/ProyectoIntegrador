<!--=====================================
COLUMNA BOTONERA
======================================-->
				<?php

if ($_SESSION["role"] == "administrador") {

    echo '

	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12" id="col1">

		<div id="logo" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

					<center><h1><a href="../index.php" target="_blank">HUARIQUES MANAGEMENT</a></h1></center>


		</div>



		<div id="botoneraMovil" class="navbar-header navbar-inverse">

			<button type="button" class="navbar-toggle pull-left" data-toggle="collapse" data-target="#botonera">

				<span class="icon-bar"></span>
        		<span class="icon-bar"></span>
       			<span class="icon-bar"></span>

			</button>

		</div>





		<nav id="botonera" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse navbar-collapse text-center">

			<ul class="nav navbar">

				<li><a href="ventas">Ventas <span class="glyphicon glyphicon-new-window"></span></a></li>
				<li><a href="slide">Slide <span class="glyphicon glyphicon-new-window"></span></a></li>
				<li><a href="productos">Productos <span class="glyphicon glyphicon-new-window"></span></a></li>
				<li><a href="categorias">Categorias <span class="glyphicon glyphicon-new-window"></span></a></li>
                <li><a href="suscriptores">Clientes <span class="glyphicon glyphicon-new-window"></span></a></li>



			</ul>

		</nav>


	</div>
    ';

}
?>
<!--====  FIn de COLUMNA BOTONERA  ====-->