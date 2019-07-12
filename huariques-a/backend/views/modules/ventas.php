<?php

session_start();

if(!$_SESSION["validar"]){

  header("location:ingreso");

  exit();

}

include "views/modules/botonera.php";
include "views/modules/cabezote.php";

?>
<!--=====================================
SUSCRIPTORES         
======================================-->

<div id="suscriptores" class="col-lg-10 col-md-10 col-sm-9 col-xs-12">
 
  <div class="panel-body">
   <div class="col-md-12" style="text-align: right;">
          <h4>Se han vendido:</h4>

         <?php
            $ventas = new VentasController();
            $ventas -> sumarVentasController();
         ?>
   </div>
  </div>

 <div>

	<table id="tablaSuscriptores" class="table table-striped dt-responsive nowrap">
    <thead>
      <tr>
        <th>Cliente</th>
        <th>Producto</th>
        <th>Costo</th>
        <th>Fecha</th>
        <th>Acciones</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
  
      <?php

      $ventas = new VentasController();
      $ventas -> mostrarVentasController();
      $ventas -> borrarVentasController();



      ?>

    </tbody>
  </table>

  </div>

</div>

<script>
  
$(window).load(function(){

  var datos = new FormData();

  datos.append("revisionVentas", 1);

  $.ajax({
      url:"views/ajax/gestorRevision.php",
      method: "POST",
      data: datos,
      cache: false,
      contentType: false,
      processData: false,
      success: function(respuesta){}

    });
})

</script>

<!--====  Fin de SUSCRIPTORES  ====-->