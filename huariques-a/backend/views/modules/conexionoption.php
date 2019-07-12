<?php
function conectar()
{
    $servidor = "localhost";
    $usuario  = "root";
    $password = "";
    $bd       = "tienda_menu";
    $cnn      = new mysqli($servidor, $usuario, $password, $bd);
    return $cnn;
}
