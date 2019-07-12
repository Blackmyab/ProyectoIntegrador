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
ARTÍCULOS ADMINISTRABLE
======================================-->

<div id="seccionArticulos" class="col-lg-10 col-md-10 col-sm-9 col-xs-12">
 
	<button id="btnAgregarArticulo" class="btn btn-info">Agregar Producto</button>

	<!--==== AGREGAR ARTÍCULO  ====-->

	<div id="agregarArtículo" style="display:none">

		<form method="post" enctype="multipart/form-data">

			<input name="tituloArticulo" type="text" placeholder="Título del Producto" class="form-control" required>

			<input name="descripcionArticulo" id="" cols="30" rows="5" placeholder="Descripcion" class="form-control"  maxlength="170" required></input>

			<textarea name="contenidoArticulo" id="" cols="30" rows="10" placeholder="Detalle del Producto" class="form-control" required></textarea>

			<br>


			<input name="precioArticulo" id="" cols="30" rows="5" placeholder="$ Precio" class="form-control"  maxlength="170" required></input>


			<input type="file" name="ruta" class="btn btn-default" id="subirFoto" required>

			<p>Tamaño recomendado: 800px * 400px, peso máximo 2MB</p>




			<!--<input name="" type="text" placeholder="categoria" class="form-control" required>-->
			<br>

			<Select name="categoriaArticulo" id="nid" class="form-control" style="width: 850px">
         <option value="---" size="300" required>SELECCIONA UNA CATEGORIA</option>
         <?php include "categoriasoption.php";?>
            </Select>

			<input type="submit" id="guardarArticulo" value="Guardar Artículo" class="btn btn-primary">

		</form>

	</div>

	<?php

$crearArticulo = new GestorProductos();
$crearArticulo->guardarProductoController();

?>

	<hr>




 <div>

	<table id="tablaSuscriptores" class="table table-striped dt-responsive nowrap">
    <thead>
      <tr>
      	<th>#</th>
        <th>Titulo</th>
        <th>Descripción</th>
        <th>Contenido</th>
        <th>Precio</th>
        <th>Categoria</th>
        <th>Acciones</th>
      </tr>
    </thead>
    <tbody>
  
      <?php

$mostrarArticulo = new GestorProductos();
$mostrarArticulo->mostrarProductosController();
$mostrarArticulo->borrarProductoController();

      ?>

    </tbody>
  </table>


  </div>

</div>





</div>

<!--====  Fin de ARTÍCULOS ADMINISTRABLE  ====-->

