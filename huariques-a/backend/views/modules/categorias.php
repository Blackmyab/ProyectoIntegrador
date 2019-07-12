<?php

session_start();

if (!$_SESSION["validar"]) {

    header("location:ingreso");

    exit();

}

include "views/modules/botonera.php";
include "views/modules/cabezote.php";

?>
<!--=====================================
 ADMINISTRABLE
======================================-->







<div id="seccionArticulos" class="col-lg-10 col-md-10 col-sm-9 col-xs-12">


	

	<button id="btnAgregarArticulo" class="btn btn-info">Agregar Categoria</button>

	<!--==== AGREGAR ARTÍCULO  ====-->

	<div id="agregarArtículo" style="display:none">

		<form method="post" enctype="multipart/form-data">

			<input name="tituloArticulo" type="text" placeholder="Título de la categoria" class="form-control" required>


			<input type="submit" id="guardarArticulo" value="Guardar Categoria" class="btn btn-primary">

		</form>

	</div>

	<?php

$crearArticulo = new GestorCategorias();
$crearArticulo->guardarCategoriaController();

?>

	<hr>

	<!--==== EDITAR ARTÍCULO  ====-->

	<ul id="editarArticulo">

	<?php

$mostrarArticulo = new GestorCategorias();
$mostrarArticulo->mostrarCategoriasController();
$mostrarArticulo->borrarCategoriaController();
$mostrarArticulo->editarCategoriaController();

?>

	</ul>





</div>

<!--====  Fin de ARTÍCULOS ADMINISTRABLE  ====-->

