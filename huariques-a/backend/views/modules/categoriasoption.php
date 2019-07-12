<?php
include "conexionoption.php";
$consulta   = "Select * from categorias";
$cnn        = conectar();
$resultados = $cnn->query($consulta);
while ($reg = $resultados->fetch_assoc()) {
    $ids       = $reg['id'];
    $categoria = $reg['titulo'];
    echo "<option value='$ids'>".utf8_encode($categoria)."</option>";
}
$cnn->close();
